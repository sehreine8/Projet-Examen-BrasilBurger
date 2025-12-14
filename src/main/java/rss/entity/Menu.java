package rss.entity;

public class Menu {
    private int id;
    private String nom;
    private Burger burger;
    private Complement boisson;
    private Complement frites;
    private double prixTotal;
    private String imageUrl;
    private String description;

    public Menu() {}

    public Menu(String nom, Burger burger, Complement boisson, Complement frites,
                String imageUrl, String description) {

        this.nom = nom;
        this.burger = burger;
        this.boisson = boisson;
        this.frites = frites;
        this.imageUrl = imageUrl;
        this.description = description;

        this.prixTotal = burger.getPrix() + boisson.getPrix() + frites.getPrix();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public void setPrixTotal(double prixTotal) { this.prixTotal = prixTotal; }

    public String getNom() { return nom; }
    public Burger getBurger() { return burger; }
    public Complement getBoisson() { return boisson; }
    public Complement getFrites() { return frites; }
    public double getPrixTotal() { return prixTotal; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription() { return description; }
}
