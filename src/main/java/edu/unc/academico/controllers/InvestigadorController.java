package edu.unc.academico.controllers;

import java.util.List;
import java.util.Optional;

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

import edu.unc.academico.domain.Investigador;
import edu.unc.academico.services.InvestgadorService;

@RestController
@RequestMapping("api/v1/investigadores")
public class InvestigadorController {
	@Autowired
	private InvestgadorService invService;

	
	@GetMapping
	public List<Investigador> listarInv() {
		return invService.listarInv();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<?> listarPorInv(@PathVariable Long id) {
		Optional<Investigador> invOptinal = invService.buscarPorIdInv(id);
		if(invOptinal.isPresent()) {
			return ResponseEntity.ok(invOptinal.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> crearInv(@RequestBody Investigador inv){
		return ResponseEntity.status(HttpStatus.CREATED).body(invService.grabarInv(inv));
	}
	
	@PutMapping
	public ResponseEntity<?> ediarInv(@PathVariable Long id, @RequestBody Investigador inv){
		Optional<Investigador> o = invService.buscarPorIdInv(id);
		if(o.isPresent()) {
			Investigador invDB = o.get();
			invDB.setApeMat(inv.getApeMat());
			invDB.setApeMat(inv.getApePat());
			invDB.setEmail(inv.getEmail());
			invDB.setFechaNac(inv.getFechaNac());
			invDB.setNombres(inv.getNombres());
			return ResponseEntity.status(HttpStatus.CREATED).body(invService.grabarInv(invDB));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarInv (@PathVariable Long id){
		Optional<Investigador> o =invService.buscarPorIdInv(id);
		if(o.isPresent()) {
			invService.eliminarInv(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
