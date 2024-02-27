package edu.unc.academico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unc.academico.domain.Investigador;
import edu.unc.academico.services.investigadorDptoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/investigadores")
public class InvestigadorDepartamentoController {
	@Autowired
	private investigadorDptoService invDptoService;
	
	@PutMapping(value="/{idInv}/{idDpto}")
	public Investigador replaceDpto(@PathVariable Long idInv, @PathVariable Long idDpto) {
		Investigador invEntity = invDptoService.replaceDpto(idInv, idDpto);
		
		return invEntity;
	}
}
