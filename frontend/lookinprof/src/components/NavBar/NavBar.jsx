import { Button } from '@mui/material'
import React, { useState, useEffect, useRef } from 'react'
import { Link, NavLink } from 'react-router-dom'

export const links = [
    {
        path: '/',
        name: 'Inicio',
    },
    {
        path: '/services',
        name: 'Servicios',
    },
    {
        path: '/contact',
        name: 'Contacto',
    },
    {
        path: '/login',
        name: 'Login',
    },
    {
        path: '/register',
        name: 'Registrarme',
    },
    {
        path: '/profile',
        name: 'Perfil',
    },
]

const NavBar = () => {
    const [active, setActive] = useState(0);
    const [menuOpen, setMenuOpen] = useState(false);
    const navRef = useRef(null);

    const toggleMenu = () => {
        setMenuOpen(!menuOpen);
    };

    useEffect(() => {
        const closeMenuOnScroll = () => {
            setMenuOpen(false);
        };

        const closeMenuOnClickOutside = (e) => {
            if (navRef.current && !navRef.current.contains(e.target)) {
                setMenuOpen(false);
            }
        };

        window.addEventListener('scroll', closeMenuOnScroll);
        document.addEventListener('mousedown', closeMenuOnClickOutside);

        return () => {
            window.removeEventListener('scroll', closeMenuOnScroll);
            document.removeEventListener('mousedown', closeMenuOnClickOutside);
        };
    }, []);

    return (
        <nav ref={navRef} className='w-full h-24 sticky top-0 bg-white flex items-center justify-between px-4 md:px-20 z-20'>
            <div className='flex items-center'>
                <Link to={'/'} className='font-bold text-xl'>
                    LookingProf
                </Link>
            </div>
            <div className='flex items-center'>
                <div className="lg:hidden p-2">
                    <button className="text-gray-800 hover:text-gray-600 focus:text-gray-600 focus:outline-none"
                            onClick={toggleMenu}>
                        <svg className="h-6 w-6 fill-current" viewBox="0 0 24 24">
                            <path fillRule="evenodd"
                                  d="M4 6h16a1 1 0 0 1 0 2H4a1 1 0 0 1 0-2zm0 5h16a1 1 0 1 1 0 2H4a1 1 0 0 1 0-2zm0 5h16a1 1 0 1 1 0 2H4a1 1 0 1 1 0-2z"/>
                        </svg>
                    </button>
                </div>
                <div className={`hidden lg:flex flex-row items-center justify-center md:gap-2`}>
                    {links.map((item, index) => (
                        <div key={index}
                             className={`${active === index && 'text-[#004466] after:w-full after:bg-[#004466] font-bold'} 
                                        ${item.name !== "Login" && item.name !== "Registrarme" && 'after:h-[2px] after:w-0 after:bg-[#004466] relative after:absolute after:-bottom-1 after:left-0'}
                                    `}>
                            <NavLink to={item.path} className=''
                                     onClick={() => setActive(index)}>
                                {item.name === "Registrarme" ? (
                                    <Button variant="contained" color='primary'>Registrarme</Button>
                                ) : item.name === "Login" ? (
                                    <Button variant="outlined" color='success'>Login</Button>
                                ) : (
                                    item.name
                                )}
                            </NavLink>
                        </div>
                    ))}
                </div>
            </div>
            {menuOpen && (
                <div className="lg:hidden absolute top-20 right-4 bg-white shadow-md rounded-md z-10">
                    {links.map((item, index) => (
                        <NavLink key={index} to={item.path}
                            className={`block py-2 px-4 ${active === index && 'text-[#004466] font-bold'}`}
                            onClick={() => {
                                setActive(index);
                                toggleMenu();
                            }}>
                            {item.name === "Registrarme" ? (
                                <p className='text-blue-600'>Registrarme</p>
                            ) : item.name === "Login" ? (
                                <p className='text-green-600'>Login</p>
                            ) : (
                                item.name
                            )}
                        </NavLink>
                    ))}
                </div>
            )}
        </nav>
    )
}

export default NavBar
