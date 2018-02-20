package com.softeam.formation.jpa.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.softeam.formation.hibernate.metier.modele.Adresse;


public class AdresseDAO {
	
	// déclaration de la variable emf contenant l'EMF
		private EntityManagerFactory emf;


		// constructeur pour passer l'emf, donc juste pour l'ouvrir
	public AdresseDAO(EntityManagerFactory emf) {
			this.emf = emf;
		}


	/*------------METHODES--------------*/
	// Methode AJOUTER UNE ADRESSE A UNE PERSONNE EXISTANTE
	public void ajouterAdresse(Adresse adresse) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(adresse);

		tx.commit();
		em.close();

	}
	
}
