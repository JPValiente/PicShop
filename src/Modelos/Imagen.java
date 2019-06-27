/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import EstructurasDeDatos.Cola;
import EstructurasDeDatos.MatrizDispersa;
import Nodos.NodoLista;
import Nodos.NodoMatriz;

/**
 *
 * @author anclenius
 */
public class Imagen {
    private String id;
    private Cola capas;
    private Cola cola;
    private static MatrizDispersa imagen;
    
    public Imagen(String id) {
        this.id = id;
        capas = new Cola();
        cola = new Cola();
    }
    
    public Imagen(String id,Cola capas) {
        this(id);
        this.capas = capas;
    }
    
    
    public void setCapas(Cola capas) {
        this.capas = capas;
    }
    
    public void graficar() {
        if(this.imagen == null) {
            hacerImagen();
        } else {
            imagen.graficarMatriz();
        }
    }
    
    public void hacerImagen(){
        imagen = new MatrizDispersa();
        if(capas.estaVacia()) return;
        NodoLista aux = capas.descolar();
        MatrizDispersa capa;
        while(aux != null) {
            capa = ((Capa)aux.getInfo()).getMatriz();
            int filas = capa.totalFilas;
            int columnas = capa.totalColumnas;
            for(int y = 1;y <=filas;y++) {
                for (int x = 1;x<=columnas;x++) {
                    NodoMatriz nodo = capa.triangular(x, y);
                    System.out.println("Coordenada actual ("+x+","+y+")\n");
                    if(nodo != null) {
                        System.out.println("Insertando en X: " + x + " en Y: " + y + " el color: " + nodo.getHexaColor());
                        imagen.insertar(nodo.getX(), nodo.getY(), nodo.getHexaColor());
                    }
                }
            }
            
            System.out.println("\n\n\n");
            aux = capas.descolar();
        }
        imagen.graficarMatriz();
        
    }
    
    
    
    
    
    
    
}
