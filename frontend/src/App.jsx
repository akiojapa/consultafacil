import { useEffect, useState } from 'react'
import './App.css'
import NavBar from './Components/NavBar/NavBar'
import Home from './pages/Home/Home'
import Login from './pages/Login/Login'
import 'bootstrap/dist/css/bootstrap.min.css';
import {Routes, Route} from 'react-router-dom'
import Consultas from './pages/Consultas/Consultas'
import Details from './pages/Consultas/Details'
import axios from 'axios'
import { BASE_URL } from '../utils/request'
import Create from './pages/Consultas/Create'
import Mangager from './pages/Manager/Manager'

function App() {
  const [appointments, setAppointments] = useState([])

  useEffect(() => {

    const fetchAppointment = async() => {
      const data = await axios.get(`${BASE_URL}/appointment`);
      setAppointments(data)

    }
    fetchAppointment();


  }, [])



  
  return (
    
    <div className="App">
        <Routes>
          <Route exact path ="/login" element={ < Login />}/>
          <Route exact path ="appointment/login" element={ < Login />}/>
          <Route exact path= "/" element={< Home />}/>
          <Route exact path= "/appointment" element={< Consultas />}/>
          <Route path = ':id' element={ < Details />}/>
          <Route exat path='/appointment/create/' element={< Create />} />
          <Route exat path = '/appointment/Adm' element={< Mangager />}/>
        </Routes>

    </div>



  )
}

export default App
