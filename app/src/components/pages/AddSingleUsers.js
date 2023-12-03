import React, { useState, useEffect } from "react";
import axios from "axios";
import {Link, useNavigate} from "react-router-dom";
import '../../App.css';

export default function AddSingleUsers () {
    let navigate = useNavigate();

    const [user, setUser] = useState({
        userName: "",
        firstName: "",
        lastName: "",
        email: "",
        password: ""
    })

    const { userName, firstName, lastName, email, password } = user;

    const onInputChange = (e) => {
        setUser({...user, [e.target.name]: e.target.value});
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        // await axios.post("http://localhost:8080/api/v1/singleUsers", user);
        await axios.post("http://localhost:8080/api/v1/registration", user);
        navigate("/");
    };

    useEffect(() => {
        window.scrollTo({top: 0, left: 0, behavior: "instant"});
    }, []);

    return (
        <div className="users">
            <form onSubmit={(e) => onSubmit(e)}>
                <label>
                    User Name
                </label>
                <input
                    type={"text"}
                    placeholder={"User Name"}
                    name={"userName"}
                    value={userName}
                    onChange={(e) => onInputChange(e)}
                />
                <label>
                    First Name
                </label>
                <input
                    type={"text"}
                    placeholder={"First Name"}
                    name={"firstName"}
                    value={firstName}
                    onChange={(e) => onInputChange(e)}
                />
                <label>
                    Last Name
                </label>
                <input
                    type={"text"}
                    placeholder={"Last Name"}
                    name={"lastName"}
                    value={lastName}
                    onChange={(e) => onInputChange(e)}
                />
                <label>
                    Email
                </label>
                <input
                    type={"email"}
                    placeholder={"Email"}
                    name={"email"}
                    value={email}
                    onChange={(e) => onInputChange(e)}
                />
                <label>
                    Password
                </label>
                <input
                    type={"password"}
                    placeholder={"Password"}
                    name={"password"}
                    value={password}
                    onChange={(e) => onInputChange(e)}
                />
                <button type={"submit"}>
                    Submit
                </button>
            </form>
        </div>
    )
}