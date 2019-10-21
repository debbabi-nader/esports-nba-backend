package org.esports.nba.configurations;

import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final CasAuthenticationProvider casAuthenticationProvider;
	private final CasAuthenticationEntryPoint casAuthenticationEntryPoint;
	private final LogoutFilter logoutFilter;
	private final SingleSignOutFilter singleSignOutFilter;
	
	@Autowired
	public SecurityConfiguration(CasAuthenticationProvider casAuthenticationProvider, CasAuthenticationEntryPoint casAuthenticationEntryPoint, LogoutFilter logoutFilter, SingleSignOutFilter singleSignOutFilter) {
		this.casAuthenticationProvider = casAuthenticationProvider;
		this.casAuthenticationEntryPoint = casAuthenticationEntryPoint;
		this.logoutFilter = logoutFilter;
		this.singleSignOutFilter = singleSignOutFilter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(this.casAuthenticationProvider);
	
	}
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		http.authorizeRequests()
			.regexMatchers("/api.*")
			.authenticated();
		
		http.httpBasic()
			.authenticationEntryPoint(this.casAuthenticationEntryPoint);
		
		http.logout()
			.logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
				httpServletResponse.addHeader("Set-Cookie", "JSESSIONID=; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT");
				httpServletResponse.addHeader("Set-Cookie", "XSRF-TOKEN=; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT");
				httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			});
		
		http.addFilterBefore(this.logoutFilter, LogoutFilter.class);
		http.addFilterBefore(this.singleSignOutFilter, CasAuthenticationFilter.class);
		
	}

}
