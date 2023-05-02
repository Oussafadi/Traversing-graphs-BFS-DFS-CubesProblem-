/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc;

/**
 *
 * @author Fadio
 */
public class Liens {
                          // Classe pour stocker l'arboresence
    public Noeud depart ;
    public Noeud Arrive ;
    
    public Liens( Noeud depart , Noeud arrive) {
        this.depart = depart ;
        this.Arrive= arrive ;
    }
    public Noeud getDepart() {
        return depart ;
    }
    public Noeud getArrive() {
        return Arrive ;
    }
    
    @Override
    public String toString() {
        return " Chemin qui commence en  " + depart.toString()+ " vers " + Arrive.toString() ;
    }
    
}
