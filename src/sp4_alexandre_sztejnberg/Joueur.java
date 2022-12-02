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
    private String nom;
    String couleur;
    private ArrayList<Jeton> reserveJetons = new ArrayList();
    private int nombreDesintegrateurs ;
    
    /**
     * initialise le nom du joueur avec son paramètre, et initialise son nombre de désintégrateurs disponibles à 0
     * @param nom
     */
    public Joueur(String nom){
        nom = nom ;
        nombreDesintegrateurs = 0 ;
    }
    public void affecterCouleur (String Couleur){
        couleur=Couleur;
    }
  
    /**
     *ajoute le jeton passé en paramètre à la réserve de jetons
     * @param newJeton
     */
    public void ajouterJeton (Jeton newJeton){
        reserveJetons.add(newJeton);
}

    /**
     *etire un jeton de la réserve de jetons et on renvoie une référence vers ce jeton
     * @return
     */
    public Jeton jouerJeton(){
        Jeton reference = reserveJetons.remove(0);
        return reference ;
    } 

    /**
     *incrémente le nombre de désintégrateurs du joueur.
     */
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs += 1 ;
    }

    /**
     *décrémente le nombre de désintégrateurs.
     */
    public void utiliserDesintegrateur(){
        nombreDesintegrateurs -= 1 ;
    }
}


