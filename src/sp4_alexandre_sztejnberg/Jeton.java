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
    
    public Jeton (String Couleur){    
       couleur=Couleur; 
    
    }
    public String lireCouleur(){
        return couleur;
    }
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
