/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package EstructurasDeDatos;

import Modelos.Capa;
import Nodos.NodoLista;

/**
 *
 * @author anclenius
 */
public class ListaDoble {
    
    NodoLista inicio,fin;
    public int size;
    
    public ListaDoble() {
        this.inicio = null;
        this.fin = null;
    }
    
    public boolean listaVacia(){
        if(inicio == null && fin == null) return true;
        return false;
    }
    
//    public void insertarOrdenado(NodoLista nodo){
//        if(!listaVacia()){
//            if(nodo.getId() < inicio.getId()) {
//                nodo.setSiguiente(inicio);
//                inicio.setAnterior(nodo);
//                inicio = nodo;
//            } else if (nodo.getId() > inicio.getId() && nodo.getId() < fin.getId()) {
//                NodoLista aux = inicio;
//                boolean repetido = false;
//                while(aux.getSiguiente() != null && aux.getId() < nodo.getId()) {
//                    if(aux.getId() == nodo.getId()) {
//                        repetido = true;
//                        break;
//                    }
//                    aux = aux.getSiguiente(); 
//                }
//                if(repetido) {
//                    System.out.println("Valor repetido");
//                } else {
//                    NodoLista anterior = aux.getAnterior();
//                    NodoLista siguiente = aux.getSiguiente();
//                    anterior.setSiguiente(nodo);
//                    siguiente.setAnterior(nodo);
//                    nodo.setAnterior(anterior);
//                    nodo.setSiguiente(siguiente);
//                }
//            } else if (nodo.getId() > fin.getId()){
//                fin.setSiguiente(nodo);
//                nodo.setAnterior(fin);
//                fin = nodo;
//            } else if (nodo.getId() == inicio.getId() || nodo.getId() == fin.getId()) {
//                System.out.println("Valor repetido");
//            }
//        } else {
//            inicio = fin = nodo;
//            inicio.setSiguiente(fin);
//            fin.setAnterior(inicio);
//        }
//    }
    
    public void insertar(String id,Object info){
        NodoLista nodo = crearNodo(id,info);
        if(listaVacia()){
            inicio = fin = nodo;
            inicio.setSiguiente(fin);
            fin.setAnterior(inicio);
        } else {
            fin.setSiguiente(nodo);
            nodo.setAnterior(fin);
            fin = nodo;
        }
        size++;
    }

    public void eliminar(String id){
        if(listaVacia()) System.out.println("Lista Vacia");
        NodoLista aux = inicio;
        while(aux.getSiguiente() != null) {
            if(aux.getId().equals(id))
                break;
            aux = aux.getSiguiente();
        }
        if(id.equals(aux.getId())) {
            NodoLista anterior = aux.getAnterior();
            NodoLista siguiente = aux.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            size--;
        }
    }
    
    public void graficar(){
        Object cosa = inicio.getInfo();
        if(cosa instanceof Capa) {
            
            NodoLista aux = inicio;
            while(aux != null) {
                
            }
        }
    }
    
    public static NodoLista crearNodo(String id,Object info) {
        return new NodoLista(id,info);
    }
}
