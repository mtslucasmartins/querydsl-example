package br.com.tareffa.fileupload.config;

import java.util.Arrays;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableOAuth2Client
public class ResourceServerWebConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    /**
     * The heart of our interaction with the resource; handles redirection for
     * authentication, access tokens, etc.
     *
     * @param oauth2ClientContext
     * @return
     */
    @Bean
    public OAuth2RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(resource(), oauth2ClientContext);
    }

    private OAuth2ProtectedResourceDetails resource() {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setClientId("devglan-client");
        resource.setClientSecret("devglan-secret");
        resource.setAccessTokenUri("http://localhost:9092/oauth/token");
        resource.setUserAuthorizationUri("http://localhost:9092/oauth/authorize");
        resource.setScope(Arrays.asList("read"));

        return resource;
    }

}
