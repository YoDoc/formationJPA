package com.softeam.formation.hibernate.metier.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // M'a importé le javax correspondant
@Table(name="Salle") //Mapping de ma table
public class Salle {
	@Id @GeneratedValue
	private long idSalle;
	String nom;
	int nbPlaces;
	public long getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(long idSalle) {
		this.idSalle = idSalle;
		
		/*----------- GETTER SETTERS----------------------*/
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	
	
}
