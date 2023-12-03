import React from "react";
import {Button} from "./Button";
import './MainSection.css';
import '../App.css';
import {Link} from "react-router-dom";

function MainSection() {
    return (
        <div className='main-container'>
            <h1>A Feast Awaits</h1>
            <p>What are you waiting for?</p>
            <div className='main-btns'>
                <Link to="/sign-up">
                    <Button className='btns' buttonStyle='btn--outline' buttonSize='btn--large'>
                        Get Started
                    </Button>
                </Link>
            </div>
        </div>
    )
}

export default MainSection