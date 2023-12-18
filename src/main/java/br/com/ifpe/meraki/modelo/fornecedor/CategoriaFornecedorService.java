package br.com.ifpe.meraki.modelo.fornecedor;

import java.time.LocalDate;

import javax.transaction.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaFornecedorService {
    @Autowired
    private CategoriaFornecedorRepository repository;

    @Transactional
    public CategoriaFornecedor save(CategoriaFornecedor categoria) {
        categoria.setHabilitado(Boolean.TRUE);
        categoria.setVersao(1L);
        categoria.setDataCriacao(LocalDate.now());
        return repository.save(categoria);
    }

    public List<CategoriaFornecedor> findAll() {
        return repository.findAll();
    }

    public CategoriaFornecedor findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, CategoriaFornecedor categoriaAlterada) {
        CategoriaFornecedor categoria = repository.findById(id).get();
        categoria.setCategoria(categoriaAlterada.getCategoria());

        categoria.setVersao(categoria.getVersao() + 1);
        repository.save(categoria);
    }

    @Transactional
    public void delete(Long id) {

        CategoriaFornecedor categoria = repository.findById(id).get();
        categoria.setHabilitado(Boolean.FALSE);
        categoria.setVersao(categoria.getVersao() + 1);

        repository.save(categoria);
    }

}
