import React, {useState} from "react";
import man from "../../assets/manLaptop.png";
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

const Login = () => {
  const [showPassword, setShowPassword] = React.useState(false);
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const handleClickShowPassword = () => setShowPassword((show) => !show);


  const handleMouseDownPassword = (event) => {
    event.preventDefault();
    setShowPassword((show) => !show);
  };

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };
  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  }
  console.log(email, password)
  return (
    <div className="flex flex-row items-center justify-center p-10">
    <div className="flex justify-center items-center">
      <div className="shadow-2xl rounded-3xl shadow-gray-400 bg-slate-200/50 flex items-center h-[500px] w-[400px]">
        <img src={man} alt="man with laptop" className="z-20 h-[500px] relative left-10"></img>
      </div>

      <div className="h-[500px] shadow-2xl rounded-3xl shadow-gray-400 p-10 flex flex-col justify-between z-100 relative right-20  bg-white">
        
          <Typography variant="h3" gutterBottom>
            Iniciar Sesión
          </Typography>
        
        <form className="flex flex-col gap-5">
          <TextField
            label="Correo Electrónico"
            placeholder="Correo Electrónico"
            variant="outlined"
            size="small"
            value={email}
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

          <Button variant="contained">Iniciar Sesión</Button>
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
