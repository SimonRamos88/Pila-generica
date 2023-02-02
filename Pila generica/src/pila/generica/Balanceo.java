
package pila.generica;


public class Balanceo {
    private final char [] cerrados =  {'}',']',')'};
    private char[] brackets;
    private Pila pila;
    
    public int EsCerrado(char bracket){
        int i = 0;
        int len = this.cerrados.length;
        while(i<len && this.cerrados[i] != bracket){
            i++;
        }
        return i; /*Me va a devolver la posicion en las que se 
        encuentra el bracket en la lista de cerrados. Si no está en la lista,
        devolverá un 3*/
    }
    
    public void Apilar(){
        for(char x:this.brackets){
            int i = EsCerrado(x);
            if(i>=3){
                this.pila.push(x);
            }else{
                char abierto = (char) pila.pop();
                boolean validacion = Comparar(abierto,i);
                if(!validacion){
                    throw new RuntimeException("Los corchetes estan mal pa");
                }
            }
        }
        System.out.println("Los corchetes estan bien");
    }
    
    public boolean Comparar(char abierto, int posCerrado){
        boolean bandera = false; 
        if(posCerrado == 0 && (abierto=='{')){
            bandera = true;
        }else if(posCerrado == 1 && (abierto == '[')){
            bandera = true;
        } else if(posCerrado==2 && (abierto=='(')){
            bandera = true;
        }
        return bandera;
    }
    
    public Balanceo(String input){
        this.brackets = input.toCharArray();
        this.pila = new Pila(brackets.length);
    }
    
    public static void main(String[] args) {
        Balanceo xd = new Balanceo("{([()])())}"); //En este input estan mal
        //En este input estan bien {(([()])())}
        xd.Apilar();
        System.out.println(xd.pila.toString());
    }
}
