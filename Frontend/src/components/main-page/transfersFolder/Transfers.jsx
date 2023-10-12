import AddresseCard from "./addresseFolder/AdresseCard";
import './Transfers.css';

function Transfers(){
    return(
        <div className="transfersContainer">
            <h2>Cuentas favoritas</h2>
            <div className="addressesContainer">
                <AddresseCard
                    addresseName = "John Mario"
                    addresseCount = {456789}
                />
                <AddresseCard
                    addresseName = "Mariana Cruz"
                    addresseCount = {986456}
                />
            </div>
        </div>
    );
}

export default Transfers;