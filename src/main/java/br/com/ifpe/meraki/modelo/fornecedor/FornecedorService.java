package br.com.ifpe.meraki.modelo.fornecedor;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private EnderecoFornecedorRepository enderecoFornecedorRepository;

    @Transactional
    public Fornecedor save(Fornecedor fornecedor) {

        fornecedor.setHabilitado(Boolean.TRUE);
        fornecedor.setVersao(1L);
        return repository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {

        return repository.findAll();
    }

    public Fornecedor findById(long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Fornecedor fornecedorAlterado) {

        Fornecedor fornecedor = repository.findById(id).get();
        fornecedor.setNome(fornecedorAlterado.getNome());
        fornecedor.setEmail(fornecedorAlterado.getEmail());
        fornecedor.setSenha(fornecedorAlterado.getSenha());
        fornecedor.setTelefone(fornecedorAlterado.getTelefone());

        fornecedor.setVersao(fornecedor.getVersao() + 1);
        repository.save(fornecedor);

    }

    @Transactional
    public void delete(Long id) {
        Fornecedor fornecedor = repository.findById(id).get();
        fornecedor.setHabilitado(Boolean.FALSE);
        fornecedor.setVersao(fornecedor.getVersao() + 1);
        repository.save(fornecedor);
    }

    @Transactional
    public EnderecoFornecedor adicionarEnderecoFornecedor(Long fornecedorId, EnderecoFornecedor endereco) {
        Fornecedor fornecedor = this.findById(fornecedorId);

        endereco.setFornecedor(fornecedor);
        endereco.setHabilitado(Boolean.TRUE);
        enderecoFornecedorRepository.save(endereco);

        List<EnderecoFornecedor> listaEnderecoFornecedor = fornecedor.getEnderecos();

        if (listaEnderecoFornecedor == null) {
            listaEnderecoFornecedor = new ArrayList<EnderecoFornecedor>();
        }
        listaEnderecoFornecedor.add(endereco);
        fornecedor.setEnderecos(listaEnderecoFornecedor);
        this.save(fornecedor);

        return endereco;
    }

    @Transactional
    public EnderecoFornecedor atualizarEnderecoFornecedor(Long id, EnderecoFornecedor enderecoAlterado) {
        EnderecoFornecedor endereco = enderecoFornecedorRepository.findById(id).get();
        endereco.setRua(enderecoAlterado.getRua());
        endereco.setNumero(enderecoAlterado.getNumero());
        endereco.setBairro(enderecoAlterado.getBairro());
        endereco.setCep(enderecoAlterado.getCep());
        endereco.setCidade(enderecoAlterado.getCidade());
        endereco.setEstado(enderecoAlterado.getEstado());
        endereco.setComplemento(enderecoAlterado.getComplemento());

        return enderecoFornecedorRepository.save(endereco);
    }

    @Transactional
    public void removerEnderecoFornecedor(Long id) {
        EnderecoFornecedor endereco = enderecoFornecedorRepository.findById(id).get();
        endereco.setHabilitado(Boolean.FALSE);
        enderecoFornecedorRepository.save(endereco);

        Fornecedor fornecedor = this.findById(endereco.getFornecedor().getId());
        fornecedor.getEnderecos().remove(endereco);
        this.save(fornecedor);
    }

    // Listagem de produto
    public List<Fornecedor> filtrar(String nome) {
        List<Fornecedor> listarFornecedor = repository.findAll();
        listarFornecedor = repository.consultarPorNome(nome);

        return listarFornecedor;

    }
}
