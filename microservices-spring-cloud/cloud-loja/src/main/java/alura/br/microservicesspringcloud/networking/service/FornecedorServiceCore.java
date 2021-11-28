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
            @Param("estado") String estado);
}

