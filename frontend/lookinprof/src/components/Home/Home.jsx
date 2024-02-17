import { Button } from '@mui/material'
import React from 'react'
import { FaStar } from "react-icons/fa";
import ImageHome from './../../assets/Group.svg'
import ImageHome2 from './../../assets/ImageHomeSection2.svg'
import Cards from '../../UI/cards/Cards';
import { servicesData } from '../../utils';
import { useNavigate } from 'react-router-dom';
import { RiStarSFill, RiStarSLine } from "react-icons/ri";

const Home = () => {
  const navigate = useNavigate()
  const sortedServicesData = servicesData.sort((a, b) => b.starts - a.starts);
  const servicesHome = sortedServicesData.slice(0, 6);
  const handleClickContact = () => {
    navigate('/services')
  }
  return (
    <div className='w-full h-full flex flex-col justify-center items-center pt-2 py-6'>
      {/* Section 1 de la pagina principal */}
      <div className='m-6 p-6 flex flex-col md:flex-row justify-center items-center lg:w-[1100px] min-w-[320px] p-auto '>
        <div className=' lg:p-6 w-full md:w-[60%] flex flex-col items-center lg:items-start lg:justify-between gap-6'>          
          <h2 className='lg:mt-4 text-2xl text-[#004466] font-black'>¿Necesitas ayuda? Encuentra al profesional perfecto aquí</h2>
          <p className=''>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Risus nullam eget felis eget nunc lobortis mattis aliquam. </p>
          <div className='w-26'>
            <Button variant='contained' color='primary' onClick={handleClickContact}>Quiero Contactar</Button>
          </div>
          <div className='flex flex-row items-center gap-4'>
            <div className='bg-yellow-500 w-8 h-8 flex items-center justify-center rounded-xl'>
              <FaStar />
            </div>
            <span className='text-xs'>Nuestra valoración  4.9 de 1200 reviews</span>
          </div>
        </div >
        <img src={ImageHome} alt="" className='m-4 hidden lg:block max-h-[400px] md:max-h-[500px] rounded-xl' />
      </div>

      {/* Section 2 de la pagina principal */}
      <section className='flex flex-col items-center justify-center w-full gap-y-4'>
        <h3 className='text-[#004466] text-xl text-center p-4'>Nuestra selección de profesionales</h3>
        <div className='grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 w-auto max-w-[1100px] min-w-[320px] p-2 justify-center'>
          {servicesHome.map((item, index) => (
            <div key={index} className='m-2 border-[#004466] border-2 rounded-lg h-auto'>
              <Cards className='p-4'>
                <div>
                  <img src={item.image} alt={item.title} className='w-full h-[200px] object-cover rounded-lg mb-4' />
                </div>
                <div className='flex flex-col text-start'>
                  <h4 className='font-semibold text-xl'>{item.title}</h4>
                  <p className='text-sm'>{item.prof}</p>
                  <div className='flex flex-row gap-1 items-center'>
                    {[...Array(Math.floor(item.starts))].map((_, i) => (
                      <RiStarSFill key={i} className='text-yellow-500' />
                    ))}
                    {item.starts % 1 !== 0 && (
                      <RiStarSLine className='text-yellow-500' />
                    )}
                  </div>
                </div>
                <div className='flex py-2'>
                  <Button variant='contained' color='primary'onClick={() => navigate('/login')}>
                    Contactar
                  </Button>
                </div>
              </Cards>
            </div>
          ))}
        </div>
        <div>
          <Button variant='contained' color='primary' onClick={handleClickContact} >Ver más...</Button>
        </div>
      </section>

      {/* Section 3 de la pagina principal */}
      <div className='bg-[#FCE6C4] w-full max-w-[1100px] rounded-xl flex flex-col items-center justify-center m-10 p-10'>
        <div className='w-full flex flex-row items-center justify-evenly'>
          <div className='border-l-8  border-[#004466] p-1 m-1'><p className='m-1 text-sm'>Mas del 50% de nuestros profesionales son expertos</p></div>
          <div className='border-l-8  border-[#004466] p-1 m-1'><p className='m-1 text-sm'>Id interdum velit laoreet id donec</p></div>
          <div className='border-l-8  border-[#004466] p-1 m-1'><p className='m-1 text-sm'>Id interdum velit laoreet id donec</p></div>
        </div>
        <div className='flex flex-row w-full'>
        <img src={ImageHome2} alt="" className='hidden md:block w-[50%] h-[400px] ml-36' />

        
        <div className='flex flex-col justify-center items-center gap-10'>
          <h2 className='text-4xl font-bold'>¿Te animas a empezar?</h2>
          <div>
            <Button variant='contained' color='primary' onClick={() => navigate('/register')}>Ofrecer Servicios</Button>
          </div>
        </div>
        </div>
      </div>
    </div>
  )
}

export default Home
