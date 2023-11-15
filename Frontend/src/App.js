import * as ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import './App.css';
import Login from './components/login/Login';
import MainPage from "./components/main-page/MainPage";

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
    </div>
  );
}

export default App;
