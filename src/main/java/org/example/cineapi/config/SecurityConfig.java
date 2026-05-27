package org.example.cineapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //padrão da config, essas anotações são lidas na inicialização do projeto
public class SecurityConfig {
    //Configurando a segurança da api

    @Bean //logo é gerenciada pelo spring
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                //desativar o CSRF - isso NÃO é realizado em empresas pois praticametne deixa o site vulnerável
                //cross-site request forgery
                //proteção usada em websites  -  impede que sites terceiros ou aplicativos externos enviem requisições em seu nome (usuário)
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v3/api-docs", "/swagger-ui/**").permitAll() //libera acesso ao swagger e tudo que tiver ali dentro, sem precisar de login
                        //obiviamente perigoso em situações reais
                        .requestMatchers("/filmes").permitAll()
                        .requestMatchers("/filmes/buscar").permitAll()
                        .anyRequest().authenticated() // para qualquer outra request, precisa estar autenticado
                )
                //ativando autenticação
                .httpBasic()
                .and()
                .build(); //chamando o httpBasic e fanzendo a build "pra fazer o bglh ali

    }

}
