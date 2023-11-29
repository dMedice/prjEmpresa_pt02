package com.senai.prjEmpresa.Entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcodigo;


	private String Funnome;

	private Long Funsalario;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate Funnascimento;

	@ManyToOne
	private Departamento departamento;

	public Long getFuncodigo() {
		return funcodigo;
	}

	public void setFuncodigo(Long funcodigo) {
		this.funcodigo = funcodigo;
	}

	public String getFunnome() {
		return Funnome;
	}

	public void setFunnome(String funnome) {
		Funnome = funnome;
	}

	public Long getFunsalario() {
		return Funsalario;
	}

	public void setFunsalario(Long funsalario) {
		Funsalario = funsalario;
	}

	public LocalDate getFunnascimento() {
		return Funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		Funnascimento = funnascimento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
}
