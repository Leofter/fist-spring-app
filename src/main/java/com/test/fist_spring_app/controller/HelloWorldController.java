package com.test.fist_spring_app.controller;

import com.test.fist_spring_app.domain.User;
import com.test.fist_spring_app.service.HelloWorldService;
import org.springframework.web.bind.annotation.*;

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

    //metodo de ver o que esta recebendo
    @PostMapping("")
    //estou falando para o sping para injetar no parametro body que é do tipo User tudo que vier de "post" do body, ele faz isso atraves do request body
    public String helloWorldPost(@RequestBody User body){
        return "Hello world " + body.getName();
    }

    @PostMapping("/{id}")
    // Estou falando agora que o ID que vamos recuperar da URL deve ser injetado na String/parametro id, o que nos permite usar como variavel
    public String helloWorldPostWithID(@PathVariable("id") String id, @RequestBody User body){
        return "Hello world " + body.getName() + id;
    }

    @PostMapping("/{id}")
    // agora  ao inves de retirar parametros da URL estou retirando parametros de consulta da URL (o que fica depois da interrogacao http//dsads31.com/dsadsa?filter=Leonardo)
    public String helloWorldPostWithIDAndFilter(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter    @RequestBody User body){
        return "Hello world " + body.getName() + id + filter; //vai usar "nenhum" quando filter nao exister na URL
    }
}
