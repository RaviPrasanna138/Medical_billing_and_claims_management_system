package com.wipro.mbcms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.wipro.mbcms.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	
	@Autowired
	JwtAuthFilter authFilter;
	
    @Bean
    //authentication
    public UserDetailsService userDetailsService() {
		
       return new UserInfoUserDetailsService();
    }
    
    @Bean
    public  SecurityFilterChain   getSecurityFilterChain(HttpSecurity http) throws Exception {
    	
    		return http.csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(requests -> requests.requestMatchers("/swagger-ui/**", "/swagger-resources/**", "/api",
                            "/api/patients/authenticate", "/api/patients/addpatients", "/api/patients/get/allpatients", "/api/patients/updatePatient", "/api/patients/getbyname/{patientName}", "/api/patients/delete/patient/{patientId}",
                            "/api/healthcareprovider/authenticate", "/api/healthcareprovider/add", "/api/healthcareprovider/update" ,"/api/healthcareprovider/getall", "/api/healthcareprovider/getbyid/{providerId}", "/api/healthcareprovider/deletebyid/{providerId}",
                            "/api/insurancecompany/authenticate", "/api/insurancecompany/add/company", "/api/insurancecompany/update/company/{companyId}", "/api/insurancecompany/delete/companybyid/{companyId}", "/api/insurancecompany/getbycompanyname/{companyName}", "/api/insurancecompany/getallcompaniesdata",
                            "/api/admin/authenticate", "/api/admin/add", "/apiadmin/getAllPatients", "/api/admin/getAllInsuranecClaims", "/api/admin/getAllInsurancePlans",
                            "/api/healthcareprovider/deletebyid/{providerId}",
                            "/api/insuranceclaims/getallclaims").permitAll())
                    .authorizeHttpRequests(requests -> requests.requestMatchers("/api/admin/**", "/api/healthcareprovider/**", "/api/insuranceclaims/**", "/api/insurancecompany/**", "/api/plans/**", "/api/invoicedetails/**", "/api/patients/**")
                            .authenticated())   //.formLogin().and().build();
                    .sessionManagement(management -> management
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authenticationProvider(authenticationProvider())
                    .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
    	
    }
    
    
    
    

    @Bean    
    public PasswordEncoder passwordEncoder() {          
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	
    	return config.getAuthenticationManager();
    	
    }
    
    
    
}
