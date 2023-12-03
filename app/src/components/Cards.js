import React, {useEffect, useState} from "react";
import CardItem from "./CardItem";
import './Cards.css';
import axios from "axios";

function Cards() {

    const [menuItems, setMenuItems] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/menuItems')
            .then(response => response.data)
            .then(data => {
                setMenuItems(data);
            })
    }, []);

    return (
        <div className='cards'>
            <h1>Check out these fantastic Menu Items</h1>
            <div className="cards__container">
                <div className="cards__wrapper">
                    <ul className="cards__items">
                        {menuItems.length!==0 ? menuItems.map(group =>
                            <CardItem
                                src="images/chowder.jpg"
                                text={group.description}
                                label={group.title}
                                path={"/menuItems/" + group.title}
                            />

                        ) :
                            <h2>Nothing here yet!</h2>
                        }
                    </ul>
                </div>
            </div>
        </div>
    )
}

export default Cards