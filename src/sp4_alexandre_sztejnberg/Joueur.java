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
//Realisation de la classe "joueur" :
public class Joueur {

    String Nom;
    String couleur;
    private ArrayList<Jeton> reserveJetons = new ArrayList();
    int nombreDesintegrateurs;
    int nombrejetonsrestants;

    /**
     * initialise le nom du joueur avec son paramètre, et initialise son nombre
     * de désintégrateurs disponibles à 0
     *
     * @param nom
     */
    // Le constructeur d'objet de type "joueur"
    public Joueur(String nom) {
        Nom = nom;
        nombreDesintegrateurs = 0;
    }

    // Cette méthode permet d'affecer une couleur à un joueur:
    public void affecterCouleur(String Couleur) {
        couleur = Couleur;
    }
    // permet d'acceder à la couleur du jeton:
    public String lireCouleur(){
        return couleur;
    }

    /**
     * permet d' ajouter le jeton passé en paramètre à la réserve de jetons
     *
     * @param newJeton
     */
    public void ajouterJeton(Jeton newJeton) {
        reserveJetons.add(newJeton);
        nombrejetonsrestants++;
    }

    /**
     * methode qui permet de retirer un jeton de la réserve de jetons et renvoie une référence vers
     * ce jeton
     *
     * @return
     */
    public Jeton jouerJeton() {
        Jeton reference = reserveJetons.remove(0);
        return reference;
    }

    /**
     * methode permettant d'incrémenter le nombre de désintégrateurs du joueur.
     */
    public void obtenirDesintegrateur() {
        nombreDesintegrateurs += 1;
    }

    /**
     * methode qui décrémente le nombre de désintégrateurs.
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
