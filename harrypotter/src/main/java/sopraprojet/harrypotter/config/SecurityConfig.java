package sopraprojet.harrypotter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

// @formatter:off
		
		http.antMatcher("/api/**")
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Garder des infos en mémoire avec les variables de session
		.and()
		.csrf().disable() //
		.authorizeHttpRequests()
			.antMatchers("/api/**").permitAll()
			//je fais l'angular
			
//			.antMatchers("/api/compte").permitAll()
//			.antMatchers("/api/eleve/**").permitAll()
//			.antMatchers("/api/prof").hasAnyRole("PROF","ADMIN")
//			.antMatchers("/api/prof/{id}").hasAnyRole("PROF","ADMIN")
//			.antMatchers("/api/compte/admin").hasAnyRole("ADMIN")
//			.antMatchers("/api/eleve/edit").hasAnyRole("ADMIN")
//			.antMatchers("/api/compte/prof").hasAnyRole("PROF","ADMIN")
//			.antMatchers("/api/compte/eleve").hasAnyRole("ELEVE", "ADMIN")
			
			.antMatchers("/api/compte/**").authenticated()
			.anyRequest().denyAll()
			.and().httpBasic();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
