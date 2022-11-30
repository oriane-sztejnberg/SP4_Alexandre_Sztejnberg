/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_alexandre_sztejnberg;

/**
 *
 * @author jason
 */
public class Plateaudejeu {

    CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];

    public void PlateauDeJeu() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grille[i][j] = new CelluleDeGrille();
            }
        }
    }

    public int ajouterJetonDansColonne(Jeton UnJeton, int colonne) {
        for (int k = 5; k >= 0; k--) {
            if ("Rouge".equals(grille[k][colonne].lireCouleurDuJeton()) || "Jaune".equals(grille[k][colonne])) {
                grille[k + 1][colonne].affecterJeton(UnJeton);
                return k + 1;
            }
        }
        return 0;
    }

    public boolean grilleRemplie() {
        for (int k = 0; k <= 6; k++) {
            if (grille[5][k].presenceJeton() == true) {
                return true;
            }
        }
        return false;
    }

    public void afficherGrilleSurConsole() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 6) {
                    System.out.print(grille[i][j] + "/n");
                } else {
                    System.out.print(grille[i][j] + "");
                }
            }
        }
    }

    public boolean presenceJeton(int ligne, int colonne) {
        return grille[ligne][colonne].presenceJeton() == true;
    }

    public String lireCouleurDuJeton(int ligne, int colonne) {
        return grille[ligne][colonne].lireCouleurDuJeton();
    }

    public boolean LigneGagnantePourCouleur(String couleur) {
        int compteur = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7;j++){
                if (grille[i][i].lireCouleurDuJeton()==couleur){
                    compteur += 1;
                    if (compteur== 4) {
                        return true;

                    }
                }else{
                    compteur=0;
                }
                
            }
            compteur=0;
        }
        return false;
    }
    
    public boolean colonneGagnantePourCouleur(String couleur){
        int compteur=0;
        for (int j=0; j<7; j++){
            for (int i=0; i<6; i++){
                if (grille[i][j].lireCouleurDuJeton()==couleur){
                    compteur+=1;
                    if (compteur==4){
                        return true;
                    }
                }else{
                    compteur=0;
                }
            }
            compteur=0;
        }
        return false;   
    }
    
    
    
            }
