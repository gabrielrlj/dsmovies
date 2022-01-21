import {ReactComponent as Arrow} from "assets/img/arrow.svg";
import Sorting from "components/sorting";
import { MoviePage } from "types/movie";
import "./styles.css"

type Props = {
    page: MoviePage,
    onChange: Function,
    onSortChange: Function
}

function Pagination({page, onChange, onSortChange} : Props){

    return (
        <div className="container" id="container">
            <Sorting onChange={onSortChange} />

            <div className="dsmovie-pagination-container">
                <div className="dsmovie-pagination-box">
                    <button className="dsmovie-pagination-button" disabled={page.first} 
                        onClick={() => onChange(page.number - 1)}>
                        <Arrow />
                    </button>
                    <p>{`${page.number + 1} de ${page.totalPages}`}</p>
                    <button className="dsmovie-pagination-button" disabled={page.last} 
                        onClick={() => onChange(page.number + 1)}>
                        <Arrow className="dsmovie-flip-horizontal" />
                    </button>
                </div>
            </div>
        </div>
    );
}

export default Pagination;