package pila.generica;

public interface PilaGenerica<T> {

    //El <T> es para hacer la interfaz generica, se establece el tipo a la  hora de declarar la pila//
    
    public boolean empty();

    public boolean full();

    public T pop();

    public void push(T item);

    public static void main(String[] args) {

    }

}
