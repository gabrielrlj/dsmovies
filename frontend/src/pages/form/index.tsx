import FormCard from "components/formCard";
import { useParams } from "react-router-dom";



function Form() {

    const params = useParams();

    return (
        //transformando id do filme em string (o atribudo do params vem da url, nome definido na rota no App.tsx)
       <FormCard movieId={`${params.movieId}`}/> 
    );
}

export default Form;