import {ReactComponent as GitHubIcon} from 'assets/img/git.svg'
import './styles.css'

function Navbar(){
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>Meu catálogo pessoal</h1>
                    <a href="https://github.com/gabrielrlj">
                        <div className="dsmovie-contato-container">
                            <GitHubIcon />
                            <p className="dsmovie-contato-link">gabrielrlj</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;