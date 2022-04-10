package sopraprojet.harrypotter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import sopraprojet.harrypotter.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

// @formatter:off
		
		http.antMatcher("/api/**")
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Garder des infos en mémoire avec les variables de session
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
			.antMatchers(HttpMethod.OPTIONS, "api/**").permitAll()
			.antMatchers("/api/eleve/**").permitAll()
			.antMatchers("/api/prof").hasAnyRole("PROF","ADMIN")
			.antMatchers("/api/prof/{id}").hasAnyRole("PROF","ADMIN")
			.antMatchers("/api/compte/admin").hasAnyRole("ADMIN")
			.antMatchers("/api/eleve/edit").hasAnyRole("ADMIN")
			.antMatchers("/api/compte/prof").hasAnyRole("PROF","ADMIN")
			.antMatchers("/api/compte/eleve").hasAnyRole("ELEVE", "ADMIN")
			.antMatchers("/api/boutiques").hasAnyRole("ELEVE","PROF","ADMIN")
			.antMatchers("/api/**").authenticated()

			.anyRequest().denyAll()
			.and().httpBasic()
			.and().headers()
        
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
         //   .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, GET","OPTIONS", "PUT"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Credentials", "true"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "true"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization"));
		http.cors();
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
