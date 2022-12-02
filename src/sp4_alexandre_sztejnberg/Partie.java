/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_alexandre_sztejnberg;

import java.util.Random;

/**
 *
 * @author jason
 */
public class Partie {

    private Joueur[] listeJoueurs = new Joueur[2];
    private Joueur joueurCourant;
    private Plateaudejeu plateau;

    /**
     * Affecte les deux joueurs passés en paramètre aux deux cellules de listeJoueurs, et crée un nouveau plateau de jeu.
     * @param joueur1
     * @param joueur2
     */
    public Partie(Joueur joueur1, Joueur joueur2) {
        listeJoueurs[0] = joueur1;
        listeJoueurs[1] = joueur2;
        plateau = new Plateaudejeu();
    }

    /**
     * distribue une couleur aléatoire aux deux joueurs, rouge ou jaune. Un joueur est rouge, l’autre jaune.
     */
    public void attribuerCouleurAuxJoueurs() {
        Random aleat = new Random();
        int nb = aleat.nextInt(0, 2);
        if (nb == 0) {
            listeJoueurs[0].affecterCouleur("rouge");
            listeJoueurs[1].affecterCouleur("jaune");
        } else {
            listeJoueurs[1].affecterCouleur("rouge");
            listeJoueurs[0].affecterCouleur("jaune");
        }
    }

        }
            
    }
}
