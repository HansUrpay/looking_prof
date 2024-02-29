import React, { useState, useMemo, useEffect } from 'react';
import Cards from '../../UI/cards/Cards';
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
import axios from 'axios';

const Services = () => {
    const [profession, setProfession] = useState('');
    const [stars, setStars] = useState('');
    const [sortOrder, setSortOrder] = useState('desc');
    const [provincia, setProvincia] = useState({});
    const [servicesData, setServicesData] = useState([])
    const [provinciaData, setProvinciaData] = useState([])
    const navigate = useNavigate();

    useEffect(() => {
        let didCancel = false; // Flag to track whether the component is unmounted

        const fetchServicesData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/user/all');
                if (!didCancel) { // Only update state if the component is still mounted
                    setServicesData(response.data);
                }
            } catch (error) {
                console.error(error);
            }
        }

        fetchServicesData();

        return () => {
            didCancel = true; // Set flag to true when the component unmounts
        };
    }, []);

    const uniqueProfessions = useMemo(() => {
        // Filter out only "PROFESSIONAL" roles first, then map their professions
        const professionalItems = servicesData.filter((item) => item.ROLE === "PROFESSIONAL");
        const professions = professionalItems.map((item) => item.profession);

        // Use Set to retrieve unique professions 
        return [...new Set(professions)];
    }, [servicesData]);


    const handleProfessionChange = (event) => {
        setProfession(event.target.value);
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
        if (profession) {
            filteredData = filteredData.filter(item => item.profession === profession);
        }
        if (provincia.provincia && provincia.provincia) {
            filteredData = filteredData.filter(item => item.provincia === provincia.provincia);
        }
        if (provincia.localidad && provincia.localidad) {
            filteredData = filteredData.filter(item => item.city === provincia.localidad);
        }
        if (stars) {
            filteredData = filteredData.filter(item => item.starts.toString() === stars);
        }
        return filteredData;
    }, [profession, provincia, stars]);

    const sortedServicesData = useMemo(() => {
        let data = [...filteredServicesData];
        if (sortOrder === 'desc') {
            data.sort((a, b) => b.starts - a.starts);
        } else {
            data.sort((a, b) => a.starts - b.starts);
        }
        return data;
    }, [filteredServicesData, sortOrder]);
    const professionals = servicesData.filter((item) => item.role === 'PROFESSIONAL');

    const hasProfessionals = sortedServicesData.length > 0;
    console.log(provincia)
    useEffect(()=>{
        const id = provincia.toString()
        const getProvincias = async()=>{
            if(!provincia){
                return
            
            }
        try {
            
                const response = await axios.get(`http://localhost:8080/province/get/${id}`)
                setProvinciaData(response.data)
            }
         catch (error) {
            console.log(error)
        }}
        getProvincias()
    },[setProvinciaData])
    console.log(provinciaData)
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
                                value={profession}
                                label="Profesión"
                                onChange={handleProfessionChange}
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                {uniqueProfessions.map((profession) => (
                                    <MenuItem key={profession} value={profession} />
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
                {professionals.length > 0 && (
                    <div className='grid grid-cols-3 gap-2 w-full max-w-6xl'>
                        {professionals.map((item) => (
                            <div key={item.idUser} className='m-2 border-[#004466] border-2 rounded-lg h-auto'>
                                <Cards className='p-4'>
                                    <img src={item.imageUrl} alt={item.profession} className='w-full h-[200px] rounded-lg mb-4 object-cover' /> {/* image source corrected, width changed to be responsive */}
                                    <div className='flex flex-col text-start'>
                                        <h4 className='font-semibold text-xl'>{item.firstName} {item.lastName}</h4>
                                        <p className='text-sm'>{item.profession}</p>
                                        <p className='text-sm'>{item.city}</p>
                                    </div>
                                    <div className='flex py-2'>
                                        <Button variant='contained' color='primary' onClick={() => navigate(`/services/${item.idUser}`)}>
                                            Contactar
                                        </Button>
                                    </div>
                                </Cards>
                            </div>
                        ))}
                    </div>
                )}
            </div>


        </section>
    );
};

export default Services;
