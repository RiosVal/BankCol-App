import './App.css';
import Login from './components/login/Login';
import MainPage from "./components/main-page/MainPage";
import Footer from './components/footer/Footer';

function App() {
  const isAuthenticaded = true;

  return (
    <div>
      {
        isAuthenticaded ? (
          <MainPage />
        ) : (
          <Login />
        )
      }
      <Footer />
    </div>
  );
}

export default App;
