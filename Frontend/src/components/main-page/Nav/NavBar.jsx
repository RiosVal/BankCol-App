import "./NavBar.css";
import Menu from "./MenuFolder/Menu";
import { useState } from "react";

function NavBar(props) {
    const [menuIsOpen, setMenuIsOpen] = useState(true);

    function menuHandler() {
        if (menuIsOpen) {
            setMenuIsOpen(false);
        } else {
            setMenuIsOpen(true);
        } 
    }

    return (
        <div className="navContainer">
            <div className="menu-container" onClick={menuHandler}><img alt="" src={menuIsOpen ? "/img/exit-icon.png" : "/img/menu-icon.png"} className="menuIcon"></img></div>
            {menuIsOpen ? (<Menu />) : <h1><b>Hola, {props.clientName}!</b></h1>}
        </div>
    );
}

export default NavBar;