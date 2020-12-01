package com.sample.student.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

//	private String clientid = "tutorialspoint";
//	private String clientSecret = "my-secret-key";
	private String privateKey = "MIIEpAIBAAKCAQEA0QnSK0dEoTJ0x9M9CaHVjj/f0X1T3L0nnAzx8K/GW6XVz9r+\r\n" + 
			"/Ovk4ES89ZS/C5e8vL5dM8e1//+pt9h5EeRuUD7UUAO4K6E4D6uxJTal93N0XwFf\r\n" + 
			"gBkoLEBB+1JXw68bsQa+Dzrt7v/oxU0z2681jJvFjoa09XW1iYQ2a5WU0GiVhvab\r\n" + 
			"IOkvqI0g2SGhwYTR5KLyiS8potoyMzY9XYUN5mjmK6k5VhDfLrrQqYNvba5wbIFM\r\n" + 
			"6ju2Zlxbjzj2NZFeMr52K/l83unCOd0DHeY8KNKM8AvTC+s3NFgtXg1JL5T/yXvt\r\n" + 
			"DUHxUL8YUoX82+rRQkxLszqHM6N7FwfBHFEPMQIDAQABAoIBAQClGEyVQcRCS8dP\r\n" + 
			"ytX6NYakwm3S1ljVjc8qwE6U+T6AQ4mKkDuzJduuBJv4mXIJhd3ac77IloJ3nUQ9\r\n" + 
			"nwp/xxoY5oZoa4eZbcsJFWDjMzYBKX5PSpZSZYwE5vs1suL9+d61Ac452SDyEcuV\r\n" + 
			"iFPcvZRdaOmul1V0R3MJGRKiBZFyxrekKhZCAZ2NNvepciKVwO0l2gtAb88Oc7sK\r\n" + 
			"10f9sWE+JwMk+wuEsUj8uMlEVe8RNmYRuEtNyeJejVoxNLS3duOYXhuE9/JrK1MA\r\n" + 
			"3Ju256eHfSgVtxtosilpxmz6MvU/Jb69Yiwf/CC6TQoN4NoKRdd+nb1a+qQcMcFP\r\n" + 
			"JQAy/HXBAoGBAP9BIAQxH/EDEmblH6+pYXTN1gtOnABIDv0vpiIogv0JiS77r6Mk\r\n" + 
			"SBQb7sYmNOt8pe+z3HbpryjFoICb0bC3xOjsGrQYcFRTgi8PdnzPjp2Z0WZpvq0C\r\n" + 
			"3gKDn6nUamZjzU6BpHSs+ec6bRtYmhUS2WZtop69Yg+dDaU0SNel1XjrAoGBANGm\r\n" + 
			"IucehAEV6DlvzflV7L8aZ69O25J0LqHUtC12Z+rNKhh2pqa8IJCaWHmhxwU2P7Ph\r\n" + 
			"kINbDZ7qpZNDGOYnP06A9A90YRRt0chIobvxGu5UlIA/t6hzLtPZjhB5GPUQz2EF\r\n" + 
			"1spFBLFEOrN8R/qQfMtGCV5+tWpCg/akmA9oadFTAoGAY6IbCifWrO+jBjDXLmzy\r\n" + 
			"EnKp4t37PIzj9OXddiXUA0rulj09sHNgAyFoEUYmj+imqKrPGkdazJJfdPPdZJpG\r\n" + 
			"rRhD0Bpd9jxma1Ig0NT/ePrqZoxOFiAxYk/YSaUVJwQ7xjIKbFR8c0o1/l+WPTWP\r\n" + 
			"UFDpEgcgOLH3+o0vBaXAbqMCgYAJuLl/nCOk5T4qg6u6dyiOSAwszexSoz6SVImy\r\n" + 
			"Xf49nhvonH/n1WtxKScXJNBUxoo3risEXFGKX/kjlgXujj1aR5KJsOzbhKgosG2H\r\n" + 
			"iIumJ5fnRo0eq5CtVDZJP0RQAOKM7jdik8a+7ZoHPqkbzl1rE6lVj2ycK89wvXsr\r\n" + 
			"o7zcbwKBgQCbTKYsgY1oYc2KtA5NYXeZ4pnSkln4PNd8uUH6L9QKNqaUC4RclWWv\r\n" + 
			"no93fqUpni4BexvH5JW0X/miVFRzd3rqeY88cTAOb2PCP1wk6v1ZA1lKDGmgw1a4\r\n" + 
			"Nhn9TqWyryUic/ROxQ2RFmi64WpOMSp1scYkg29dD0Czq8KS6PPoGg==";
	private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0QnSK0dEoTJ0x9M9CaHV\r\n" + 
			"jj/f0X1T3L0nnAzx8K/GW6XVz9r+/Ovk4ES89ZS/C5e8vL5dM8e1//+pt9h5EeRu\r\n" + 
			"UD7UUAO4K6E4D6uxJTal93N0XwFfgBkoLEBB+1JXw68bsQa+Dzrt7v/oxU0z2681\r\n" + 
			"jJvFjoa09XW1iYQ2a5WU0GiVhvabIOkvqI0g2SGhwYTR5KLyiS8potoyMzY9XYUN\r\n" + 
			"5mjmK6k5VhDfLrrQqYNvba5wbIFM6ju2Zlxbjzj2NZFeMr52K/l83unCOd0DHeY8\r\n" + 
			"KNKM8AvTC+s3NFgtXg1JL5T/yXvtDUHxUL8YUoX82+rRQkxLszqHM6N7FwfBHFEP\r\n" + 
			"MQIDAQAB";

	
	@Autowired
	@Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
//				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
//				.refreshTokenValiditySeconds(20000);
//
//	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()
			.withClient("user").secret(passwordEncoder.encode("password")).scopes("read", "write")
					.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
					.refreshTokenValiditySeconds(20000).
			and()
			.withClient("admin").secret(passwordEncoder.encode("password")).scopes("read", "write")
					.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
					.refreshTokenValiditySeconds(20000);


	}

}
