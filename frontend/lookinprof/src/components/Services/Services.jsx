import React, { useState, useMemo } from 'react';
import Cards from '../../UI/cards/Cards';
import { servicesData } from '../../utils';
import { Button } from '@mui/material';
import { RiStarSFill, RiStarSLine } from "react-icons/ri";
import ServiciosImages from '../../assets/ServiciosImages.svg';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import { useNavigate } from 'react-router-dom';
import { IoMdArrowRoundUp, IoMdArrowRoundDown } from "react-icons/io";
import SelectProvince from '../../UI/SelectProvince';

const Services = () => {
    const [profesion, setProfesion] = useState('');
    const [stars, setStars] = useState('');
    const [sortOrder, setSortOrder] = useState('desc');
    const [provincia, setProvincia] = useState({});

    const navigate = useNavigate();

    const uniqueProfessions = useMemo(() => [...new Set(servicesData.map(item => item.prof))], []);
    const uniqueStars = useMemo(() => {
        return [...new Set(servicesData.map(item => item.starts.toString()))];
    }, [servicesData]);

    const handleProfessionChange = (event) => {
        setProfesion(event.target.value);
        setProvincia({});
        setStars('');
    };

    const handleProvinciaChange = (nuevaProvincia) => {
        setProvincia(nuevaProvincia);
        setStars('');
    };

    const handleStarsChange = (event) => {
        setStars(event.target.value);
    };

    const handleSortOrderChange = () => {
        setSortOrder(sortOrder === 'desc' ? 'asc' : 'desc');
    };

    const filteredServicesData = useMemo(() => {
        let filteredData = [...servicesData];
        if (profesion) {
            filteredData = filteredData.filter(item => item.prof === profesion);
        }
        if (provincia.provincia && provincia.provincia) {
            filteredData = filteredData.filter(item => item.provincia === provincia.provincia);
        }
        if(provincia.localidad && provincia.localidad){
            filteredData = filteredData.filter(item => item.city === provincia.localidad);
        }
        if (stars) {
            filteredData = filteredData.filter(item => item.starts.toString() === stars);
        }
        return filteredData;
    }, [profesion, provincia, stars]);

    const sortedServicesData = useMemo(() => {
        let data = [...filteredServicesData];
        if (sortOrder === 'desc') {
            data.sort((a, b) => b.starts - a.starts);
        } else {
            data.sort((a, b) => a.starts - b.starts);
        }
        return data;
    }, [filteredServicesData, sortOrder]);

    const hasProfessionals = sortedServicesData.length > 0;
    console.log({provincia})
    return (
        <section className='p-10 flex flex-col justify-center items-center'>
            <div className='flex flex-row items-center justify-center w-[1100px]'>
                <img src={ServiciosImages} alt="" className='w-[400px] h-[400px]' />
                <div className='flex flex-col items-start justify-center gap-y-10'>
                    <h2 className='lg:mt-4 text-3xl text-[#004466] font-black w-[350px]'>Encuentra a los mejores profesionales cerca de ti</h2>
                    <h5 className='text-[#223139] text-xl font-bold'>Filtrar profesionales por:</h5>
                    <div className='flex flex-col gap-3'>
                        <FormControl className='w-[240px] text-[#004466]'>
                            <InputLabel id="profesion-select-label">Profesión</InputLabel>
                            <Select
                                labelId="profesion-select-label"
                                id="profesion-select-small"
                                value={profesion}
                                label="Profesión"
                                onChange={handleProfessionChange}
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                {uniqueProfessions.map((prof, index) => (
                                    <MenuItem key={index} value={prof}>{prof}</MenuItem>
                                ))}
                            </Select>
                        </FormControl>
                        <div>
                            <SelectProvince onProvinciaChange={handleProvinciaChange} />
                        </div>
                        <FormControl className='w-[240px] text-[#004466]'>
                            <InputLabel id="stars-select-label">Stars</InputLabel>
                            <Select
                                labelId="stars-select-label"
                                id="stars-select-small"
                                value={stars}
                                label="Stars"
                                onChange={handleStarsChange}
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                {uniqueStars.map((star, index) => (
                                    <MenuItem key={index} value={star}>{star}</MenuItem>
                                ))}
                            </Select>
                        </FormControl>

                    </div>
                </div>
            </div>
            <div className='h-[150px] flex flex-row items-center justify-between w-[1100px]'>
                <p>{servicesData.length} Profecionales disponibles</p>
                <Button onClick={handleSortOrderChange} className='flex gap-2'>
                    Ordenar {sortOrder === 'desc' ? <IoMdArrowRoundDown /> : <IoMdArrowRoundUp />}
                </Button>
            </div>
            <div className='flex flex-col items-center justify-center'>
                {hasProfessionals ? (
                    <div className='grid grid-cols-3 w-[1100px]'>{
                        sortedServicesData.map((item) => (
                            <div key={item.id} className='m-2 border-[#004466] border-2 rounded-lg h-auto'>
                                <Cards className='p-4'>
                                    <div>
                                        <img src={item.image} alt={item.title} className='w-[400px] h-[200px] rounded-lg mb-4' />
                                    </div>
                                    <div className='flex flex-col text-start'>
                                        <h4 className='font-semibold text-xl'>{item.name}</h4>
                                        <p className='text-sm'>{item.prof}</p>
                                        <p className='text-sm'>{item.city}</p>
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
                                        <Button variant='contained' color='primary' onClick={() => navigate(`/services/${item.id}`)}>
                                            Contactar
                                        </Button>
                                    </div>
                                </Cards>
                            </div>
                        ))}
                    </div>

                ) : (
                    <h3 className='text-3xl text-[#004466] text-center'>No se han encontrado profesionales</h3>
                )}
            </div>


        </section>
    );
};

export default Services;
