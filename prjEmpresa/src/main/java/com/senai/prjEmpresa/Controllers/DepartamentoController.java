package com.senai.prjEmpresa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.prjEmpresa.Entities.Departamento;
import com.senai.prjEmpresa.Services.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



@Tag(name = "Departamentos", description = "API REST DE GERENCIAMENTO DE DEPARTAMENTOS")
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	private final DepartamentoService departamentoService;

	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/{depcodigo}")
	@Operation(summary = "Localiza departamento por ID/código ")
	public ResponseEntity<Departamento> findDepartamentobyId(@PathVariable Long id) {
		Departamento departamento = departamentoService.findDepartamentoById(id);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary="Apresenta todos os departamentos")
	public ResponseEntity<List<Departamento>> findAllDepartamentoscontroll() {
		List<Departamento> departamentos = departamentoService.findAllDepartamento();
		return ResponseEntity.ok(departamentos);
	}

	@PostMapping("/{depcodigo}")
	@Operation(summary = "Cadastra um Usuário")
	public ResponseEntity<Departamento> insertDepartamentosControll(@RequestBody @Valid Departamento departamento) {
		Departamento novoDepartamento = departamentoService.insertDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
	}

	@PutMapping("/depcodigo")
	@Operation(summary = "Altera um Usuário")
	public ResponseEntity<Departamento> updateDepartamentoControll(@PathVariable Long id, @RequestBody @Valid Departamento departamento) {
		Departamento mudaDepartamento= departamentoService.updateDepartamento(id, departamento);
		if (mudaDepartamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/depcodigo")
	@Operation(summary = "Excluí um Departamento")
	public ResponseEntity<String> deleteDepartamentoControll(@PathVariable Long id) {
		boolean remover = departamentoService.deleteUsuario(id);
		if (remover) {
			return ResponseEntity.ok().body("Departamento Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
