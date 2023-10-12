import "./AddresseCard.css";

function AddresseCard(props) {
    return (
        <div className="adresseCardContainer">
            <p className="addresseName">{props.addresseName}</p>
            <p className="addresseAccount">{props.addresseCount}</p>
        </div>
    );
}

export default AddresseCard;