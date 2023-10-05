import './App.css';
import Login from './components/login/Login';
import Products from "./components/products-page/Products";
import Footer from './components/footer/Footer';

function App() {
  const isAuthenticaded = false;

  return (
    <div>
      {
        isAuthenticaded ? (
          <Products />
        ) : (
          <Login />
        )
      }
      <Footer />
    </div>
  );
}

export default App;
