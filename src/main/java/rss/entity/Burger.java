package rss.entity;

public class Burger {
    private int id;
    private String nom;
    private double prix;
    private String imageUrl;
    private String description;

    public Burger() {}

    public Burger(int id, String nom, double prix, String imageUrl, String description) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Burger(String nom, double prix, String imageUrl, String description) {
        this.nom = nom;
        this.prix = prix;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription() { return description; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrix(double prix) { this.prix = prix; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return id + " - " + nom + " - " + prix + " CFA\n"
               + "Image: " + imageUrl + "\n"
               + "Description: " + description;
    }
}
