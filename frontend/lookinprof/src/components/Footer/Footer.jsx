import React from 'react'
import { FaFacebook, FaInstagram, FaTwitter, FaLinkedinIn} from "react-icons/fa";
import { Link } from 'react-router-dom';

const SocialsNetwork =[
  {
    name:"Facebook",
    icon:<FaFacebook/>,
  },{
    name:"Instagram",
    icon:<FaInstagram/>,
  },{
    name:"Twitter",
    icon:<FaTwitter/>,
  },{
    name:"LinkedIn",
    icon:<FaLinkedinIn/>,
  },  
]

const Footer = () => {
  return (
    <div className='w-full h-96 bg-[#004466] pt-6 pl-10 pr-10 flex flex-col justify-between m-auto items-center' >
      <div className='grid grid-cols-5 justify-center gap-10 text-white'> 
        <div className='w-[350px]'>
          <h2 className='text-white text-[40px]' >LookingProf</h2>
          <span className='text-sm text-white'>Siguenos en:</span>

          <div className='flex flex-row items-center mt-2 gap-4'>
            {
              SocialsNetwork.map((item, index)=>{
                return(
                  <div key={index}>
                    <Link to='#' className='text-white gap-2 text-2xl'>
                    {item.icon}
                    </Link>
                  </div>
                )
              })
            }
          </div>
        </div>
        <div className='mt-3'>
          <h3 className='text-lg font-semibold'>About</h3>
          <ul className='m-2 py-2 text-sm' >
            <li className='py-2'>Company</li>
            <li className='py-2'>Leadership</li>
            <li className='py-2'>Jobs - HIRING!</li>
            <li className='py-2'>Pricing</li>
            <li className='py-2'>Press</li>
            <li className='py-2'>Inventors</li>
          </ul>
        </div>
        <div className='mt-3'>
        <h3 className='text-lg font-semibold'>Solutions</h3>
          <ul className='m-2 text-sm'>
          <li className='py-2'>At School</li>
            <li className='py-2'>At Work</li>
            <li className='py-2'>At Home</li>
          </ul>
        </div>
        <div className='mt-3'>
          <h3 className='text-lg font-semibold'>Resources</h3>
          <ul className='m-2 text-sm'>
          <li className='py-2'>Study with Kurtis</li>
            <li className='py-2'>Blog</li>
            <li className='py-2'>Kurtis Certified</li>
            <li className='py-2'>Help Center</li>
            <li className='py-2'>Library</li>
            <li className='py-2'>Shop</li>
            <li className='py-2'>Safety center</li>

          </ul>
        </div>
        <div className='mt-3'>
          <h3 className='text-lg font-semibold'>Terms and conditions</h3>
          <ul className='m-2 text-sm'>
          <li className='py-2'>Terms and Conditions</li>
          <li className='py-2'>Privacy Policy</li>
          <li className='py-2'>US Privacy Laws</li>
          <li className='py-2'>Children’s Privacy Policy</li>
          <li className='py-2'>Inclusion and Accessibility policy</li>
          </ul> 
        </div>
      </div>
      <div className='flex flex-col justify-start'>
        <span className='text-[10px] text-white p-2'>Copyright @ 2024, LookingProf All rights reserved.</span>
      </div>
    </div>
  )
}

export default Footer