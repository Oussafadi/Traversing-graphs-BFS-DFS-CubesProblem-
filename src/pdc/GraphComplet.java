/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Fadio
 */
public class GraphComplet {
    
    public int nbTables ;
    public  LinkedHashSet<Noeud> N ;  // Noeuds visites 
    public LinkedHashSet<Liens> L ;  // Liens Developes
    public LinkedHashSet<Mouvements> M ;
    
    public GraphComplet( int nbtables) {
        this.nbTables = nbtables ;
        N = new LinkedHashSet<Noeud>();
        L = new LinkedHashSet<Liens>();
        M = new LinkedHashSet<Mouvements>();
         // Tout les mouvements possibles
         for (int i = 0; i < nbtables; i++) {
            for (int j = 0; j < nbtables; j++) {
                if (i != j) {
                    M.add(new Mouvements(i, j));
                }
            }
        }
        
    }
    public void reset () {
        N = new LinkedHashSet<Noeud>();
        L = new LinkedHashSet<Liens>();
    }
    
    public void RechercheLargeur ( Noeud nDepart, Noeud nFinal ) {
        this.reset();
       // System.out.println(nDepart.toString());
        Queue<Noeud> q = new LinkedList<Noeud>() ;
        q.add(nDepart);
        while ( !q.isEmpty()) {
            Noeud courant = q.remove();
            if (  !N.contains(courant)) {
                N.add(courant); 
            }
            Noeud prochain ;
            for ( Mouvements mv : M) { // Les actions possibles 
                if ( mv.PossibleouPas(courant)) {
                    prochain = mv.changerEtat(courant);   // si Mouvement possible , generer le noeud fils                 
                    if (!N.contains(prochain)) {
                        q.add(prochain);
                        N.add(prochain);                   
                        System.out.println(prochain.toString());
                        L.add( new Liens( courant , prochain)); // ajouter le noeud et son parent a l'arboresence
                        if ( nFinal.equals(prochain) ) { // Solution trouver ??
                           // N.add(prochain);
                            System.out.println("    Bien arrivee a l'etat finale !! ");
                            System.out.println(  "    Nombre d'etats parcourus est : "+ N.size());
                           
                            return ;
                        }
                    }
                }
            }
        }
        
    }
    
    public void RechercheProfondeur( Noeud nDepart , Noeud nFinal) {
        this.reset();
        Stack<Noeud> pile = new Stack<>();     
        pile.push(nDepart);
        while ( !pile.isEmpty()) {
             // System.out.println("BEFORE : " +pile.toString());
            Noeud courant = pile.pop();
           // System.out.println("AFTER : " +pile.toString());
              if (  !N.contains(courant)) {
                N.add(courant); 
            } 
            Noeud prochain ;
            for ( Mouvements mv : M) {
                if( mv.PossibleouPas(courant)) {
                     prochain = mv.changerEtat(courant);
                    if (!N.contains(prochain)) {
                        System.out.println(prochain.toString());
                        pile.push(prochain);
                         N.add(prochain);
                        L.add(new Liens(courant,prochain));
                        if (nFinal.equals(prochain)) {
                            System.out.println("    Bien arrivee a l'etat finale !! ");
                            System.out.println(  "    Nombre d'etats parcourus est : "+ N.size());
                            return ;
                        }
                    }
                }
            }
                   
        }
    }
    
    public ArrayList<Noeud> getChemin( Noeud nDestination , Noeud ndepart) {
        
        // Chemin de destination vers depart donc on doit inverser cette liste
      
        ArrayList<Noeud> Chemin = new ArrayList<Noeud>() ;
        Noeud courant = nDestination ;
        Chemin.add(nDestination);
        thisLoop :
        while ( true ) {
            boolean noeudTrouve = false;
            for ( Liens li : L) {
              // System.out.println(li.toString());
                if ( li.getArrive().equals(courant)) {
                    Chemin.add(li.getDepart());
                    //System.out.println(li.getArrive().toString());
                    courant = li.getDepart();
                    
                    noeudTrouve= true ;
                    L.remove(li);
                    if(courant.equals(ndepart)) {
                        break thisLoop ;
                    }
                    break;
                }        
            } 
            if( !noeudTrouve) {
                break;
            }
        }
            
        //  Chemin.add(nDepart);
        Collections.reverse(Chemin);
        return Chemin ;
    }
    
    public ArrayList<Noeud> ParcourEnLargeur( Noeud pdepart,Noeud parrive) {
        RechercheLargeur(pdepart, parrive);
        return getChemin(parrive ,pdepart);
    }

    public ArrayList<Noeud> ParcourEnProfondeur( Noeud pdepart , Noeud parrive) {
        RechercheProfondeur(pdepart, parrive);
        return getChemin(parrive, pdepart);
    }
    
    
}
