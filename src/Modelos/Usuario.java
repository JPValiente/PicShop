/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import EstructurasDeDatos.ListaDoble;
import Nodos.NodoLista;

/**
 *
 * @author anclenius
 */
public class Usuario {
    int id;
    String nombre;
    ListaDoble imagenes;
    
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.imagenes = new ListaDoble();
    }
    
    public Usuario(int id, String nombre, ListaDoble imagenes) {
        this(id,nombre);
        this.imagenes = imagenes;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getString(){
        return this.nombre;
    }
    
    public void agregarImagen(String id,Imagen imagen){
        imagenes.insertar(id,new NodoLista(id,imagen));
    }
    
    public void eliminarImagen(String id){
        imagenes.eliminar(id);
    }
    
    public void limpiarLista(){
        imagenes = new ListaDoble();
    }
}
