package com.example.texassolutions.config;


import org.springframework.context.annotation.Configuration;



@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    private final RsaKeyProperties rsaKeyProperties;
//
//    public SecurityConfig(RsaKeyProperties rsaKeyProperties) {
//        this.rsaKeyProperties = rsaKeyProperties;
//    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth ->
//                        auth.anyRequest().authenticated()
//                )
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .httpBasic(Customizer.withDefaults())
//                .build();
//
//    }

//    @Bean
//    JwtDecoder jwtDecoder () {
//        return NimbusJwtDecoder.withPublicKey(rsaKeyProperties.publicKey()).build();
//    }

//    @Bean
//    JwtEncoder (RsaKeyProperties rsaKeyProperties) {
//        JWK jwk = new RSAKey.Builder(rsaKeyProperties.publicKey()).privateKey(rsaKeyProperties.privateKey()).build();
//        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
//        return new NimbusJwtEncoder(jwks);
//    }
}
