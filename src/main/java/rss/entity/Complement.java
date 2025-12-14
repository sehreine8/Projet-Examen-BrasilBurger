package rss.entity;

public class Complement {
    private int id;
    private String nom;
    private double prix;
    private String imageUrl;

    public Complement() {}

    public Complement(int id, String nom, double prix, String imageUrl) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.imageUrl = imageUrl;
    }

    public Complement(String nom, double prix, String imageUrl) {
        this.nom = nom;
        this.prix = prix;
        this.imageUrl = imageUrl;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public String getImageUrl() { return imageUrl; }
}
