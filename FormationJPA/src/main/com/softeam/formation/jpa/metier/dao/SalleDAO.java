package com.softeam.formation.jpa.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.softeam.formation.hibernate.metier.modele.Project;
import com.softeam.formation.hibernate.metier.modele.Salle;

public class SalleDAO {
	// déclaration de la variable emf contenant l'EMF
			private EntityManagerFactory emf;
			
			
			//Je fais un constructeur qui me rentre cette variable en paramètre 
			// et me retourne le this.emf (Project.emf)
			public SalleDAO(EntityManagerFactory emf) {
				this.emf = emf;
				}	
			// Methode qui prend une salle en attribut et retourne l'id correspond
			public long ajouter(Salle salle) {
				
				EntityManager em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				
				em.persist(salle); // je rends persistant l'objet adresse1

				tx.commit();
				em.close(); // close l'em
				
				return salle.getIdSalle();//id de la Réunion créée
			}
			
			
			// Methode qui prend l'id d'un projet en attribut et retourne le projet correspond
			public static Project lire(long idSalle) {
				return null;
			}
}
