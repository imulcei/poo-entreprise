package fr.afpa.model.bo;

import java.time.LocalDate;
import java.util.List;

// TODO @Override de la méthode de calcul de prime

public class Directeur extends Employe {

    public Directeur(String nom, String prenom, int dateEmbauche, String poste, int salaire, String service,
            Agence agence, boolean chequeVacances, List<Enfant> enfants) {
        super(nom, prenom, dateEmbauche, poste, salaire, service, agence, chequeVacances, enfants);
    }

    public int calculerPrimeDirecteur() {
        int primeSalaire = getSalaire() * 7 / 100;
        int primeAnciennete = anneeDansLentreprise(getDateEmbauche()) * getSalaire() * 3 / 100;
        return primeSalaire + primeAnciennete;
    }

    public void ordreDeTransfertDirecteur() {
        int moisActuel = LocalDate.now().getMonth().getValue();
        int jourActuel = LocalDate.now().getDayOfMonth();

        if (moisActuel == 4 && jourActuel == 28) {
            int prime = calculerPrimeDirecteur();
            System.out.println(
                    "La prime du directeur de " + prime + "€ a été versée.");
        }
    }
}
