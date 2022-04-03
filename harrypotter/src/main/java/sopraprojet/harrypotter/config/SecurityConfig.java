package sopraprojet.harrypotter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import sopraprojet.harrypotter.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.antMatcher("/api/**")
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
//		.csrf().disable();

		//_______________________ ou _____________________
		
		http.antMatcher("/api/**")
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().ignoringAntMatchers("/api/**")
		.and()
		.authorizeHttpRequests();

		//_______________________  +  _____________________
		
		// cette partie seule permet l'authentifiation, mais ne permet pas encore de faire le CRUD. Si on veut
		// tester le crud, il faut la partie du haut (premiere partie ou la 2e) sans celle du bas
		http.authorizeHttpRequests()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/prof").hasAnyRole("PROF","ADMIN")
				.antMatchers("/eleve").hasAnyRole("ELEVE", "ADMIN")
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated().and().formLogin();
	}


//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
