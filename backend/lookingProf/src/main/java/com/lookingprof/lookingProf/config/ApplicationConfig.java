package com.lookingprof.lookingProf.config;

import com.lookingprof.lookingProf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Autowired
    IUserService iUserService;

    /**
     * Personaliza el administrador de autenticación que va usar la aplicación.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /**
     * Personaliza el proveedor de autenticación para usuarios que va usar la aplicación, se establece DaoAuthenticationProvider como proveedor
     * @return devuelve el proveedor personalizado
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    /**
     * Personaliza el encriptador que va usar la apliccción para las contraseñas de usuarios antes de alamcenar en la BD
     * @return devuelve una instancia de BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * TODO: pendiente de configurar el UserDetailService con el User model, definir si va ser busqueda por userName o por email
     */
    @Bean
    public UserDetailsService userDetailService() {
        return username -> (UserDetails) iUserService.findByName(username);
    }

}
