package com.softeam.formation.jpa.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.softeam.formation.hibernate.metier.modele.Personne;
import com.softeam.formation.hibernate.metier.modele.Reunion;
import com.softeam.formation.jpa.metier.dao.PersonneDAO;
import com.softeam.formation.jpa.metier.dao.ReunionDAO;

public class Exercice07 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

		// Je crée mes objets reunion/personne
		Reunion reunionJour = new Reunion();
		Reunion reunionNuit = new Reunion();

		Personne p1 = new Personne("Jean Choin", 18);
		Personne p2 = new Personne("Marie R", 22);
		Personne p3 = new Personne("C Jerome", 96);
		Personne p4 = new Personne("B IU", 55);
		Personne p5 = new Personne("J Christ", 33);

		// definition d'un HashSet de Personne (Anthony)
		// Obligé car j'avais créé un Set (liste non ordonnée) de personnes dans Personnes.
		Set<Personne> groupe1 = new HashSet<Personne>();
		Set<Personne> groupe2 = new HashSet<Personne>();

		reunionJour.setTitre("Titre: Ordre du Jour");
		reunionNuit.setTitre("Titre: Ordre du Nuit");

		// Et du coup
		groupe1.add(p1);
		groupe1.add(p2);
		groupe1.add(p3);

		groupe2.add(p4);
		groupe2.add(p5);

		// Association reunion / personne
		/* C'est dans ce sens, càd la reunion contient une personne et pas l'inverse 
		 * Donc le MappedBy est porté par la classe Personne. 
		 * 
		 * Ensuite attention à l'ordre de déclaration des personnes et réunions 
		*/
		reunionJour.setPersonnes(groupe1); 
		reunionNuit.setPersonnes(groupe2); 
		
		PersonneDAO personneDAO = new PersonneDAO(emf);

		personneDAO.ajouter(p1);
		personneDAO.ajouter(p2);
		personneDAO.ajouter(p3);
		personneDAO.ajouter(p4);
		personneDAO.ajouter(p5);

		ReunionDAO reunionDAO = new ReunionDAO(emf);

		reunionDAO.ajouter(reunionJour);
		reunionDAO.ajouter(reunionNuit);
	}

}
