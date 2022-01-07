package alura.br.microservicesspringcloud.networking.service;

import alura.br.microservicesspringcloud.config.constants.LojaEndPointConstants;
import alura.br.microservicesspringcloud.dto.InfoFornecedorDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface FornecedorServiceCore {

    @RequestLine("GET " + LojaEndPointConstants.FORNECEDOR_GET_INFO)
    @Headers({"Content-Type: application/json"})
    InfoFornecedorDto getFornecedorList(
            @Param("estado") String estado, @Param("cidade") String cidade);

    @RequestLine("GET " + LojaEndPointConstants.FORNECEDOR_GENERATE_EXCEPTION)
    @Headers({"Content-Type: application/json"})
    void generateException(
            @Param("exceptioncode") String exceptioncode, @Param("service") String service);
}

