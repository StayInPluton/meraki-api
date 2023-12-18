package br.com.ifpe.meraki.api.fornecedor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.meraki.modelo.fornecedor.CategoriaFornecedor;
import br.com.ifpe.meraki.modelo.fornecedor.CategoriaFornecedorService;
import io.swagger.models.Response;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin
public class CategoriaFornecedorController {

    @Autowired
    private CategoriaFornecedorService categoriaFornecedorService;

    @PostMapping
    public ResponseEntity<CategoriaFornecedor> save(@RequestBody CategoriaFornecedorRequest request) {
        // TODO: process POST request

        CategoriaFornecedor categoriaFornecedorNovo = request.build();

        CategoriaFornecedor categoriaFornecedor = categoriaFornecedorService.save(categoriaFornecedorNovo);

        return new ResponseEntity<CategoriaFornecedor>(categoriaFornecedor, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CategoriaFornecedor> findAll() {
        return categoriaFornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaFornecedor findById(@PathVariable Long id) {

        return categoriaFornecedorService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaFornecedor> update(@PathVariable("id") Long id,
            @RequestBody CategoriaFornecedorRequest request) {
        // TODO: process PUT request
        categoriaFornecedorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        categoriaFornecedorService.delete(id);
        return ResponseEntity.ok().build();
    }

    
}
