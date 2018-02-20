package com.softeam.formation.hibernate.metier.modele;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Personne")
public class Personne {
	@Id
	@GeneratedValue
	private long idPersonne;

	@Embedded
	private Identite identite;

	// attention a la minuscule sur personne et le fait que ce soit bien personne
	// qui est mappedBy
	@OneToMany(mappedBy = "personne")
	private Set<Adresse> adresses;

	@ManyToMany(mappedBy = "personnes")// Mon MappedBy est ici
	private Set<Reunion> reunions;

	/*------------DECLARATION VARIABLES--------------*/
	String email;
	int age;

	/*------------CONSTRUCTEUR--------------*/

	// D'abord Constructeur vide
	Personne() {
	}

	// Constructeur Personne
	public Personne(String personneMail, int personneAge) {
		email = personneMail;
		age = personneAge;
	}

	/*------------GETTER SETTERS--------------*/

	public Set<Reunion> getReunions() {
		return reunions;
	}

	public void setReunions(Set<Reunion> reunions) {
		this.reunions = reunions;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
