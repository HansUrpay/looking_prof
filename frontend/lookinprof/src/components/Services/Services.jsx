import React from 'react';
import Cards from '../../UI/cards/Cards';
import { servicesData } from '../../utils';
import { Button } from '@mui/material';
import { RiStarSFill, RiStarSLine } from "react-icons/ri";
import ServiciosImages from '../../assets/ServiciosImages.svg';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

const Services = () => {
  // Ordenar el array servicesData según la propiedad starts
  const sortedServicesData = servicesData.sort((a, b) => b.starts - a.starts);
  const [age, setAge] = React.useState('');

  const handleChange = (event) => {
    setAge(event.target.value);
  };

  return (
    <section className='p-10 flex flex-col justify-center items-center'>
      <div className='flex flex-row w-[1100px]'>
        <img src={ServiciosImages} alt="" />
        <div className='flex flex-col gap-y-4'>
          <h2 className='text-[#004466] text-5xl font-bold'>Encuentra a los mejores profesionales cerca de ti</h2>
          <h5 className='text-[#223139] text-xl font-bold'>Filtrar profesionales por:</h5>
          <div>
          <FormControl sx={{ m: 1, minWidth: 120 }} size="small">
      <InputLabel id="demo-select-small-label">Age</InputLabel>
      <Select
        labelId="demo-select-small-label"
        id="demo-select-small"
        value={age}
        label="Age"
        onChange={handleChange}
      >
        <MenuItem value="">
          <em>None</em>
        </MenuItem>
        <MenuItem value={10}>Ten</MenuItem>
        <MenuItem value={20}>Twenty</MenuItem>
        <MenuItem value={30}>Thirty</MenuItem>
      </Select>
    </FormControl>

          </div>
        </div>
      </div>
      <div className='grid grid-cols-3 w-[1100px]'>
        {sortedServicesData.map((item, index) => (
           <div key={index} className='m-2 border-[#004466] border-2 rounded-lg h-auto'>
           <Cards className='p-4'>
             <div>
               <img src={item.image} alt={item.title} className='w-[400px] h-[200px] rounded-lg mb-4' />
             </div>
             <div className='flex flex-col text-start'>
               <h4 className='font-semibold text-xl'>{item.title}</h4>
               <p className='text-sm'>{item.prof}</p>
               <div className='flex flex-row gap-1 items-center'>
                 {item.starts}
                 {[...Array(Math.floor(item.starts))].map((_, i) => (
                   <RiStarSFill key={i} className='text-yellow-500' />
                 ))}
                 {item.starts % 1 !== 0 && (
                   <RiStarSLine className='text-yellow-500' />
                 )}
               </div>

             </div>
             <div className='flex py-2'>
               <Button variant='contained' color='primary'>
                 Contactar
               </Button>
             </div>

           </Cards>
         </div>
        ))}
      </div>
    </section>
  );
};

export default Services;
