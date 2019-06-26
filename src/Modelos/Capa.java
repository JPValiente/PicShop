/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import EstructurasDeDatos.MatrizDispersa;

/**
 *
 * @author anclenius
 */
public class Capa {
    private int id;
    private MatrizDispersa matriz;
    
    public Capa(int id,MatrizDispersa matriz) {
        this.id = id;
        this.matriz = matriz;
    }
    
    public int getId(){
        return this.id;
    }
    
    public MatrizDispersa getMatriz() {
        return this.matriz;
    }
}
