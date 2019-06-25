package EstructurasDeDatos;

import Nodos.NodoAb;

public class ABB
{
    private NodoAb raiz;
    private String nombre;
    
    public ABB()
    {
        this( "abb" );    
    }
    
    public ABB(String nombre)
    {
        this.nombre = nombre;
        raiz = null;
    }
    
    public boolean estaVacio(){ return null == raiz; }
    
    public void insertar(int llave, Object dato)
    {
        if( estaVacio() )
            raiz = new NodoAb( llave, dato );
        else
            raiz.insertar( llave, dato );
    }
    
    private void inOrden(NodoAb nodo)
    {
        if( null == nodo ) return;
        inOrden( nodo.izq );
        System.out.println( "{ Llave: " + nodo.llave + "\n, o: " + nodo.dato.toString() + " }\n" );
        System.out.println("\n\n");
        inOrden( nodo.der );
    }
    
    private void preOrden(NodoAb nodo)
    {
        if( null == nodo ) return;
        System.out.println( "{ Llave: " + nodo.llave + "\n, o: " + nodo.dato.toString() + " }\n" ); System.out.println("\n\n");
        preOrden( nodo.izq );
        preOrden( nodo.der );
    }
    
    private void postOrden(NodoAb nodo)
    {
        if( null == nodo ) return;
        postOrden( nodo.izq );
        postOrden( nodo.der );
        System.out.println( "{ Llave: " + nodo.llave + "\n, o: " + nodo.dato.toString() + " }\n" ); System.out.println("\n\n");
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
    
    private int profundidad(NodoAb raiz)
    {
        if( null == raiz ) return 0;
        
        int profundidadI = profundidad( raiz.izq );
        int profundidadD = profundidad( raiz.der );
        
        return ( profundidadI > profundidadD ) ? profundidadI + 1 : profundidadD + 1;
    }
    
    public int profundidad()
    {
        return profundidad(this.raiz);
    }
    
    public int totalNodos(NodoAb raiz){
        if(null == raiz) return 0;
        
        int a = totalNodos(raiz.izq);
        int b = totalNodos(raiz.der);
        return a+b+1;
    }
    
    public int totalNodos(){
        return totalNodos(raiz);
    }
    
    public int totalHojas(){
        return totalHojas(this.raiz);
    }
    
    
    public int totalHojas(NodoAb raiz){
        int total = 0;
        if(raiz == null) return -1;
        int a = totalHojas(raiz.izq);
        int b = totalHojas(raiz.der);
        if(a == -1 && b == -1){
            return 1;
        } else {
            if (a == -1) {
                return b;
            } else if (b == -1){
                return a;
            } else {
                return a+b;
            }
        }
    }
    
}
