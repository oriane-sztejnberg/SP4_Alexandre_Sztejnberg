/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_alexandre_sztejnberg;

/**
 *
 * @author orian
 */
public class SP4_Alexandre_Sztejnberg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Jeton J1=new Jeton("rouge");
        System.out.println(J1);
        Jeton J2=new Jeton("jaune");
        System.out.println(J2);
        Jeton J3=new Jeton("vert");
        System.out.println(J3);*/
        
        Joueur j1 = new Joueur("Joueur 1"); // creation d'un premier joueur
        Joueur j2 = new Joueur("Joueur 2");// creation du second joueur
        Partie partie = new Partie(j1, j2); // creation d'une nouvelle partie
        partie.debuterpartie();
    }
}