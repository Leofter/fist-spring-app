package com.test.fist_spring_app.configuration;

//usada para configuracoes no spring que nao são do spring (como usar AWS, etc)

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration // Usar a classe como base de configuraçoes
//public class HelloWorldConfiguration {
//
//    //geralmente eu defino metodos publicos que retornam o tipo da classe que eu quero configurar (exemplo do SDK AWS)
//    @Bean //bean para indicar que o sping deve gerenciar o retorno do metodo (classes de bibliotecas de terceiros que preciso mapear)
//    public SDKAWS sdkAWS(){
//        return new SDKAWS();
//    }
//}
