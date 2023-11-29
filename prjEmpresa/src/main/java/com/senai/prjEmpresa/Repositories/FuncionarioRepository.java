package com.senai.prjEmpresa.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.senai.prjEmpresa.Entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	@Query("SELECT f FROM Funcionario f WHERE LOWER(f.Funnome) LIKE LOWER(CONCAT('%', :Funnome, '%'))")
	List<Funcionario> findByNomeContaining(@Param("Funnome") String Funnome);
}