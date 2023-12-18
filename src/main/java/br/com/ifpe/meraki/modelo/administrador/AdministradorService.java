package br.com.ifpe.meraki.modelo.administrador;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository repository;

    @Transactional
    public Administrador save(Administrador administrador) {
        administrador.setHabilitado(Boolean.TRUE);
        administrador.setVersao(1L);
        administrador.setDataCriacao(LocalDate.now());

        return repository.save(administrador);
    }

    public List<Administrador> findAll() {
        return repository.findAll();
    }

    public Administrador findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Administrador administradorAlterado) {

        Administrador administrador = repository.findById(id).get();
        administrador.setNome(administradorAlterado.getNome());
        administrador.setEmail(administradorAlterado.getEmail());
        administrador.setSenha(administradorAlterado.getSenha());
        administrador.setIndentificacao(administradorAlterado.getIndentificacao());

        administrador.setVersao(administrador.getVersao() + 1);
        repository.save(administrador);
    }

    @Transactional
    public void delete(Long id) {
        Administrador administrador = repository.findById(id).get();
        administrador.setHabilitado(Boolean.FALSE);
        administrador.setVersao(administrador.getVersao() + 1);

        repository.save(administrador);
    }

}
