import java.util.Scanner;
import java.util.Stack;
public class TorreHanoi_Deber {
    static Stack<String> origen = new Stack<>();
    static Stack<String> destino = new Stack<>();
    static Stack<String> fin = new Stack<>();
    static int num;
    int llenar;
    Scanner entrada = new Scanner(System.in);
    public void cargar(){
        System.out.print("INGRESE EL NUMERO DE AROS: ");
        num = entrada.nextInt();
        llenar = num;
        for(int i=0; i<num; i++){
            origen.push(Integer.toString(llenar));
            llenar--;
        }
    }
    public void mover(){
        System.out.println("");
        System.out.println("TORRE 1: " + origen);
        System.out.println("");
        destino.push(origen.peek());
        origen.pop();
        System.out.println("TORRE 1: " + origen);
        System.out.println("TORRE 2: " + destino);
        System.out.println("TORRE 3: " + fin);
        System.out.println("");
        destino.push(origen.peek());
        origen.pop();
        System.out.println("TORRE 1: " + origen);
        System.out.println("TORRE 2: " + destino);
        System.out.println("TORRE 3: " + fin);
        System.out.println("");
        fin.push(destino.peek());
        destino.pop();
        System.out.println("TORRE 1: " + origen);
        System.out.println("TORRE 2: " + destino);
        System.out.println("TORRE 3: " + fin);
        System.out.println("");
        fin.push(origen.peek());
        origen.pop();
        System.out.println("TORRE 1: " + origen);
        System.out.println("TORRE 2: " + destino);
        System.out.println("TORRE 3: " + fin);
    }

    public static void TorreHanoi_Deber(int num, Stack<String> origen, Stack<String> destino, Stack<String> fin){
        if(num==1){
            System.out.println("MUEVA EL DISCO " + num + "DE LA TORRE " + origen + "HASTA LA TORRE " + fin);
            TorreHanoi_Deber.fin.push(origen.pop());
        } else{
            TorreHanoi_Deber(num-1, origen, fin, destino);
            System.out.println("MUEVA EL DISCO " + num + "DE LA TORRE " + origen + "HASTA LA TORRE " + fin);
            TorreHanoi_Deber.fin.push(origen.pop());
            TorreHanoi_Deber(-1, destino, origen, fin);
        }
    }

    public static void main(String[] args) {
        TorreHanoi_Deber torres = new TorreHanoi_Deber();
        torres.cargar();
        torres.TorreHanoi_Deber(num, origen, destino, fin);
        System.out.println("TORRE 1: " + origen + "\n TORRE 2: " + destino + "\n TORRE 3: " + fin);
    }
}