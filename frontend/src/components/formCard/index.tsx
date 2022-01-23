import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Movie } from "types/movie";
import { BASE_URL } from "utils/requests";
import { validateEmail } from "utils/validate";
import "./styles.css"

type Props = {
    movieId: string;  
}


function FormCard({movieId} : Props) {

    const navigate = useNavigate();
    const [movie, setMovie] = useState<Movie>();

    useEffect(() => {
        axios.get(`${BASE_URL}/movies/${movieId}`)
            .then(response => {
                setMovie(response.data);
            });
    }, [movieId]);

    const handleSubmit = (event : React.MouseEvent<HTMLButtonElement, MouseEvent>) => {

        let email = $('#email').val();
        let pontuacao = $('#score').val();
        
        if(!validateEmail(email)){
            $('.dsmovie-form').addClass('was-validated');
            return;
        }

        const score = {
            movieId: movieId,
            email: email,
            score: pontuacao
        }

        console.log(score);

        axios.put(`${BASE_URL}/scores`, score)
            .then( response => {
               navigate("/");
            });
        
    }

    return (
        <div className="dsmovie-form-container">
            <img className="dsmovie-movie-card-image" src={movie?.image} alt={movie?.title} />
            <div className="dsmovie-card-bottom-container">
                <h3>{movie?.title}</h3>
                <form className="dsmovie-form" noValidate>
                    <div className="form-group dsmovie-form-group">
                        <label htmlFor="email">Informe seu email</label>
                        <input required type="email" className="form-control" id="email" placeholder="Digite um e-mail válido"/>
                        <div className="invalid-feedback">
                            Por favor informe um endereço de e-mail válido
                        </div>
                    </div>
                    <div className="form-group dsmovie-form-group">
                        <label htmlFor="score">Informe sua avaliação</label>
                        <select className="form-control" id="score" required>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div className="dsmovie-form-btn-container">
                        <button onClick={(e) => {handleSubmit(e)}} type="button" className="btn btn-primary dsmovie-btn">Salvar</button>
                    </div>
                </form >
                <Link to="/">
                    <button className="btn btn-primary dsmovie-btn mt-3">Voltar</button>
                </Link>
            </div >
        </div >
    );
}

export default FormCard;