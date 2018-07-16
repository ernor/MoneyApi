package br.com.api.confg;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("{noop}admin").roles("ROLE");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/categorias").permitAll() // Qualquer requisição pode acessar categorias
				.anyRequest().authenticated()  // Qualquer requisição precisa estar autenticado
				.and() // AND
				.httpBasic() // Tipo de autenticação
				.and() // AND
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Não Mantem estado
				.and() // AND
				.csrf().disable(); // Não permite Javascript Inject
	}
	
	
	
}
