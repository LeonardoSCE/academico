package edu.unc.academico.services;

import java.util.List;
import java.util.Optional;

import edu.unc.academico.domain.Departamento;

public interface DepartamentoService {
	
	List<Departamento> listarDptos();
	Optional<Departamento> buscarPorIdInv(Long idDpto);
	Departamento grabarDpto(Departamento dpto);
	void eliminarDpto(Long IdDpto);
	
}
