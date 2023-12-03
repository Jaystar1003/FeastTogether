import React, {useEffect, useState} from "react";
import '../../App.css';
import axios from "axios";
import {Button} from "../Button";
import {Link} from "react-router-dom";

export default function SingleUsers() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/singleUsers')
            .then(response => response.data)
            .then(data => {
                setUsers(data);
            })
    }, []);

    useEffect(() => {
        // 👇️ scroll to top on page load
        window.scrollTo({top: 0, left: 0, behavior: "instant"});
    }, []);

    return (
        <div className="users">
            <h1>Users</h1>
            {users.length!==0 ?
                <table className="users-table">
                    <tr>
                        <th className="users-table-header"> User Name</th>
                        <th className="users-table-header"> First Name</th>
                        <th className="users-table-header"> Last Name</th>
                        <th className="users-table-header"> Email</th>
                    </tr>
                    {users.map(group =>
                        <tr>
                            <td className="users-table-item"> {group.userName} </td>
                            <td className="users-table-item"> {group.firstName} </td>
                            <td className="users-table-item"> {group.lastName} </td>
                            <td className="users-table-item"> {group.email} </td>
                        </tr>
                    )}
                </table> :
                <h2>Click below to add the first User!</h2>
            }
            <div className="bottom-button">
                <Link to={"/users/add"}>
                    <Button buttonStyle="btn--outline" buttonTheme="btn--dark">Add new User</Button>
                </Link>
            </div>
        </div>
    )
}