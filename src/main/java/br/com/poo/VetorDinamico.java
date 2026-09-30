package br.com.poo;

public class VetorDinamico {
    private int [] elementos;
    private int quantidade;
    private int capacidade;
    private final static int PADRAO_CAPACIDADE_INICIAL = 4;

    public VetorDinamico(){
        this(PADRAO_CAPACIDADE_INICIAL);
        // elementos = new int[PADRAO_CAPACIDADE_INICIAL];
        // capacidade = PADRAO_CAPACIDADE_INICIAL;
        // quantidade = 0;
    }

    public VetorDinamico(int capacidadeInicialDesejada){
            if(capacidadeInicialDesejada > 0){
                elementos = new int[capacidadeInicialDesejada];
                capacidade = capacidadeInicialDesejada;
            }
            else{
                elementos = new int[PADRAO_CAPACIDADE_INICIAL];
                capacidade = PADRAO_CAPACIDADE_INICIAL;
            }
        quantidade = 0;
    }

    public void adicionar(int e){
        //ArrayIndexOutOfBoundsException
        elementos[quantidade++] = e;
        // if(quantidade < capacidade){
        //     elementos[quantidade] = e;
        //     quantidade++;
        // }
    }
}