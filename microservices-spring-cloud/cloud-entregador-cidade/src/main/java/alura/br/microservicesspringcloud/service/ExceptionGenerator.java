package alura.br.microservicesspringcloud.service;

import alura.br.microservicesspringcloud.exception.ServerErrorException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExceptionGenerator {

    /**Lança uma exceção encandeada IOException
     *  com causa raiz ArithmeticException **/
    public void arithmeticExceptionInitCauseGenerator() throws ServerErrorException {
        try {
            int i = 4 / 0;
        } catch (ArithmeticException exception) {

            //simular um nível de exceção IoException
            IOException ioException = new IOException("Falha ao obter informações do arquivo");
            ioException.initCause(exception);

            //lancar nível de ServerErrorException, com cause: ioException
            ServerErrorException serverErrorException= new ServerErrorException("Falha Interna",ioException);
            throw serverErrorException;
        }
    }

}
