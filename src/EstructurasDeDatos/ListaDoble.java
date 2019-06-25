/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

import Nodos.NodoLista;

/**
 *
 * @author anclenius
 */
public class ListaDoble {
    
    NodoLista inicio,fin;
    
    public ListaDoble() {
        this.inicio = null;
        this.fin = null;
    }
    
    public boolean listaVacia(){
        if(inicio == null && fin == null) return true;
        return false;
    }
    
    public void insertar(NodoLista nodo){
        if(!listaVacia()){
            fin.setSiguiente(nodo);
            nodo.setAnterior(fin);
            fin = nodo;
        } else {
            System.out.println("Lista vacia");
        }
    }

    public void eliminar(int id){
        if(listaVacia()) System.out.println("Lista Vacia");
        NodoLista aux = inicio;
        while(aux.getSiguiente() != null) {
            if(aux.getId() == id)
                break;
            aux = aux.getSiguiente();
        }
        if(id == aux.getId()) {
            NodoLista anterior = aux.getAnterior();
            NodoLista siguiente = aux.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
        }
    }
}
