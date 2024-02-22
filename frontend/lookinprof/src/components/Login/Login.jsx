import React from "react";
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

  const handleClickShowPassword = () => setShowPassword((show) => !show);

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };
  return (
    <div className="flex justify-center">
      <div className="shadow-2xl rounded-3xl shadow-gray-400 bg-slate-200 w-1/3 flex items-center relative left-40">
        <img src={man} alt="man with laptop" className="z-20"></img>
      </div>

      <div className="w-[600] shadow-2xl rounded-3xl shadow-gray-400 px-20 py-20 flex flex-col justify-between z-10  bg-white">
        <div className="m-5">
          <Typography variant="h3" gutterBottom>
            Iniciar Sesión
          </Typography>
        </div>

        <form className="flex flex-col space-y-5">
          <TextField
            label="Correo Electrónico"
            placeholder="Correo Electrónico"
            variant="outlined"
            type="email"
          />

          <FormControl variant="outlined">
            <InputLabel htmlFor="outlined-adornment-password">
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
            />
          </FormControl>

          <Button type= "submit" variant="contained">Iniciar Sesión</Button>
        </form>
        <p>
          No tienes una cuenta aún,{" "}
          <Link to={`/register`} className="text-blue-700 blod font-semibold">
            click aquí.
          </Link>
        </p>
      </div>
    </div>
  );
};

export default Login;
