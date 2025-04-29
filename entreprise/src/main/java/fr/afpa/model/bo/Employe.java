package fr.afpa.model.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

// TODO Ca aurait pu être une bonne idée de gérer chequeVacances dans le constructeur mais ici, le temps passant, chequeVacances ne sera plus à jour
// Il vaut mieux faire ce que tu as fait dans un getter et supprimer le setter
// La boucle WHILE n'est pas utile dans primeAnciennete
// Ce n'est pas à la classe Employe de faire le tri par ordre alphabétique (employesTriesParNomPrenom / emmployesTriesNomPrenomService)
// Ce n'est pas à la classe Employe de faire masseSalariale pour tous les employés
// Ce n'est pas à la classe Employe de faire afficherModeDeRestauration
// L'affichage ne doit pas se faire dans la classe Employe mais plutôt dans le main

public class Employe {
    private Agence agence;
    private String nom;
    private String prenom;
    private int dateEmbauche;
    private String poste;
    private int salaire;
    private String service;
    private boolean chequeVacances;
    private List<Enfant> enfants;

    public Employe(String nom, String prenom, int dateEmbauche, String poste, int salaire, String service,
            Agence agence, boolean chequeVacances, List<Enfant> enfants) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        this.poste = poste;
        this.salaire = salaire;
        this.service = service;
        this.agence = agence;

        if (LocalDate.now().getYear() - dateEmbauche >= 1) {
            this.chequeVacances = true;
        } else {
            this.chequeVacances = false;
        }

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
        return chequeVacances;
    }

    public void setChequeVacances(boolean chequeVacances) {
        this.chequeVacances = chequeVacances;
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
     * Calcule la prime annuelle de 5% sur le salaire brut.
     * 
     * @param salaire
     * @return Renvoie le montant de la prime
     */
    public static int primeBrut(int salaire) {
        int prime = salaire * 5 / 100;
        return prime;
    }

    /**
     * Calcule la prime de 2% par année d'ancienneté
     * 
     * @param dateEmbauche
     * @param salaire
     * @return Renvoie le montant de la prime
     */
    public static int primeAnciennete(int dateEmbauche, int salaire) {
        int anciennete = anneeDansLentreprise(dateEmbauche);
        int i = 0;
        int prime = 0;
        while (i < anciennete) {
            prime += salaire * 2 / 100;
            i++;
        }
        System.out.println(anciennete);
        return prime;
    }

    /**
     * Ordonne à la banque de virer la prime à l'employé le 30/11 de chaque année
     * 
     * @param dateEmbauche
     * @param salaire
     */
    public static void ordreDeTransfert(int dateEmbauche, int salaire) {
        int moisActuel = LocalDate.now().getMonth().getValue();
        int jourActuel = LocalDate.now().getDayOfMonth();
        System.out.println(moisActuel);
        if (moisActuel == 4 && jourActuel == 28) {
            int primes = primeBrut(salaire) + primeAnciennete(dateEmbauche, salaire);
            System.out.println(primes + "€ a été versé à l'employé.");
        }
    }

    /**
     * Trie par ordre alphabétique la liste des employés via le nom et prénom
     * 
     * @param employes
     */
    public static void employesTriesParNomPrenom(List<Employe> employes) {
        employes.sort(Comparator.comparing(Employe::getNom).thenComparing(Employe::getPrenom));

        for (Employe e : employes) {
            System.out.println(e.getNom() + " " + e.getPrenom());
        }
    }

    /**
     * Trie par ordre alphabétique la liste des employés via le nom, prénom, service
     * 
     * @param employes
     */
    public static void emmployesTriesNomPrenomService(List<Employe> employes) {
        employes.sort(Comparator.comparing(Employe::getService).thenComparing(Employe::getNom)
                .thenComparing(Employe::getPrenom));

        for (Employe e : employes) {
            System.out.println(e.getService() + " " + e.getNom() + " " + e.getPrenom());
        }
    }

    /**
     * Renvoie le montant de la masse salariale
     * 
     * @param employes
     * @return
     */
    public static int masseSalariale(List<Employe> employes) {
        int masseSalariale = 0;
        for (Employe e : employes) {
            int primes = primeBrut(e.getSalaire()) + primeAnciennete(e.getDateEmbauche(), e.getSalaire());
            masseSalariale += e.getSalaire() + primes;
        }
        return masseSalariale;
    }

    /**
     * Renvoie le type de restauration pour chqque employé
     * 
     * @param employes
     */
    public static void afficherModeDeRestauration(List<Employe> employes) {
        for (Employe e : employes) {
            Agence agence = e.getAgence();
            String restauration = "";
            if (agence.getRestauration() == true) {
                restauration = "Self";
            } else {
                restauration = "Ticket Restaurant";
            }
            System.out.println(e.getNom() + " " + e.getPrenom() + " " + restauration);
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
