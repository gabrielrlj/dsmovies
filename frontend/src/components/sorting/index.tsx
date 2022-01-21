type Props = {
    onChange: Function;
}

function Sorting({onChange} : Props){

    return (
        <div className="dsmovie-sorting-container">
            <div className="dsmovie-sorting-box">
                <select onChange={(e) => onChange(e.target.value)}
                className="form-control dsmovie-sorting-select" id="score">
                    <option>Ordenar por...</option>
                    <option value="title,asc">Alfabética crescente</option>
                    <option value="title,desc">Alfabética decrescente</option>
                    <option value="score,desc">Maior avaliação</option>
                    <option value="score,asc">Menor avaliação</option>
                </select>
            </div>
        </div>

    );
}

export default Sorting;