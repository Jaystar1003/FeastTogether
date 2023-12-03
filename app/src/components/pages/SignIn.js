import React, {useEffect, useState} from "react";
import '../../App.css';
import {useNavigate} from "react-router-dom";
import axios from "axios";

export default function SignIn() {
    let navigate = useNavigate();

    const [user, setUser] = useState({
        username: "",
        password: ""
    })

    const { username, password } = user;

    const onInputChange = (e) => {
        setUser({...user, [e.target.name]: e.target.value});
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/login", user);
        navigate("/");
    };

    useEffect(() => {
        window.scrollTo({top: 0, left: 0, behavior: "instant"});
    }, []);

    return (
        <div className="users">
            <h1>Login</h1>
            <form name='f' action="login" method='POST'
                  onSubmit={(e) => onSubmit(e)}>
                <table>
                    <tr>
                        <td>User:</td>
                        <td><input type='text' name='username'/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type='password' name='password' /></td>
                    </tr>
                    <tr>
                        <td><button name="submit" type="submit" value="submit" /></td>
                    </tr>
                </table>
            </form>
        </div>
    )
}