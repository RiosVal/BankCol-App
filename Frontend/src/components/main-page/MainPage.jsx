import NavBar from "./Nav/NavBar";
import "./MainPage.css";


function MainPage() {
    const clientName = 'Valeria';
    return (
        <div className="products">
            <NavBar clientName={clientName}/>
        </div>
    );
}

export default MainPage;