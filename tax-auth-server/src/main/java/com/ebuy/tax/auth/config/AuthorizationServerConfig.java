package com.ebuy.tax.auth.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.ebuy.tax.auth.service.impl.UserDetailsServiceImpl;

/**
 * 
* @author dd
* @date 2018年9月4日
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    /*@Autowired
    private DataSource dataSource;*/
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    RedisTokenStore redisTokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }

    //token存储数据库
//    @Bean
//    public JdbcTokenStore jdbcTokenStore(){
//        return new JdbcTokenStore(dataSource);
//    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	clients.inMemory().withClient("client_1")
        .resourceIds("user")
        .authorizedGrantTypes("client_credentials")
        .scopes("select")
        .authorities("oauth2")
        .secret("123456")
        .and().withClient("client_2")
        .resourceIds("user")
        .authorizedGrantTypes("password", "refresh_token")
        .scopes("select")
        .authorities("oauth2")
        .secret("123456");
    }
    /*@Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }*/
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    	endpoints
	        .tokenStore(new RedisTokenStore(redisConnectionFactory))
	        .tokenStore(new InMemoryTokenStore())
	        .authenticationManager(authenticationManager)
	        .userDetailsService(userDetailsService)
	        // 2018-4-3 增加配置，允许 GET、POST 请求获取 token，即访问端点：oauth/token
	        .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
	
    	endpoints.reuseRefreshTokens(true);
    }

    /**
     * <p>注意，自定义TokenServices的时候，需要设置@Primary，否则报错，</p>
     * @return
     */
    /*@Primary
    @Bean
    public DefaultTokenServices defaultTokenServices(){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(redisTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(clientDetails());
        tokenServices.setAccessTokenValiditySeconds(60*60*12); // token有效期自定义设置，默认12小时
        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);//默认30天，这里修改
        return tokenServices;
    }*/

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()");
        security .checkTokenAccess("isAuthenticated()");
        security.allowFormAuthenticationForClients();
    }
}
