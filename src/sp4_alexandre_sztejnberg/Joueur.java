/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_alexandre_sztejnberg;

/**
 *
 * @author jason
 */
public class Joueur {
    private String nom;
    String couleur;
    Vector reserveJetons = new Vector ();
    int nombreJetonsRestants;
    int nombreDesintegrateurs=0;
    
    public Joueur (String couleur){
        this.nom=nom;
        
    }
  
public void affecterCouleur (String couleur){
    this.couleur=couleur;
}
public void ajouterJeton (Jeton newJeton){
    reserveJetons.add(newJeton);
    nombreJetonsRestants +=1;
}

}
