package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //usada para api's rest, diferente de apenas @Controller
@RequestMapping("/hello") //para qual url esse controller irá responder
public class HelloController {

    @GetMapping //requisições do tipo GET vão cair nesse método aqui
    public String olaMundo() {
        return "Hello World Spring!";
    }

}
