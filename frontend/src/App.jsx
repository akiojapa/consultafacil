import { useState } from 'react'
import './App.css'
import NavBar from './Components/NavBar/NavBar'
import Home from './pages/Home/Home'
import Login from './pages/Login/Login'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
        <Login />
    </div>
  )
}

export default App
