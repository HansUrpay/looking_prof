import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { useSelector } from 'react-redux';

const ProtectedRoutes = () => {
    const { currentUser } = useSelector(state => state.user);
    // const { currentUser } = useSelector(state => state.userEntity);
    return currentUser ? <Outlet/> : <Navigate to='login'/>;
}

export default ProtectedRoutes;