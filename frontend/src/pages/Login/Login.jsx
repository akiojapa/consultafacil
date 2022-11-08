import React, { useEffect } from 'react';
import axios from "axios"
import { useState } from 'react';
import './Login.css'
import Button from 'react-bootstrap/Button'
import Form from 'react-bootstrap/Form'
import { BASE_URL } from '../../../utils/request';
import { User } from '../../models/User';
import { Await, useNavigate } from 'react-router';
import LoginLogoB from '../../assets/LogoBrancoIcon.png'
import LoginLogoW from '../../assets/LogoPreto.png'
import LoginLogoWbg from '../../assets/LogoBranco-removebg.png'
import LoginLogoBbg from '../../assets/LogoPreto-removebg.png'
import { Container } from 'react-bootstrap';
import Home from '../Home/Home';
import Header from '../Header/Header';
import { AccessLevel } from '../../models/AccessLevel';




const login = () => {

    const navigate = useNavigate();

    const user = new Array(User)

    const userlogin = new User()

    const [cpf, setCpf] = useState("");

    const [password, setPassword] = useState("");

    const[login, setLogin] = useState(userlogin)

    const [users, setUsers] = useState(user)

        // id,cpf,password,AccessLevel


    const handleSubmit = (e) => {
        e.preventDefault();


        users.map(user => {
            if(password == user.password && cpf == user.cpf){
                setLogin(user);
                axios.put(`${BASE_URL}/users/` + user.id, {id: user.id, cpf: user.cpf, password: user.password, logged: 1, accessLevel: user.accessLevel});
               
                if(login.accessLevel.id != 3){
                    navigate('/appointment/adm')
                }
                else{
                    navigate('/')
                }
                
                
            }

        })

    };






    useEffect(() => {

        const document = cpf;
        const pass = password;

    
        axios.get(`${BASE_URL}/users`).then(response => {
            if(response.data){
                setUsers(response.data)

            }
            else{
                console.log("Ta errado")
            }
            
        })

        
    }, [cpf,password]);




    return (

        <div className="auth-form-container">

            <Form className='auth-form' onSubmit={handleSubmit} method="post" action="/">
            <Container className='d-flex align-items-center justify-content-center justify-content-md-around logo-login'>
            <a href="/"><img src={LoginLogoB} alt="logo-header" className='logo-login-img' /></a>
            </Container>
                <div className='p-4'>
                    <Form.Group className="mb-3" id="formBasicEmail">
                        <Form.Label>CPF</Form.Label>
                        <Form.Control type="text" placeholder="Digite o seu cpf" value={cpf} name="cpf" id='cpf' onChange={(e) => setCpf(e.target.value)} />
                        <Form.Text className="text-muted">
                            Não compartilhe seus dados com ninguém.
                        </Form.Text>
                    </Form.Group>

                    <Form.Group className="mb-3" id="formBasicPassword">
                        <Form.Label>Senha</Form.Label>
                        <Form.Control type="password" placeholder="Digite sua senha" name='password' id='password' value={password} onChange={(e) => setPassword(e.target.value)} />
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Entrar
                    </Button>
                    <Form.Group>
                        <p className='pt-4'>Não tem uma conta?</p>
                        <a href="#" className='sign-up'>Cadastrar</a>
                    </Form.Group>

                </div>
            </Form>
        </div>


        )
}

export default login;