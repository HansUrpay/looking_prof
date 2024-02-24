import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { setCurrentUser } from "../../redux/slices/userSlice";
import mountain from "../../assets/montain.png";
import manWorking from "../../assets/manWorking.svg";
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
import FormHelperText from "@mui/material/FormHelperText"; // Import FormHelperText
import { Link, useNavigate } from "react-router-dom";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";

const Register = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [value, setValue] = useState("user");
  const [showPassword, setShowPassword] = useState(false);
  const [formData, setFormData] = useState({
    email: "",
    firstName: "",
    lastName: "",
    password: "",
    role: "user",
  });
  const [formErrors, setFormErrors] = useState({
    email: "",
    firstName: "",
    lastName: "",
    password: "",
    role: "",
  });
  const [loggedIn, setLoggedIn] = useState(false);

  const handleChange = (event) => {
    setValue(event.target.value);
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
    setFormErrors({ ...formErrors, [name]: "" });
  };

  const handleClickShowPassword = () => setShowPassword(!showPassword);

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();
    setValue(event.target.value);
    let errors = {};
    let formIsValid = true;
    // Validation for email
    if (!formData.email.trim() || formData.email.length === 0) {
      errors.email = "El correo electrónico es requerido";
      formIsValid = false;
    }
    // Validation for firstName
    if (!formData.firstName.trim() || formData.firstName.length === 0) {
      errors.firstName = "El nombre es requerido";
      formIsValid = false;
    }
    // Validation for lastName
    if (!formData.lastName.trim() || formData.lastName.length === 0) {
      errors.lastName = "El apellido es requerido";
      formIsValid = false;
    }
    // Validation for password
    if (!formData.password.trim() || formData.password.length < 8) {
      errors.password = "Revisa la contraseña";
      formIsValid = false;
    }

    if (formIsValid) {
      localStorage.setItem("currentUser", JSON.stringify(formData));
      dispatch(setCurrentUser(formData));
      setLoggedIn(true);
      navigate("/");
    } else {
      setFormErrors(errors);
    }
  };

  return (
    <div
      className=" flex flex-col-reverse lg:relative h-screen flex lg:justify-center items-center"
      style={{
        backgroundImage: `url(${mountain})`,
        backgroundSize: "cover",
      }}
    >
      <img
        src={manWorking}
        alt="manWorking"
        className="absolute left-0 p-[43px] hidden lg:block"
      />
      
        <div className="flex flex-col lg:justify-center items-center relative sm:relative lg:rounded-3xl p-10 z-20  bg-white lg:bottom-[-1px] justify-center">
          <Typography variant="h3" gutterBottom>
            Registrarse
          </Typography>
          <form
            className="flex flex-col align-items: center justify-content: center space-y-2"
            onSubmit={handleFormSubmit}
          >
            <FormControl>
              <RadioGroup
                row
                aria-labelledby="demo-row-radio-buttons-group-label"
                name="role"
                value={formData.role}
                onChange={handleChange}
              >
                <FormControlLabel
                  value="user"
                  control={<Radio />}
                  label="Usuario"
                />
                <FormControlLabel
                  value="professional"
                  control={<Radio />}
                  label="Professional"
                />
              </RadioGroup>
            </FormControl>
            <TextField
              name="email"
              label="Correo Electrónico"
              placeholder="Correo Electrónico"
              variant="outlined"
              size="small"
              onChange={handleChange}
              error={!!formErrors.email}
              helperText={formErrors.email ? !formErrors.email : ""}
            />
            <FormHelperText error className="text-xs">
              {formErrors.email}
            </FormHelperText>

            <TextField
              name="firstName"
              label="Nombres"
              placeholder="Nombres"
              variant="outlined"
              size="small"
              onChange={handleChange}
              error={!!formErrors.firstName}
            />
            <FormHelperText error className="text-xs">
              {formErrors.firstName}
            </FormHelperText>

            <TextField
              name="lastName"
              label="Apellidos"
              placeholder="Apellidos"
              variant="outlined"
              size="small"
              onChange={handleChange}
              error={!!formErrors.lastName}
            />
            <FormHelperText error>{formErrors.lastName}</FormHelperText>

            <FormControl variant="outlined">
              <InputLabel htmlFor="outlined-adornment-password" size="small">
                Contraseña
              </InputLabel>
              <OutlinedInput
                name="password"
                id="outlined-adornment-password"
                type={showPassword ? "text" : "password"}
                endAdornment={
                  <InputAdornment position="end" size="small">
                    <IconButton
                      aria-label="toggle password visibility"
                      onClick={handleClickShowPassword}
                      onMouseDown={handleMouseDownPassword}
                      edge="end"
                      size="small"
                    >
                      {showPassword ? <VisibilityOff /> : <Visibility />}
                    </IconButton>
                  </InputAdornment>
                }
                label="Contraseña"
                size="small"
                onChange={handleChange}
                error={!!formErrors.password}
              />
            </FormControl>
            <FormHelperText error>{formErrors.password}</FormHelperText>

            <Button variant="contained" className="shadow-2xl" type="submit">
              Registrarme
            </Button>
          </form>
          {loggedIn && (
            <p className="pt-5 text-xs font-medium">
              ¡Registro y login exitosos!
            </p>
          )}
          <p className="pt-5 text-xs font-medium">
            Ya tienes una cuenta,{" "}
            <Link to={`/login`} className="text-blue-700 blod font-semibold ">
              haz clic aquí
            </Link>
            .
          </p>
       
      </div>
    </div>
  );
};

export default Register;
