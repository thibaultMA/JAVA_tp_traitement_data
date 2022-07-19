package org.fr.diginamic;


import org.fr.diginamic.bll.SaveActeurBll;
import org.fr.diginamic.dal.DAO.ActeurDAO;
import org.fr.diginamic.entity.Acteur;

import java.util.Scanner;

public class app {
    private static Scanner scanner = new Scanner(System.in);
    private static SaveActeurBll d = new SaveActeurBll();

    public static void main(String[] args) {
//        d.saveBDD();
        System.out.println();
        System.out.println("veuillez faire votre choix (expmple -> tapez : 2 (pour Affichage du casting d’un film donné)");
        int choix=0;
        do {
        menu();

            choix = scanner.nextInt();
            Scanner scannerDemande = new Scanner(System.in);
            switch (choix) {
                case 1 -> {
                    System.out.println("(1) .Affichage de la filmographie d’un acteur donné");
                    System.out.println("veuillez inscrire le nom et le prenom d'un acteur");
                    String identiteChoisi = scannerDemande.next();
                    ActeurDAO acteurDAO = new ActeurDAO();
                    Acteur acteur = acteurDAO.findByName(identiteChoisi);
                    System.out.println(acteur.getRoles());
                }
                case 2 -> System.out.println("(2) .Affichage du casting d’un film donné");
                case 3 -> System.out.println("(3) .Affichage des films sortisentre 2 années données");
                case 4 -> System.out.println("(4) .Affichage des films communs à 2 acteurs/actrices donnés.");
                case 5 -> System.out.println("(5) .Affichage des acteurs communs à 2 films donnés");
                case 6 -> System.out.println("(6) .Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au casting");
                case 7 -> System.out.println("(7) .Fin de l’application");
                case 99 -> d.saveBDD();
            }
        } while (choix != 7);
    }
    private static void menu(){

        System.out.println("(1) .Affichage de la filmographie d’un acteur donné");
        System.out.println("(2) .Affichage du casting d’un film donné");
        System.out.println("(3) .Affichage des films sortisentre 2 années données");
        System.out.println("(4) .Affichage des films communs à 2 acteurs/actrices donnés.");
        System.out.println("(5) .Affichage des acteurs communs à 2 films donnés");
        System.out.println("(6) .Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au casting");
        System.out.println();
        System.out.println("(7) .Fin de l’application");

    }
}
