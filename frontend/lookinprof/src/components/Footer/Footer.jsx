import React from 'react'
import { FaFacebook, FaInstagram, FaTwitter, FaLinkedinIn } from "react-icons/fa";
import { Link } from 'react-router-dom';

const SocialsNetwork = [
  {
    name: "Facebook",
    icon: <FaFacebook />,
  }, {
    name: "Instagram",
    icon: <FaInstagram />,
  }, {
    name: "Twitter",
    icon: <FaTwitter />,
  }, {
    name: "LinkedIn",
    icon: <FaLinkedinIn />,
  },
]

const Footer = () => {
  return (
    <footer className='w-full bg-[#004466] py-10 px-6 md:px-20'>
      <div className='container mx-auto grid grid-cols-1 md:grid-cols-5 gap-10 text-white'>
        {/* Columna 1 */}
        <div>
          <h2 className='text-3xl font-bold mb-4'>LookingProf</h2>
          <p className='text-sm mb-4'>Siguenos en:</p>
          <div className='flex gap-4'>
            {SocialsNetwork.map((item, index) => (
              <Link key={index} to='#' className='text-2xl'>
                {item.icon}
              </Link>
            ))}
          </div>
        </div>
        {/* Columna 2 */}
        <div>
          <h3 className='text-lg font-semibold mb-4'>About</h3>
          <ul className='text-sm'>
            <li className='py-1'>Company</li>
            <li className='py-1'>Leadership</li>
            <li className='py-1'>Jobs - HIRING!</li>
            <li className='py-1'>Pricing</li>
            <li className='py-1'>Press</li>
            <li className='py-1'>Inventors</li>
          </ul>
        </div>
        {/* Columna 3 */}
        <div>
          <h3 className='text-lg font-semibold mb-4'>Solutions</h3>
          <ul className='text-sm'>
            <li className='py-1'>At School</li>
            <li className='py-1'>At Work</li>
            <li className='py-1'>At Home</li>
          </ul>
        </div>
        {/* Columna 4 */}
        <div>
          <h3 className='text-lg font-semibold mb-4'>Resources</h3>
          <ul className='text-sm'>
            <li className='py-1'>Study with Kurtis</li>
            <li className='py-1'>Blog</li>
            <li className='py-1'>Kurtis Certified</li>
            <li className='py-1'>Help Center</li>
            <li className='py-1'>Library</li>
            <li className='py-1'>Shop</li>
            <li className='py-1'>Safety center</li>
          </ul>
        </div>
        {/* Columna 5 */}
        <div>
          <h3 className='text-lg font-semibold mb-4'>Terms and conditions</h3>
          <ul className='text-sm'>
            <li className='py-1'>Terms and Conditions</li>
            <li className='py-1'>Privacy Policy</li>
            <li className='py-1'>US Privacy Laws</li>
            <li className='py-1'>Children’s Privacy Policy</li>
            <li className='py-1'>Inclusion and Accessibility policy</li>
          </ul>
        </div>
      </div>
      <div className='text-sm text-white text-center mt-8'>
        <p>Copyright @ 2024, LookingProf All rights reserved.</p>
      </div>
    </footer>
  )
}

export default Footer
