/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

import Nodos.NodoAVL;

/**
 *
 * @author anclenius
 */
public class AAVL {
    
    private NodoAVL raiz;
    
    public AAVL(){
        this.raiz = null;
    }
    
    public NodoAVL buscar(int id,NodoAVL raiz) {
        if(raiz == null) {
            return null;
        } else if (raiz.getClave() == id) {
            return raiz;
        } else if (raiz.getClave() < id) {
            return buscar(id,raiz.getDer());
        } else {
            return buscar(id,raiz.getIzq());
        }
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
    
    public NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subAr) {
        NodoAVL nuevoPadre = subAr;
        if(nuevo.getClave() < subAr.getClave()) {
            if (subAr.getIzq() == null) {
                subAr.setIzq(nuevo);
            } else {
                subAr.setIzq(insertarAVL(nuevo,subAr.getIzq() ));
                if(obtenerFe(subAr.getIzq()) - obtenerFe(subAr.getDer()) == 2) {
                    if(nuevo.getClave() < subAr.getIzq().getClave()) {
                        nuevoPadre = rotacionIzquierda(subAr);
                    } else {
                        nuevoPadre = rotacionDerecha(subAr);
                    }
                }
            }
        } else if (nuevo.getClave() > subAr.getClave()) {
            if(subAr.getDer() == null) {
                subAr.setDer(nuevo);
            } else {
                subAr.setDer(insertarAVL(nuevo,subAr.getDer()));
                if (obtenerFe(subAr.getDer()) - obtenerFe(subAr.getIzq()) == 2) {
                    if (nuevo.getClave() > subAr.getDer().getClave()) {
                        nuevoPadre = rotacionDerecha(subAr);
                    } else {
                        nuevoPadre = rotacionIzquierda(subAr);   
                    }
                }
            }
        }
    }
    
    
    
    
    
    
}
