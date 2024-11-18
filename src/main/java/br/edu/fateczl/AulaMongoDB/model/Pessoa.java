package br.edu.fateczl.AulaMongoDB.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
	
	@Id
	private String id;
	private String nome;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtNasc;
	
}
