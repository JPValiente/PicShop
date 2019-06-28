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
import Modelos.Usuario;
import Nodos.NodoAVL;
import Nodos.NodoAb;
import Nodos.NodoLista;
import Nodos.NodoMatriz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import picshop.NodoDuplicado;

/**
 *
 * @author anclenius
 */
public class Manejador {
    
    private static ABB capas = new ABB();
    private static AAVL usuarios = new AAVL();
    private static ListaDoble imagenes = new ListaDoble();
    
    
    public static void insertarUsuario(String id) throws Exception{
        usuarios.insertar(id,null);
    }
    
    public static void insertarCapa(int id,MatrizDispersa capa){
        capas.insertar(id, new Capa(id,capa));
        //capa.graficarMatriz();
    }
    
    public static void insertarCapa(MatrizDispersa matriz){
        capas.insertar(capas.totalNodos() + 1,matriz);
    }
    
    public static void insertarImagen(String id){
        imagenes.insertar(id,null);
        
    }
    
    public static void insertarImagen(String id,List<Integer> a) throws IOException {
        Imagen ima;
        Cola cola = new Cola();
        if(!a.isEmpty()) {
            NodoAb nodo;
            Capa capa;
            for (int i : a) {
                nodo = capas.buscar(i);
                if(nodo != null) {
                    capa = (Capa)nodo.dato;
                    cola.encolar(new NodoLista("0",capa));
                }
            }
            
        } else {
            NodoMatriz nodito = new NodoMatriz(1,1,"#000000");
            MatrizDispersa matriz = new MatrizDispersa();
            matriz.insertar(nodito);
            Capa capa = new Capa(1,matriz);
            cola.encolar(new NodoLista("1",capa));
        }
        
        ima = new Imagen(id,cola);
        imagenes.insertar(id, ima);
        ima.graficar();
    }
    
    public static void insertarUsuario(String id,List<Integer> a) throws NodoDuplicado {
        Usuario usuario;
        ListaDoble lista = new ListaDoble();
        if(!a.isEmpty()) {
            NodoLista nodo;
            for (Integer i : a) {
                nodo = imagenes.buscar(i+"");
                if(nodo != null) {
                    lista.insertar(nodo); }
                
            }
            usuario = new Usuario(id,lista);
        } else {
            usuario = new Usuario(id);
        }
        usuarios.insertar(id,usuario);
    }
    
    public static int getImagesSize(){
        return imagenes.size;
    }
    
    public static int getUsersSize(){
        return usuarios.size;
    }
    
    public static int getCapasSize(){
        return capas.totalNodos();
    }
    
    
    
    public static void generarImagenInOrden(String id,String as) throws IOException{
        ABB arbol = generarArbol(as);
        Imagen ima = new Imagen(id,arbol.inOrden());
        imagenes.insertar(id,ima);
        ima.graficar();
    }
    
    public static void generarImagenPreOrden(String id,String as) throws IOException{
        ABB arbol = generarArbol(as);
        Imagen ima = new Imagen(id,arbol.preOrden());
        imagenes.insertar(id,ima);
        ima.graficar();
    }
    
    public static void generarImagenPostOrden(String id,String as) throws IOException{
        ABB arbol = generarArbol(as);
        Imagen ima = new Imagen(id,arbol.postOrden());
        imagenes.insertar(id,ima);
        ima.graficar();
    }
    
    private static ABB generarArbol(String as){
        String[] a = as.split(",");
        ABB arbol = new ABB();
        for (String string : a) {
            arbol.insertar(capas.buscar(Integer.parseInt(string)));
        }
        return arbol;
    }
    
    
    
    public static MatrizDispersa buscarCapa(int a){
        NodoAb ab = capas.buscar(a);
        if(ab != null)
            return ((Capa)ab.dato).getMatriz();
        return null;
    }
    
    public static void graficarUsuarios(){
        String salida = "diagraph {\n";
        
    }
    
    public static void graficarImagenes(){
        
    }
    
    public static void graficarCapas(){
        String salida = "diagraph g {\n";
        
    }
    
    public static void modificarUsuario(String id,String newId,String as){
        Usuario usuario = buscarUsuario(id);
        ListaDoble nuevalista = new ListaDoble();
        if(usuario != null) {
            String[] a = as.split(",");
            for (String i : a) {
                NodoLista nodo = imagenes.buscar(i);
                if(nodo != null)
                    nuevalista.insertar(nodo);
            }
            usuario.setListaImagenes(nuevalista);
            usuario.setId(newId);
        }
    }
    
    public static Usuario buscarUsuario(String id) {
        NodoAVL userNode = usuarios.buscar(id);
        if(userNode!= null) 
            return (Usuario)userNode.getInfo();
        return null;
    }
    
    public static void crearUsuario(String id,String as) {
        List<Integer> a = new ArrayList<>();
        String[] p = as.split(",");
        for (String string : p) {
            a.add(Integer.parseInt(string));
        }
        try{
            insertarUsuario(id,a);
            JOptionPane.showMessageDialog(null, "Usuario insertado");
        } catch(NodoDuplicado ex) {
            JOptionPane.showMessageDialog(null, "Nodo duplicado");
        }
        
    }
    
    public static void buscarImagenUsuario(String idUser,String idImage) throws IOException {
        NodoAVL userNode = usuarios.buscar(idUser);
        Usuario user = new Usuario("");
        try {
            user = (Usuario)userNode.getInfo();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null,"Usuario no encontrado");
        }
        NodoLista imageNode = user.buscarImagen(idImage);
        try {
        Imagen imagen = (Imagen)imageNode.getInfo();
        imagen.graficar();
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Imagen no encontrada");
        }
    }
    
    
}
