import React, {useEffect, useState} from "react";
import '../../App.css';
import axios from "axios";
import {Button} from "../Button";
import {Link} from "react-router-dom";

export default function MenuItems() {

    const [menuItems, setMenuItems] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/menuItems')
            .then(response => response.data)
            .then(data => {
                setMenuItems(data);
            })
    }, []);

    useEffect(() => {
        // 👇️ scroll to top on page load
        window.scrollTo({top: 0, left: 0, behavior: "instant"});
    }, []);

    return (
        <div className="menuItems">
            <h1>Menu Items</h1>
            {menuItems.length!==0 ?
                <table className="menuItems-table">
                    <tr>
                        <th className="menuItems-table-header"> Name</th>
                        <th className="menuItems-table-header"> Description</th>
                    </tr>
                    {menuItems.map(group =>
                        <tr>
                            <td className="menuItems-table-item"> {group.title} </td>
                            <td className="menuItems-table-item"> {group.description} </td>
                        </tr>
                    )}
                </table> :
                <h2>Click below to add the first Menu Item!</h2>
            }
            <div className="bottom-button">
                <Link to="/menuItems/add">
                    <Button buttonStyle="btn--outline" buttonTheme="btn--dark">Add new Menu Item</Button>
                </Link>
            </div>
        </div>
    )
}