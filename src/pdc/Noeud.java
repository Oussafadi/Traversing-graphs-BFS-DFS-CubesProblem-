/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Fadio
 */
public class Noeud {
    
   public ArrayList<Stack<Integer>> tables;
   public int nbTables ;
   public int nbCubes;
   public String[] parties ; // pour stocker l'etat saisi par l'utilisateur
    
      //  "[[3,2,1],[],[]]" exemple avec 3 tables 
     public Noeud ( String schema , int nbtables , int nbcubes) {
         this.nbTables = nbtables;
          this.nbCubes= nbcubes;
          this.parties  = schema.split("\\],\\[");
          tables = new ArrayList<Stack<Integer>>(this.nbTables);
          for (int i=0; i < this.nbTables; i++) {
                tables.add(new Stack<Integer>());
               
                    parties[i]=parties[i].replaceAll("\\[","");
                    parties[i]=parties[i].replaceAll("\\]","");
                    ArrayList<String> valeurs = new ArrayList<String>(Arrays.asList(parties[i].split(",")));
                   // this.nbCubes = valeurs.size();
                  
                    Iterator<String> it = valeurs.iterator();
                    while (it.hasNext()) {
                        String cube = it.next();
                        if (!cube.equals("")) {  
                          
                            tables.get(i).push(Integer.parseInt(cube));
                        }
                    }
                   
                   
            }
          //System.out.println(tables);
     }
//     public void remplirTables() {
//         tables = new ArrayList<Stack<Integer>>(this.nbTables);
//          for (int i=0; i < this.nbTables; i++) {
//                tables.add(new Stack<Integer>());
//               
//                    parties[i]=parties[i].replaceAll("\\[","");
//                    parties[i]=parties[i].replaceAll("\\]","");
//                    ArrayList<String> valeurs = new ArrayList<String>(Arrays.asList(parties[i].split(",")));
//                    Iterator<String> it = valeurs.iterator();
//                    while (it.hasNext()) {
//                        String cube = it.next();
//                        if (!cube.equals("")) {    
//                            tables.get(i).push(Integer.parseInt(cube));
//                        }
//                    }
//                   
//            }
//     }
     
      @Override
        public String toString() {
            String dessin = "[";
            for (int i = 0; i < this.nbTables; i++) {
                dessin += tables.get(i).toString().replace(" ", "");
                if (i < this.nbTables - 1) {
                    dessin += ",";
                }
            }
            dessin += "]";
            return dessin;
        }
    
//    public ArrayList<Stack<Integer>> getTables() {
//        return tables;
//    }
    
        @Override
        public boolean equals(Object obj) {
            return this.toString().equals(obj.toString());
        }
         @Override
        public int hashCode(){
            return tables.hashCode();
          
        }

    
     
     
    
}
