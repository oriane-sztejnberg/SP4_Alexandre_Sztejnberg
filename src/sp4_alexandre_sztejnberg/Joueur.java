/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_alexandre_sztejnberg;

import java.util.ArrayList;

/**
 *
 * @author jason
 */
public class Joueur {

    String Nom;
    String couleur;
    ArrayList<Jeton> reserveJetons = new ArrayList();
    int nombreDesintegrateurs;
    int nombrejetonsrestants;

    /**
     * initialise le nom du joueur avec son paramètre, et initialise son nombre
     * de désintégrateurs disponibles à 0
     *
     * @param nom
     */
    public Joueur(String nom) {
        Nom = nom;
        nombreDesintegrateurs = 0;
    }

    public void affecterCouleur(String Couleur) {
        couleur = Couleur;
    }

    /**
     * ajoute le jeton passé en paramètre à la réserve de jetons
     *
     * @param newJeton
     */
    public void ajouterJeton(Jeton newJeton) {
        reserveJetons.add(newJeton);
        nombrejetonsrestants++;
    }

    /**
     * retire un jeton de la réserve de jetons et on renvoie une référence vers
     * ce jeton
     *
     * @return
     */
    public Jeton jouerJeton() {
        Jeton reference = reserveJetons.remove(0);
        return reference;
    }

    /**
     * incrémente le nombre de désintégrateurs du joueur.
     */
    public void obtenirDesintegrateur() {
        nombreDesintegrateurs += 1;
    }

    /**
     * décrémente le nombre de désintégrateurs.
     */
    public void utiliserDesintegrateur() {
        nombreDesintegrateurs -= 1;
    }

    /**
     *permet de savoir s'il reste ou non des jetons au joueur
     * @return
     */
    public Jeton poserjeton() {
        if (nombrejetonsrestants > 0) {
            nombrejetonsrestants--;
            Jeton jeton = reserveJetons.get(0);
            reserveJetons.remove(0);
            return jeton;
        }
        return null;
    }
}
