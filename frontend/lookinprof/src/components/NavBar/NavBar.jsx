import { Button } from '@mui/material'
import React, { useState } from 'react'
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
    }
]

const NavBar = () => {
    const [active, setActive] = useState(0)
    return (
        <nav className='w-full h-24  sticky top-0 bg-white'>
            <div className='w-full h-16 flex flex-row items-center justify-between p-10'>
                <Link to={'/'} className='font-bold text-[36px]'>
                    LookingProf
                </Link>
                <div className='flex flex-row items-center justify-center gap-2'>
                    {
                        links.map((item, index) => {
                            return (
                                <div
                                    key={index}
                                    className={`${
                                        active === index &&
                                        'text-[#004466] after:w-full after:bg-[#004466] font-bold'} 
                                        ${item.name !== "Login" && item.name !== "Registrarme" && 'after:h-[2px] after:w-0 after:bg-[#004466] relative after:absolute after:-bottom-1 after:left-0'}
                                    `}>
                                    <NavLink to={item.path} className=''
                                        onClick={() => setActive(index)}
                                    >
                                        {item.name === "Registrarme" ? (
                                            <Button variant="contained" color='primary'>Registrarme</Button>
                                        ) : item.name === "Login" ? (
                                            <Button variant="outlined" color='success'>Login</Button>
                                        ) : (
                                            item.name
                                        )}
                                    </NavLink>
                                </div>
                            )
                        })
                    }
                </div>

            </div>
        </nav>
    )
}

export default NavBar
