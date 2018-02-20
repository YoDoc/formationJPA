package com.softeam.formation.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercice01 {
	//Avec ajouter un loggeur de slrf4 (qu'on utilise)
	// Definie le logger qui s'appelle logger, à définir une seule fois
	private static Logger logger = LoggerFactory.getLogger(Exercice01.class);
	
	public static void main(String[] args) {
		logger.info("Départ de l'exercice 01");
		// récupérer l'Entity Manager Factory (importer ce qu'il faut)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		// récupérer l'Entity Manager (importer ce qu'il faut)
		EntityManager em = emf.createEntityManager();
		// Recuperer une transaction à partir du manager
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// code a exécuter dans la transaction, comme createNativeQuery
		// Je crée un objet q de type Query  avec comme attribut la requete em.blabla; ne pas oublier le "em." sinon pas de ref à l'EntityManager
		// methode création de requète qui prend en paramètre une chaine de carac
		Query q= em.createNativeQuery("INSERT INTO TEST VALUES('Exercice 01')");
		Query e= em.createNativeQuery("INSERT INTO TEST VALUES('Exercice 001bis')");
		
				/* ESSAI
				Query f= em.createNativeQuery("INSERT INTO TEST2 VALUES('gg', 'uh''ouh')");*/
		
		// Puis pour exécuter:
		q.executeUpdate();
		e.executeUpdate();
				/* ESSAI SUITE:
				f.executeUpdate();*/
		logger.info("Exécution / Update");
		
		tx.commit();// Valider la transaction
		em.close();// Ferme l'EM
		
	}

}
