
import java.util.Arrays;
public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private char elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public MiArrayList() {
        size=0;
        elements=new char[DEFAULT_CAPACITY];
    }     

    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() {
        return size;
    }   
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(char a) {
       size++;//c1
       if(size!=1&&(size-1)%10==0){
        char elements2[] =new char[2*(size-1)];//c2
        for(int i=0; i<elements.length;i++){
            elements2[i]=elements[i];//n*c3
        }
         elements=elements2;//c4
        }
      elements[size-1]=a;//c5
      //complejidad: t(n)=n*c1+c2;
      
     //Este método no nos parece apto para ser utilizado en un editor de texto porque en un editor de texto 
     //se necesita que en menos de un segundo la letra aparezca y al haber muchos caracteres, 
     //el algoritmo se volvería muy lento y no funcionaría con la rapidez necesaria. 
       
     }
       
    
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public char get(int i) throws ArrayIndexOutOfBoundsException{
       
        if(i<=0||i>=size){
          throw new ArrayIndexOutOfBoundsException("perdon usuario, pero esta posición no existe");
       }
       else{
        return elements[i];
        }
       
    }
    
    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add(int index, char a) {
       size++;//c1
        if(size!=1&&(size-1)%10==0){//c2
        char elements2[] =new char[2*(size-1)];//c3
        for(int i=0; i<elements.length;i++){
            elements2[i]=elements[i];//n*c4
        }
        elements=elements2;//c2
    }

    for(int i=size-1;i>index;i--){
            elements[i]=elements[i-1];//n*c3
     }
     elements[index]=a;//c4
     //T(n)=2*n*c1+c2
    
    } 

    /**
    * @param index es la posicion en la cual se va agregar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index){
        size--;
        for(int i=index;i<elements.length-1;i++){
            elements[i]=elements[i+1];
        }
    }
}