package br.edu.fateczl.AulaMongoDB.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.fateczl.AulaMongoDB.model.Pessoa;

public interface IPessoaRepository extends MongoRepository<Pessoa, String> {
	
	public List<Pessoa> findByDtNascOrderByNomeDesc(LocalDate dtNasc);
	public Pessoa findByNome(String nome);
	public Optional<Pessoa> findById(String id);

}
