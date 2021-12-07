package alura.br.microservicesspringcloud.exception;

import alura.br.microservicesspringcloud.dto.responseError.InfoFornecedorErrorDto;
import alura.br.microservicesspringcloud.exception.config.ErroDeFormularioDto;
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

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CentralExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    //captura erros de body
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
    //captura erros de validacao
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public List<InfoFornecedorErrorDto> handleNullPointer(NullPointerException exception) {

        List<InfoFornecedorErrorDto> infoFornecedorErrorDtoList = new ArrayList<>();
        InfoFornecedorErrorDto infoFornecedorErrorDto =  new InfoFornecedorErrorDto("Estado não pode ser Encontrado.");
        infoFornecedorErrorDtoList.add(infoFornecedorErrorDto);

        logger.info("NullPointerException {}",exception.getMessage());
        return infoFornecedorErrorDtoList;

    }
    //captura badrequest de outro servico
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public List<InfoFornecedorErrorDto> handleBadRequest(BadRequestException exception) {

        List<InfoFornecedorErrorDto> infoFornecedorErrorDtoList = new ArrayList<>();
        InfoFornecedorErrorDto infoFornecedorErrorDto =  new InfoFornecedorErrorDto("Cidade não pode ser Encontrada.");
        infoFornecedorErrorDtoList.add(infoFornecedorErrorDto);

        logger.info("BadRequestException {}",exception.getMessage());
        return infoFornecedorErrorDtoList;

    }
}
