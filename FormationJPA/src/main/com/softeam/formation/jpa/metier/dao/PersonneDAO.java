package com.softeam.formation.jpa.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.softeam.formation.hibernate.metier.modele.Personne;

public class PersonneDAO {

	// je pense que Variables, Constructeur et Getter sont inutiles
	
												/*------------DECLARATION VARIABLES--------------*/
												String personneAAjouter;
											
												// déclaration de la variable emf contenant l'EMF
												private EntityManagerFactory emf;
											
												// Je fais un constructeur qui me rentre cette variable en paramètre
												// et me retourne le this.emf (Project.emf)
												public PersonneDAO(EntityManagerFactory emf) {
													this.emf = emf;
												}

												/*------------GETTER SETTERS--------------*/
												public String getPersonneAAjouter() {
													return personneAAjouter;
												}
											
												public void setPersonneAAjouter(String personneAAjouter) {
													this.personneAAjouter = personneAAjouter;
												}

	/*------------METHODES--------------*/
	// Methode ajouter (main exo04)
	public void ajouter(Personne personne) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(personne);

		tx.commit();
		em.close();

	}

	// Methode lire
	public Personne lire(long idPersonne) {
		EntityManager em = emf.createEntityManager();

		Personne p1 = em.find(Personne.class, idPersonne);

		return p1;
	}

	// Methode supprimer
	public void supprimer(Personne personne) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.remove(em.merge(personne));

		tx.commit();
		em.close();
	}

	/*
	 * A FAIRE LA METHODE MODIFIER Methode modifier public void modifier(Personne
	 * personne) { EntityManager em = emf.createEntityManager(); EntityTransaction
	 * tx = em.getTransaction(); tx.begin();
	 * 
	 * em.merge(null);
	 * 
	 * tx.commit(); em.close();
	 * 
	 * }
	 */
}
