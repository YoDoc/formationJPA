package com.softeam.formation.jpa.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.softeam.formation.hibernate.metier.modele.Adresse;
import com.softeam.formation.hibernate.metier.modele.Personne;
import com.softeam.formation.jpa.metier.dao.AdresseDAO;
import com.softeam.formation.jpa.metier.dao.PersonneDAO;

public class Exercice05 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// CODE DU MAIN
		// CREATION PERSONNE/ADRESSE
		
		Personne p1 = new Personne("jon.Snow@mars.wo", 66);
		Personne p2 = new Personne("eivfiunbmi@liyhb", 33);

		Adresse a1 = new Adresse("11", "rue", "Duchesse Anne", "35000", "RENNES");
		Adresse a2 = new Adresse("35", "Bd", "Des Arcs", "98000", "NANTES");
		
		Adresse a3 = new Adresse("33", "all", "rabe", "56000", "UYDIUB");

		
		// Association adresse / personne
		a1.setPersonne(p1); // c'est dans ce sens, càd l'adresse a une personne et pas l'inverse (ce que j'ai fait au départ
		a2.setPersonne(p1); // idem
		
		a3.setPersonne(p2); // idem
		
		// Appelle du constructeur pour rentrer l'emf
		// Puis méthode Ajout personne
		PersonneDAO personneDAO= new PersonneDAO(emf);
		personneDAO.ajouter(p1);
		
		personneDAO.ajouter(p2);
		
		// Appelle du constructeur pour rentrer l'emf
		// Puis méthode Ajout adresse
		AdresseDAO adresseDAO = new AdresseDAO (emf);
		
		
		adresseDAO.ajouterAdresse(a1);
		adresseDAO.ajouterAdresse(a2);
		adresseDAO.ajouterAdresse(a3);
		
		tx.commit();
		em.close(); // close l'em
		emf.close(); // l'emf sinon ca tourne
	}

}
