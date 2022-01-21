import axios from "axios";
import MovieCard from "components/moviecard";
import Pagination from "components/pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing(){

    const [sorting, setSorting] = useState<string>('');
    const [pageNumber, setPageNumber] = useState(0);
    const [page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 10,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    useEffect(() => {

        axios.get(`${BASE_URL}/movies?page=${pageNumber}${sorting}`)
        .then( response => {
            const data = response.data as MoviePage;
            setPageNumber(data.number); 
            setPage(data);
            setSorting(sorting);
        });

    }, [pageNumber, sorting]);


    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    };

    const handleSortChange = (newSort: string) => {
        let sort = `&sort=${newSort}`
        setSorting(sort);
    };


    return (
        <>
            <Pagination page={page} onChange={handlePageChange} onSortChange={handleSortChange}/>
            <div className="container">
                <div className="row">
                    {page.content.map(movie => {
                        return (
                            <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                                <MovieCard movie={movie}/>        
                            </div>   
                        );
                    })}
        
                </div>
            </div>
        </>
    );
}

export default Listing;