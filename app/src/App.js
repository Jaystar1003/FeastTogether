import React from 'react';
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import './App.css';
import Navbar from "./components/Navbar";
import Home from "./components/pages/Home";
import Ingredients from "./components/pages/Ingredients";
import MenuItems from "./components/pages/MenuItems";
import SignUp from "./components/pages/SignUp";
import SingleUsers from "./components/pages/SingleUsers";
import Footer from "./components/Footer";
import AddIngredients from "./components/pages/AddIngredients";
import AddMenuItems from "./components/pages/AddMenuItems";
import AddSingleUsers from "./components/pages/AddSingleUsers";
import SignIn from "./components/pages/SignIn";

const App = () => {

    return (
        <>
            <Router>
                <Navbar />
                <Routes>
                    <Route path="/" element={ <Home /> }/>
                    <Route path="/ingredients" element={ <Ingredients /> } />
                    <Route path="/menuItems" element={ <MenuItems /> } />
                    <Route path="/users" element={ <SingleUsers /> } />
                    <Route path="/sign-up" element={ <SignUp /> } />
                    <Route path="/login" element={ <SignIn /> } />
                    <Route path="/ingredients/add" element={ <AddIngredients/> } />
                    <Route path="/menuItems/add" element={ <AddMenuItems/> } />
                    <Route path="/users/add" element={ <AddSingleUsers/> } />
                </Routes>
                <Footer />
            </Router>
        </>
    );
}

export default App;