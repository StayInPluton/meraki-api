package br.com.ifpe.meraki.api.fornecedor;

import javax.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.meraki.api.cliente.EnderecoClienteRequest;
import br.com.ifpe.meraki.modelo.fornecedor.EnderecoFornecedor;
import br.com.ifpe.meraki.modelo.fornecedor.Fornecedor;
import br.com.ifpe.meraki.modelo.fornecedor.FornecedorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/fornecedor")
@CrossOrigin

public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody FornecedorRequest request) {
        Fornecedor fornecedor = fornecedorService.save(request.build());
        return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Fornecedor> findAll() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public Fornecedor findById(@PathVariable Long id) {
        return fornecedorService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable("id") Long id, @RequestBody FornecedorRequest request) {
        // TODO: process PUT request
        fornecedorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        fornecedorService.delete(id);
        return ResponseEntity.ok().build();
    }

    // PARTE DO ENDEREÇO
    @PostMapping("/endereco/{fornecedorId}")
    public ResponseEntity<EnderecoFornecedor> adicionarEnderecoFornecedor(
            @PathVariable("forncedorId") Long fornecedorId, @RequestBody @Valid EnderecoFornecedorRequest request) {
        // TODO: process POST request
        EnderecoFornecedor endereco = fornecedorService.adicionarEnderecoFornecedor(fornecedorId, request.build());
        return new ResponseEntity<EnderecoFornecedor>(endereco, HttpStatus.CREATED);
    }

    @PutMapping("/endereco/{enderecoId}")
    public ResponseEntity<EnderecoFornecedor> atualizarEnderecoFornecedor(@PathVariable("enderecoId") Long enderecoId,
            @RequestBody EnderecoFornecedorRequest request) {

        EnderecoFornecedor endereco = fornecedorService.atualizarEnderecoFornecedor(enderecoId, request.build());
        return new ResponseEntity<EnderecoFornecedor>(endereco, HttpStatus.OK);
    }

    @DeleteMapping("/endereco/{enderecoId}")
    public ResponseEntity<Void> removerEnderecoFornecedor(@PathVariable("enderecoId") Long enderecoId) {

        fornecedorService.removerEnderecoFornecedor(enderecoId);
        return ResponseEntity.noContent().build();
    } 

}
