import React from 'react';
import './Header.css'
import headerImage from '../../assets/favicon/health.png'

import { BsFillArrowUpRightSquareFill } from 'react-icons/bs'


import { useNavigate } from 'react-router';

import { Button } from 'react-bootstrap';
import { User } from '../../models/User';
import { useEffect } from 'react';
import axios from 'axios';
import { BASE_URL } from '../../../utils/request';
import { useState } from 'react';
import { Patient } from '../../models/Patient';
import { render } from 'react-dom';
import { Doctor } from '../../models/Doctor';
import { Receptionist } from '../../models/Receptionist';
import login from '../Login/Login';



const Header = () => {


    const navigate = useNavigate();


    const patient = new Patient();

    const [name,setName] = useState('')

    const [doctor, setDoctor] = useState('')

    const [receptionist, setReceptionist] = useState('')

    const userlogged = new User();

    const [dataUser, setDataUser] = useState(userlogged);

    const [userp, setPatient] = useState(patient);


    const handleSubmit = (e) => {
        e.preventDefault();
        if (dataUser.logged == true) {
            navigate('')
        }
        else {
            navigate('login')
        }




    }

    const handleOut = (e) => {
        e.preventDefault();
        navigate('/login');
        axios.put(`${BASE_URL}/users/` + dataUser.id, { id: dataUser.id, cpf: dataUser.cpf, password: dataUser.password, logged: 0, accessLevel: dataUser.accessLevel });

    }

    useEffect(() => {


        async function carregaUsers() {
            axios.get(`${BASE_URL}/users/`).then(response => {
                if (response.data) {
                        response.data.map(user => (
                            user.logged == true ? setDataUser(user) : ''
                        )
                        )
                }
                else {
                    console.log("Ta errado!")
                }
            })
        }
        carregaUsers()
    }, []);

    useEffect(() => {

        async function carregaDoutor() {
            axios.get(`${BASE_URL}/doctors`).then(response => {
                if (response.data) {
                    response.data.map(doc => (
                        doc.user.id === dataUser.id ? setDoctor(doc) : ''
                    ))
                }
            });
        }

        carregaDoutor()

    }, [dataUser])

    useEffect(() => {

        async function carregaRecepcao() {
            axios.get(`${BASE_URL}/receptionists`).then(response => {
                if (response.data) {
                    response.data.map(rec => (
                        rec.user.id === dataUser.id ? setReceptionist(rec) : ''
                    ))
                }
            });
        }

        carregaRecepcao()

    }, [dataUser])


    useEffect(() => {

        async function carregaPacientes() {
            axios.get(`${BASE_URL}/patients`).then(response => {
                if (response.data) {
                    response.data.map(Patient => (
                        Patient.user.id === dataUser.id ? setPatient(Patient) : ''
                    ))
                }
            });
        }

        carregaPacientes()

    }, [dataUser])

    useEffect(() => {

        if(userp.length !== 0){
            setName(userp.name)
        }
        if(doctor.length !== 0){
            setName(doctor.name)
        }
        if(receptionist.length !== 0){
            setName(receptionist.name);
        }

        console.log(name)
        console.log(doctor)

    }, [userp,doctor,receptionist])



    return(

        <header>
            <div className="d-flex align-items-center justify-content-center justify-content-md-around py-3 mb-4">
                <a href="/" className="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
                    <img src={headerImage} alt="logo-header" className='logo-header' />
                </a>
                <ul className="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0 header-content">
                    <li><a href="/" className="nav-link px-2 link-dark">Home</a></li>
                    <li><a href="/" className="nav-link px-2 link-dark">Features</a></li>
                    <li><a href="/" className="nav-link px-2 link-dark">Pricing</a></li>
                    <li><a href="/" className="nav-link px-2 link-dark">FAQs</a></li>
                    <li><a href="/" className="nav-link px-2 link-dark">About</a></li>


                </ul>
                <div className="col-md-3 text-end ">
                    <Button className='btn btn-header px3 m-3' onClick={handleSubmit}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="18"
                            height="18" fill="currentColor" className="bi bi-person me-2" viewBox="0 0 16 16">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" />
                        </svg>{
                            dataUser.logged === true ? name : 'login'
                        }
                    </Button>
                    <Button className={'btn btn-header px3 out' + (dataUser.logged == true ? 'login' : '')} onClick={handleOut}>
                        <BsFillArrowUpRightSquareFill />
                        Sair
                    </Button>
                </div>
            </div>
        </header>


    );
}

export default Header;