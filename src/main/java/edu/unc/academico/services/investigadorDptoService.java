package edu.unc.academico.services;

import edu.unc.academico.domain.Investigador;

public interface investigadorDptoService {
	public Investigador replaceDpto(Long idInvestidagor, Long idDpto);
	public void removeDpto(Long idInvestigador);
	
}
