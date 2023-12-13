package br.com.ifpe.meraki.modelo.fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    @Query(value = "SELECT f FROM Fornecedor f HWERE f.nome like %:nome% ORDER BY f.nome ")
    List<Fornecedor> consultarPorNome(String nome);
}
