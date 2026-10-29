package br.com.poo;
import java.util.Random;
public class App{
    public static void main( String [] args ) throws Exception{
        var gerador = new Random();
        var v = new VetorDinamico();
        while (true){ 
            var ehParaAdicionar = gerador.nextBoolean();
            if(ehParaAdicionar){
                var elemento = gerador.nextInt(10) + 1;
                System.out.println("Adicionando...");
                v.adicionar(elemento);
            }
            else{
                System.out.println("Removendo...");
                v.remover();
            }
            var elemento = gerador.nextInt(10) + 1;
            v.adicionar(elemento);
            System.out.println(v);
            System.out.println("==========================");
            Thread.sleep(2000);
        }
    }
}