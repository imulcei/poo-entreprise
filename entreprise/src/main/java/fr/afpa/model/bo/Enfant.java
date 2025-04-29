package fr.afpa.model.bo;

public class Enfant {
    private String nom;
    private int age;

    public Enfant(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }
}
