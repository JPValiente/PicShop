/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

import Nodos.NodoMatriz;

/**
 *
 * @author Tito Valiente
 */
public class MatrizDispersa {
    private ListaDoble xAxis;
    private ListaDoble yAxis;
    private int totalNodos;
    private int totalFilas;
    private int totalColumnas;
    private final NodoMatriz inicio;
    
    public MatrizDispersa() {
        inicio = new NodoMatriz(0,0,null);
        totalNodos = totalFilas = totalColumnas = 0;
    }
    
    public void insertarNodo(NodoMatriz nodo) {
    }
    
    public NodoMatriz crearNodo(int x, int y,String color) {
        return new NodoMatriz(x,y,color);
    }
    
    public NodoMatriz insertarFila(int fila) {
        NodoMatriz cabeza = inicio.getSigFila();
        NodoMatriz nuevo = new NodoMatriz(0,fila,null);
        if(cabeza == null) {
            inicio.setSigFila(nuevo);
            nuevo.setAntColumna(inicio);
        } else {
            if(cabeza.getY() > fila) {
                nuevo.setSigFila(cabeza);
                cabeza.setAntFila(nuevo);
                inicio.setSigFila(nuevo);
                nuevo.setAntFila(inicio);
            } else {
                NodoMatriz aux = cabeza;
                while(aux.getSigFila() != null) {
                    if(aux.getSigFila().getY() < fila) {
                        nuevo.setSigFila(aux.getSigFila());
                        aux.getSigFila().setAntFila(nuevo);
                        nuevo.setAntFila(aux);
                        aux.setSigFila(nuevo);
                        totalFilas++;
                        return nuevo;
                    }
                }
                aux.setSigFila(nuevo);
                nuevo.setAntFila(aux);
            }
        }
        totalFilas++;
        return nuevo;
    }
    
    public NodoMatriz insertarColumna(int columna) {
        NodoMatriz cabeza = inicio.getSigColumna();
        NodoMatriz nuevo = new NodoMatriz(columna,0,null);
        if(cabeza == null) {
            inicio.setSigColumna(nuevo);
            nuevo.setAntColumna(inicio);
        } else {
            if(cabeza.getX() > columna) {
                nuevo.setSigColumna(cabeza);
                cabeza.setAntColumna(nuevo);
                inicio.setSigColumna(nuevo);
                nuevo.setAntColumna(inicio);
            } else {
                NodoMatriz aux = cabeza;
                while(aux.getSigColumna() != null) {
                    if(aux.getSigColumna().getX() < columna) {
                        nuevo.setSigColumna(aux.getSigColumna());
                        aux.getSigColumna().setAntColumna(nuevo);
                        nuevo.setAntColumna(aux);
                        aux.setSigColumna(nuevo);
                        totalColumnas++;
                        return nuevo;
                    }
                }
                aux.setSigColumna(nuevo);
                nuevo.setAntColumna(aux);
            }
        }
        totalColumnas++;
        return nuevo;
    }
    
    
    public NodoMatriz obtenerFila(int fila) {
        NodoMatriz aux = inicio.getSigFila();
        while(aux != null) {
            if(aux.getY() == fila){
                return aux;
            }
            aux = aux.getSigFila();
        }
        return insertarFila(fila);
    }
    
    public NodoMatriz obtenerColumna(int columna) {
        NodoMatriz aux = inicio.getSigColumna();
        while(aux != null) {
            if(aux.getX() == columna){
                return aux;
            }
            aux = aux.getSigColumna();
        }
        return insertarColumna(columna);
    }
    
    public void insertar(int fila, int columna,String color) {
        NodoMatriz nuevo = new NodoMatriz(columna,fila,color);
        NodoMatriz inicioFila = obtenerFila(fila);
        NodoMatriz inicioColumna = obtenerColumna(columna);
    
        ///////////////////// Insercion en columna /////////////////////
        
        NodoMatriz cabeza = inicioColumna.getSigFila();
        if(cabeza == null) {
            inicioColumna.setSigFila(nuevo);
            nuevo.setAntFila(inicioColumna);
        } else {
            if(cabeza.getY() > fila) {
                nuevo.setSigFila(cabeza);
                cabeza.setAntFila(nuevo);
                inicioColumna.setSigFila(nuevo);
                nuevo.setAntFila(inicioColumna);
            } else {
                NodoMatriz aux = cabeza;
                boolean insertado = false;
                while(aux.getSigFila() != null) {
                    if(aux.getSigFila().getY() < fila) {
                        nuevo.setSigFila(aux.getSigFila());
                        aux.getSigFila().setAntFila(nuevo);
                        nuevo.setAntFila(aux);
                        aux.setSigFila(nuevo);
                        insertado = true;
                        
                    }
                }
                if (!insertado) {
                    aux.setSigFila(nuevo);
                    nuevo.setAntFila(aux);
                }
            }
        }
        ////////////////// insercion en fila /////////////////////
        cabeza = inicioFila.getSigColumna();
        if(cabeza == null) {
            inicioFila.setSigColumna(nuevo);
            nuevo.setAntColumna(inicioFila);
        } else {
            if(cabeza.getX() > columna) {
                nuevo.setSigColumna(cabeza);
                cabeza.setAntColumna(nuevo);
                inicioFila.setSigColumna(nuevo);
                nuevo.setAntColumna(inicioFila);
            } else {
                NodoMatriz aux = cabeza;
                boolean insertado = false;
                while(aux.getSigColumna() != null) {
                    if(aux.getSigColumna().getX() < columna) {
                        nuevo.setSigColumna(aux.getSigColumna());
                        aux.getSigColumna().setAntColumna(nuevo);
                        nuevo.setAntColumna(aux);
                        aux.setSigColumna(nuevo);
                        insertado = true;
                    }
                }
                if(!insertado) {
                    aux.setSigColumna(nuevo);
                    nuevo.setAntColumna(aux);
                }
            }
        }
    totalNodos++;
    }
    
}
 