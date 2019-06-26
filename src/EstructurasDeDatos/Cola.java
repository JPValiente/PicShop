/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

import Nodos.NodoLista;

/**
 *
 * @author Tito Valiente
 */
public class Cola {
    NodoLista inicio, fin;
    int size;
    
    public Cola(){
        inicio = fin = null;
        size = 0;
    }
    
    public int size() {
        return this.size;
    }
    
    public void encolar(NodoLista nuevo){
        if(!estaVacia()) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            size++;
        } else {
            inicio = fin = nuevo;
        }
    }
    
    public NodoLista descolar() {
        if(!estaVacia()) {
            NodoLista aux = inicio;
            if(inicio == fin) {
                inicio = fin = null;
                size--;
                return aux;
            }
            
            inicio = inicio.getSiguiente();
            size--;
            return aux;
        }
            System.out.println("Lista Vacia");
            return null;
    }
    
    public boolean estaVacia(){
        if(inicio == fin && inicio == null) return true;
        return false;
    }
}
