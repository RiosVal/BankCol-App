import "./Menu.css";

function Menu(props) {

    return(
        <div className="menuContainer">
            <button
                style={props.isFirstClicked ? {"font-size": "20px", "font-weight": "bolder"} : {"font-size": "18px", "font-weight": ""}}
                id="firstButton"
                onClick={props.clickFirstHandler}>
                Productos
            </button>
            <button
                style={props.isSecondClicked ? {"font-size": "20px", "font-weight": "bolder"} : {"font-size": "18px", "font-weight": ""}}
                onClick={props.clickSecondHandler}>
                Transferencias
            </button>
            <button
                style={props.isThirdClicked ? {"font-size": "20px", "font-weight": "bolder"} : {"font-size": "18px", "font-weight": ""}}
                onClick={props.clickThirdHandler}>
                Abrir cdt
            </button>
        </div>
    );
}

export default Menu;