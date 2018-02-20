package com.softeam.formation.hibernate.metier.modele;

import javax.persistence.Embeddable;

@Embeddable
public class Identite {

	/*------------DECLARATION VARIABLES--------------*/
	String nom;
	String prenom;
	String initiales;

	/*------------CONSTRUCTEURS--------------*/
	// Constructeur vide
	public Identite() {

	}

	public Identite(String nom, String prenom, String initiales) {
		this.nom = nom;
		this.prenom = prenom;
		this.initiales = initiales;
	}

	/*------------GETTER SETTERS--------------*/
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getInitiales() {
		return initiales;
	}

	public void setInitiales(String initiales) {
		this.initiales = initiales;
	}

}
