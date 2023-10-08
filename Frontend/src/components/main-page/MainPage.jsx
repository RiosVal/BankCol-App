import { useState } from "react";
import WelcomeName from "./welcomeName/WelcomeName";
import Menu from "./menu/Menu";
import ProductsPage from "./productsFolder/ProductsPage";
import "./MainPage.css";


function MainPage() {
    const clientName = 'Valeria';
    

    const [isFirstClicked, setIsFirstClicked] = useState(true);
    const [isSecondClicked, setIsSecondClicked] = useState(false);
    const [isThirdClicked, setIsThirdClicked] = useState(false);

    function clickFirstHandler() {
        if (isFirstClicked) {setIsFirstClicked(false);}
        else {
            setIsFirstClicked(true);
            setIsSecondClicked(false);
            setIsThirdClicked(false);
        }
    }

    function clickSecondHandler() {
        if (isSecondClicked) {setIsSecondClicked(false);}
        else {
            setIsSecondClicked(true);
            setIsFirstClicked(false);
            setIsThirdClicked(false);
        }
    }

    function clickThirdHandler() {
        if (isThirdClicked) {setIsThirdClicked(false);}
        else {
            setIsThirdClicked(true);
            setIsFirstClicked(false);
            setIsSecondClicked(false);
        }
    }

    return (
        <div className="products">

            <WelcomeName clientName={clientName}/>
            <div className="pageContent">
                <Menu
                    isFirstClicked = {isFirstClicked}
                    isSecondClicked = {isSecondClicked}
                    isThirdClicked = {isThirdClicked}
                    clickFirstHandler = {clickFirstHandler}
                    clickSecondHandler = {clickSecondHandler}
                    clickThirdHandler = {clickThirdHandler}
                />
                {isFirstClicked && <ProductsPage />}
                {isSecondClicked && <h1>Tranferencias</h1>}
                {isThirdClicked && <h1>Abrir cdts</h1>}
            </div>
        </div>
    );
}

export default MainPage;