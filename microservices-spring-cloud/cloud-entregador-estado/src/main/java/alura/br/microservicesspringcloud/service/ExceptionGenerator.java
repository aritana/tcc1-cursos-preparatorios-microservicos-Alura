package alura.br.microservicesspringcloud.service;

import alura.br.microservicesspringcloud.exception.NotFoundException;
import alura.br.microservicesspringcloud.exception.ServerErrorException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.NoSuchElementException;

@Service
public class ExceptionGenerator {
    /**
     * Lança uma exceção encandeada IOException
     * com causa raiz ArithmeticException
     **/
    public void arithmeticExceptionInitCauseGenerator()  {
        try {
            int i = 4 / 0;
        } catch (ArithmeticException exception) {

            //simular um nível de exceção IoException
            IOException ioException = new IOException("Falha ao obter informações do arquivo");
            ioException.initCause(exception);

            //lancar nível de ServerErrorException, com cause: ioException
            ServerErrorException serverErrorException = new ServerErrorException("Falha Interna", ioException);
            throw serverErrorException;
        }
    }

    public void arrayIndexOutOfBoundsExceptionInitCauseGenerator() {

        Integer[] fequencies = new Integer[10];
        try {
            Integer frequency = fequencies[11];
        } catch (ArrayIndexOutOfBoundsException exception) {

            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operacao não permitida");
            unsupportedOperationException.initCause(exception);
            ServerErrorException serverErrorException = new ServerErrorException("Falha Interna", unsupportedOperationException);
            throw serverErrorException;
        }

    }

    public void nullPointerExceptionExceptionInitCauseGenerator() {

        try {
            String name = null;
            int getLengthOfNullString = name.length();
        } catch (NullPointerException exception) {

            NoSuchElementException noSuchElementException = new NoSuchElementException("Classe não Encontrada");
            noSuchElementException.initCause(exception);
            NotFoundException notFoundException = new NotFoundException("Sintaxe inválida", noSuchElementException);
            throw notFoundException;
        }

    }
}