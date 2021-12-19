package alura.br.microservicesspringcloud.networking.service;

import alura.br.microservicesspringcloud.config.constants.LojaEndPointConstants;
import alura.br.microservicesspringcloud.dto.InfoFornecedorCidadeDto;
import alura.br.microservicesspringcloud.dto.InfoFornecedorDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface FornecedorCidadeServiceCore {

    @RequestLine("GET " + LojaEndPointConstants.FORNECEDOR_GET_INFO)
    @Headers({"Content-Type: application/json"})
    InfoFornecedorCidadeDto getFornecedor(
            @Param("cidade") String cidade);//nao preciso lancar excecoes como  badrequestEx..?
}

