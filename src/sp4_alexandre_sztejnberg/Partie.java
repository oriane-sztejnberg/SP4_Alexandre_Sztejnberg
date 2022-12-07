/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_alexandre_sztejnberg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jason
 */
public class Partie {

    Joueur[] ListeJoueur = new Joueur[2];
    Joueur JoueurCourant;
    Plateaudejeu Grille;
    ArrayList<String> colorlist = new ArrayList<String>() {
        {
            add("Rouge");
            add("Jaune");
        }
    };

    public Partie(Joueur j1, Joueur j2) {

        ListeJoueur[0] = j1;
        ListeJoueur[1] = j2;

    }

    public void initialiserpartie(int nombrejetons) {

        int Ligne = 6;
        int Colonne = 7;
        int TrousNoir = 5;
        int Desintegrateurs = 3;
        int DesintegrateursTrouNoir = 2;
        ArrayList<CelluleDeGrille> ListeTrousNoir = new ArrayList<>();

        if (nombrejetons % 2 != 0) {
            nombrejetons++;
        }

        Grille = new Plateaudejeu();
        JoueurCourant = ListeJoueur[0];
        Jeton jeton;
        String[] couleur = attribuercouleursauxjoueurs();

        for (int k = 0; k < nombrejetons; k++) {
            if (k % 2 == 0) {
                jeton = new Jeton(couleur[0]);
                ListeJoueur[0].ajouterJeton(jeton);
            } else {
                jeton = new Jeton(couleur[1]);
                ListeJoueur[1].ajouterJeton(jeton);
            }
        }

        //placer les trous noir et les téléporteurs
        Random generateurAleat = new Random();
        int x, y;
        while (TrousNoir > 0) {
            x = generateurAleat.nextInt(Ligne);
            y = generateurAleat.nextInt(Colonne);
            if (Grille.grille[x][y].placerTrouNoir()) {
                ListeTrousNoir.add(Grille.grille[x][y]);
                TrousNoir--;
            }
        }

        while (DesintegrateursTrouNoir > 0) {
            ListeTrousNoir.get(generateurAleat.nextInt(ListeTrousNoir.size())).placerDesintegrateur();
            DesintegrateursTrouNoir--;
        }

        while (Desintegrateurs > 0) {
            x = generateurAleat.nextInt(Ligne);
            y = generateurAleat.nextInt(Colonne);
            if (!Grille.grille[x][y].presenceTrouNoir()) {
                if (Grille.grille[x][y].placerDesintegrateur()) {
                    Desintegrateurs--;
                }
            }
        }

    }

    public String[] attribuercouleursauxjoueurs() {

        int couleur;
        String[] couleurs = new String[2];
        Random generateurAleat = new Random();

        for (int k = 0; k < 2; k++) {

            couleur = generateurAleat.nextInt(colorlist.size());
            couleurs[k] = colorlist.get(couleur);
            ListeJoueur[k].affecterCouleur(colorlist.get(couleur));
            System.out.println("Le joueur : " + ListeJoueur[k].Nom + " a la couleur " + colorlist.get(couleur));
            colorlist.remove(couleur);
        }
        return couleurs;
    }

    public void debuterpartie() {
        initialiserpartie(42);
        int nbrcoup = 0;
        int choice;
        Joueur winner;
        ArrayList<Joueur> winners = new ArrayList<Joueur>();

        while (true) {
            //détermine quel joueur jour selon si le nombre de coup total est pair ou non (ils jouent donc chacun leur tour)
            if (nbrcoup % 2 == 0) {
                JoueurCourant = ListeJoueur[0];
            } else {
                JoueurCourant = ListeJoueur[1];
            }

            System.out.println("C'est à " + JoueurCourant.Nom + " de jouer");

            choice = choice();
            switch (choice) { //Le joueur courant joue
                case 0:
                    jouerjeton();
                    break;
                case 1:
                    recupererjeton();
                    break;
                case 2:
                    jouerdesintegrateur();
                    break;
            }
        
    

        Grille.afficherGrilleSurConsole();
        nbrcoup++;

        winners = whoswin();
        int size = winners.size();
        if (size > 0) {
            if (size == 2 | (size == 1 & winners.get(0) != JoueurCourant)) {
                if (ListeJoueur[0] == JoueurCourant) {
                    winner = ListeJoueur[1];
                } else {
                    winner = ListeJoueur[0];
                }
            }
            if (size == 1 & winners.get(0) == JoueurCourant) {
                winner = JoueurCourant;
            }
            break;

        } else {
            winner = null;
        }

        if (Grille.grilleRemplie()) {
            System.out.println("La grille est remplie...");
            break;
        }

    }

    System.out.println (

"--Partie terminée--");

    }

