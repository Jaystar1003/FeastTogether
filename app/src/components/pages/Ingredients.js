import React, {useEffect, useState} from "react";
import '../../App.css';
import axios from "axios";
import {Button} from "../Button";
import {Link, useNavigate} from "react-router-dom";

export default function Ingredients() {

    const [ingredients, setIngredients] = useState([]);

    // !!!!!!!!!!!! //

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/ingredients')
            .then(response => response.data)
            .then(data => {
                setIngredients(data);
            }).catch((error) => {
                window.location.replace("http://localhost:3000/sign-up")
        })
    }, []);

    useEffect(() => {
        // 👇️ scroll to top on page load
        window.scrollTo({top: 0, left: 0, behavior: "instant"});
    }, []);

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
        <div>
            <div className={click ? 'ingredients active' : 'ingredients'}>
                <h1>Ingredients</h1>
                {ingredients.length!==0 ?
                    <table className="ingredients-table">
                        <tr>
                            <th className="ingredients-table-header"> Name</th>
                        </tr>
                        {ingredients.map(group =>
                            <tr>
                                <td className="ingredients-table-item"> {group.name} </td>
                            </tr>
                        )}
                    </table> :
                    <h2>Click below to add the first Ingredient!</h2>
                }

                <div className="bottom-button" onClick={handleClick}>
                    <Button buttonStyle="btn--outline" buttonTheme="btn--dark">Add new Ingredient</Button>
                </div>
            </div>
            <div className={click ? 'add-ingredients active' : 'add-ingredients'}>
                <div className="add-ingredients-container">
                    <h3 className="add-ingredients-header">New Ingredient</h3>
                    <form onSubmit={(e) => {
                        onSubmit(e);
                        handleClick();
                        setTimeout(() => window.location.reload(), 1000)
                    }}>
                        <label>
                            Name
                        </label>
                        <input
                            required={true}
                            minLength={2}
                            type={"text"}
                            placeholder={"Name"}
                            name={"name"}
                            value={name}
                            onChange={(e) => onInputChange(e)}
                            // onSubmit={handleClick}
                        />
                        <button type={"submit"}>
                            Submit
                        </button>
                    </form>
                </div>
            </div>
        </div>
    )
}