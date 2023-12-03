import React from 'react';
import './Button.css';
import { Link } from 'react-router-dom';

const STYLES = ['btn--primary', 'btn--outline'];

const SIZES = ['btn--medium', 'btn--large'];

const THEMES = ['btn--light', 'btn--dark'];

export var Button = ({
                           children,
                           type,
                           onClick,
                           buttonStyle,
                           buttonSize,
                           buttonTheme
                       }) => {
    const checkButtonStyle = STYLES.includes(buttonStyle)
        ? buttonStyle
        : STYLES[0];

    const checkButtonSize = SIZES.includes(buttonSize) ? buttonSize : SIZES[0];

    const checkButtonTheme = THEMES.includes(buttonTheme) ? buttonTheme : THEMES[0];

    return (
        <div className='btn-mobile'>
            <button
                className={`${checkButtonStyle} ${checkButtonSize} ${checkButtonTheme}`}
                onClick={onClick}
                type={type}
            >
                {children}
            </button>
        </div>
    );
};