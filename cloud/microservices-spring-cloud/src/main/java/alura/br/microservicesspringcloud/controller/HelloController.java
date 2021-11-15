package alura.br.microservicesspringcloud.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @GetMapping(value="/{firstname}/{lastname}")
    public  String hello(@PathVariable("firstname")String firstname, @PathVariable("lastname")String lastname){
        return String.format("\"message\": \"Hello %s %s\" ", firstname, lastname);
    }
}