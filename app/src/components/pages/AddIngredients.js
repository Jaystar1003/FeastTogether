import React, { useState, useEffect } from "react";
import axios from "axios";
import {Link, useNavigate} from "react-router-dom";
import '../../App.css';
import './AddIngredients.css';

export default function AddIngredients () {

    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);

    let navigate = useNavigate();

    const [ingredient, setIngredient] = useState({
        name: "",
    })

    const { name } = ingredient;

    const onInputChange = (e) => {
        setIngredient({...ingredient, [e.target.name]: e.target.value});
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/api/v1/ingredients", ingredient);
        navigate("/ingredients");
    };

    useEffect(() => {
        // 👇️ scroll to top on page load
        window.scrollTo({top: 0, left: 0, behavior: "instant"});
    }, []);

    return (
        <div className="ingredients">
            <button onClick={handleClick}>Click me</button>
            <div className={click ? 'add-ingredients active' : 'add-ingredients'}>
                <h3>New Ingredient</h3>
                <form onSubmit={(e) => onSubmit(e)}>
                    <label>
                        Name
                    </label>
                    <input
                    type={"text"}
                    placeholder={"Name"}
                    name={"name"}
                    value={name}
                    onChange={(e) => onInputChange(e)}
                    />
                    <button type={"submit"}>
                        Submit
                    </button>
                </form>
            </div>
        </div>
    )
}