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

    private Jeton jetonCourant = null;
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
    public void setJetonCourant(Jeton jetonCourant) {
        this.jetonCourant = jetonCourant;
    }

    public String lireCouleurDuJeton() {
        if (presenceJeton() == true) {
            return jetonCourant.toString();
        } else {
            return "vide";
        }
    }
    public void placerTrouNoir() {
        avoirTrouNoir = true;
    

    }

    public void supprimerTrouNoir() {
        avoirTrouNoir = false;
    }

    public boolean presenceTrouNoir() {
        if (avoirTrouNoir == true) {
            return true;
        } else {
            return false;
        }
    }
    public Jeton recupererJeton(){
        Jeton var;
        var = jetonCourant;
        jetonCourant=null;
        return var;
    }
    public void supprimerJeton(){
        jetonCourant= null;
                
    }
    public boolean presenceDesintegrateur(){
        if (avoirDesintegrateur==true){
            return true;
        }else{
            return false;
            
        }
    }
    public void placerDesintegrateur(){
        avoirDesintegrateur=true;
        
    }
    
   public void supprimerDesintegrateur(){
       avoirDesintegrateur=false;
   } 
   public void activerTrouNoir(){
       supprimerJeton();
       supprimerTrouNoir();
   }
   public String tostring(){
       if (presenceJeton()==true){
           return jetonCourant.toString();
       }else if (presenceTrouNoir()==true){
           return "@";
       }else if (presenceDesintegrateur()==true){
           return "D";
       }else{
           return".";
       }
   }
}



