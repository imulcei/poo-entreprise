package fr.afpa.model.bo;

import java.util.Comparator;
import java.util.List;

public class Agence {
    private String nom;
    private String adresse;
    private int codePostal;
    private String ville;
    private boolean restauration;

    public Agence(String nom, String adresse, int codePostal, String ville, boolean restauration) {
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.restauration = restauration;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public boolean getRestauration() {
        return restauration;
    }

    public void setRestauration(boolean restauration) {
        this.restauration = restauration;
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
    public int masseSalariale(List<Employe> employes) {
        int masseSalariale = 0;
        for (Employe e : employes) {
            int primes = e.primes();
            masseSalariale += e.getSalaire() + primes;
        }
        return masseSalariale;
    }

    /**
     * Renvoie le type de restauration pour chqque employé
     * 
     * @param employes
     */
    public void afficherModeDeRestauration(List<Employe> employes) {
        for (Employe e : employes) {
            Agence agence = e.getAgence();
            String restauration;
            if (agence.getRestauration() == true) {
                restauration = "Self";
            } else {
                restauration = "Ticket Restaurant";
            }
            System.out.println(e.getNom() + " " + e.getPrenom() + " : " + restauration);
        }
    }
}
