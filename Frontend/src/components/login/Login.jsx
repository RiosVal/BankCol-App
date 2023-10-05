import './Login.css';

function Login() {
    return (
        <div className='login-form'>
            <img src="/img/logo-blue.png" alt="logo" className='logo'></img>
            <form>
                <div className='info-container'>
                    <div className="input-box">
                        <label>Usuario</label>
                        <div className='input-container'><input type="text" name="username" placeholder="Ingresa tu usuario aquí"></input></div>
                    </div>
                    <div className="input-box">
                        <label>Contraseña</label>
                        <div className='input-container'><input type="password" name="password" placeholder="Ingresa tu contraseña aquí"></input></div>
                    </div>
                </div>
                <button type="submit"><b>Ingresar</b></button>
            </form>
        </div>
    );
}

export default Login;