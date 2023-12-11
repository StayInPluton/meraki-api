package br.com.ifpe.meraki.api.produto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.meraki.modelo.produto.ProdutoService;
import br.com.ifpe.meraki.api.produto.ProdutoRequest;
import br.com.ifpe.meraki.modelo.produto.CategoriaProdutoService;
import br.com.ifpe.meraki.modelo.produto.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {
        // TODO: process POST request
        Produto produtoNovo = request.build();
        produtoNovo.setCategoria(categoriaProdutoService.findById(request.getIdCategoria()));
        Produto produto = produtoService.save(produtoNovo);
        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);

    }

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Produto findByid(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {
        // TODO: process PUT request
        Produto produto = request.build();
        produto.setCategoria(categoriaProdutoService.findById(request.getIdCategoria()));
        produtoService.update(id, produto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        produtoService.delete(id);
        return ResponseEntity.ok().build();

    }

}
