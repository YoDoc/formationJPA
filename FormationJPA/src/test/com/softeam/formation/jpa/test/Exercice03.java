package com.softeam.formation.jpa.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.softeam.formation.hibernate.metier.modele.Project;
import com.softeam.formation.hibernate.metier.modele.Reunion;
import com.softeam.formation.hibernate.metier.modele.Salle;
import com.softeam.formation.jpa.metier.dao.ProjectDAO;
import com.softeam.formation.jpa.metier.dao.ReunionDAO;
import com.softeam.formation.jpa.metier.dao.SalleDAO;

public class Exercice03 {

	public static void main(String[] args) {
		/* j'ouvre une seule fois mon emf car couteux. En revanche ca lève un pb car sur les DAO il en aura besoin
		*donc dans mon DAO, je déclare une variable contenant l'emf et Je fais un constructeur qui me rentre cette variable en paramètre 
		*et me retourne le this.emf (Project.emf) */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		
		// Je crée mes objets reunion, projet, salle;
		Reunion reunion1 = new Reunion();
		reunion1.setTitre("Reunion 1");
		
		Project project1 = new Project();
		project1.setNom("Projet d'Avenir");
		
		Salle salle1 = new Salle();
		salle1.setNom("Salle S.CONNERY");
		
						// Lier une réunion a une salle et un projet; Et déclarer la réunion et la salle 
		reunion1.setSalle(salle1);
		reunion1.setProject(project1);
		
		// Je crée Une nouvelle Reunion2 que j'associe à une salle 2 et un projet2:
				Reunion reunion2 = new Reunion();
				reunion2.setTitre("Reunion 2");
				
				Project project2 = new Project();
				project2.setNom("Project Alpha");
				
				Salle salle2 = new Salle();
				salle2.setNom("Salle Angus Young");
				
				reunion2.setSalle(salle2);
				reunion2.setProject(project2);
		
		/* Je crée un nouvel objet de ProjectDAO et je rentre l'emf en paramètre de la méthode. 
		 * c'est mon lien entre l'emf de ce main et la variable déclarée dans le Project
		 * Je fais de manière identique pour Salle et projet.
		 * Particularité, je crée ma salle et mon projet avant de déclarer ma réunion sinon ca casse*/
		 
		ProjectDAO projectDAO = new ProjectDAO(emf); 
		SalleDAO salleDAO = new SalleDAO(emf); 
		ReunionDAO reunionDAO = new ReunionDAO(emf); 

		// Ensuite j'appelle mes méthodes pour chaque objet.
		projectDAO.ajouter(project1);
		salleDAO.ajouter(salle1);
		reunionDAO.ajouter(reunion1);
				
		projectDAO.ajouter(project2);
		salleDAO.ajouter(salle2);
		reunionDAO.ajouter(reunion2);
		
		// Appel de ma méthode lire de ReunionDAO;
		long idReunion1 = reunion1.getIdReunion();
		Reunion reunionFound = reunionDAO.lire(idReunion1);
		System.out.println(" reunion found <id>: " + reunionFound.getIdReunion() + ", reunion1 <id>: " + reunion1.getIdReunion());
		
		// Appeler la méthode lire de ProjectDAO;
		/*long idProject1*/
		emf.close(); // l'emf sinon ca tourne
	}

}
