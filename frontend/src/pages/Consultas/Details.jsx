import axios from "axios";
import { useState } from "react";
import { useEffect } from "react";
import { Button, Container } from "react-bootstrap";
import { BsCalendarDateFill, BsFillCheckSquareFill, BsFillClockFill, BsFillPeopleFill, BsFillPinMapFill, BsFillStarFill } from "react-icons/bs";
import { useParams } from "react-router";
import { BASE_URL } from "../../../utils/request";
import { Doctor } from "../../models/Doctor";
import { Patient } from "../../models/Patient";
import { Schedule } from "../../models/Schedule";
import { UBS } from "../../models/UBS";



import { toast } from 'react-toastify';


import img1 from '../../assets/Consultas/geral.jpg'
import img2 from '../../assets/Consultas/Odontologia.jpg'

import Footer from "../Footer/Footer";
import Header from "../Header/Header";

import { useNavigate } from "react-router";

import './Details.css'


class Props {
    id = Number;
    appointmentStatus = String;
    patient = Patient;
    schedule = Schedule;
    ubs = UBS;
}




const Details = () => {

    const navigate = useNavigate();

    const doc = new Doctor()


    const params = useParams();

    const [doctor, setDoctor] = useState(doc)


    const [details, setDetails] = useState(new Props())

    const [patient, setPatient] = useState(new Patient())
    
    const [schedule, setSchedule] = useState(new Schedule())

    const [dayA, setDay] = useState('');

    const [hrini, setHrini] = useState('');

    const [hrend, setHrend] = useState('');




    const handleConfirm = (e) => {
        e.preventDefault()

        if(patient.cel !== undefined){
    
        axios.put(`${BASE_URL}/appointment/` + details.id, { id: details.id, appointmentStatus: 1, pacient: details.patient, schedule: details.schedule, ubs: details.ubs });
    
        axios(`${BASE_URL}/appointment/` + details.id + `/notification`).then(response => {

            navigate(0)    

        });

        toast.info("um SMS com as informações da consulta agendada foi enviada a: " + patient.cel);


    }






    }

    const handleButtonBack = () => {

        navigate(-1)

    }
    

    useEffect(() => {

        const fetchAppointment = async () => {

            const data = await axios.get(`${BASE_URL}/appointment/` + params.id)
            setDetails(data.data);

        }
        fetchAppointment();


    }, [])

    // useEffect(() => {

    //     const fetchPatient = async () => {

    //         const data = await axios.get(`${BASE_URL}/patients`)
    //         if(details.patient !== undefined){
    //             data.data.map(patientdata => (
    //                 details.patient.id === patientdata.id ? setPatient(patientdata) : ''
    //             ))

    //         }

    //     }
    //     fetchPatient()

    // }, [details])

    useEffect(() => {

        const fetchSchedule = async () => {

            const data = await axios.get(`${BASE_URL}/schedule`)
            if(data.data){
                data.data.map(scheduledata => (
                    scheduledata.id === details.schedule.id ? setSchedule(scheduledata) : ''
                ))
            }


        }
        fetchSchedule()


    }, [details])


    

    useEffect(() => {

        let day = ''
        let dateformat = new Date(schedule.hr_ini)
        let dateformatend = new Date(schedule.hr_end)
        if (dateformat !== undefined) {
            day = (dateformat.getDay() < 10 ? '0' + dateformat.getDay() : dateformat.getDay()) + '/' + (dateformat.getMonth() < 10 ? '0' + dateformat.getMonth() : dateformat.getMonth())
            setDay(day)
            day = dateformat.getHours() + ':' + dateformat.getMinutes() + dateformat.getSeconds()
            setHrini(day)
            day = dateformatend.getHours() + ':' + dateformatend.getMinutes() + dateformatend.getSeconds()
            setHrend(day);

        }


    }, [schedule])



    return (
        <>
            <Header />
            <Button className="d-flex m-4" onClick={handleButtonBack}>Voltar</Button>
            <Container>
                <h1>Consulta: {doctor.spec}</h1>
                <hr className="col-8 col-md-12 mb-3" />
                <div className="row g-5">
                    <div className="col-md-6 show-container-image d-flex justify-content-center">
                        <img src={schedule.docSchedule.spec == 'Geral' ? img1 : img2} alt=""
                            className="shadow image-med" />
                    </div>



                    <div className="col-md-6">
                        <h2>Informações</h2>
                        <ul className="list-group show-list-event">
                            <li className="my-2">
                                <BsFillStarFill />
                                Nome da UBS: {details.ubs.name}
                            </li>
                            <li className="my-2">
                                <BsFillPinMapFill />
                                Local: {details.ubs.loc}
                            </li>

                            <li className="my-2">
                                <BsFillPeopleFill />
                                Médico: {schedule.docSchedule.name}
                            </li>
                            <li className="my-2">
                                <BsCalendarDateFill />
                                Data: {dayA}
                            </li>
                            <li className="my-2">
                                <BsFillClockFill />
                                Horário: {hrini}
                            </li>

                        </ul>
                        {details.appointmentStatus !== 'CONFIRMED' ?       <button type="submit" className="btn-confirm mt-3" id="event-submit" onClick={handleConfirm}>
                            Confirmar presença
                        </button> : <button type="submit" className="btn-confirm mt-3" id="event-submit" >
                            Presença confirmada
                        </button>}

                            <p className="mt-4">
                                Caso a presença não seja confirmada um dia antes da consulta, ela será cancelada automaticamente.
                            </p>

                    </div>

                </div>




                <hr className="col-8 col-md-12 mb-3" />




                <div className="d-flex m-auto desc">



                    <div className="mb-auto w-100 d-flex justify-content-center flex-column">
                        <h3 className="text-center m-4 col-md-12">Pedimos que ao chegar:</h3>
                        <ul className="list-group show-list-event-items m-4">
                            <li className="my-2">
                                <BsFillCheckSquareFill />
                                Utilize Máscara
                                <span>
                                </span>
                            </li>
                            <li className="my-2">
                                <BsFillCheckSquareFill />
                                Utilize álcool em gel
                                <span>
                                </span>
                            </li>
                            <li className="my-2">
                                <BsFillCheckSquareFill />
                                Confirme a presença
                                <span>
                                </span>
                            </li>
                        </ul>
                    </div>
                </div>



            </Container>
            <Footer />
        </>
    );

}

export default Details;