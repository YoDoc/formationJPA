package com.softeam.formation.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.softeam.formation.hibernate.metier.modele.Adresse;

public class Exercice02 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Je rentre les données suivantes dans la table
		// donc je crée un objet appelé adresse1 de la classe Adresse et comprenant: les
		// attributs suivants
		Adresse adresse1 = new Adresse();
		adresse1.setLigne1("11");
		adresse1.setLigne2("Bd");
		adresse1.setLigne3("Paris");
		adresse1.setCodePostal("49000");
		adresse1.setVille("Sète");
		em.persist(adresse1); // je rends persistant l'objet adresse1

		tx.commit();
		em.close(); // close l'em
		emf.close(); // l'emf sinon ca tourne
	}

}
