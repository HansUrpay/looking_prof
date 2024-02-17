import React from 'react'
import { useParams } from 'react-router-dom'
import { servicesData } from '../../utils'
import { Button } from '@mui/material'
import { FaStar } from "react-icons/fa";

const ServicesDetails = () => {
    const { id } = useParams()
    const serviceItem = servicesData.find(item => item.id.toString() === id) 

    let lastGoodComment = null; 
    if (serviceItem) {
        for (let i = serviceItem.feedback.length - 1; i >= 0; i--) {
            const feedback = serviceItem.feedback[i];
            if (feedback.stars === 5) {
                lastGoodComment = feedback.comment;
                break;
            }
        }
    }

    return (
        <div className='flex flex-col justify-center items-center pt-10'>
            {serviceItem && (
                <div>
                    <section className='flex flex-row gap-8 w-[1100px]'>
                        <div className='flex flex-col gap-6 m-2'>
                            <div className=''>
                                <h2 className='text-4xl w-[700px] text-[#004466] font-extrabold'>{serviceItem.title}</h2>
                            </div>
                            <div>
                                <h5 className='font-semibold'>Lugar de residencia</h5>
                                <span>{serviceItem.city}</span>
                            </div>
                            <div>
                                <h5 className='font-semibold'>Acerca de {serviceItem.name}</h5>
                                <p>{serviceItem.description}</p>
                            </div>
                        </div>
                        <div className='border-[1px] p-4 rounded-xl shadow-lg' >
                            <div className='flex flex-col items-center justify-center w-[300px]'>
                                <img src={serviceItem.image} alt="" className='rounded-full bg-center w-[200px] h-[200px]'/>
                                <h5 className='font-bold text-xl'>{serviceItem.name}</h5>
                                <p className='text-sm'>{serviceItem.prof}</p>
                                <p className='text-xs'>{serviceItem.starts}</p>
                                {lastGoodComment && ( 
                                    <div>
                                        <p className='text-xs p-4 w-[250px] text-center'>{lastGoodComment}</p>
                                    </div>
                                )}
                                <Button variant='contained' color='primary'>Contactar</Button>
                            </div>
                        </div>
                    </section>
                    <section className='p-2'>
                        <h4>Opiniones del servicio</h4>
                        <div className='flex flex-row items-center gap-2 bg-yellow-200 w-[200px] rounded-full py-1 px-4'>
                        <FaStar className='text-yellow-300'/>
                            <span className='text-black/40 text-xs' >{serviceItem.starts}</span>

                            <p className='text-xs'>{serviceItem.feedback.length} opiniones</p>
                        </div>
                        
                        {serviceItem.feedback.map(item =>
                            <div key={item.id} className='flex flex-row gap-4'>
                                <p>{item.comment}</p>
                                <p>{item.stars}</p>
                            </div>)
                        }
                    </section>
                    <section></section>
                </div>
            )}
        </div>
    )
}

export default ServicesDetails
