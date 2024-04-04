package com.dealership.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
				// .requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/**").permitAll()
			)
			.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults());
			// .formLogin((formlogin) -> formlogin
			// 	.usernameParameter("username")
			// 	.passwordParameter("password")
			// 	.loginPage("/login")
			// 	.failureUrl("/login?failed")
			// 	.defaultSuccessUrl("/", true)
			// )
			// .logout((logout) -> logout
			// 	.logoutSuccessUrl("/")
			// );
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		UserDetails user = User.withUsername("user")
			.password(encoder.encode("password"))
			.roles("USER")
			.build();
		UserDetails admin = User.withUsername("u")
			.password(encoder.encode("p"))
			.roles("ADMIN", "USER")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}

}