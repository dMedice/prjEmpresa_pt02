package com.senai.prjEmpresa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.prjEmpresa.Entities.Departamento;
import com.senai.prjEmpresa.Repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	private  DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	// preparando as buscas por id
	public Departamento findDepartamentoById(Long depcodigo) {
		Optional<Departamento> Departamento = departamentoRepository.findById(depcodigo);
		return Departamento.orElse(null);
	}

	// preparando a busca geral
	public List<Departamento> findAllDepartamento() {
		return departamentoRepository.findAll();
	}

	// salvando
	public Departamento insertDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	// fazendo o update com o optional
	public Departamento updateDepartamento(Long id, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(id);
		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setDepnome(novoDepartamento.getDepnome());
			return departamentoRepository.save(departamentoExistente);
		} else {
			return null;
		}
	}

	// deletando o update com o optional
	public boolean deleteUsuario(Long id) {
		Optional<Departamento> departamentoExistente = departamentoRepository.findById(id);
		if (departamentoExistente.isPresent()) {
			departamentoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
