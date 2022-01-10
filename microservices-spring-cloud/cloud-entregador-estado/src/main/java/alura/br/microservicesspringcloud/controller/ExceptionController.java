package alura.br.microservicesspringcloud.controller;

import alura.br.microservicesspringcloud.service.ExceptionComunicator;
import alura.br.microservicesspringcloud.service.ExceptionGenerator;
import io.swagger.annotations.Api;
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
    @Autowired
    ExceptionComunicator exceptionComunicator;

    @GetMapping(value = "/{exceptioncode}/{service}")
    public void exceptionSelector(@PathVariable("exceptioncode") String exceptionCodeInitCause,@PathVariable("service") String service) {
        if(service.equals("2")) {//The exception will be generated in this service

            switch (exceptionCodeInitCause) {
                case "1"://arithmeticException
                    exceptionGenerator.arithmeticExceptionInitCauseGenerator();
                    break;
                case "2":
                    exceptionGenerator.arrayIndexOutOfBoundsExceptionInitCauseGenerator();
                    break;
                case "3":
                    exceptionGenerator.nullPointerExceptionExceptionInitCauseGenerator();
                default:
            }
        }else{//The exception will be generated in another service
            exceptionComunicator.sendSignalOfExceptiorToBeGenerate( exceptionCodeInitCause, service);
        }
    }
}
