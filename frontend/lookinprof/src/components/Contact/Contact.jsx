import { useNavigate } from 'react-router-dom';
import React, { useState } from 'react';
import mountainImage from '../../assets/montain.png';
import manSettingsImage from '../../assets/manSettings.svg';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

import axios from 'axios';

const Contact = () => {
  const [userName, setUserName] = useState('');
  const [userLastName, setUserLastName] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [userMessage, setUserMessage] = useState('');
  const [userSubject, setUserSubject] = useState('');
  const navi = useNavigate();
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
     await axios.post('http://localhost:8080/supportContact/create', {
        userName,
        lastName: userLastName,
        email: userEmail,
        description: userMessage,
        asunt: userSubject,
      },{
        headers: {
            'Access-Control-Allow-Origin': '*',
        }
    });
      window.confirm("Estas seguro de querer enviar el soporte?",{
        buttons: {
          confirm: {
            label: 'Si',
            className: 'btn-success'

        },
        cancel: {
            label: 'No',
            className: 'btn-danger'}

      },
      }, setTimeout(
        () => {
          alert("Sera redirrecionado al Home")
          navi('/');
        }, 3000
      ));
      
      // Optionally handle successful response here
    } catch (error) {
      console.error('Error sending data:', error);
      // Optionally handle error here
    }
  };
 

  return (
    <div className="flex flex-row lg:relative h-screen lg:justify-evenly items-center" style={{ backgroundImage: `url(${mountainImage})`, backgroundSize: 'cover',  backgroundRepeat:'no-repeat', backgroundColor:'50%'}}>
      <img src={manSettingsImage} alt="manSettings" className=" p-[43px] hidden lg:block" />

      <div className="shadow-2xl rounded-3xl shadow-gray-400 px-10 py-5 flex flex-col justify-between w-1/4 bg-white">
        <div>
          <h3 className='text-4xl text-[#004466] font-bold'>
            Contactanos
          </h3>
          <p className='text-xs py-2'>
            Envianos tu consulta a nuestro mail
          </p>
        </div>
        <form className="flex flex-col align-items: center justify-content: center space-y-2 " onSubmit={handleSubmit}>
          <TextField
            label="Nombre"
            placeholder="Nombre"
            variant="outlined"
            type='text'
            required
            value={userName}
            onChange={(e) => setUserName(e.target.value)}
            size='small'
          />
          <TextField
            label="Apellido"
            placeholder="Apellido"
            variant="outlined"
            type='text'

            required
            value={userLastName}
            onChange={(e) => setUserLastName(e.target.value)}
            size='small'
          />
          <TextField
            label="Correo Electrónico"
            placeholder="Correo Electrónico"
            variant="outlined"
            type='email'
            required
            value={userEmail}
            onChange={(e) => setUserEmail(e.target.value)}
            size='small'
          />
          <TextField
            label="Asunto"
            placeholder="Asunto"
            variant="outlined"
            type='text'
            required
            value={userSubject}
            onChange={(e) => setUserSubject(e.target.value)}
            size='small'
          />
          
          <textarea
             minRows={3}
            variant="outlined"
            className='border-2 border-gray-400 rounded-md p-1 hover:border-[#004466] selection:border-[#004466]'
            aria-label="maximum height"
            placeholder="Descripción"
            required
            value={userMessage}
            onChange={(e) => setUserMessage(e.target.value)}
          ></textarea>
          <Button type="submit" variant="contained">Enviar</Button>
        </form>
      </div>
    </div>
  );
};

export default Contact;
