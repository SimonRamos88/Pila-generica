
package pila.generica;



public class Posfijo {
    private final char[] operators=  {'/','+','-','*','^'};
    
    private char[] nums;
    private Pila pila;
    
    
    public boolean EsOperador(char Char){
        int i = 0;
        int len = this.operators.length;
        while(i<len && this.operators[i] != Char){
            i++;
        }
        return i<5;
    }
   
    
    public int Procesar(){
        int i = 0;
        System.out.println(nums.length);
        while(i<nums.length){
            char caracter = this.nums[i];
            System.out.println(!EsOperador(caracter));
            if(!EsOperador(caracter)){
               this.pila.push(caracter);
            }else{
               Operar(caracter);
            }
           i++;
        }
        return (int) this.pila.pop();
    }
    
    public void Operar(char operator){
        System.out.println(pila.pop());
        char num1C = (char) pila.pop();
        int num1 = Character.getNumericValue(num1C);
        char num2C = (char) pila.pop();
        int num2 = Character.getNumericValue(num2C);
        /*Dado que el pop devuelve un objeto T, primero debemos castearlo a char
        y de char castearlo a int. Por alguna razon no podemos castearlo directo 
        de object a int*/
        
        /*
        int num1 = (Integer) pila.pop();
        int num2 = (Integer) pila.pop();
        */
        int res;
        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2-num1;
                break;
            case '/':
                res = num2/num1;
                break;
            case '*':
                res = num1*num2;
                break;
            default:
                res= num2^num1;
                break;
        }
        pila.push(res);
    }
    
    public Posfijo(String input){
        this.nums = input.toCharArray();
        this.pila = new Pila(nums.length);
    }
    
    public static void main(String[] args) {
        Posfijo xd = new Posfijo("523+*");
        /*
        System.out.println(xd.nums.length);
        System.out.println(xd.EsOperador('5'));
        xd.Procesar(0);
        System.out.println(xd.pila.toString());*/
        System.out.println(xd.Procesar());
        
    }
}
