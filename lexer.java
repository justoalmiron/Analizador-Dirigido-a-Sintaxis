/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Justo
 */
//Este objeto tiene el objetivo de realizar el analisis leximo y escribir el archivo de entrada
public class lexer {
    //todas estas variables simbolizan una tabla de simbolos que estara escribiendo en la salida
    String signos[] = {"L_CORCHETE","R_CORCHETE","L_LLAVE","R_LLAVE","COMA","DOS_PUNTOS"," ","\n"};
    char lexema[] = {'[',']','{','}',',',':',' ','\n'};
    String componente[] ={"PR_TRUE","PR_FALSE","PR_NULL","STRING","NUMBER","PALABRA NO VALIDA ERROR LEXICO"};
    int estado=5; //se define al comienzo en estado 5 que genera palabra no valida por si exista alguna expresion que no exista en el alfabeto o no represente un token valido
    String salida="";
    String tokens="";
    String fuente="";
    String palabra="";
    
  public int delimitador(char letra){

      //esta funcion se encargara de identificar los simbolos delimitadores de codigos todo simbolo que no se necesite una expresion regular amplia
    for (int i=0;i<signos.length;i++){
        
        if(letra == lexema[i] ){

            salida = salida + signos[i] +" ";
            tokens= signos[i];
            return 0;
        }
    
    }
    
 return 1;

}  
  
  public int ComprobarDelimitador(char letra){

      //esta funcion se encargara de identificar los simbolos delimitadores de codigos todo simbolo que no se necesite una expresion regular amplia
    for (int i=0;i<signos.length;i++){
        
        if(letra == lexema[i] ){

            salida = salida + signos[i] +" ";
            return 0;
        }
    
    }
    
 return 1;

}   
  
  
  
 
   public void funcion(char letra[]){
     //esta funcion detecta las expresiones regulares
       
     for(int i=0;i < letra.length;i++){
         //controla true 
         if(letra[i]== 't'){
             
             i++;
         
                if(letra[i]== 'r'){
                    
                   i++;
                }else{  System.out.println("error");   }
                
                
                    if(letra[i]== 'u'){
                        ; 
                        i++;
                    }
                        if(letra[i]== 'e'){
                            estado=0; 
                            
                            i++;
                        }
                            
           //controla false              }
          }else if(letra[i]=='f'){
                 
                 i++;
                   if(letra[i]== 'a'){
                    
                       i++;
                   }
                       if(letra[i]== 'l'){
                    
                       i++;
                       } 
                       
                         if(letra[i]== 's'){
                    
                            i++;
                           } 
                         
                              if(letra[i]== 'e'){
                    
                                i++;
                                estado=1;
                               
                                }
                 
                 
              //controla Null      
             }else if(letra[i]=='n'){
                
                 i++;
                    if(letra[i]=='u'){
                      i++;
                    
                    }
                       if(letra[i]=='l'){
                          i++;
                              if(letra[i]=='l'){
                                 i++;
                                 estado=2;
                                 
                               }
                        }
             //controla cadena
             }else if(letra[i]=='"'){
             
                 i++;
                 while(letra[i]!='"'  ){
                     i++;
                 
                 }
                  if(letra[i]=='"'){
                                 
                                 estado=3;
                                 
                               }
                  
             //controla la expresion regular de numeros 
             }else if( esnumero(letra[i])==1  ){
                   i++;
                   estado=4;
                   if(letra[i]=='.'){
                     estado=4;
                     i++;
                        if(esnumero(letra[i])==1){ estado=4; } 
                        else{ estado=5; }           
                   }
                   if(letra[i]=='e' || letra[i]=='E'){
                      estado=4;
                      i++;
                      if(esnumero(letra[i])==1){ estado=4; } 
                        else{ estado=5; }
                       
                    }

                
                   
            //controla el fin de linea
              }else if( letra[i]=='e'){
                    i++;
                        if( letra[i]=='o'){
                          i++;
                           if( letra[i]=='f'){
                              i++;
                             System.exit(0);
                        }
                        }
                 
              
              }
       
         }

       
       salida= salida + componente[estado]+" ";
       tokens=componente[estado];
       palabra=String.valueOf(letra);
     }     
     
   public int esnumero(char num){
   //funcion para identificar si un caracter es numerico
   if(num=='0'|| num=='1'||num=='2'||num=='3'||num=='4'||num=='5'||num=='6'||num=='7'||num=='8'||num=='9' ){
       return 1;
       
       
   }
   
   return 0;
   
   }

    public String getSalida() {
        
        
        return salida;
        
        
    }

    public String getTokens() {
        return tokens;
    }

    public String getPalabra() {
        return palabra;
    }
  
   
   
   
   
   
     
   }
 

  
  
  
  
  
    
    
    



