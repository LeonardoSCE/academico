package edu.unc.academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.academico.domain.Departamento;
import edu.unc.academico.domain.Investigador;
import edu.unc.academico.repository.DepartamentoRepository;
import edu.unc.academico.repository.InvestigadorRepository;

@Service
public class investigadorDptoServiceImp implements investigadorDptoService {

	@Autowired
	private InvestigadorRepository invRepository;
	@Autowired
	private DepartamentoRepository dptoRepository;
	
	@Override
	@Transactional
	public Investigador replaceDpto(Long idInvestigador, Long idDpto) {
		Optional<Investigador> invEntity = invRepository.findById(idInvestigador);
		Optional<Departamento> dptoEntity = dptoRepository.findById(idDpto);
		
		invEntity.get().setDepartamento(dptoEntity.get());
		return invEntity.get();
	}
	
	@Override
	@Transactional
	public void removeDpto(Long idInvestigador) {
		Optional<Investigador> invEntity = invRepository.findById(idInvestigador);
		Optional<Departamento> dptoEntity = dptoRepository.findById(invEntity.get().getDepartamento().getIdDpto());
		
		dptoEntity.ifPresent(departamento -> departamento.getInvestigadores().remove(invEntity.get()));
		invEntity.get().setDepartamento(null);
		
	}

}
