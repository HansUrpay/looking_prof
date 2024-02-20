import { BrowserRouter, Routes, Route, Router } from "react-router-dom";
import Home from './components/Home/Home'
import Services from './components/Services/Services'
import Contact from './components/Contact/Contact'
import Login from './components/Login/Login'
import Register from './components/Register/Register'
import NotFound from './components/NotFound/NotFound'
import NavBar from './components/NavBar/NavBar'
import Footer from './components/Footer/Footer'
import ProtectedRoutes from './Routes/ProtectedRoutes'
import Profile from "./components/Profile/Profile";
import CheckOut from './components/Checkout/Checkout.jsx'
function App() {
  return (
    <BrowserRouter>
      <NavBar/>
      <Routes>
      <Route index element={<Home/>}/>
      <Route path='contact' element={<Contact/>}/>
      <Route path='login' element={<Login/>}/>
      <Route path='register' element={<Register/>}/>
      {/* <Route path='/*' element={<ProtectedRoutes/>}> */}
        <Route path='services' element={<Services/>}/>
        <Route path='profile' element={<Profile/>}/>
        <Route path='checkout' element={<CheckOut/>}/>

      {/* </Route> */}
      <Route path='*' element={<NotFound/>}/>
      </Routes>
      <Footer/>
    </BrowserRouter>
  );
}

export default App;