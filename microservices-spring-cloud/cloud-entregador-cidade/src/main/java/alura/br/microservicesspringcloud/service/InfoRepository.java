package alura.br.microservicesspringcloud.service;

import alura.br.microservicesspringcloud.model.InfoFornecedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {
    InfoFornecedor findByCidade(String cidade);
}
