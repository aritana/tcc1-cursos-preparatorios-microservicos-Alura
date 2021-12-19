package alura.br.microservicesspringcloud.exception;

import alura.br.microservicesspringcloud.networking.config.ResponseError;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;

@RestControllerAdvice
public class CentralExceptionHandler {

    @Autowired
    private MessageSource messageSource;
    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseError handleNotFound(NotFoundException exception) {
        ResponseError responseError;
        if(exception.responseError == null){
            responseError = ResponseError.builder()
                    .timestamp(String.valueOf(LocalTime.now()))
                    .status("404")
                    .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                    .message(exception.getMessage()).build();
        }else{//a resposta chegou preenchida de outro serviçp
            responseError = exception.responseError;
        }
        logger.debug("NotFoundException {}",exception.getMessage());
        return responseError;
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerErrorException.class)
    public ResponseError handleServerError(ServerErrorException exception) {

        ResponseError responseError = ResponseError.builder()
                .timestamp(String.valueOf(LocalTime.now()))
                .status("500")
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(exception.getMessage()).build();

        logger.debug("NotFoundException {}", exception.getMessage());
        return responseError;
    }
}
