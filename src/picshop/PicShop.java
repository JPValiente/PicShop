/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picshop;

import Nucleo.Manejador;
import Parsers.LexCapas;
import Parsers.LexImages;
import Parsers.parserCapas;
import Parsers.parserImages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anclenius
 */
public class PicShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            //        MatrizDispersa matriz = new MatrizDispersa();
//        matriz.insertar(2, 1, "#FE2E64");
//        matriz.insertar(1, 2, "#FE2E64");
//        matriz.insertar(4, 1, "#FE2E64");
//        matriz.insertar(3, 2, "#FE2E64");
//        matriz.insertar(5, 2, "#FE2E64");
//        matriz.insertar(1, 3, "#FE2E64");
//        matriz.insertar(5, 3, "#FE2E64");
//        matriz.insertar(2, 4, "#FE2E64");
//        matriz.insertar(4, 4, "#FE2E64");
//        matriz.insertar(3, 5, "#FE2E64");
//        MatrizDispersa matriz2 = new MatrizDispersa();

//        matriz2.insertar(2, 2, "#FF0000");
//        matriz2.insertar(4, 2, "#FF0000");
//        matriz2.insertar(2, 3, "#FF0000");
//        matriz2.insertar(3, 3, "#FF0000");
//        matriz2.insertar(4, 3, "#FF0000");
//        matriz2.insertar(3, 4, "#FF0000");

//        MatrizDispersa matriz3 = new MatrizDispersa();
//        matriz3.insertar(1,1,"#000000");
//        matriz3.insertar(3,1,"#000000");
//        matriz3.insertar(5,1,"#000000");
//        matriz3.insertar(1,4,"#000000");
//        matriz3.insertar(5,4,"#000000");
//        matriz3.insertar(1,5,"#000000");
//        matriz3.insertar(2,5,"#000000");
//        matriz3.insertar(4,5,"#000000");
//        matriz3.insertar(5,5,"#000000");
//        Capa capa1 = new Capa(1,matriz);
//        Capa capa2 = new Capa(2,matriz2);
//        Capa capa3 = new Capa(3,matriz3);
//        Cola cola = new Cola();
//        cola.encolar(new NodoLista("1",capa1));
//        cola.encolar(new NodoLista("2",capa2));
//        cola.encolar(new NodoLista("3",capa3));
//        Imagen imagen = new Imagen("1",cola);
//        
//        imagen.graficar();
        

        try{
            
            alg();
            alg2();
            System.out.println(Manejador.getCapasSize());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PicShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public static void alg() throws FileNotFoundException {
        File file = new File("./Capas.cap");
        Scanner scan = new Scanner(new FileInputStream(file));
        String buffer = "";
        while (scan.hasNext()) {
                    buffer += scan.nextLine() + "\n";
        }
        StringReader reader = new StringReader(buffer);
                LexCapas miLexer = new LexCapas(reader);
                parserCapas miParser = new parserCapas(miLexer) {};
                try {
                    System.out.println("Empezando a parser");
                    miParser.parse();
                    
                } catch (Exception ex) {
                    System.out.println("Comando desconocido.");
                    ex.printStackTrace();
                } 
    }
    
    public static void alg2() throws FileNotFoundException {
        File file = new File("./imagenes.im");
        Scanner scan = new Scanner(new FileInputStream(file));
        String buffer = "";
        while (scan.hasNext()) {
                    buffer += scan.nextLine() + "\n";
        }
        StringReader reader = new StringReader(buffer);
                LexImages miLexer = new LexImages(reader);
                parserImages miParser = new parserImages(miLexer) {};
                try {
                    System.out.println("Empezando a parser");
                    miParser.parse();
                    
                } catch (Exception ex) {
                    System.out.println("Comando desconocido.");
                    ex.printStackTrace();
                } 
    }
    
}
