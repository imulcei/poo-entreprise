package fr.afpa.model.bo;

import java.time.LocalDate;
import java.util.List;

public class Directeur extends Employe {

    public Directeur(String nom, String prenom, int dateEmbauche, String poste, int salaire, String service,
            Agence agence, List<Enfant> enfants) {
        super(nom, prenom, dateEmbauche, poste, salaire, service, agence, enfants);
    }

    @Override
    public int primes() {
        int prime = getSalaire() * 7 / 100;
        prime += anneeDansLentreprise(getDateEmbauche()) * (getSalaire() * 3 / 100);
        return prime;
    }

    public void ordreDeTransfertDirecteur(int salaire, int dateEmbauche) {
        int moisActuel = LocalDate.now().getMonth().getValue();
        int jourActuel = LocalDate.now().getDayOfMonth();

        if (moisActuel == 4 && jourActuel == 28) {
            int prime = primes();
            System.out.println(
                    "La prime du directeur de " + prime + "€ a été versée.");
        }
    }
}
