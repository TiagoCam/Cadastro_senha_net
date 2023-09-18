package br.com.cadastros.model.repository;

import br.com.cadastros.model.entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {


}
