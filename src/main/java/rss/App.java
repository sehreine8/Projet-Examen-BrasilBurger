package rss;

import rss.service.IBurgerService;
import rss.service.IComplementService;
import rss.service.IMenuService;
import rss.service.impl.BurgerServiceImpl;
import rss.service.impl.ComplementServiceImpl;
import rss.service.impl.MenuServiceImpl;

import rss.entity.Burger;
import rss.entity.Complement;
import rss.entity.Menu;

import java.util.List;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    private static final IBurgerService burgerService = new BurgerServiceImpl();
    private static final IComplementService complementService = new ComplementServiceImpl();
    private static final IMenuService menuService = new MenuServiceImpl();

    public static void main(String[] args) {

        int choix;

        do {
            System.out.println("\n========== BRASIL BURGER (JAVA CONSOLE) ==========");
            System.out.println("1 - Ajouter un burger");
            System.out.println("2 - Lister les burgers");
            System.out.println("3 - Ajouter un complément");
            System.out.println("4 - Lister les compléments");
            System.out.println("5 - Créer un menu");
            System.out.println("6 - Lister les menus");
            System.out.println("0 - Quitter");
            System.out.print("Votre choix : ");

            choix = lireInt();

            switch (choix) {

                case 1 -> ajouterBurger();
                case 2 -> listerBurgers();
                case 3 -> ajouterComplement();
                case 4 -> listerComplements();
                case 5 -> creerMenu();
                case 6 -> listerMenus();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }

        } while (choix != 0);
    }

    // ================================================================
    // BURGER
    // ================================================================

    private static void ajouterBurger() {
        System.out.println("\n--- AJOUTER BURGER ---");

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Prix : ");
        double prix = lireDouble();

        System.out.print("URL de l'image : ");
        String imageUrl = scanner.nextLine();

        System.out.print("Description : ");
        String description = scanner.nextLine();

        burgerService.addBurger(nom, prix, imageUrl, description);

        System.out.println("Burger ajouté !");
    }

    private static void listerBurgers() {
        System.out.println("\n--- LISTE DES BURGERS ---");
        List<Burger> list = burgerService.getAllBurgers();

        if (list.isEmpty()) {
            System.out.println("Aucun burger enregistré.");
            return;
        }

        for (Burger b : list) {
            System.out.println("ID: " + b.getId());
            System.out.println("Nom: " + b.getNom());
            System.out.println("Prix: " + b.getPrix());
            System.out.println("Image: " + b.getImageUrl());
            System.out.println("Description: " + b.getDescription());
            System.out.println("----------------------------");
        }
    }

    // ================================================================
    // COMPLEMENT
    // ================================================================

    private static void ajouterComplement() {
        System.out.println("\n--- AJOUTER COMPLÉMENT ---");

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Prix : ");
        double prix = lireDouble();

        System.out.print("URL de l'image : ");
        String imageUrl = scanner.nextLine();

        complementService.addComplement(nom, prix, imageUrl);

        System.out.println("Complément ajouté !");
    }

    private static void listerComplements() {
        System.out.println("\n--- LISTE DES COMPLÉMENTS ---");
        List<Complement> list = complementService.getAllComplements();

        if (list.isEmpty()) {
            System.out.println("Aucun complément enregistré.");
            return;
        }

        for (Complement c : list) {
            System.out.println("ID: " + c.getId());
            System.out.println("Nom: " + c.getNom());
            System.out.println("Prix: " + c.getPrix());
            System.out.println("Image: " + c.getImageUrl());
            System.out.println("----------------------------");
        }
    }

    // ================================================================
    // MENU
    // ================================================================

    private static void creerMenu() {
        System.out.println("\n--- CRÉATION MENU ---");

        System.out.print("Nom du menu : ");
        String nom = scanner.nextLine();

        System.out.print("ID Burger : ");
        int burgerId = lireInt();

        System.out.print("ID Complément Boisson : ");
        int boissonId = lireInt();

        System.out.print("ID Complément Frites : ");
        int fritesId = lireInt();

        System.out.print("URL image du menu : ");
        String imageUrl = scanner.nextLine();

        System.out.print("Description : ");
        String description = scanner.nextLine();

        try {
            menuService.addMenu(nom, burgerId, boissonId, fritesId, imageUrl, description);
            System.out.println("Menu ajouté !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void listerMenus() {
        System.out.println("\n--- LISTE DES MENUS ---");

        List<Menu> list = menuService.getAllMenus();

        if (list.isEmpty()) {
            System.out.println("Aucun menu enregistré.");
            return;
        }

        for (Menu m : list) {
            System.out.println("Nom: " + m.getNom());
            System.out.println("Burger: " + m.getBurger().getNom());
            System.out.println("Boisson: " + m.getBoisson().getNom());
            System.out.println("Frites: " + m.getFrites().getNom());
            System.out.println("Prix total: " + m.getPrixTotal());
            System.out.println("Image: " + m.getImageUrl());
            System.out.println("Description: " + m.getDescription());
            System.out.println("----------------------------");
        }
    }

    // ================================================================
    // UTILITAIRES
    // ================================================================

    private static int lireInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.print("Veuillez entrer un entier valide : ");
            }
        }
    }

    private static double lireDouble() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (Exception e) {
                System.out.print("Veuillez entrer un nombre valide : ");
            }
        }
    }
}
