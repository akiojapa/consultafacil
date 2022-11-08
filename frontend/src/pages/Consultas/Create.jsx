import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { Navigate, useAsyncError, useNavigate } from "react-router";
import { BASE_URL } from "../../../utils/request";
import { Doctor } from "../../models/Doctor";
import { Patient } from "../../models/Patient";
import { Schedule } from "../../models/Schedule";
import { UBS } from "../../models/UBS";
import { User } from "../../models/User";
import Footer from "../Footer/Footer";
import Header from "../Header/Header";


class Props {
    id = Number;
    appointmentStatus = String;
    schedule = Schedule;
    patient = Patient;
    ubs = UBS;
}


const Create = () => {

    const navigate = useNavigate()

    const consultas = new Array(Schedule);

    const [dayAppointment, setDayAppointment] = useState('');

    const [dayActive, setDayActive] = useState('')

    const [UBSs, setUBSs] = useState(new Array(UBS))

    const [userlogged, setUserLoged] = useState(new Patient())

    const [appointments,setAppointment] = useState(consultas)

    const [doctors,setdoctors] = useState(new Array(Doctor))

    const [choosedoc,setchooseDoc] = useState('')

    const [chooseubs, setchooseUBS] = useState('')

    const handleButtonAppointment = (e) => {


        

        e.preventDefault();
        console.log(userlogged)

        console.log(chooseubs)




        
         navigate('/appointment')


         axios.post(`${BASE_URL}/appointment`, {id: 0, appointmentStatus: 0, pacient: userlogged, schedule: dayActive, ubs: chooseubs}),

         
         
         axios.get(`${BASE_URL}/schedule`).then(response => {
            response.data.map(day => (



                day.hr_ini === dayAppointment && day.docSchedule.id === choosedoc.id ? 
                axios.put(`${BASE_URL}/schedule/` + day.id, {id: day.id, day_schedule: day.day_schedule, hr_ini: day.hr_ini, hr_end: day.hr_end, condition: "Busy", docSchedule: dayActive.docSchedule})
                : ''
            
                ))

            }
        )

        

        

    
    }



    const handleButtonBack = () => {

        navigate(-1)

    }


    const handleChangeUBS = (e) => {

        axios.get(`${BASE_URL}/ubs`).then(response=>{
            
            console.log(response.data)
            response.data.map(ubs => (
                ubs.name === e.target.value ? setchooseUBS(ubs) : ''
            ))
            

        })
    
        
    }

    const handleChangeDoctor = (e) => {

        axios.get(`${BASE_URL}/doctors`).then(response => {
            response.data.map(doc => (
                doc.spec === e.target.value ? setchooseDoc(doc) : ''
            ))

        })


    }

    useEffect(() => {

        const fetchUser = async () => {

            const data = await axios.get(`${BASE_URL}/patients`)
            data.data.map(user => (
                user.user.logged === true ? setUserLoged(user) : ''
            ))

        }
        fetchUser()

    }, [])

    useEffect(() => {

        const fetchUBSs = async () => {

            const data = await axios.get(`${BASE_URL}/ubs`)
            setUBSs(data.data)


        }
        fetchUBSs();
        
    }, [])


    
    useEffect(() => {

        const fetchDoc = async () => {

            const data = await axios.get(`${BASE_URL}/ubs`)
            data.data.map(ubs => (
                ubs.name === chooseubs.name ? setdoctors(ubs.doctors) : ''
            ))


        }
        fetchDoc();
        

    }, [chooseubs])


    useEffect(() => {

        const fetchAppointment = async () => {

            let list = []

            const data = await axios.get(`${BASE_URL}/schedule`)
            data.data.map(day => (
                day.condition === 'Free' && day.docSchedule.id === choosedoc.id ? list.push(day) : ''
            ))


            setAppointment(list)

        }
        fetchAppointment()


    }, [choosedoc])

    useEffect(() => {

        const fetchDayActive = async () => {

            const data = await axios.get(`${BASE_URL}/schedule`)
            data.data.map(day => (
                day.hr_ini === dayAppointment && day.docSchedule.id === choosedoc.id ? setDayActive(day) : ''
            ))


        }
        fetchDayActive()


    }, [dayAppointment])






    return (

        <>
            <Header />
            <Button className="d-flex m-4" onClick={handleButtonBack}>Voltar</Button>
            <div id="event-create-container" className="container">

                <h1>Agende sua consulta!</h1>

                <form onSubmit={handleButtonAppointment} method="POST" className="row g-3 mt-4">
                    <div className="col-md-12">
                        <label for="title" className="form-label">Paciente a ser consultado</label>
                        <input type="text" className="form-control" id="title" name="title" disabled value={userlogged.name}/>
                    </div>

                    <div>
                        <label for="state" className="form-label">Selecione a UBS</label>
                        <select id="state" className="form-select" name="state" required onChange={handleChangeUBS}>
                        <option selected disabled value="">Ubs...</option>
                            {UBSs.map(ubs => (
                                <option value={ubs.name}>{ubs.name}</option>
                            ))}

                        </select>
                    </div>

                    <div>
                        <label for="state" className="form-label">Tipo de consulta</label>
                        <select id="private" className="form-select" name="private" disabled={chooseubs.length === 0  ? true : false} onChange={handleChangeDoctor} required>
                        <option selected disabled value="" >Especialidade...</option>

                        {doctors.map(doctor => (
                                <option value={doctor.spec}>{doctor.spec}</option>
                            ))}
                        </select>
                    </div>

                    <div>
                        <label for="date" className="form-label">Datas disponíveis</label>
                        <select id="state" className="form-select" name="state" disabled={choosedoc.length === 0 ? true : false} required  onChange={(e) => setDayAppointment(e.target.value)}>
                        <option selected disabled value="">Data e hora da consulta...</option>
                        {
                        appointments.map(day => (<option value={day.hr_ini}>{
                                        (new Date(day.hr_ini).getDay() < 10 ? '0' + new Date(day.hr_ini).getDay() : new Date(day.hr_ini).getDay()) + '/' + 
                                        (new Date(day.hr_ini).getMonth() < 10 ? '0' + new Date(day.hr_ini).getMonth() : new Date(day.hr_ini).getMonth()) + ' às ' + (new Date(day.hr_ini).getHours() + 3)  + ':' + new Date(day.hr_ini).getMinutes() + new Date(day.hr_ini).getSeconds() + ' horas '
                                    }</option> 
                                ))                               
                            }
                        
                        </select>



                    </div>

                    <div className="col-md-12">
                        <label for="description" className="form-label">Caso julgue necessário informe o motivo da consulta e caso haja sintomas, o que está sentindo?</label>
                        <textarea className="form-control" id="description" name="description" rows="3"></textarea>
                    </div>

                    <div className="col-12 mb-4">
                        <button type="submit" className="btn btn-primary" >Agendar consuta</button>
                    </div>

                </form>

            </div>
            <Footer />
        </>
    );
}

export default Create;
