import React, {useEffect} from "react";
import '../../App.css';
import MainSection from "../MainSection";
import Cards from "../Cards";

function Home () {

    useEffect(() => {
        // 👇️ scroll to top on page load
        window.scrollTo({top: 0, left: 0, behavior: "instant"});
    }, []);

    return (
        <>
            <MainSection />
            <Cards />
        </>
    )
}

export default Home