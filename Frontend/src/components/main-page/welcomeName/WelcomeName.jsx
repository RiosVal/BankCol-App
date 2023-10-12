import "./WelcomeName.css";

function NavBar(props) {

    return (
        <div className="navContainer">
            <h1><b>Hola, {props.clientName}!</b></h1>
        </div>
    );
}

export default NavBar;