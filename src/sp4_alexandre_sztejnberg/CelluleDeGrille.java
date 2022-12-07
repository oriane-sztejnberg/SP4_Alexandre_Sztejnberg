/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_alexandre_sztejnberg;

/**
 *
 * @author oriane
 */
public class CelluleDeGrille {

    Jeton jetonCourant = null;
    private boolean avoirTrouNoir = false;
    private boolean avoirDesintegrateur = false;
//initialisant les attributs avec des valeurs par défaut

    /**
     * renvoie true si un jeton est présent sur la cellule, et false sinon
     *
     * @return
     */
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
    public void setJetonCourant(Jeton jetonCourant) {
        this.jetonCourant = jetonCourant;
    }

    /**
     * ajoute le jeton en paramètre à la cellule
     *
     * @param nomDuJeton
     * @return
     */
    public Jeton affecterJeton(Jeton nomDuJeton) {
        return jetonCourant;

    }

    /**
     * Si le jeton présent sur la cellule existe (qu’il est différent de null),
     * la méthode renvoie la couleur du jeton (soit « rouge » soit « jaune).
     * Sinon, elle renvoie le mot-clé « vide ».
     *
     * @return
     */
    public String lireCouleurDuJeton() {
        if (presenceJeton() == true) {
            return jetonCourant.toString();
        } else {
            return "vide";
        }
    }

    /**
     * ajoute un trou noir à la cellule en passant la valeur de avoirTrouNoir à
     * true
     */
    public boolean placerTrouNoir() {
        if (!presenceTrouNoir()) {
            avoirTrouNoir = true;
            return true;
        } else {
            return false;
        }

    }

    /**
     * supprime un trou noir présent sur la cellule en passant la valeur de
     * avoirTrouNoir à false
     */
    public void supprimerTrouNoir() {
        avoirTrouNoir = false;
    }

    /**
     * renvoie true si un trou noir est présent sur la cellule et false
     * autrement
     *
     * @return
     */
    public boolean presenceTrouNoir() {
        if (avoirTrouNoir == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * retourne une référence vers le jeton de la cellule, mais doit également
     * supprimer ce dernier de la cellule Cette méthode est utilisée soit pour
     * récupérer un jeton en cours de jeu, soit lorsqu’on vide la grille pour
     * recommencer une partie : il convient alors de redistribuer les jetons aux
     * joueurs.
     *
     * @return
     */
    public Jeton recupererJeton() {
        Jeton var;
        var = jetonCourant;
        jetonCourant = null;
        return var;
    }

    /**
     * supprime simplement le jeton de la cellule en passant jetonCourant à null
     */
    public void supprimerJeton() {
        jetonCourant = null;

    }

    /**
     * renvoie true si un désintégrateur est présent sur la cellule et false
     * sinon.
     *
     * @return
     */
    public boolean presenceDesintegrateur() {
        if (avoirDesintegrateur == true) {
            return true;
        } else {
            return false;

        }
    }

    /**
     * ajoute un désintégrateur sur la cellule en placant la valeur de
     * avoirDesintegrateur à true.
     *
     * @return
     */
    public boolean placerDesintegrateur() {
        if (!presenceDesintegrateur()) {
            avoirDesintegrateur = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * supprime le désintégrateur présent de la cellule lorsqu’un joueur joue
     * sur une cellule disposant d’un désintégrateur.
     */
    public void supprimerDesintegrateur() {
        avoirDesintegrateur = false;
    }

    /**
     *permet de récupérer un désintégrateur si le joueur n'en a pas déjà
     * @return
     */
    public boolean recupererDesintegrateur() {
        if (avoirDesintegrateur) {
            avoirDesintegrateur = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * le trou noir engloutit le jeton et disparait
     */
    public void activerTrouNoir() {
        supprimerJeton();
        supprimerTrouNoir();
    }

    /**
     * Retourne un caractère permettant d’identifier ce qui est dans la
     * celluleDeGrille
     *
     * @return
     */
    public String tostring() {
        if (presenceJeton() == true) {
            return jetonCourant.toString();
        } else if (presenceTrouNoir() == true) {
            return "@";
        } else if (presenceDesintegrateur() == true) {
            return "D";
        } else {
            return ".";
        }
    }
}
