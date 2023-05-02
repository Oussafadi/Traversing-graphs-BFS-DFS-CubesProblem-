/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc;

/**
 *
 * @author Fadio
 */
public class Mouvements {
     
                         
     public int i ; // table i
     public int j ; // vers table j 
     
     public Mouvements( int i , int j) {
         this.i = i ;
         this.j= j ;
     }
     
      // Verifier si on peut bouger un cube d'une table a une autre
     public boolean PossibleouPas( Noeud n) {
         if ( !n.tables.get(i).isEmpty()) {
             if( n.tables.get(j).isEmpty() || n.tables.get(j).size()< n.nbCubes ) {
                 return true ;
             }
         }
         return false ;
     }
     
      // Prend le noeud de depart et retourne le noeud d'arrive 
     public Noeud changerEtat( Noeud n) {
         Noeud narrive = new Noeud( n.toString(), n.nbTables,n.nbCubes);
        // narrive.remplirTables();
         narrive.tables.get(j).push(narrive.tables.get(i).pop());
         return narrive ;
     }
     
     @Override
        public String toString() {
            return i+" vers "+j;
        }
}
