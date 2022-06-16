package com.mphasis.security;


import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.jwt.Jwt;


@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
	security.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
	.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}
}
	
	
	
	
/*@Override
protected void configure(HttpSecurity http) throws Exception {
http
.authorizeRequests()
.anyRequest().authenticated()
.and()
.oauth2ResourceServer()
.jwt(jwt -> jwt.jwtAuthenticationConverter( jwtAuthenticationConverter()));
}*/



/*private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {
JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
jwtConverter.setJwtGrantedAuthoritiesConverter(new RealmRoleConverter());
return jwtConverter;
}*/
//}


