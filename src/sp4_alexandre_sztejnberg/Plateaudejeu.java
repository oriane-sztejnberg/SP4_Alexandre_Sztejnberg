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
    public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
        int compteur=0;
        for (int i=0; i<3;i++){
            for(int j=0; j<4;j++){
                for (int k=0;k<7;k++){
                    if (grille[i+k][j+k].lireCouleurDuJeton()==couleur){
                        compteur+=1;
                    }else{
                        compteur=0;
                }
                    if(compteur==4){
                        return true;
                    }
                    if (i==5 && j==6){
                        break;
                    }
                }
            compteur=0;
            }
        }
        return false;
    }
    public boolean diagonaleDescendanteGagnantePourCouleur(String couleur){
        int compteur=0;
        for(int i=3; i<6; i++){
            for (int j=0;j<4;j++){
                for(int k=0; k<7; k++){
                     if (grille[i-k][j+k].lireCouleurDuJeton()==couleur){
                    compteur+=1;
                    }   
                    else {
                        compteur=0;
                    }if (compteur==4){
                        return true;
                    }
                    if (i==0&&j==6){
                        break;
                 
                    }
                }  
            
            compteur=0;
    
        }
    }
    return false;
    
    }
public void tasserLigne (int colonne){
    for (int i=0; i<6;i++){
        if (grille[i][colonne]==null){
            for (int j=i;j<5;j++){
                grille [j][colonne]=grille[j+1][colonne];    
            }
            grille[5][colonne]=null;
        }
    }
}
public boolean colonneRemplie(int colonne){
    return grille[5][colonne]!=null;
    
}

public boolean placerTrouNoir(int ligne, int colonne){
    if (grille[ligne][colonne].presenceTrouNoir()==true){
        grille[ligne][colonne].placerTrouNoir();
        return true;
    }else{
        return false;
    }
    
}
public boolean supprimerTrouNoir(int ligne, int colonne){
    if (grille[ligne][colonne].presenceTrouNoir()==true){
        grille[ligne][colonne].supprimerTrouNoir();
        return true;
    }else{
        return false;
    }
}
public boolean placerDesintegrateur(int ligne, int colonne){
    if (grille[ligne][colonne].presenceDesintegrateur()==true){
        grille[ligne][colonne].placerDesintegrateur();
        return true;
    }else{
        return false;
    }
}
public boolean supprimerDesintegrateur(int ligne, int colonne){
    if (grille[ligne][colonne].presenceDesintegrateur()==true){
        grille[ligne][colonne].supprimerDesintegrateur();
        return true;
    }else{
        return false;
    }
}
public boolean supprimerJeton(int ligne, int colonne){
    if(grille[ligne][colonne].presenceJeton()==true){
        grille[ligne][colonne].supprimerJeton();
        return true;
    }else{
        return false;
    }
}
public Jeton recupererJeton(int ligne,int colonne){
    return grille[ligne][colonne].recupererJeton();
}

}


