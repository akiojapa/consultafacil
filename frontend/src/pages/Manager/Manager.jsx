import { useState } from "react";
import { Button, Container } from "react-bootstrap";
import Footer from "../Footer/Footer";
import Header from "../Header/Header";

const Mangager = () => {
    
    const [query,setQuery] = useState('')
    
    
    return ( 
        <>
        <Header />
        <main>
        <Button className="d-flex m-4">Voltar</Button>
            <section className="py-5 text-center container">

                <div className="row py-lg-5">
                    <div className="col-lg-6 col-md-8 mx-auto">
                        <h1 className="fw-light">Agendamento de Consultas</h1>
                        <p className="lead text-muted">Aqui você editar as consultas marcadas dos clientes para então melhorarem seus horários</p>
                        <p>

                            <form className="g-3 mt-4" method="POST">
                            <input type="text" sub/>
                            <Button className="m-2" >
                                Agendar Consulta
                            </Button>
                            </form>
                        
                        
                        </p>

                    </div>
                </div>
            </section>

            <div className="album py-5 bg-light">
                

                <h1 className="mb-5">Minhas consultas</h1>
                <Container>
                    <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

                        {/* {
                           listAppointments.map((consulta, index) => (
                                
                                <Consulta key={index} AppointmentID={consulta} />
                            )) 
                        } */}
                    
                    </div>
                </Container>
            </div>
        </main>
        <Footer />
    </>
    );
}
 
export default Mangager;