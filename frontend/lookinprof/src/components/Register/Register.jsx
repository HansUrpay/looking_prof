import React, { useState } from 'react';
import deliveryMan from "../../assets/deliveryMan.png";
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
import FormGroup from "@mui/material/FormGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";

const Register = () => {
  const [showPassword, setShowPassword] = React.useState(false);

  const handleClickShowPassword = () => setShowPassword((show) => !show);

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

  const [usuarioChecked, setUsuarioChecked] = useState(false);
  const [profesionalChecked, setProfesionalChecked] = useState(false);

  const handleUsuarioChange = () => {
    setUsuarioChecked(true);
    setProfesionalChecked(false);
  };

  const handleProfesionalChange = () => {
    setUsuarioChecked(false);
    setProfesionalChecked(true);
  };
  return (
    <div className="flex justify-center">
      <div className="shadow-2xl rounded-3xl shadow-gray-400 bg-slate-300 w-1/3">
        <img src={deliveryMan} alt="Man delivery"></img>
      </div>
     
        <div className="shadow-2xl rounded-3xl shadow-gray-400 px-20 py-20 h-full flex flex-col justify-between w-1/3">
          <Typography variant="h3" gutterBottom>
            Registrarse
          </Typography>

          <form className="flex flex-col align-items: center justify-content: center space-y-5">
            {/* <FormGroup>
              <FormControlLabel
                control={<Checkbox checked={usuarioChecked} onChange={handleUsuarioChange} />}
                label="Usuario"
              />
              <FormControlLabel
                control={<Checkbox checked={profesionalChecked} onChange={handleProfesionalChange} />}
                label="Profesional"
              />
            </FormGroup> */}

            {/* <Button variant="outlined" startIcon={<DeleteIcon />}>
  Delete
</Button>
<Button variant="contained" endIcon={<SendIcon />}>
  Send
</Button> */}
            <TextField
              label="Correo Electrónico"
              placeholder="Correo Electrónico"
              variant="outlined"
            />

            <TextField
              label="Nombre y Apellido"
              required
              placeholder="Nombre y Apellido"
              variant="outlined"
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

            <Button variant="contained" className="shadow-2xl">Registrarme</Button>
          </form>
          <p className='pt-5'>
            Ya tienes una cuenta,{" "}
            <Link to={`/login`} className="text-blue-700 blod font-semibold ">
              click aquí.
            </Link>
          </p>
        </div>
      
    </div>
  );
};

export default Register;
