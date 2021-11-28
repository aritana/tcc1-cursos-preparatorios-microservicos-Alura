package alura.br.microservicesspringcloud.service;

import alura.br.microservicesspringcloud.dto.CompraDTO;
import alura.br.microservicesspringcloud.dto.InfoFornecedorDto;
import alura.br.microservicesspringcloud.networking.service.FornecedorServiceCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private FornecedorServiceCore fornecedorServiceCore;

    @Autowired
    public CompraService(FornecedorServiceCore fornecedorServiceCore){
        this.fornecedorServiceCore =fornecedorServiceCore;
    }
    public InfoFornecedorDto realizaCompra(CompraDTO compra) {

        String estado = compra.getEndereco().getEstado();
        InfoFornecedorDto infoFornecedorDto= fornecedorServiceCore.getFornecedorList(estado);
        return infoFornecedorDto;
    }
}
