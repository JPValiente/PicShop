/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

/**
 *
 * @author Tito Valiente
 */
public class NodoMatriz {
    int x;
    int y;
    String hexaColor;
    NodoMatriz izquierda,arriba,derecha,abajo;
    
    public NodoMatriz(int x, int y, String hexaColor) {
        this.x = x;
        this.y = y;
        this.hexaColor = hexaColor;
        izquierda = arriba = derecha = abajo = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getHexaColor() {
        return hexaColor;
    }

    public NodoMatriz getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoMatriz izquierda) {
        this.izquierda = izquierda;
    }

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    public NodoMatriz getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoMatriz derecha) {
        this.derecha = derecha;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }
    
    
    
    
}
