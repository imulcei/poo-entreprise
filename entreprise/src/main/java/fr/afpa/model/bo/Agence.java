package fr.afpa.model.bo;

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

}
