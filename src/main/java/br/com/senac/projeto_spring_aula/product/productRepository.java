package br.com.senac.projeto_spring_aula.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<productEntity, Integer> {
}
