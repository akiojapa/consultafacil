import { useEffect, useState } from "react";
import { Appointment } from "../../models/Appointment";
import { Patient } from "../../models/Patient";
import { Schedule } from "../../models/Schedule";
import { UBS } from "../../models/UBS";

import axios from "axios";
import { BASE_URL } from "../../../utils/request"
import { User } from "../../models/User";
import img1 from '../../assets/Consultas/geral.jpg'
import img2 from '../../assets/Consultas/Odontologia.jpg'
import { Doctor } from "../../models/Doctor";


import { Carousel, Button, Card, Container, Alert } from 'react-bootstrap';
import { Navigate, useNavigate } from "react-router";



class Props {
    id = Number;
    appointmentStatus = String;
    schedule = Schedule;
    patient = Patient;
    ubs = UBS
}



const Consultas = ({ AppointmentID = Props }) => {


    const navigate = useNavigate()

    const consulta = new Props()


    const [userAppointment, setAppointment] = useState(consulta);

    const [userDoctor, setDoctor] = useState(new Doctor());

    const [doctorSchedule, setDocterS] = useState(new Doctor());

    const [scheduleToday, setSchedule] = useState(new Schedule())

    const [hrini, setHrini] = useState('');

    const [hrend, setHrend] = useState('');



    const handleDelete = (e) => {
        e.preventDefault();

        axios.delete(`${BASE_URL}/appointment/` + userAppointment.id).then(response => {
            console.log(response.data)
        })
        navigate('/appointment')


    }

    const handleDetails = () => {

        navigate('/' + userAppointment.id);

    }


    useEffect(() => {

        async function carregaConsultas() {
            axios.get(`${BASE_URL}/appointment`).then(response => {
                if (response.data) {
                    response.data.map(appointment => (
                        appointment.id === AppointmentID.id ? setAppointment(appointment) : ''
                    

                    ))

                }

            })
        }

        carregaConsultas()


    }, [AppointmentID])


    useEffect(() => {

        async function carregaAgendamento() {

            axios.get(`${BASE_URL}/schedule`).then(response=>{

                if(response.data){
                    response.data.map(day => (
                        day.id === userAppointment.id ? setSchedule(day) : ''
                    ))
                }


            })

        }

        carregaAgendamento();

    }, [userAppointment])


    useEffect(() => {

        let day = ''
        let dateformat = new Date(scheduleToday.hr_ini)
        if (dateformat !== undefined) {
            day = (dateformat.getDay() < 10 ? '0' + dateformat.getDay() : dateformat.getDay()) + '/' + (dateformat.getMonth() < 10 ? '0' + dateformat.getMonth() : dateformat.getMonth()) + ' - ' + dateformat.getHours() + ':' + dateformat.getMinutes() + dateformat.getSeconds() + ' Horas'
            setHrini(day)
        }
    }, [scheduleToday])




    useEffect(() => {

        let hr = scheduleToday.hrend
        if(hr !== undefined){
            console.log("OK")
            setHrend(scheduleToday.hrend)
        }
        


    }, [scheduleToday])

    useEffect(() => {


        setDocterS(scheduleToday);


    }, [scheduleToday])

    useEffect(() => {

        async function carregaMedico() {

            
            axios.get(`${BASE_URL}/doctors`).then(response=>{
                

                if(response.data){
                    response.data.map(doc => (
                        doc.id === doctorSchedule.id ? setDoctor(doc) : ''
                    ))
                }


            })

        }

        carregaMedico();
        
    }, [scheduleToday])







    return (
        <div className="col">
            <div className="card shadow-sm">
                <img className="bd-placeholder-img card-img-top" src=
                {userDoctor.spec === 'Geral' ? img2 : img1} alt="Aerfacs" 
                />
                {console.log(userDoctor.spec)}

                <div className="card-body">
                    <p className="card-text">{"Local: " + userAppointment.ubs.loc}</p>
                    <p className="card-text">{"Data: " + hrini !== undefined ? hrini : ''}</p>
                    <div className="d-flex justify-content-between align-items-center">
                        <div className="btn-group">
                            <Button className="btn-sm btn-primary btn-outline" onClick={handleDetails}>
                                Visualizar
                            </Button>
                            <Button className="btn-sm btn-danger btn-outline" onClick={handleDelete}>
                                Cancelar
                            </Button>
                        </div>
                    </div>

                </div>
                {userAppointment.appointmentStatus === 'CONFIRMED' ?
                <Alert className="alert-success">Presen??a confirmada</Alert>
                : <Alert className="alert-danger">Aguardando confirma????o</Alert>
                }

            </div>
        </div>


    );
}

export default Consultas;