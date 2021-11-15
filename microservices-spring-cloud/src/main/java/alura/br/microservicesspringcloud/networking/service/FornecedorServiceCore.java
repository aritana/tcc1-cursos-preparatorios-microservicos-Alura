package alura.br.microservicesspringcloud.networking.service;

import alura.br.microservicesspringcloud.config.constants.LojaEndPointConstants;
import alura.br.microservicesspringcloud.dto.InfoFornecedorDto;
import alura.br.microservicesspringcloud.networking.model.response.InfoFornecedorList;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface FornecedorServiceCore {

    @RequestLine("GET " + LojaEndPointConstants.FORNECEDOR_GET_INFO)
    @Headers({"Content-Type: application/json"})
    InfoFornecedorDto getFornecedorList(
            @Param("estado") String estado);
}
//    @RequestLine("GET " + LojaEndPointConstants.FORNECEDOR_GET_INFO)
//    @Headers({"Content-Type: application/json"})
//    InfoFornecedorList getFornecedorList(
//            @Param("estado") String estado);
//}
