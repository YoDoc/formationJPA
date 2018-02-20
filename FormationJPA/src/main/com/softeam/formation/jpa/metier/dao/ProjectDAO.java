package com.softeam.formation.jpa.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.softeam.formation.hibernate.metier.modele.Project;



public class ProjectDAO {

	// déclaration de la variable emf contenant l'EMF
	private EntityManagerFactory emf;
	
	//Je fais un constructeur qui me rentre cette variable en paramètre 
	// et me retourne le this.emf (Project.emf)
	public ProjectDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	// Methode qui prend un project en attribut et retourne l'id correspond
	public long ajouter(Project project) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(project); // je rends persistant l'objet adresse1

		tx.commit();
		em.close(); // close l'em
		
		return project.getIdProject();//id du project créé
	}
	
	
	/*Methode qui prend l'id d'une Project en attribut et me retournera un objet de la classe Project 
	 * Pour trouver cet objet, il ya une méthode find qui, va trouver l'objet "idProject" de la classe Project
	* j'attribue cette recherche à une variable, que je retourne*/
	public Project lire(long idProject) {
		EntityManager em = emf.createEntityManager();
		Project p1 = em.find(Project.class, idProject);
		return p1;
	}
}
