/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_alexandre_sztejnberg;

/**
 *
 * @author orian
 */
public class CelluleDeGrille {

    private String jetonCourant = null;
    private boolean avoirTrouNoir = false;
    private boolean avoirDesintegrateur = false;

    public boolean presenceJeton() {
        if (jetonCourant == null) {
            return false;
        } else {
            return true;
        }

    }

    /**
     *
     * @param jetonCourant ajoute le jeton en parametre a la cellule
     */
    public void setJetonCourant(String jetonCourant) {
        this.jetonCourant = jetonCourant;
    }

    String lireCouleurDuJeton() {
        if (presenceJeton() == true) {

            return jetonCourant.toString();
        } else {
            return "vide";
        }

    }
    
}
