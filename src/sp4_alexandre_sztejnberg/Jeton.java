/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_alexandre_sztejnberg;

/**
 *
 * @author jason
 */
public class Jeton {
    private String couleur;
    
    /**
     * initialise l’attribut couleur du jeton avec la valeur passée en paramètre.
     * @param Couleur
     */
    public Jeton (String Couleur){    
       couleur=Couleur; 
    
    }

    /**
     *renvoie la couleur du jeton : « rouge » ou « jaune »
     * @return
     */
    public String lireCouleur(){
        return couleur;
    }

    /**
     *Retourne juste le caractère ‘R’ ou ‘J’ selon la couleur du jeton.
     * @return
     */
    @Override
    public String toString(){
        String c;
        if ("rouge".equals(couleur)){
            c="R";
        }else {
            c="J";
    }return c;
    
    }  
}
