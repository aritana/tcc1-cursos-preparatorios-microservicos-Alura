package alura.br.microservicesspringcloud.exception;

import alura.br.microservicesspringcloud.networking.config.ResponseError;
import alura.br.microservicesspringcloud.service.MongoDBHandleException;
import alura.br.microservicesspringcloud.service.TraceService;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;

@RestControllerAdvice
public class CentralExceptionHandler {

    @Autowired
    TraceService traceService;

    @Autowired
    MongoDBHandleException mongoDBHandleException;

    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseError handleNotFound(NotFoundException exception) {
        ResponseError responseError;
        if (exception.responseError == null) {
            responseError = ResponseError.builder()
                    .timestamp(String.valueOf(LocalTime.now()))
                    .status("404")
                    .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                    .trace_id(traceService.getTraceId())
                    .message(exception.getMessage()).build();

        } else {//a resposta chegou preenchida de outro serviçp
            responseError = exception.responseError;
        }
        logger.debug("NotFoundException {}", exception.getMessage());

        //Agregar exceções na central de armazenamento de exceções
        mongoDBHandleException.saveException(exception);

        return responseError;
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerErrorException.class)
    public ResponseError handleServerError(ServerErrorException exception) {
        ResponseError responseError;

        if (exception.responseError == null) {
            responseError = ResponseError.builder()
                    .timestamp(String.valueOf(LocalTime.now()))
                    .status("500")
                    .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                    .trace_id(traceService.getTraceId())
                    .message(exception.getMessage()).build();
        } else {//a resposta chegou preenchida de outro serviçp
            responseError = exception.responseError;
        }
        logger.debug("ServerErrorException {}", exception.getMessage());

        //Agregar exceções na central de armazenamento de exceções
        mongoDBHandleException.saveException(exception);

        return responseError;
    }
}
