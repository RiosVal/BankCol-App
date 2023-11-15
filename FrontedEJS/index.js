import express from "express";
//import axios from "axios";
import bodyParser from "body-parser";
import { dirname } from "path";
import { fileURLToPath } from "url";
import { name, userProducts, addresses } from "./usrData.js";

const __dirname = dirname(fileURLToPath(import.meta.url));

const app = express();
const port = 3000;


const updatedUserProducts = userProducts.map(product => {
    if (product.type === 'Cdt') {
        product['imgURL'] = 'images/cdt-icon.png';
    } else {
        product['imgURL'] = 'images/savings-icon-black.png';
    }
    return product;
});

const userData = {
    name: name,
    addresses: addresses,
    products: updatedUserProducts
}

let cdtSimulation = 0;
let finalAmountCdt = 0;

app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));

function getTodayDate() {
    const todaysDate = new Date();
    var year = todaysDate.getFullYear();
    var month = (todaysDate.getMonth() + 1).toString().padStart(2, '0'); // Sumar 1 al mes porque en JavaScript los meses van de 0 a 11
    var day = todaysDate.getDate().toString().padStart(2, '0');
    const today = year + '-' + month + '-' + day;
    return today;
}

function calcFinalAmntCdt(initialAmount, term){
    const percentage = 0.1;
    let finalAmount = 0;
    switch(term) {
        case 3:
            finalAmount = initialAmount + (((initialAmount*percentage)/12)*3);
            break;
        case 6:
            finalAmount = initialAmount + (((initialAmount*percentage)/12)*6);
            break;
        case 9:
            finalAmount = initialAmount + (((initialAmount*percentage)/12)*9);
            break;
        case 12:
            finalAmount = initialAmount + (initialAmount*percentage);
            break;
    }
    return finalAmount;
}

function addMonthsToDate(term) {
    var fechaHoy = new Date();
    var fechaEnTresMeses = new Date(fechaHoy);
    fechaEnTresMeses.setMonth(fechaEnTresMeses.getMonth() + term);

    // Formatear la fecha en el formato "2023-10-30"
    var año = fechaEnTresMeses.getFullYear();
    var mes = (fechaEnTresMeses.getMonth() + 1).toString().padStart(2, '0');
    var dia = fechaEnTresMeses.getDate().toString().padStart(2, '0');

    var fechaEnTresMesesEnFormato = año + '-' + mes + '-' + dia;
    return fechaEnTresMesesEnFormato;
}

app.get("/", async (req, res) => {
    res.render(__dirname + '/views/welcomePage.ejs');
});

app.get("/login", (req, res) => {
    res.render(__dirname + '/views/login.ejs');
});

app.get("/products", (req, res) => {
    res.render(__dirname + '/views/products.ejs', {data: userData});
});

app.get("/products/:productid", (req, res) => {
    const requestedId = req.params.productid;
    let data = {};

    const { name, products } = userData;

    products.forEach(product => {
        if (requestedId == product.id) {
            data = {
                name: name,
                type: product.type,
                id: product.id,
                details: product.details,
            }
        }
    });
    res.render(__dirname + '/views/details.ejs', {data: data});
});

app.get("/transfer", (req, res) => {
    res.render(__dirname + "/views/transfer.ejs", {data: userData});
});

app.post("/saveAddressee", (req, res) => {
    const { addresseeName, addresseeId, addresseeBank, addresseeAccNumber } = req.body;
    const newAddressee = {
        name: addresseeName,
        id: addresseeId,
        bank: addresseeBank,
        accountNumber: addresseeAccNumber
    };

    addresses.push(newAddressee);
    res.redirect("/transfer");
});

app.post("/transfer", (req, res) => {
    const { transferType, addresseeId, accountToUse, amount } = req.body;
    const today = getTodayDate();
    let transaction = {};

    addresses.forEach(addressee => {
        if (addresseeId == addressee.id) {
            transaction = {
                addressee: addressee
            }
        }
    });
    
    userProducts.forEach(product => {
        if (product.id == accountToUse){
            if (amount <= product.amount) {
                transaction = {
                    date: today,
                    type: transferType,
                    monto: amount,  
                    ...transaction
                }
                product.details.transactions.push(transaction);
                product.amount -= amount;
                res.redirect("/products");
            } else {
                console.log('Te excediste wey');
            }
        } 
    });


});



app.get("/withdraw", (req, res) => {
    res.render(__dirname + "/views/withdraw.ejs", {data: userData});
});

app.post("/withdraw", (req, res) => {
    const { accountToUse, amount } = req.body;
    let transaction = {};
    userProducts.forEach(product => {
        if (product.id == accountToUse){
            if (parseInt(amount, 10) <= product.amount) {
                product.amount -= parseInt(amount, 10);
                transaction = {
                    date: getTodayDate(),
                    type: 'Retiro en cajero',
                    monto: parseInt(amount, 10)
                }
                product.details.transactions.push(transaction);
                res.redirect("/products");
            }
        }
    });
});



app.get("/consign", (req, res) => {
    res.render(__dirname + '/views/consign.ejs', {data: userData});
});

app.post("/consign", (req, res) => {
    const { accountToUse, amount } = req.body;
    let transaction = {};
    userProducts.forEach(product => {
        if (product.id == accountToUse){
            if (parseInt(amount, 10) <= product.amount) {
                product.amount += parseInt(amount, 10);
                transaction = {
                    date: getTodayDate(),
                    type: 'Consignación',
                    monto: parseInt(amount, 10)
                }
                product.details.transactions.push(transaction);
                res.redirect("/products");
            }
        }
    });
});




app.get("/openCDT", (req, res) => {
    res.render(__dirname + "/views/openCDT.ejs", {data: userData, finalAmountSimulation: cdtSimulation});
});

app.post("/simulateCdt", (req, res) => {
    const { simInitialAmount, term } = req.body;
    const initialAmount = parseInt(simInitialAmount, 10);
    const cdtTerm = parseInt(term, 10);
    cdtSimulation = calcFinalAmntCdt(initialAmount, cdtTerm);
    res.redirect("/openCDT");
});

app.post("/startCdt", (req, res) => {
    const { initialAmount, cdtTerm, bankBrach } = req.body;
    let id = Date.now().toString();
    finalAmountCdt = calcFinalAmntCdt(parseInt(initialAmount, 10), parseInt(cdtTerm, 10));
    const expirationDate = addMonthsToDate(parseInt(cdtTerm, 10));
    let product = {
        type: 'Cdt',
        id: id,
        amount: parseInt(initialAmount, 10),
        details: {
            openingDate: getTodayDate(),
            bankBranch: bankBrach,
            percentage: 12,
            finalAmount: finalAmountCdt,
            term: parseInt(cdtTerm, 10),
            expirationDate: expirationDate
        }
    }
    userData.products.push(product);
    res.redirect("/products");
});


app.listen(port, () => {
    console.log(`Listening on port ${port}`);
});
