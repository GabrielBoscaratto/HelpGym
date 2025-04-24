package com.helpgym.academiaapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Permite requisições de qualquer origem (isso deve ser ajustado em produção)
        config.addAllowedOrigin("*");
        
        // Permite os métodos HTTP necessários para operações CRUD
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        
        // Permite todos os cabeçalhos
        config.addAllowedHeader("*");
        
        // Permite credenciais como cookies
        config.setAllowCredentials(true);
        
        // Aplica esta configuração a todos os endpoints da API
        source.registerCorsConfiguration("/api/**", config);
        
        return new CorsFilter(source);
    }
}
