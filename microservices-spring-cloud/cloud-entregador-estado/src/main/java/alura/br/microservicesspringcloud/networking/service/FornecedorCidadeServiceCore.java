package alura.br.microservicesspringcloud.networking.service;

import alura.br.microservicesspringcloud.config.constants.EndPointConstants;
import alura.br.microservicesspringcloud.dto.InfoFornecedorCidadeDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface FornecedorCidadeServiceCore {

    @RequestLine("GET " + EndPointConstants.FORNECEDOR_GET_INFO)
    @Headers({"Content-Type: application/json"})
    InfoFornecedorCidadeDto getFornecedor(
            @Param("cidade") String cidade);

    @RequestLine("GET " + EndPointConstants.FORNECEDOR_GENERATE_EXCEPTION)
    @Headers({"Content-Type: application/json"})
    void generateException(
            @Param("exceptioncode") String exceptioncode, @Param("service") String service);
}

