/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picshop;

import GUI.MainFrame;
import Parsers.LexCapas;
import Parsers.LexImages;
import Parsers.LexUsers;
import Parsers.parserCapas;
import Parsers.parserImages;
import Parsers.parserUsers;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

/**
 *
 * @author anclenius
 */
public class PicShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        try{
//            
//            alg();
//            System.out.println("\n\n\n\n");
//            System.out.println(Manejador.getCapasSize());
//            alg2();
//            System.out.println("\n\n\n\n");
//            System.out.println(Manejador.getImagesSize());
//            alg3();
//            System.out.println("\n\n\n\n");
//            System.out.println(Manejador.getUsersSize());
//            Scanner scan = new Scanner(System.in);
////            System.out.println("Capas: ");
////            String capas = scan.nextLine();
////            Manejador.generarImagenInOrden("1", capas);
//            System.out.println("\n\n\n\n\n\n\n\n\n\n\n-------------Salida--------------\n");
//            String idUser = scan.nextLine();
//            String idImage = scan.nextLine();
//            Manejador.buscarImagenUsuario(idUser, idImage);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(PicShop.class.getName()).log(Level.SEVERE, null, ex);
//        }

    new MainFrame();
        
        
        
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
                    System.out.println("Empezando a parsear capas");
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
                    System.out.println("Empezando a parsear imagenes");
                    miParser.parse();
                    
                } catch (Exception ex) {
                    System.out.println("Comando desconocido.");
                    ex.printStackTrace();
                } 
    }
    
    public static void alg3() throws FileNotFoundException {
        File file = new File("./Usuarios.usr");
        Scanner scan = new Scanner(new FileInputStream(file));
        String buffer = "";
        while (scan.hasNext()) {
                    buffer += scan.nextLine() + "\n";
        }
        StringReader reader = new StringReader(buffer);
                LexUsers miLexer = new LexUsers(reader);
                parserUsers miParser = new parserUsers(miLexer) {};
                try {
                    System.out.println("Empezando a parsear usuarios");
                    miParser.parse();
                    
                } catch (Exception ex) {
                    System.out.println("Comando desconocido.");
                    ex.printStackTrace();
                } 
    }
    
    public static void saveFile(String texto,String absolutePath) {
        
	FileWriter escritor = null;
	try {
            escritor = new FileWriter(absolutePath,true);
            BufferedWriter out = new BufferedWriter(escritor);
            out.write("");
            out.write(texto);
            out.close();
	} catch (IOException e) {
            System.out.println("============== error escribiendo en archivo");
	} finally {
            try {
                escritor.close();
            } catch (IOException ex) {
                System.out.println("========no se pudo cerrar archivo");
            }
        }

    }
    
}
