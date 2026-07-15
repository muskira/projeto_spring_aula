package br.com.senac.projeto_spring_aula.product;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public ResponseEntity<ProductEntity> salvar (@Valid @RequestBody ProductPostDto dto) {
        ProductEntity produto = new ProductEntity();

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setQuantidadeEstoque(dto.quantidadeEstoque());

        if (dto.quantidadeEstoque() > 0) {
            produto.setStatus(ProductStatus.DISPONIVEL);
        } else {
            produto.setStatus(ProductStatus.ESGOTADO);
        }

        repository.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> listar(){

        return ResponseEntity.ok(repository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> buscar(@PathVariable long id){

        Optional<ProductEntity> produto = repository.findById(id);

        if(produto.isPresent()){
            return ResponseEntity.ok(produto.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){

        Optional<ProductEntity> produto = repository.findById(id);

        if(produto.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        repository.delete(produto.get());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/reabastecer")
    public ResponseEntity<ProductEntity> reabastecer(
            @PathVariable Long id,
            @RequestParam Integer quantidade){

        Optional<ProductEntity> produto = repository.findById(id);

        if(produto.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ProductEntity p = produto.get();

        p.setQuantidadeEstoque(
                p.getQuantidadeEstoque() + quantidade
        );

        if(p.getQuantidadeEstoque() > 0){
            p.setStatus(ProductStatus.DISPONIVEL);
        }else{
            p.setStatus(ProductStatus.ESGOTADO);
        }

        repository.save(p);

        return ResponseEntity.ok(p);
    }

}

