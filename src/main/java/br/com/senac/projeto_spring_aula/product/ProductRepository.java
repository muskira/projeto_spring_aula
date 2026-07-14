package br.com.senac.projeto_spring_aula.product;


import br.com.senac.projeto_spring_aula.product.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
