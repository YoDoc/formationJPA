package com.softeam.formation.hibernate.metier.modele;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // M'a importé le javax correspondant
@Table(name = "Reunion") // Mapping de ma table
public class Reunion {
	
	@Id	@GeneratedValue	@Column(name = "Reunion")
	private long idReunion;
	String titre;
	Date dateDebut;
	Date dateFin;
	
	@ManyToOne	@JoinColumn(name = "Salle")
	private Salle salle;
	
	@ManyToOne	@JoinColumn(name = "Project")
	private Project project;
	
	@ManyToMany // Hibernate s'attend à trouver "réunion" dans la classe qui porte le ManyToMany (donc la classe Personne)
	@JoinTable (name="Filiation",
	joinColumns=@JoinColumn(name="idReunion"), 
	inverseJoinColumns=@JoinColumn(name="idPersonne"))
	private Set<Personne> personnes;

	
	/*----------- GETTER SETTERS----------------------*/
	

	public Set<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}
	public long getIdReunion() {
		return idReunion;
	}
	public void setIdReunion(long idReunion) {
		this.idReunion = idReunion;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
}
