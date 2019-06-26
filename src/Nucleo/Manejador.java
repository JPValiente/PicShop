/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo;

import EstructurasDeDatos.AAVL;
import EstructurasDeDatos.ABB;
import EstructurasDeDatos.ListaDoble;
import EstructurasDeDatos.MatrizDispersa;

/**
 *
 * @author anclenius
 */
public class Manejador {
    
    private static ABB capas;
    private static AAVL usuarios;
    private static ListaDoble imagenes;
    
    public static void inicializar(){
        capas = new ABB();
        usuarios = new AAVL();
        imagenes = new ListaDoble();
    }
    
    public static void insertarUsuario(String id){
        usuarios.insertar(id,null);
    }
    
    public static void insertarCapa(int id,MatrizDispersa matriz){
        capas.insertar(id, matriz);
    }
    
    public static void insertarCapa(MatrizDispersa matriz){
        capas.insertar(capas.totalNodos() + 1,matriz);
    }
    
    public static void insertarImagen(String id){
        imagenes.insertar(id,null);
    }
}
