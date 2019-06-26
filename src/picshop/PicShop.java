/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picshop;

import EstructurasDeDatos.MatrizDispersa;
import Nucleo.Manejador;

/**
 *
 * @author anclenius
 */
public class PicShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatrizDispersa matriz = new MatrizDispersa();
        matriz.insertar(2, 1, "#FE2E64");
        matriz.insertar(1, 2, "#FE2E64");
        matriz.insertar(4, 1, "#FE2E64");
        matriz.insertar(3, 2, "#FE2E64");
        matriz.insertar(5, 2, "#FE2E64");
        matriz.insertar(1, 3, "#FE2E64");
        matriz.insertar(5, 3, "#FE2E64");
        matriz.insertar(2, 4, "#FE2E64");
        matriz.insertar(4, 4, "#FE2E64");
        matriz.insertar(3, 5, "#FE2E64");
        
        matriz.insertar(2, 2, "#FE2E64");
        matriz.insertar(4, 2, "#FE2E64");
        matriz.insertar(2, 3, "#FE2E64");
        matriz.insertar(3, 3, "#FE2E64");
        matriz.insertar(4, 3, "#FE2E64");
        matriz.insertar(3, 4, "#FE2E64");
        Manejador.inicializar();
        matriz.graficarMatriz();
    }
    
}
