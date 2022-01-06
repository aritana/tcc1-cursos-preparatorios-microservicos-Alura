package alura.br.microservicesspringcloud.controller;

import alura.br.microservicesspringcloud.config.MongoDb;
import alura.br.microservicesspringcloud.service.ExceptionGenerator;
import alura.br.microservicesspringcloud.service.MongoDBHandleException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.swagger.annotations.Api;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value = "exception")
public class ExceptionController {

    @Autowired
    ExceptionGenerator exceptionGenerator;

    @GetMapping(value="/{exceptioncode}")
    public  void exceptionSelector(@PathVariable("exceptioncode")String exceptionCodeInitCause){

        switch (exceptionCodeInitCause){
            case "3"://arithmeticException
                exceptionGenerator.arithmeticExceptionInitCauseGenerator();
                break;
            default:
        }

    }
}
