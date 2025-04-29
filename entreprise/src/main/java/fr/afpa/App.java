package fr.afpa;

import java.util.ArrayList;
import java.util.List;

import fr.afpa.model.bo.Agence;
import fr.afpa.model.bo.Employe;
import fr.afpa.model.bo.Enfant;
import fr.afpa.model.bo.Directeur;

public class App {
        public static void main(String[] args) {

                Agence agenceBrest = new Agence("Agence Brest", "123 Rue de Paris", 29200, "Brest", true);
                Agence agencePerpignan = new Agence("Agence Perpignan", "123 Rue de Perpignan", 66000, "Perpignan",
                                false);

                Enfant enfant1 = new Enfant("Alice", 9);
                Enfant enfant2 = new Enfant("James", 2);
                Enfant enfant3 = new Enfant("Milla", 18);
                Enfant enfant4 = new Enfant("Bob", 13);
                Enfant enfant5 = new Enfant("Charlie", 17);

                List<Enfant> enfants1 = List.of(enfant1, enfant4);
                List<Enfant> enfants2 = List.of(enfant2);
                List<Enfant> enfants3 = List.of(enfant3, enfant5);

                Employe employe1 = new Employe("Dupont", "Michel", 2005, "Comptable", 35000, "Administration",
                                agencePerpignan, null);
                Employe employe2 = new Employe("Smith", "John", 2010, "Manager", 31000, "Administration",
                                agencePerpignan, enfants2);
                Employe employe3 = new Employe("Bonnet", "Marcel", 1997, "Assistant de direction", 40000,
                                "Administration",
                                agenceBrest, enfants1);
                Employe employe4 = new Employe("Pochard", "Sandrine", 1999, "RH", 33000, "Administration", agenceBrest,
                                enfants3);
                Employe employe5 = new Employe("Chese", "Théo", 2022, "Concierge", 24000, "Services", agencePerpignan,
                                null);
                Directeur employe6 = new Directeur("Dupont", "Jean", 2015, "Directeur", 50000, "Direction", agenceBrest,
                                null);

                List<Employe> listeEmployes = new ArrayList<>();
                listeEmployes.add(employe1);
                listeEmployes.add(employe2);
                listeEmployes.add(employe3);
                listeEmployes.add(employe4);
                listeEmployes.add(employe5);
                listeEmployes.add(employe6);

                // Employe.employesTriesParNomPrenom(listeEmployes);
                // Employe.emmployesTriesNomPrenomService(listeEmployes);
                System.out.println(agenceBrest.masseSalariale(listeEmployes));
                agenceBrest.afficherModeDeRestauration(listeEmployes);
                // Employe.gestionChequeDeNoel(listeEmployes);
                // System.out.println(Employe.masseSalariale(listeEmployes));
                // employe6.ordreDeTransfertDirecteur();
                System.out.println(employe6.primes());
                Employe.gestionChequeDeNoel(listeEmployes);
        }
}
