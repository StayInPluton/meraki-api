package br.com.ifpe.meraki.api.administrador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.meraki.modelo.administrador.Administrador;
import br.com.ifpe.meraki.modelo.administrador.AdministradorService;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/mera-6669")
@CrossOrigin
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<Administrador> save(@RequestBody AdministradorRequest request) {
        // TODO: process POST request
        Administrador administrador = administradorService.save(request.build());
        return new ResponseEntity<Administrador>(administrador, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Administrador> findAll() {
        return administradorService.findAll();
    }

    @GetMapping("/{id}")
    public Administrador findById(@PathVariable Long id) {
        return administradorService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> update(@PathVariable("id") Long id,
            @RequestBody AdministradorRequest request) {
        // TODO: process PUT request
        administradorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        administradorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
