package alura.br.microservicesspringcloud.controller;

import alura.br.microservicesspringcloud.config.MongoDb;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.swagger.annotations.Api;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @GetMapping(value="/{firstname}/{lastname}")
    public  String hello(@PathVariable("firstname")String firstname, @PathVariable("lastname")String lastname){

        MongoDatabase database = MongoDb.client.getDatabase("exceptionHandlerDB");
        MongoCollection<Document> alunos = database.getCollection("alunos");
        Document aluno =  alunos.find().first();
        System.out.println(aluno);

        return String.format("\"message\": \"Hello %s %s\" ", firstname, lastname);
    }
}
