package fr.afpa.model.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Employe {
    private Agence agence;
    private String nom;
    private String prenom;
    private int dateEmbauche;
    private String poste;
    private int salaire;
    private String service;
    private List<Enfant> enfants;

    public Employe(String nom, String prenom, int dateEmbauche, String poste, int salaire, String service,
            Agence agence, List<Enfant> enfants) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        this.poste = poste;
        this.salaire = salaire;
        this.service = service;
        this.agence = agence;
        this.enfants = enfants;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(int dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public boolean isChequeVacances() {
        return LocalDate.now().getYear() - dateEmbauche >= 1;
    }

    public List<Enfant> getEnfants() {
        return enfants;
    }

    public void setEnfants(List<Enfant> enfants) {
        this.enfants = enfants;
    }

    public static int anneeDansLentreprise(int dateEmbauche) {
        int result = LocalDateTime.now().getYear() - dateEmbauche;
        return result;
    }

    /**
     * Calcule la prime annuelle de 5% et la prime d'ancienneté sur le salaire brut.
     * 
     * @param salaire
     * @return Renvoie le montant de la prime
     */
    public int primes() {
        int prime = this.getSalaire() * 5 / 100;
        prime += anneeDansLentreprise(this.getDateEmbauche()) * (this.getSalaire() * 2 / 100);
        return prime;
    }

    /**
     * Ordonne à la banque de virer la prime à l'employé le 30/11 de chaque année
     * 
     * @param dateEmbauche
     * @param salaire
     */
    public void ordreDeTransfert() {
        int moisActuel = LocalDate.now().getMonth().getValue();
        int jourActuel = LocalDate.now().getDayOfMonth();
        System.out.println(moisActuel);
        if (moisActuel == 4 && jourActuel == 28) {
            int primes = primes();
            System.out.println(primes + "€ a été versé à l'employé.");
        }
    }

    // Gestion des chèques de Noël en fonction des enfants et de leurs âges
    public void chequesDeNoel() {
        int cheque20 = 0;
        int cheque30 = 0;
        int cheque50 = 0;

        if (enfants != null && !enfants.isEmpty()) {
            for (Enfant e : enfants) {
                int age = e.getAge();
                if (age >= 0 && age <= 10) {
                    cheque20++;
                } else if (age >= 11 && age <= 15) {
                    cheque30++;
                } else if (age >= 16 && age <= 18) {
                    cheque50++;
                }
            }

            if (cheque20 > 0 || cheque30 > 0 || cheque50 > 0) {
                if (cheque20 > 0) {
                    System.out.println("Chèques de Noël de 20€ : " + cheque20);
                }
                if (cheque30 > 0) {
                    System.out.println("Chèques de Noël de 30€ : " + cheque30);
                }
                if (cheque50 > 0) {
                    System.out.println("Chèques de Noël de 50€ : " + cheque50);
                }
            } else {
                System.out
                        .println("L'employé " + this.nom + " " + this.prenom + " n'a pas droit à de chèques de Noël.");
            }
        }
    }

    /**
     * Affiche le nombre de chèques de Noël en fonction des tranches d'âge des
     * enfants
     * 
     * @param employes
     */
    public static void gestionChequeDeNoel(List<Employe> employes) {
        for (Employe e : employes) {
            System.out.println(e.getNom() + " " + e.getPrenom());
            e.chequesDeNoel();
        }
    }
}
