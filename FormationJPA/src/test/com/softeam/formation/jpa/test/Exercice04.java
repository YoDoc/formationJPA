package com.softeam.formation.jpa.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.softeam.formation.hibernate.metier.modele.Identite;
import com.softeam.formation.hibernate.metier.modele.Personne;
import com.softeam.formation.jpa.metier.dao.PersonneDAO;

public class Exercice04 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		System.out.println("emf ouvert");
				
		// CREATION PERSONNE et IDENTITE
		Personne p1 = new Personne("jon.Snow@mars.wo", 66);
		Identite i1 = new Identite("Snow", "Jon", "JS");
		p1.setIdentite(i1);
		
		PersonneDAO personneDAO= new PersonneDAO(emf); 
		
		// AJOUT PERSONNE
		personneDAO.ajouter(p1);
	
		
		// LIRE PERSONNE
		Personne p2 = personneDAO.lire(58);
		System.out.println("Personne1 <id>: " + p2.getIdentite().getNom());
		
			
		//SUPPRIMER PERSONNE
		personneDAO.supprimer(p2);
		
		// Appel de la méthode modifier
		
		emf.close(); // l'emf sinon ca tourne

	}

}
