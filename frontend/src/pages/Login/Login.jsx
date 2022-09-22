import React from 'react';
import { useState } from 'react';
import './Login.css'

const login = () => {
    
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();

        console.log("submit", {email,password});
    };
    
    
    return (

        <div className="login">
            <h1 className="title">Login do sistema</h1>
            <form className="form" onSubmit={handleSubmit}>
                <div className="field">
                    <label htmlFor="email">Email</label>
                    <input type="email" name="email" id="email" value={email} onChange={(e) =>setEmail(e.target.value)}/>
                </div>
                <div className="field">
                    <label htmlFor="password">Senha</label>
                    <input type="password" name='password' id='password' value={password} onChange={(e) => setPassword(e.target.value)}/>
                </div>
                <div className='actions'>
                    <button type='submit'>
                        Entrar
                    </button>
                </div>
            </form>
        </div>

    )
}

export default login;