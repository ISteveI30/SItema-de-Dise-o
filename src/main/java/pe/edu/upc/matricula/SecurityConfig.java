package pe.edu.upc.matricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.matricula.serviceimplements.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/css/**", "/js/**", "/img/**", "/bootstrap/**","/registros/**")
				.permitAll()
				.antMatchers("/inicio")
				.hasAnyRole("INSTITUTO")	
			.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login")
				/*.defaultSuccessUrl("/inicio")*/
				.permitAll()
			.and()
				.logout().permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/error");
	}
	/*.anyRequest().authenticated()*/
	/*.antMatchers("/telefonos/**") .hasRole("ACADEMY")
	.antMatchers("/personas/**") .hasRole("STUDENT")
	.antMatchers("/inicio")
	.hasAnyRole("ACADEMY","STUDENT")
	.defaultSuccessUrl("/carreras/inicio")
	.failureUrl("/login?error")
	*/
	/*
	 * http.authorizeHttpRequests() .antMatchers("/telefonos/**") .hasRole("ADMIN")
	 * .antMatchers("/personas/**") .hasRole("USER") .antMatchers("/inicio")
	 * .hasAnyRole("USER","ADMIN") .and() .formLogin() .and()
	 * .exceptionHandling().accessDeniedPage("/error") ;
	 * 
	 * 
	 */
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	
	}
}
