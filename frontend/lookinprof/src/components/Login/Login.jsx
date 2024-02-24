import React, { useState, useEffect } from "react";
import mountain from "../../assets/montain.png";
import manSettings from "../../assets/manSettings.svg";
import FormControl from "@mui/material/FormControl";
import InputLabel from "@mui/material/InputLabel";
import OutlinedInput from "@mui/material/OutlinedInput";
import InputAdornment from "@mui/material/InputAdornment";
import IconButton from "@mui/material/IconButton";
import Visibility from "@mui/icons-material/Visibility";
import VisibilityOff from "@mui/icons-material/VisibilityOff";
import Typography from "@mui/material/Typography";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { setCurrentUser } from "../../redux/slices/userSlice";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Login = () => {
  const [showPassword, setShowPassword] = useState(false);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const dispatch = useDispatch();
  const navigate = useNavigate();

  useEffect(() => {
    // Verificar si hay datos de usuario en el local storage al cargar el componente
    const storedUser = JSON.parse(localStorage.getItem("currentUser"));
    if (storedUser) {
      // Si hay datos de usuario, establecer el correo electrónico en el estado
      setUsername(storedUser.username);
    }
  }, []);

  const handleClickShowPassword = () => setShowPassword(!showPassword);

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

  const handleEmailChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const signIn = async (e) => {
    e.preventDefault();
    // Suponiendo que no hay una API real, simplemente compararemos los datos con los simulados.
    // if (storedUser && storedUser.username === username && storedUser.password === password) {
    //   // Si los datos coinciden, iniciar sesión
    //   dispatch(setCurrentUser(storedUser));
    //   // Mostrar un mensaje de éxito y navegar al inicio
    //   navigate('/');
    // } else {
    //   // Mostrar mensaje de error o manejar la situación de credenciales incorrectas
    //   console.log("Credenciales incorrectas.");
    // }
    try {
      const responseData = await axios.post(
        "http://localhost:8080/auth/login",
        { username, password }
      );
      const token = responseData.data.token;
      localStorage.setItem("jwt", token);
      const [header, payload, signature] = token.split(".");
      const decodedPayload = JSON.parse(atob(payload));
      dispatch(setCurrentUser(decodedPayload));
      alert(`Hola de nuevo!! ${decodedPayload.firstName}`);
      navigate("/");
    } catch (error) {}
  };

 
  
  return (
    <div className=" flex flex-col-reverse lg:relative h-screen flex lg:justify-center items-center" style={{
      backgroundImage: `url(${mountain})`,
      backgroundSize: "cover",
    }}>

<img
        src={manSettings}
        alt="manSettings"
        className="absolute left-0 p-[43px] hidden lg:block"
      />
      <div className="lg:flex justify-center items-center">
      
        

        <div className="h-auto relative sm:relative lg:rounded-3xl p-10 z-20  bg-white lg:bottom-[-1px] lg:h-[400px] justify-center">
          <div className="sm:text-sm">
            <Typography variant="h3" gutterBottom>
              Iniciar Sesión
            </Typography>
          </div>

          <form onSubmit={signIn} className="flex flex-col gap-5 z-10">
            <TextField
              label="Correo Electrónico"
              placeholder="Correo Electrónico"
              variant="outlined"
              size="small"
              value={username}
              onChange={handleEmailChange}
            />
            <FormControl variant="outlined">
              <InputLabel htmlFor="outlined-adornment-password" size="small">
                Password
              </InputLabel>
              <OutlinedInput
                id="outlined-adornment-password"
                type={showPassword ? "text" : "password"}
                endAdornment={
                  <InputAdornment position="end">
                    <IconButton
                      aria-label="toggle password visibility"
                      onClick={handleClickShowPassword}
                      onMouseDown={handleMouseDownPassword}
                      edge="end"
                    >
                      {showPassword ? <VisibilityOff /> : <Visibility />}
                    </IconButton>
                  </InputAdornment>
                }
                label="Password"
                size="small"
                value={password}
                onChange={handlePasswordChange}
              />
            </FormControl>

            <Button variant="contained" type="submit">
              Iniciar Sesión
            </Button>
          </form>
          <p className="pt-5 text-xs font-medium">
            No tienes una cuenta aún,{" "}
            <Link to={`/register`} className="text-blue-700 blod font-semibold">
              click aquí.
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Login;
