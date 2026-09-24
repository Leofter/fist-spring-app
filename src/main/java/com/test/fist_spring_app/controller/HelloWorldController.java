package com.test.fist_spring_app.controller;

import com.test.fist_spring_app.service.HelloWorldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// stateless -> (sempre enviando token) a cada nova requisiçao eu recebo todas as informacoes que eu preciso para fazer aquela funcionalidade
// statefull -> o estado de cada cliente é mantido no seervidor

@RestController
@RequestMapping("/hello-world") //Estou dizendo que esse metodo, escuta o end point http de nome hello-world
public class HelloWorldController {
// post, get, delete, put, ...

    private HelloWorldService helloWorldService;
    //outra forma de fazer seria sem construtor mas usando @AutoWired,
    // indicando que essa dependencia deve ser automaticamente injetada no helloworld()

    //construtor
    public HelloWorldController(HelloWorldService helloWorldService){
        this.helloWorldService = helloWorldService;
    }

    //Estou dizendo que esse metodo, escuta o end point http de nome hello-world no metodo GET
    @GetMapping
    public String helloworld(){
        return helloWorldService.helloWorld("Leo");
    }
}
