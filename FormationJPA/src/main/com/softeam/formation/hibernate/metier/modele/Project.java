package com.softeam.formation.hibernate.metier.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // M'a importé le javax correspondant
@Table(name="Project") //Mapping de ma table
public class Project {
	@Id @GeneratedValue
	private long idProject;
	String nom;
	
	/*----------- GETTER SETTERS----------------------*/
	
	public long getIdProject() {
		return idProject;
	}
	public void setIdProject(long idProject) {
		this.idProject = idProject;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
