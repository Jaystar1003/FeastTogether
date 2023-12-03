import React, {useState, useEffect} from 'react'
import {Link} from "react-router-dom";
import './Navbar.css';
import {Button} from "./Button";

function Navbar() {
    const [click, setClick] = useState(false);
    const [button, setButton] = useState(true);
    const handleClick = () => setClick(!click);
    const closeMobileMenu = () => setClick(false);
    const showButton = () => {
        if (window.innerWidth <= 975) {
            setButton(false);
        } else {
            setButton(true);
        }
    }

    useEffect(() => {
        showButton()
    }, []);

    window.addEventListener('resize', showButton);

    return (
        <div className="navbar-all">
            <nav className="navbar">
                <div className="navbar-container">
                    <Link to="/" className="navbar-logo" onClick={closeMobileMenu}>
                        FeastTogether <img src={require("../images/faviconFT.png")}
                                           alt="ft-logo" width="40" height="40" />
                    </Link>
                    <div className="menu-icon" onClick={handleClick}>
                        <i className={click ? 'fas fa-times' : 'fas fa-bars'}/>
                    </div>
                    <ul className={click ? 'nav-menu active' : 'nav-menu'}>
                        <li className='nav-item'>
                            <Link to='/ingredients' className='nav-links' onClick={closeMobileMenu}>
                                Ingredients
                            </Link>
                        </li>
                        <li className='nav-item'>
                            <Link to='/menuItems' className='nav-links' onClick={closeMobileMenu}>
                                Menu Items
                            </Link>
                        </li>
                        <li className='nav-item'>
                            <Link to='/users' className='nav-links' onClick={closeMobileMenu}>
                                Users
                            </Link>
                        </li>
                        <li className='nav-item'>
                            <Link to='/sign-up' className='nav-links-mobile' onClick={closeMobileMenu}>
                                Sign Up
                            </Link>
                        </li>
                    </ul>
                    <div className='sign-up-btn'>
                        <Link to="/sign-up">
                            {button && <Button buttonStyle='btn--outline'>Sign Up</Button>}
                        </Link>
                    </div>
                </div>
            </nav>
        </div>
    )
}

export default Navbar