package edu.unc.academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.academico.domain.Investigador;
import edu.unc.academico.repository.InvestigadorRepository;

@Service
public class InvestigadorServicesImp implements InvestgadorService {

	@Autowired
	private InvestigadorRepository InvRep;
	
	@Override
	public List<Investigador> listarInv() {
		// TODO Auto-generated method stub
		return (List<Investigador>)InvRep.findAll();
	}

	@Override
	@Transactional(readOnly = true)

	public Optional<Investigador> buscarPorIdInv(Long idInv) {
		// TODO Auto-generated method stub
		return InvRep.findById(idInv);

	}

	@Override
	public Investigador grabarInv(Investigador inv) {
		// TODO Auto-generated method stub
		return InvRep.save(inv);
	}

	@Override
	public void eliminarInv(Long idInv) {
		InvRep.deleteById(idInv);
	}

}
