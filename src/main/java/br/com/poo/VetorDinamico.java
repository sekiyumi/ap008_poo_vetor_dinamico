package br.com.poo;

public class VetorDinamico {
    private int [] elementos;
    private int quantidade;
    private int capacidade;
    private final static int PADRAO_CAPACIDADE_INICIAL = 4;

    public VetorDinamico(){
        this(PADRAO_CAPACIDADE_INICIAL);
        //elementos = new int[PADRAO_CAPACIDADE_INICIAL];
        //capacidade = PADRAO_CAPACIDADE_INICIAL;
        //quantidade = 0;
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

    public boolean estaCheio(){
        //return quantidade == capacidade ? true : false;
        return (quantidade == capacidade);
    }

    public boolean estaVazio(){
        return quantidade == 0;
    }

    public void adicionar(int e){
        if(estaCheio())
            aumentarCapacidade();
        //ArrayIndexOutOfBoundsException
        elementos[quantidade++] = e;
        //if(quantidade < capacidade){
        //    elementos[quantidade] = e;
        //    quantidade++;
        //}
    }

    public void redimensionar(double fatorRedimensionamento){
        int [] aux = new int[(int) (capacidade * fatorRedimensionamento)];
        for(var i=0; i<quantidade; i++){
            aux[i] = elementos[i];
        }
        elementos = aux;
        capacidade *= (int)fatorRedimensionamento;
    }

    public void aumentarCapacidade(){
        int[] aux = new int[capacidade * 2];
        for(int i = 0; i<quantidade; i++){
            aux[i] = elementos[i];
        }
        elementos = aux;
        capacidade *= 2;
    }

    //escrever o metodo remover (ele sempre remove o mais a direita possivel)
    //ele corta sua capacidade pela metade quando fica um quarto cheio
    //escreva um metodo separado para reduzir a capacidade
    public void reduzirCapacidade(){
        int [] aux = new int[capacidade / 2];
        for(int i = 0; i<quantidade; i++){
            aux[i] = elementos[i];
        }
        elementos = aux;
        capacidade /= 2;
    }

    public void remover(){
        if(!estaVazio()){
            quantidade--;
            if(capacidade > PADRAO_CAPACIDADE_INICIAL && quantidade <= capacidade/4){
                redimensionar(1/2D);
            }
        }
    }

    @Override 
    public String toString(){
        var sb = new StringBuilder();
        sb.append("Quantidade: ").append(quantidade);
        sb.append("\n");
        sb.append("Capacidade: ").append(capacidade);
        sb.append("\n");

        if(!estaVazio()){
            sb.append("Elementos: ").append("\n");
            //for(int e : elementos){
            //    sb.append(e).append(" ");
            //}
            for(var i = 0; i<quantidade; i++){
                sb.append(elementos[i]).append(" ");
            }
        }
        return sb.toString();
    }
}