import React, { useState, useEffect, useRef } from 'react';
import { Link, NavLink, useLocation, useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { setCurrentUser } from '../../redux/slices/userSlice';
import { Button } from '@mui/material';

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
    }
]

const NavBar = () => {
    const [active, setActive] = useState(0);
    const [menuOpen, setMenuOpen] = useState(false);
    const navRef = useRef(null);
    const location = useLocation();
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const { currentUser } = useSelector(({user}) => user);

    const toggleMenu = () => {
        setMenuOpen(!menuOpen);
    };

    useEffect(() => {
        const currentPath = location.pathname;
        const activeIndex = links.findIndex(link => link.path === currentPath);
        if (activeIndex !== -1) {
            setActive(activeIndex);
        }
    }, [location]);

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

    const logout = () => {
        dispatch(setCurrentUser(null));
        navigate('/');
    };

    return (
        <nav ref={navRef} className='w-full h-24 sticky top-0 bg-white flex items-center justify-between px-4 md:px-20 z-10'>
            <div className='flex items-center'>
                <Link to={'/'} className='font-bold text-xl'>
                    LookingProf
                </Link>
            </div>
            <div className='flex items-center'>
                <div className={`hidden lg:flex flex-row items-center justify-center md:gap-2`}>
                    {links.map((item, index) => (
                        <div key={index}
                             className={`${active === index && 'text-[#004466] after:w-full after:bg-[#004466] font-bold'} 
                                         ${item.name !== "Login" && item.name !== "Registrarme" && 'after:h-[2px] after:w-0 after:bg-[#004466] relative after:absolute after:-bottom-1 after:left-0'}
                                     `}>
                            {currentUser ? (
                                item.name === "Login" || item.name === "Registrarme" ? null : (
                                    <NavLink to={item.path} className='' onClick={() => setActive(index)}>
                                        {item.name}
                                    </NavLink>
                                )
                            ) : (
                                <NavLink to={item.path} className='' onClick={() => setActive(index)}>
                                    {item.name === "Registrarme" ? (
                                        <Button variant='outlined' color='primary' size='small'>Registrarme</Button> 
                                    ) : (
                                        item.name === "Login" ? (
                                            <Button variant='contained' color='success' size='small'>Login</Button>
                                        ) : (
                                            item.name
                                        )
                                    )}
                                </NavLink>
                            )}
                        </div>
                    ))}

                    {currentUser && (
                        <div className='ml-4 relative '>
                            <p className='w-[200px] font-bold cursor-pointer flex flex-row items-center justifr-center px-8 py-2 rounded-full bg-[#004466] text-white' onClick={toggleMenu}>
                                <p>{currentUser.firstName}</p>
                                <svg className="h-4 w-4 ml-1 fill-current" viewBox="0 0 24 24">
                                    <path d="M7 10l5 5 5-5z"/>
                                </svg>
                            </p>
                            {menuOpen && (
                                <div className="absolute top-10 right-0 z-10 text-end p-2">
                                    <NavLink to={'/profile'} className='block py-2 px-4 text-green-600 hover:bg-gray-800/10 rounded-xl font-bold'>
                                        Perfil
                                    </NavLink>
                                    <NavLink to={'/login'} className='block py-2 px-4 text-red-600 hover:bg-gray-800/10 rounded-xl font-bold' onClick={logout}>
                                        Cerrar sesión
                                    </NavLink>
                                </div>
                            )}
                        </div>
                    )}
                </div>
            </div>
            <div className="lg:hidden p-2">
                <button className="text-gray-800 hover:text-gray-600 focus:text-gray-600 focus:outline-none"
                        onClick={toggleMenu}>
                    <svg className="h-6 w-6 fill-current" viewBox="0 0 24 24">
                        <path fillRule="evenodd"
                              d="M4 6h16a1 1 0 0 1 0 2H4a1 1 0 0 1 0-2zm0 5h16a1 1 0 1 1 0 2H4a1 1 0 0 1 0-2zm0 5h16a1 1 0 1 1 0 2H4a1 1 0 1 1 0-2z"/>
                    </svg>
                </button>
            </div>
        </nav>
    );
};

export default NavBar;
