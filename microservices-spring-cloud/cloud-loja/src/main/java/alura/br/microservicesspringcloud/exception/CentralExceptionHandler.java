package alura.br.microservicesspringcloud.exception;

import alura.br.microservicesspringcloud.exception.config.ErroDeFormularioDto;
import alura.br.microservicesspringcloud.networking.config.ResponseError;
import alura.br.microservicesspringcloud.service.TraceService;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CentralExceptionHandler {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    TraceService traceService;

    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {

        List<ErroDeFormularioDto> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach( e -> {
            String mensagem =messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
            dto.add(erro);
        });
        logger.info("Exception: MethodArgumentNotValidException {}",exception.getMessage());
        return  dto;
    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseError handleNotFound(NotFoundException exception) {
        ResponseError responseError;
        if(exception.responseError == null){
            responseError = ResponseError.builder()
                    .timestamp(String.valueOf(LocalTime.now()))
                    .status("404")
                    .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                    .trace_id(traceService.getTraceId())
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
