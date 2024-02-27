package edu.unc.academico.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDpto;
	@Column(unique = true)
	private String nombreDpto;
	@OneToMany (mappedBy = "departamento")
	
	@JsonManagedReference
	private List<Investigador> investigadores = new ArrayList<>();
	

}
