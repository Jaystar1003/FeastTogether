import React from "react";
import {Button} from "./Button";
import './Footer.css';
import {Link} from "react-router-dom";

function Footer() {
    return (
        <div className="footer-container">
            <section className="footer-subscription">
                <p className="footer-subscription-heading">
                    Join the FeastTogether Newsletter!
                </p>
                <p className="footer-subscription-text">
                    You can unsubscribe at any time.
                </p>
                <div className="input-areas">
                    <form>
                        <input type="email" name="email" placeholder="Your Email"
                               className="footer-input"/>
                        <Link to={"/sign-up"}>
                            <Button buttonStyle="btn--outline">Subscribe</Button>
                        </Link>
                    </form>
                </div>
            </section>
            <div className="footer-links">
                <div className="footer-link-wrapper">
                    <div className="footer-link-items">
                        <h2>About Us</h2>
                        <Link to='/sign-up'>How it works</Link>
                        <Link to='/sign-up'>Terms of Service</Link>
                    </div>
                    <div className="footer-link-items">
                        <h2>Contact Us</h2>
                        <Link to='/sign-up'>Contact</Link>
                        <Link to='/sign-up'>Support</Link>
                    </div>
                </div>
            </div>
            <section className="social-media">
                <div className="social-media-wrap">
                    <div className="footer-logo">
                        <Link to="/" className="social-logo">
                            FeastTogether <img src={require("../images/faviconFT.png")}
                                               alt="ft-logo" width="30" height="30" />
                        </Link>
                    </div>
                    <small className="website-rights">FeastTogether © 2023</small>
                    <div className="social-icons">
                        <Link className="social-icon-link facebook"
                            to="/"
                            target="_blank"
                            aria-label='Facebook'
                        >
                            <i className="fab fa-facebook-f"></i>
                        </Link>
                        <Link className="social-icon-link instagram"
                              to="/"
                              target="_blank"
                              aria-label='Instagram'
                        >
                            <i className="fab fa-instagram"></i>
                        </Link>
                        <Link className="social-icon-link twitter"
                              to="/"
                              target="_blank"
                              aria-label='Twitter'
                        >
                            <i className="fab fa-twitter"></i>
                        </Link>
                        <Link className="social-icon-link linkedin"
                              to="/"
                              target="_blank"
                              aria-label='LinkedIn'
                        >
                            <i className="fab fa-linkedin"></i>
                        </Link>
                    </div>
                </div>
            </section>
        </div>
    )
}

export default Footer