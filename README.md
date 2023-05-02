# Traversing-graphs-BFS-DFS-CubesProblem-
Bread First Search 
```java
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
```

Depth First Search ((best solution to this problem ) traverse less states than BFS ) 
```java
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
```
To retrive the path traversed by the search methods 
```java
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
```
