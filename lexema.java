
package javaapplication1;
import java.io.*; 
import java.util.*;
/**
 *
 * @author Justo Almiron c.i: 5248358
 * TAREA 1 ANALIZADOR LEXICO
 */
public class lexema {

    /**
     */
        int j=0;
        lexer reservada= new lexer();//objeto para realizar el analisis lexico
        char token[]; //guarda letras hasta formar las palabras
        String tokens; //guarda el lexema de cada palabra
        int i;
        int bandera=0;
        int bandera1=0;
        String entrada; 
        String palabra=""; //palabra de entrada

    public lexema(String entrada,int i) {
        this.entrada = entrada;
        this.i= 0;
        token = new char[entrada.length()];//array de caracteres para guardar tokens detectados
        tokens="";
        
    }
 
    

     
    public void gettoken(){
    
        while( i < entrada.length()){
            
            //se creo estas condiciones que ayudan a imprimir correctamente los tokens sin saltear ningun valor
            if(i>1){  
                if( (reservada.ComprobarDelimitador(entrada.charAt(i-1))==0)  
                      &&  bandera1==1 
                        ){ 
                    reservada.delimitador(entrada.charAt(i-1));
                    tokens= reservada.getTokens();
                    palabra= reservada.getPalabra();
                    bandera1=0;
                  
                      break; 
                }           
                }        
             //condicion que detecta caracteres delimitadores, cada vez que detecta un caracter delimitador
             //guarda los tokens y luego se verifica en la funcion si este token es valido para escribir en el archivo de salida
              if(reservada.delimitador(entrada.charAt(i))==0){

                  
                  
                   //la variable bandera nos ayuda a controlar cuando existe mas caracteres delmitadores
                   //cuando deje de haber caracter delimitadores
                   //se analiza la palabra guardada llamando a la funcion
                   //luego se vacia el token para volver a guardar las palabras
                      if(bandera==1){
                      reservada.funcion(token);   
                      token= null;
                      token = new char[entrada.length()];
                      j=0;
                      bandera1=1;
                      }
                  
                      
                      
                      bandera=0;
                      i++;
               
                      
                      
                      break;
                      
                      
              } else {
                  //mientras no contenga un delimitador se guardaran las palabras
                 bandera=1;
                 token[j]= entrada.charAt(i);
                 j++;
                 i++;
                 //condicion que controla que un string sea completado por si tenga algun simbolo delimitador dentro
                 if(token[0]== '\"'){
                 while( reservada.ComprobarDelimitador(entrada.charAt(i))==0 ){
                   if(token[j-1]=='\"' ){   break;}
                     
                    token[j]= entrada.charAt(i); 
                    i++;
                    j++;
                     
                   
                 }
                } 
              }
        
        }
        
        if(bandera==1){
            reservada.funcion(token);   
            token= null;
            token = new char[entrada.length()];
            j=0;
                      
                }
                  
     
           
        
        tokens= reservada.getTokens();
        palabra= reservada.getPalabra();
         
        
     
    }
   //funciones get para tokens usados
    public String getTokens() {
        return tokens;
    }
 
    public String getPalabra() {
        return palabra;
    }
    
    
    public int getLongitud() {
        return i;
    }
    
}