    public int asknbr(String qst) {
        Scanner sc = new Scanner(System.in);
        System.out.println(qst);
        int rep = sc.nextInt();
        return rep;
    }

    public int choice() {
        Scanner sc = new Scanner(System.in);
        int rep = -1;
        while ((rep < 0 | rep > 2) | (rep == 2 & JoueurCourant.nombreDesintegrateurs < 1) | (rep == 1 & !Grille.contain(JoueurCourant))) {
            System.out.println("0 -> Poser jeton\n1 -> Récupérer Jeton\n2 -> Jouer Désintégrateur");
            rep = sc.nextInt();

            if (rep == 2 & JoueurCourant.nombreDesintegrateurs < 1) {
                System.out.println("Vous ne possédez pas de désintégrateurs");
            }

            if (rep == 1 & !Grille.contain(JoueurCourant)) {
                System.out.println("Vous n'avez pas de jeton à récupérer");
            }

        }
        return rep;
    }

    /**
     *return qui gagne en regardant si les conditions pour gagner sont réspecté et associe la couleur du jeton au joueur
     * @return
     */
    public ArrayList<Joueur> whoswin() {
        ArrayList<Joueur> winners = new ArrayList<Joueur>();
        for (int k = 0; k < 2; k++) {
            if((Grille.etregagnantpourCouleur(ListeJoueur[k].couleur)==true)){
                winners.add(ListeJoueur[k]);
                System.out.println("Le joueur : " + ListeJoueur[k].Nom + " a gagné !");
            }
        }
        return winners;
    }

    public void jouerjeton() {
        int colonne = -1;
        int lignejeton;

        if (JoueurCourant.nombrejetonsrestants > 0) { //dans le cas ou l'on veut et peut placer un jeton on place le jeton

            while (colonne < 0 | colonne > 6) {
                colonne = asknbr("Colonne du jeton : ");
            }

            if (!Grille.colonneRemplie(colonne)) {

                lignejeton = Grille.ajouterJetonDansColonne(JoueurCourant.poserjeton(), colonne);
                if (lignejeton != -1) {
                    if (Grille.grille[lignejeton][colonne].presenceTrouNoir()) {
                        Grille.grille[lignejeton][colonne].activerTrouNoir();
                    }

                    if (Grille.grille[lignejeton][colonne].presenceDesintegrateur()) {
                        Grille.grille[lignejeton][colonne].recupererDesintegrateur();
                    }
                
                   
                }
            }
        }
    }

    public void recupererjeton() {
        int x = -1;
        int y = -1;

        do {
            x = asknbr("Ligne : ");
            y = asknbr("Colonne : ");
        } while (Grille.recupererJeton(x, y) == null);

        Jeton jeton = Grille.recupererJeton(x, y);
        JoueurCourant.ajouterJeton(jeton);
    }

    public void jouerdesintegrateur() {
        int x = -1;
        int y = -1;
        if (JoueurCourant.nombreDesintegrateurs > 0) {
            do {
                System.out.println("Les coordonnées du point que vous voulez désintégerer : ");
                x = asknbr("Ligne : ");
                y = asknbr("Colonne : ");
            } while (Grille.recupererJeton(x, y) == null);
            if (!Grille.grille[x][y].lireCouleurDuJeton().equals(JoueurCourant.couleur) & Grille.celluleoccupee(x, y)) {
                Grille.supprimerJeton(x, y);
            }
        }
    }

}
