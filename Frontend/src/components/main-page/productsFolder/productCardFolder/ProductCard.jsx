import "./ProductCard.css";

function ProductCard(props) {
    return(
        <div className="productCard">
            <img src={props.productType === "Cdt" ? "/img/cdt-icon.png" : "/img/savings-icon-black.png"}></img>
            <h1 className="productName">{props.productType}</h1>
            <p className="productId">{props.productId}</p>
            <p className="amountLabel">Monto</p>
            <p className="productAmount">${props.productAmount}</p>
            <button>Ver detalles</button>
        </div>
    );
}

export default ProductCard;