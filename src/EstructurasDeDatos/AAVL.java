/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

import Nodos.NodoAVL;
import picshop.NodoDuplicado;

/**
 *
 * @author anclenius
 */
public class AAVL {
    
    private NodoAVL raiz;
    public int size;
    
    public AAVL(){
        this.raiz = null;
        size = 0;
    }
    
    public NodoAVL buscar(String id,NodoAVL raiz) {
        if(raiz == null) {
            return null;
        } if (id.compareTo(raiz.getClave()) == 0) {
            return raiz;
        } if (id.compareTo(raiz.getClave()) == 1) {
            return buscar(id,raiz.getDer());
        } if (id.compareTo(raiz.getClave()) == -1){
            return buscar(id,raiz.getIzq());
        }
        return null;
    }
    
    public NodoAVL buscar(String id) {
        return buscar(id,this.raiz);
    }
    
    public int obtenerFe(NodoAVL x){
        if(x == null) {
            return -1;
        }
        return x.getFactorEquilibrio();
    }
    
    
    public NodoAVL rotacionIzquierda(NodoAVL c){
        NodoAVL aux = c.getIzq();
        c.setIzq(aux.getDer());
        aux.setDer(c);
        c.setFactorEquilibrio(Math.max(obtenerFe(c.getIzq()), obtenerFe(c.getDer())) + 1);
        aux.setFactorEquilibrio(Math.max(obtenerFe(aux.getIzq()), obtenerFe(aux.getDer())) + 1);
        return aux;
    }
    
    
    public NodoAVL rotacionDerecha(NodoAVL c){
        NodoAVL aux = c.getDer();
        c.setDer(aux.getIzq());
        aux.setIzq(c);
        c.setFactorEquilibrio(Math.max(obtenerFe(c.getIzq()), obtenerFe(c.getDer())) + 1);
        aux.setFactorEquilibrio(Math.max(obtenerFe(aux.getIzq()), obtenerFe(aux.getDer())) + 1);
        return aux;
    }   
    
    public NodoAVL rotacionDobleIzquierda(NodoAVL c) {
        NodoAVL aux;
        c.setIzq(rotacionDerecha(c.getIzq()));
        aux = rotacionIzquierda(c);
        return aux;
    }
    
    public NodoAVL rotacionDobleDerecha(NodoAVL c) {
        NodoAVL aux;
        c.setDer(rotacionIzquierda(c.getDer()));
        aux = rotacionDerecha(c);
        return aux;
    }
    
    public NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subAr) throws NodoDuplicado{
        NodoAVL nuevoPadre = subAr;
        if(nuevo.getClave().compareTo(subAr.getClave()) < 0) {
            
            if (subAr.getIzq() == null) {
                subAr.setIzq(nuevo);
            } else {
                subAr.setIzq(insertarAVL(nuevo,subAr.getIzq() ));
                if(obtenerFe(subAr.getIzq()) - obtenerFe(subAr.getDer()) == 2) {
                    if(nuevo.getClave().compareTo(subAr.getIzq().getClave()) == -1) {
                        
                        nuevoPadre = rotacionIzquierda(subAr);
                    } else {
                        nuevoPadre = rotacionDerecha(subAr);
                    }
                }
            }
        } else if (nuevo.getClave().compareTo(subAr.getClave()) > 0) {
            if(subAr.getDer() == null) {
                subAr.setDer(nuevo);
            } else {
                subAr.setDer(insertarAVL(nuevo,subAr.getDer()));
                if (obtenerFe(subAr.getDer()) - obtenerFe(subAr.getIzq()) == 2) {
                    if (nuevo.getClave().compareTo(subAr.getDer().getClave()) == 1) {
                        nuevoPadre = rotacionDerecha(subAr);
                    } else {
                        nuevoPadre = rotacionIzquierda(subAr);   
                    }
                }
            }
        } else {
            System.out.println("Nodo duplicado");
            throw new NodoDuplicado();
            
        }
        if(subAr.getIzq() == null && subAr.getDer() != null) {
            subAr.setFactorEquilibrio(subAr.getDer().getFactorEquilibrio() + 1);
        } else if (subAr.getDer() == null && subAr.getIzq() != null) {
            subAr.setFactorEquilibrio(subAr.getIzq().getFactorEquilibrio() + 1);
        } else {
            subAr.setFactorEquilibrio(Math.max(obtenerFe(subAr.getIzq()), obtenerFe(subAr.getDer())) + 1);
        }
        return nuevoPadre;
    }
    
    public void insertar(String id,Object info) throws NodoDuplicado{
        NodoAVL nuevo = new NodoAVL(id,info);
        if(raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAVL(nuevo,raiz);
        }
        size++;
    }
    
    private void inOrden(NodoAVL nodo)
    {
        if( null == nodo ) return;
        inOrden( nodo.getIzq() );
        System.out.println( "{ Llave: " + nodo.getClave() + " }\n" );
        inOrden( nodo.getDer() );
    }
    
    private void preOrden(NodoAVL nodo)
    {
        if( null == nodo ) return;
        System.out.println( "{ Llave: " + nodo.getClave() + " }\n" );
        preOrden( nodo.getIzq() );
        preOrden( nodo.getDer() );
    }
    
    private void postOrden(NodoAVL nodo)
    {
        if( null == nodo ) return;
        postOrden( nodo.getIzq() );
        postOrden( nodo.getDer() );
        System.out.println( "{ Llave: " + nodo.getClave() + " }\n" );
    }
    
    
    
    public void inOrden()
    {
        inOrden(this.raiz);
    }
    
    public void preOrden(){
        preOrden(this.raiz);
    }
    
    public void postOrden(){
        postOrden(this.raiz);
    }
    
    
    
    
    
    
}
