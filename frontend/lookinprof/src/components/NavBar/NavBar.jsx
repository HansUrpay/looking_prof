import React from 'react'
import { Link, NavLink } from 'react-router-dom'
export const links = [
    {
        path:'/',
        name:'Inicio',
    },
    {
        path:'/services',
        name:'Servicios',
    },
    {
        path:'/contact',
        name:'Contacto',
    },
    {
        path:'/login',
        name:'Login',
    },
    {
        path:'/register',
        name:'Registrarme',
    }
]

const NavBar = () => {

  return (
   <nav className=''>
    <div className='flex flex-col justify-between'>
        <Link to={'/'}>
            Looking Prof
        </Link>
        <div>
            {
                links.map((item, index) => (
                    <p key={index}>
                        <NavLink to={item.path}>{item.name}</NavLink>
                    </p>
                ))
            }
        </div>

    </div>
   </nav>
  )
}

export default NavBar