import ProductCard from "./productCardFolder/ProductCard";
import products from "../../../ClientProducts";
import "./ProductsPage.css";

function ProductsPage() {

    return(
        <div className="productsPageContainer">
            {products.map(product => {
                return (
                    <ProductCard
                        productType = {product.tipoProducto}
                        productId = {product.numCuenta}
                        productAmount = {product.monto}
                    />
                );
            })}
        </div>
    );
}

export default ProductsPage;