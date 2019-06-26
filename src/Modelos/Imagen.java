/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import EstructurasDeDatos.Cola;
import EstructurasDeDatos.ListaDoble;

/**
 *
 * @author anclenius
 */
public class Imagen {
    private String id;
    private ListaDoble capas;
    public Imagen(String id) {
        this.id = id;
        capas = new ListaDoble();
    }
    
    public Imagen(String id,ListaDoble capas) {
        this(id);
        this.capas = capas;
    }
    
    public void setCapas(ListaDoble capas) {
        this.capas = capas;
    }
    
    public void hacerImagen(){
        capas.graficar();
    }
    
    
    
}
