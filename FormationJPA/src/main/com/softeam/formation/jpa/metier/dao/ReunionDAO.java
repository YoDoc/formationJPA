package com.softeam.formation.jpa.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.softeam.formation.hibernate.metier.modele.Personne;
import com.softeam.formation.hibernate.metier.modele.Reunion;

public class ReunionDAO {
	// déclaration de la variable emf contenant l'EMF
		private EntityManagerFactory emf;
		
		//Je fais un constructeur qui me rentre cette variable en paramètre 
		// et me retourne le this.emf (Project.emf)
		public ReunionDAO(EntityManagerFactory emf) {
			this.emf = emf;
		}
		
		// Methode qui prend une néunion en attribut et retourne l'id correspond (Main du Exo03)
		public long ajouter(Reunion reunion) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			em.persist(reunion); // je rends persistant l'objet adresse1

			tx.commit();
			em.close(); // close l'em
			
			return reunion.getIdReunion();//id de la Réunion créée
		}
		
		
		/*Methode qui prend l'id d'une Reunion en attribut et me retournera un objet de la classe Reunion 
		 * Pour trouver cet objet, il ya une méthode find qui, va trouver l'objet "idReunion" de la classe Reunion
		* j'attribue cette recherche à une variable, que je retourne*/
		public Reunion lire(long idReunion) {
			EntityManager em = emf.createEntityManager();
			Reunion r1 = em.find(Reunion.class, idReunion);
			return r1;
		}
		
		// Methode modifierReunion
		public void modifierReunion(Reunion reunion) {
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction tx = em.getTransaction();
	        tx.begin();

	        em.merge(reunion);

	        tx.commit();        
	        em.close();

	        }
		// Methode Ajouter des personnes à différentes réunion
		// Identique à // Methode AJOUTER UNE ADRESSE A UNE PERSONNE EXISTANTE (exo05)
		public void ajouterPersonneDansReunion(Personne personne) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			em.persist(personne);

			tx.commit();
			em.close();
		}

}
