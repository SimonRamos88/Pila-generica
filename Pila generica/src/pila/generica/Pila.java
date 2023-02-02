
package pila.generica;

public class Pila<T>  implements PilaGenerica<T>{
    private static final int Ngen = 5;
    public T[] Arreglo;
    private int cont;
    private int n; 
    
    public boolean full(){
        return cont == n;
    }
    
    public boolean empty(){
        return cont == 0;
    }
    public void push(T element){
        if(!full()){
            int cont = this.cont;
            T[] arreglo = this.Arreglo;
            arreglo[cont] = element;
            this.cont++;
        }
    }
    
    /*
    public T pop() {
        if(empty())
        throw new RuntimeException("Stack is empty");
        this.cont--;
        return Arreglo[cont];
        }*/
    
    
    public T pop(){
        T element = (T) new Object();
        if(!empty()){
            this.cont -= 1;
            element = this.Arreglo[cont];           
        }
        return element;
    }
    
    // constructors

    public Pila(){       
        this(Ngen);
    }
    public Pila(int n){       
        T[] arreglo = (T[]) new Object[n];
        this.Arreglo = arreglo ;
        this.cont = 0;
        this.n = n;
    }
    
    @Override
    
    public String toString(){
        T[] arreglo = this.Arreglo;
        String cad = "[ ";
        int i = 0;
        while(i<this.cont){       
            cad += arreglo[i] + " ";
            i++;
        }
       
        cad += "]";
        return cad;
    }
    
    public static void main(String[] args) {
        Pila mipila = new Pila(3);
        mipila.push("A");
        
        mipila.push("B");
        mipila.push("C");
        mipila.push("D");
        
        
        
        System.out.println(mipila.toString());
        String xd = (String) mipila.pop();
        
        
        System.out.println(xd);
        System.out.println(mipila.n);
        System.out.println(mipila.toString());
    }
    

    
}
