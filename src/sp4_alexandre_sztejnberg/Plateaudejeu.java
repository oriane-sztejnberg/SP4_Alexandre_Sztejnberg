/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_alexandre_sztejnberg;

/**
 *
 * @author jason
 */
// Realisation de la classe plateaud de jeu:

public class Plateaudejeu {

    int Ligne = 6;
    int Colonne = 7;
    CelluleDeGrille[][] grille = new CelluleDeGrille[Ligne][Colonne];

    /**
     * création des 42 cellules vides de type CelluleDeGrille
     */
    //Constructeur d'objet du type plateau de jeu:
    public Plateaudejeu() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grille[i][j] = new CelluleDeGrille();
            }
        }
    }

    /**
     * méthode qui ajoute un jeton passé en paramètre dans la colonne dont l’indice est aussi
     * passé en paramètre, sur la cellule vide la plus basse.
     *
     * @param UnJeton
     * @param colonne
     * @return
     */
    /*public int ajouterJetonDansColonne(Jeton UnJeton, int colonne) {
        for (int k = 5; k >= 0; k--) {
            if (grille[k][colonne].equals("Jaune") || "Rouge".equals(grille[k][colonne].lireCouleurDuJeton())) {
                grille[k + 1][colonne].affecterJeton(UnJeton);
                return k + 1;
            }
        }
        return 0;
    }*/
    public int ajouterJetonDansColonne(Jeton Unjeton, int colonne) {
        int ligne = -1;
        if (!colonneRemplie(colonne)) {
            if (grille[Ligne - 1][colonne].jetonCourant == null) {
                grille[Ligne - 1][colonne].affecterJeton(Unjeton);
                return Ligne - 1;
            }

            for (int k = 0; k < Ligne; k++) {
                if (grille[k][colonne].jetonCourant != null) {
                    grille[k - 1][colonne].affecterJeton(Unjeton);
                    ligne = k - 1;
                    break;
                }
            }
        }
        return ligne;
    }

    /**
     * renvoie true si la grille est pleine, c’est-à-dire qu’on ne peut plus
     * jouer, et false sinon
     *
     * @return
     */
    public boolean grilleRemplie() {
        for (int k = 0; k <= 6; k++) {
            if (grille[5][k].presenceJeton() == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * methode qui a pour but d'afficher la grille sur la console;
     */
    public void afficherGrilleSurConsole() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 6) {
                    System.out.print(grille[i][j].lireCouleurDuJeton() + "\n");
                } else {
                    System.out.print(grille[i][j].lireCouleurDuJeton() + "");
                }
            }
        }
    }

    /**
     * methode qui renvoie true si la cellule de coordonnées [x][y] est occupée par un
     * jeton, et false si elle est libre
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean presenceJeton(int ligne, int colonne) {
        return grille[ligne][colonne].presenceJeton() == true;
    }

    /**
     * renvoie la couleur du jeton de la cellule ciblée par les coodonnées
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public String lireCouleurDuJeton(int ligne, int colonne) {
        return grille[ligne][colonne].lireCouleurDuJeton();
    }

    /**
     * envoie true si la grille est gagnante pour la couleur passée en paramètre
     * sur une ligne
     *
     * @param couleur
     * @return
     */
    public boolean LigneGagnantePourCouleur(String couleur) {
        int compteur = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (grille[i][i].lireCouleurDuJeton().equals(couleur)) {
                    compteur += 1;
                    if (compteur == 4) {
                        return true;

                    }
                } else {
                    compteur = 0;
                }

            }
            compteur = 0;
        }
        return false;
    }

    /**
     * envoie true si la grille est gagnante pour la couleur passée en paramètre
     * sur une colonne
     *
     * @param couleur
     * @return
     */
    public boolean colonneGagnantePourCouleur(String couleur) {
        int compteur;
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 5; i++) {
                compteur = 0;
                if (grille[i][j].lireCouleurDuJeton().equals(couleur)) {
                    compteur += 1;
                    if (compteur == 4) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    /**
     * envoie true si la grille est gagnante pour la couleur passée en paramètre
     * sur les dégonales montantes
     *
     * @param couleur
     * @return
     */
    public boolean diagonaleMontanteGagnantePourCouleur(String couleur) {
        int compteur;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                compteur = 0;
                for (int k = 0; k < 3; k++) {
                    if (grille[i + k][j + k].lireCouleurDuJeton().equals(couleur)) {
                        compteur += 1;
                    }
                    if (compteur == 4) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    /**
     * envoie true si la grille est gagnante pour la couleur passée en paramètre
     * sur les diagonales descendantes
     *
     * @param couleur
     * @return
     */
    public boolean diagonaleDescendanteGagnantePourCouleur(String couleur) {
        int compteur;
        for (int i = 5; i > 3; i--) {
            for (int j = 0; j < 4; j++) {
                compteur = 0;
                for (int k = 0; k < 3; k++) {
                    if (grille[i - k][j + k].lireCouleurDuJeton().equals(couleur)) {
                        compteur += 1;
                    }
                }
                if (compteur == 4) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean etregagnantpourCouleur(String couleur) {
        if (diagonaleDescendanteGagnantePourCouleur(couleur) == true || diagonaleMontanteGagnantePourCouleur(couleur) == true || colonneGagnantePourCouleur(couleur) == true || LigneGagnantePourCouleur(couleur) == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * lorsqu’un jeton est capturé ou détruit, tasse la colonne indiquée en
     * paramètre en décalant d’une ligne vers le bas les jetons situés au dessus
     * de la cellule libérée.
     *
     * @param colonne
     */
    public void tasserLigne(int colonne) {
        for (int i = 0; i < 6; i++) {
            if (grille[i][colonne] == null) {
                for (int j = i; j < 5; j++) {
                    grille[j][colonne] = grille[j + 1][colonne];
                }
                grille[5][colonne] = null;
            }
        }
    }

    /**
     * renvoie true si la colonne dont l’indice est passé en paramètre est
     * remplie (on ne peut y jouer de jeton), et false sinon
     *
     * @param colonne
     * @return
     */
    public boolean colonneRemplie(int colonne) {
        return grille[5][colonne] != null;

    }

    /**
     * ajoute un trou noir à l’endroit indiqué
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean placerTrouNoir(int ligne, int colonne) {
        if (grille[ligne][colonne].presenceTrouNoir() == true) {
            grille[ligne][colonne].placerTrouNoir();
            return true;
        } else {
            return false;
        }

    }

    /**
     * supprime un trou noir à l’endroit indiqué
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean supprimerTrouNoir(int ligne, int colonne) {
        if (grille[ligne][colonne].presenceTrouNoir() == true) {
            grille[ligne][colonne].supprimerTrouNoir();
            return true;
        } else {
            return false;
        }
    }

    /**
     * ajoute un désintégrateur à l’endroit indiqué
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean placerDesintegrateur(int ligne, int colonne) {
        if (grille[ligne][colonne].presenceDesintegrateur() == true) {
            grille[ligne][colonne].placerDesintegrateur();
            return true;
        } else {
            return false;
        }
    }

    /**
     * supprime un désintégrateur à l’endroit indiqué
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean supprimerDesintegrateur(int ligne, int colonne) {
        if (grille[ligne][colonne].presenceDesintegrateur() == true) {
            grille[ligne][colonne].supprimerDesintegrateur();
            return true;
        } else {
            return false;
        }
    }

    /**
     * supprime le jeton de la cellule visée.
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean supprimerJeton(int ligne, int colonne) {
        if (grille[ligne][colonne].presenceJeton() == true) {
            grille[ligne][colonne].supprimerJeton();
            return true;
        } else {
            return false;
        }
    }

    /**
     * methode qui nenlève le jeton de la cellule visée et renvoie une référence vers ce
     * jeton
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public Jeton recupererJeton(int ligne, int colonne) {
        return grille[ligne][colonne].recupererJeton();
    }

    public boolean contain(Joueur joueur) {
        for (int k = 0; k < Ligne; k++) {
            for (int i = 0; i < Colonne; i++) {
                if (grille[k][i].lireCouleurDuJeton().equals(joueur.couleur)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * methode qui retourne un booleen pour savoir si la cellule est occupée
     *
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean celluleoccupee(int ligne, int colonne) {
        return (grille[ligne][colonne].recupererJeton() != null);
    }

}
