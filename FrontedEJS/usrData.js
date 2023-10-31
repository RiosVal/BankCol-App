const name = 'Valeria';
const addresses = [
    {
        name: 'Valeria Rios',
        id: '748375',
        bank: 'Colpatria',
        accountNumber: '986473'
    },
    {
        name: 'Bernardo Rios',
        id: '287657',
        bank: 'BBVA',
        accountNumber: '918273'
    }
]
const userProducts = [
    {
        type: 'Cdt',
        id: '123456',
        amount: 10200,
        details: {
            openingDate: '2020-03-15',
            bankBranch: 'Unicentro cali',
            percentage: 9.13,
            finalAmount: 19512,
            term: 12,
            expirationDate: '2021-03-16'
        }
    },
    {
        type: 'Cuenta de ahorros',
        id: '321232',
        amount: 5340,
        details: {
            openingDate: '2021-06-08',
            bankBranch: 'Unicentro bogota',
            transactions: [
                {
                    date: '2023-10-25',
                    type: 'Retiro en cajero',
                    monto: 1200,
                    addressee: {
                        name: 'Valeria Rios',
                        id: '748375',
                        bank: 'Colpatria',
                        accountNumber: '986473'
                    }
                },
                {
                    date: '2023-10-22',
                    type: 'Transferencia',
                    monto: 550,
                    addressee: {
                        name: 'Bernardo Rios',
                        id: '287657',
                        bank: 'BBVA',
                        accountNumber: '918273'
                    }
                },
                {
                    date: '2023-10-10',
                    type: 'Consignación',
                    monto: 5000
                }
            ]
        }
    },
    {
        type: 'Cuenta corriente',
        id: '764356',
        amount: 7890,
        details: {
            openingDate: '2019-02-06',
            bankBranch: 'Jardin plaza cali',
            transactions: [
                {
                    date: '2023-04-06',
                    type: 'Transferencia',
                    monto: 200,
                    addressee: {
                        name: 'Juan Orozco',
                        id: '615283',
                        bank: 'Bancolombia',
                        accountNumber: '918273'
                    }
                },
                {
                    date: '2023-05-11',
                    type: 'Pago en línea',
                    monto: 60,
                    addressee: {
                        name: 'Pablo Alzate',
                        id: '654321',
                        bank: 'Davivienda',
                        accountNumber: '876567'
                    }
                },
                {
                    date: '2023-07-01',
                    type: 'Consignación',
                    monto: 3500
                }
            ]
        }
    }
];

export { name, userProducts, addresses };


// {
//     name: 'Andrea Hurtado',
//     id: '291198',
//     bank: 'BBVA',
//     accountNumber: '986473'
// },
// {
//     name: 'Juan Orozco',
//     id: '615283',
//     bank: 'Bancolombia',
//     accountNumber: '918273'
// },
// {
//     name: 'Pablo Alzate',
//     id: '654321',
//     bank: 'Davivienda',
//     accountNumber: '876567'
// }