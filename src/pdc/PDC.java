/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pdc;

/**
 *
 * @author Fadio
 */
public class PDC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphComplet G = new GraphComplet(3);
        Noeud depart = new Noeud("[[6,5,4,3,2,1],[],[]]",3,6);  
        Noeud arrive = new Noeud("[[],[],[6,5,4,3,2,1]]",3,6); 
         // Recherche en largeur 
       // System.out.println(G.ParcourEnLargeur(depart, arrive));
         // Recherche en profondeur 
       System.out.println(G.ParcourEnProfondeur(depart, arrive));
    }
    
}
