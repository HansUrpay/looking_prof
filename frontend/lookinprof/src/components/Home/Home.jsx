import { Button } from '@mui/material'
import React from 'react'
import { FaStar } from "react-icons/fa";
import ImageHome from './../../assets/home.jpeg'
import { useNavigate } from 'react-router-dom';

const Home = () => {
  const navigate = useNavigate()

  const handleclickContact = ()=>{
      navigate('/services')
  }
  return (
    <div className='w-full h-full flex flex-col justify-center items-center pt-10'>
      <div className='flex flex-row w-[1100px] h-[500px] items-center'>
        <div className='w-[40%] flex flex-col gap-6'>
          <h2 className='text-xl font-bold'>¿Necesitas ayuda? Encuentra al profesional perfecto aquí</h2>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Risus nullam eget felis eget nunc lobortis mattis aliquam. </p>
          <div className='w-26'>
            <Button variant='contained' color='primary' onClick={()=>handleclickContact()}>Quiero Contactar</Button>
            </div>
          <div className='flex flex-row items-center gap-4'><div className='bg-yellow-500 w-8 h-8 flex items-center justify-center rounded-xl'><FaStar/></div> <span className='text-xs'>Nuestra valoración  4.9 de 1200 reviews</span></div>
        </div>
        <div>
          <img src={ImageHome} alt="" />
        </div>

      </div>    
      <div>
        cards
        </div>
        <div>
          alta prof</div>  
    </div>
  )
}

export default Home