import React, { useState, useEffect } from "react";
import axios from "axios";
import {Link, useNavigate} from "react-router-dom";
import '../../App.css';

export default function AddMenuItems () {
    let navigate = useNavigate();

    const [menuItem, setMenuItem] = useState({
        title: "",
        description: "",
    })

    const { title, description } = menuItem;

    const onInputChange = (e) => {
        setMenuItem({...menuItem, [e.target.name]: e.target.value});
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/api/v1/menuItems", menuItem);
        navigate("/menuItems");
    };

    useEffect(() => {
        // 👇️ scroll to top on page load
        window.scrollTo({top: 0, left: 0, behavior: "instant"});
    }, []);

    return (
        <div className="menuItems">
            <form onSubmit={(e) => onSubmit(e)}>
                <label>
                    Title
                </label>
                <input
                    type={"text"}
                    placeholder={"Title"}
                    name={"title"}
                    value={title}
                    onChange={(e) => onInputChange(e)}
                />
                <label>
                    Description
                </label>
                <input
                    type={"text"}
                    placeholder={"Description"}
                    name={"description"}
                    value={description}
                    onChange={(e) => onInputChange(e)}
                />
                <button type={"submit"}>
                    Submit
                </button>
            </form>
        </div>
    )
}