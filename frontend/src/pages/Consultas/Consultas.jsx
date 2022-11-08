import Header from "../Header/Header";
import Footer from "../Footer/Footer";
import Consulta from "./Consulta"
import cardimg1 from '../../assets/irmaos-MAIN.jpg'
import cardimg2 from '../../assets/pote-com-aveia-orig-1.jpg'
import cardimg3 from '../../assets/chn-grávida-alimentação.png'
import cardimg4 from '../../assets/triste.jpg'
import '../Consultas/Consultas.css'


import { Appointment } from '../../models/Appointment'
import { User } from '../../models/User'

import { Container, Button, Card } from "react-bootstrap";
import { useState } from "react";
import { useEffect } from "react";
import axios from "axios";
import { BASE_URL } from "../../../utils/request";
import { Patient } from "../../models/Patient";
import { render } from "react-dom";
import { useNavigate } from "react-router";



const Consultas = () => {

    const navigate = useNavigate()

    const appointments = new Array(Appointment);

    const userlogged = new User();

    const patient = new Patient();



    const [listAppointments, setAppointments] = useState(appointments);

    const [userlogin, setDataUser] = useState(userlogged);

    const [userp, setPatient] = useState(patient);

    const handleButtonBack = () => {

        navigate(-1)

    }


    const handlenavCreate = (e) => {
        e.preventDefault()

        navigate('./create')
    }

    useEffect(() => {

    async function carregarUsers(){
        axios.get(`${BASE_URL}/users`).then(response => {
            if (response.data) {
                {
                    response.data.map(user => (
                        user.logged == true ? setDataUser(user) : ''
                    ))

                }
            }
            else {
                console.log("Ta errado!")
            }


        })



        }
        carregarUsers()
    }, [])

    useEffect(() => {
    
        async function carregaPacientes(){
        axios.get(`${BASE_URL}/patients`).then(response => {
            if (response.data) {
                response.data.map(Patient => (
                    Patient.user.id === userlogin.id ? setPatient(Patient) : ''
                ))
            }
        })
    }
    carregaPacientes()

    }, [userlogin])

    useEffect (() => {

    
        async function carregaConsultas(){
        axios.get(`${BASE_URL}/appointment`).then(response => {
            if (response.data) {
                const AppointmentUser = [];
                response.data.map(appointment => (
                    appointment.pacient.id === userp.id ? AppointmentUser.push(appointment) : ''

                ))
                setAppointments(AppointmentUser);
            }

        })
    }
    carregaConsultas()

    }, [userp])


        return (
            <>
                <Header />
                <main>
                <Button className="d-flex m-4" onClick={handleButtonBack}>Voltar</Button>
                    <section className="py-5 text-center container">

                        <div className="row py-lg-5">
                            <div className="col-lg-6 col-md-8 mx-auto">
                                <h1 className="fw-light">Agendamento de Consultas</h1>
                                <p className="lead text-muted">Aqui você pode agendar novas consultas e editar,visualizar e deletar as consutlas já marcadas</p>
                                <p>
                                    <Button className="m-2" onClick={handlenavCreate}>
                                        Agendar Consulta
                                    </Button>
                                </p>
                            </div>
                        </div>
                    </section>

                    <div className="album py-5 bg-light">
                        

                        <h1 className="mb-5">Minhas consultas</h1>
                        <Container>
                            <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

                                {
                                   listAppointments.map((consulta, index) => (
                                        
                                        <Consulta key={index} AppointmentID={consulta} />
                                    )) 
                                }
                            
                            </div>
                        </Container>
                    </div>
                </main>
                <Footer />
            </>
        );
}

export default Consultas;