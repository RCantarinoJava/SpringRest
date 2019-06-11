package br.com.cantarino.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cantarino.Models.Pessoa;


public interface PessoaRepositoryImpl extends  JpaRepository<Pessoa, Long>{

	
	
}
