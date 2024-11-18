package br.edu.fateczl.AulaMongoDB;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.fateczl.AulaMongoDB.model.Pessoa;
import br.edu.fateczl.AulaMongoDB.repository.IPessoaRepository;

@SpringBootTest
class AulaMongoDbApplicationTests {

	@Autowired
	IPessoaRepository pRep;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void pessoa() {
//		pRep.deleteAll();
		
		Pessoa p1 = new Pessoa("1", "Joana", "p1@email.com", LocalDate.of(1990, 8, 4));
		Pessoa p2 = new Pessoa("2", "José", "p2@email.com", LocalDate.of(1990, 8, 4));
		Pessoa p3 = new Pessoa("3", "Maria", "p3@email.com", LocalDate.of(1990, 8, 4));
		Pessoa p4 = new Pessoa("4", "Luiz", "p4@email.com", LocalDate.of(1991, 2, 2));
		
		pRep.save(p1);
		pRep.save(p2);
		pRep.save(p3);
		pRep.save(p4);
		
		p2.setEmail("jose@email.com");
		pRep.save(p2);
		
		p4.setDtNasc(LocalDate.of(1991, 1, 2));
		pRep.save(p4);
		
		List<Pessoa> pessoasData = pRep.findByDtNascOrderByNomeDesc(LocalDate.of(1990, 8, 4));
		pessoasData.forEach(System.out::println);
		System.out.println("********************************************************");
		Pessoa pes = pRep.findById("3")
				.orElseThrow(() -> new NoSuchElementException("ID Inválido"));
		System.out.println(pes);
		System.out.println("********************************************************");
		Pessoa pes1 = pRep.findByNome("Luiz");
		System.out.println(pes1);
		System.out.println("********************************************************");
		List<Pessoa> pessoas = pRep.findAll(Sort.by(Sort.Direction.DESC, "nome"));
		pessoas.forEach(System.out::println);
	}

}
