package com.softeam.formation.hibernate.metier.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // M'a importé le javax correspondant
@Table(name = "Adresse") // Mapping de ma table

public class Adresse {
	@Id
	@GeneratedValue /*
					 * défini un id et génére un id à chaque new run (sinon conflit car id peut déjà
					 * exister et donc il va pas vouloir remettre une ligne
					 */
	private long idAdresse;
	@ManyToOne
	@JoinColumn(name = "idPersonne")
	private Personne personne;
	
	/*------------DECLARATION VARIABLES--------------*/
	private String ligne1;
	private String ligne2;
	private String ligne3;
	private String codePostal;
	private String ville;
	
	/*------------CONSTRUCTEUR--------------*/
	
	// D'abord Constructeur vide
		public Adresse(){
		}
	
	// CONSTRUCTEUR Adresse (INUTILE dans exercice02 car on genere nos lignes dans le code)
	public Adresse (String ligne1, String ligne2, String ligne3, String codePostal, String ville) {
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.ligne3 = ligne3;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/*------------GETTER SETTERS--------------*/
	
	
	public String getLigne1() {
		return ligne1;
	}

	public long getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}

	public String getLigne2() {
		return ligne2;
	}

	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	public String getLigne3() {
		return ligne3;
	}

	public void setLigne3(String ligne3) {
		this.ligne3 = ligne3;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
