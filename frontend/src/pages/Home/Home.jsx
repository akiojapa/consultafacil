import React from 'react';
import Header from '../Header/Header';
import Footer from '../Footer/Footer';

import './Home.css'
import { Carousel, Button,Card} from 'react-bootstrap';
import img1 from '../../assets/image1.jpeg'
import img2 from '../../assets/image2.jpg'
import img3 from '../../assets/image3.jpeg'
import cardimg1 from '../../assets/irmaos-MAIN.jpg'
import cardimg2 from '../../assets/pote-com-aveia-orig-1.jpg'
import cardimg3 from '../../assets/chn-grávida-alimentação.png'
import cardimg4 from '../../assets/triste.jpg'
import { User } from '../../models/User';
import axios from 'axios';
import { BASE_URL } from '../../../utils/request';
import { useEffect } from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router';
import { toast } from 'react-toastify';


const Home = () => {

    const navigate = useNavigate();

    const [userlog, setUser] = useState(new User());

const handleConfUser = (e) => {

    e.preventDefault();

    if(userlog.logged === true){
        navigate('/appointment')
    }
    else{
        navigate('/login')
    }





}


useEffect(() => {

    axios.get(`${BASE_URL}/users`).then(
        response => {
            response.data.map(
                user => (
                    user.logged === true ? setUser(user) : ''
                )
                

            )
        }
    )





}, [])



    return (
        <>
            <Header />
            <main>
                <Carousel id='myCarousel' className='slide m-4'>
                    <Carousel.Item className='container-img-carousel'>
                        <img
                            className="d-block w-100 img-carousel"
                            src={img1}
                            alt="First slide"
                        />
                        <Carousel.Caption className='text-start'>
                            <h3>O que é saúde digital?</h3>
                            <p>Saúde digital: O que é e como acompanhar as mudanças do mercado?</p>
                            <Button>Leia mais</Button>
                        </Carousel.Caption>
                    </Carousel.Item>

                    <Carousel.Item  className='container-img-carousel'>
                        <img
                            className="d-block w-100 img-carousel"
                            src={img2}
                            alt="Second slide"
                        />
                        <Carousel.Caption className='text-start'>
                            <h3>6 Dicas para manter a saúde do coração.</h3>
                            <p></p>
                            <Button>Confira</Button>
                        </Carousel.Caption>
                    </Carousel.Item>

                    <Carousel.Item className='container-img-carousel'>
                        <img
                            className="d-block w-100 img-carousel"
                            src={img3}
                            alt="Third slide"
                        />

                        <Carousel.Caption>
                            <h3>Vacina da gripe</h3>
                            <p>
                            Prefeitura de Maringá mantém vacinação contra a gripe para pessoas acima de 6 meses.
                            </p>
                            <Button className='btn-carousel'>Acompanhe</Button>
                        </Carousel.Caption>
                    </Carousel.Item>
                </Carousel>
            </main>
        <div className="content-appointment d-flex align-items-center justify-content-center mb-4 flex-column">
            <h2>Guia Médico</h2>
            <p>Sua busca ainda mais fácil.
                Encontre médicos, clínicas e laboratórios perto de você.</p>
               <Button className='btn-appointment me-2' onClick={handleConfUser}> Consulte agora</Button>
        </div>
        <div className="container">
            <div className="row">
                <div className="col-sm-6 col-lg-3 mb-4">
                    <div className="card shadow">
                        <img src={cardimg1} className="img-card" />
                        <div className="card-body d-flex flex-column text-center justify-content-center">
                            <h5 className="card-title">Card title that wraps to a new line</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in
                                to
                                additional content. This content is a little bit longer.</p>
                                <Button className='btn btn-card'>Continue Lendo</Button>
                        </div>
                    </div>
                </div>
                <div className="col-sm-6 col-lg-3 mb-4">
                    <div className="card shadow">
                        <img src={cardimg2} className="img-card" />
                        <div className="card-body d-flex flex-column text-center justify-content-center">
                            <h5 className="card-title">Card title that wraps to a new line</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in
                                to
                                additional content. This content is a little bit longer.</p>
                                <Button className='btn btn-card'>Continue Lendo</Button>
                        </div>
                    </div>
                </div>
                <div className="col-sm-6 col-lg-3 mb-4">
                    <div className="card shadow">
                        <img src={cardimg3}  className="img-card" />
                        <div className="card-body d-flex flex-column text-center justify-content-center">
                            <h5 className="card-title">Card title that wraps to a new line</h5>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in
                                to
                                additional content. This content is a little bit longer.</p>
                                <Button className='btn btn-card'>Continue Lendo</Button>
                        </div>
                    </div>
                </div>
                <div className="col-sm-6 col-lg-3 mb-4">
                    <div className="card shadow">
                        <img src={cardimg4} className="img-card" />
                        <div className="card-body d-flex flex-column text-center justify-content-center">
                            <Card.Title>
                            Card title that wraps to a new line</Card.Title>
                            <p className="card-text">This is a longer card with supporting text below as a natural lead-in
                                to
                                additional content. This content is a little bit longer.</p>
                                <Button className='btn btn-card'>Continue Lendo</Button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <Footer />
        </>

    );
}

export default Home;