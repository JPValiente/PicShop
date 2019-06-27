 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo;

import EstructurasDeDatos.AAVL;
import EstructurasDeDatos.ABB;
import EstructurasDeDatos.Cola;
import EstructurasDeDatos.ListaDoble;
import EstructurasDeDatos.MatrizDispersa;
import Modelos.Capa;
import Modelos.Imagen;
import Nodos.NodoAb;
import Nodos.NodoLista;
import java.util.List;

/**
 *
 * @author anclenius
 */
public class Manejador {
    
    private static ABB capas = new ABB();
    private static AAVL usuarios = new AAVL();
    private static ListaDoble imagenes = new ListaDoble();
    
    
    public static void insertarUsuario(String id){
        usuarios.insertar(id,null);
    }
    
    public static void insertarCapa(int id,MatrizDispersa capa){
        capas.insertar(id, new Capa(id,capa));
        capa.graficarMatriz();
    }
    
    public static void insertarCapa(MatrizDispersa matriz){
        capas.insertar(capas.totalNodos() + 1,matriz);
    }
    
    public static void insertarImagen(String id){
        imagenes.insertar(id,null);
        
    }
    
    public static void insertarImagen(String id,List<Integer> a) {
        NodoAb nodo;
        Cola cola = new Cola();
        Capa capa;
        for (int i : a) {
            nodo = capas.buscar(i);
            if(nodo != null) {
                capa = (Capa)nodo.dato;
                cola.encolar(new NodoLista("0",capa));
            }
        }
        Imagen ima = new Imagen(id,cola);
        imagenes.insertar(id, ima);
        ima.graficar();
    }
    
    public static int getCapasSize(){
        return capas.totalNodos();
    }
}
