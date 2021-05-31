package maratonaProgramacao;

public class PoliciaLadrao {
    public static void main(String[] args) {
        int[][] vector = {{0,1,0}, {0,0,1}, {1,0,0}};

        if(function(vector,0,0,2,2)){
            System.out.println("Polícia");
        }else{
            System.out.println("Ladrão");
        }

        for(int[] vec : vector){
            for (int v : vec){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static boolean function(int[][] vector, int posicaoXPolicia, int posicaoYPolicia, int posicaoXLadrao, int posicaoYLadrao){
        int value = vector[posicaoXPolicia][posicaoYPolicia];
        vector[posicaoXPolicia][posicaoYPolicia] = 2;

        System.out.println("Posição x ladrão :" + posicaoXPolicia);
        System.out.println("Posição y ladrão: " + posicaoYPolicia);
        for(int[] vec : vector){
            for (int v : vec){
                System.out.print(v + " ");
            }
            System.out.println();
        }

        if (posicaoXPolicia == posicaoXLadrao && posicaoYPolicia == posicaoYPolicia) {
            return true;
        }

        boolean resultado = false;
        if(posicaoYPolicia < 2 && vector[posicaoXPolicia][posicaoYPolicia + 1] == 0){
            resultado |= function(vector, posicaoXPolicia, posicaoYPolicia + 1, posicaoXLadrao, posicaoYLadrao);
        }
        if (!resultado){
            // mover para baixo
            if(posicaoXPolicia < 2 && vector[posicaoXPolicia + 1][posicaoYPolicia] == 0){
                resultado |= function(vector, posicaoXPolicia + 1, posicaoYPolicia, posicaoXLadrao, posicaoYLadrao);
            }
            // movendo para esquerda
            if(posicaoYPolicia > 0  && vector[posicaoXPolicia][posicaoYPolicia - 1] == 0){
                resultado |= function(vector, posicaoXPolicia, posicaoYPolicia - 1, posicaoXLadrao, posicaoYLadrao);
            }
            // movendo para cima
            if(posicaoXPolicia > 0 && vector[posicaoXPolicia - 1][posicaoYPolicia] == 0){
                resultado |= function(vector, posicaoXPolicia - 1, posicaoYPolicia, posicaoXLadrao, posicaoYLadrao);
            }

        }
        vector[posicaoXPolicia][posicaoYPolicia] = value;
        return resultado;
    }
}
