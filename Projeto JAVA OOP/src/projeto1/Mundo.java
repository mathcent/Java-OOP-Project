/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

/**
 *
 * @author Windows
 */
public class Mundo {
    private int[][] mapa = new int[30][60];
    private Hospital[] hospitais = new Hospital[3];
    private Pessoa[] pessoas;
    private int contPs, contPd, contP, tempo;
    
    public Mundo(int ps, int pd){
        contPs = ps;
        contPd = pd;
        contP = ps + pd;
        tempo = 0;
        pessoas = new Pessoa[contP];
        
        for(int i=0;i<contPs;i++)
            pessoas[i] = new PessoaSaudavel();
        
        for(int i=contPs;i<contPs + contPd;i++)
            pessoas[i] = new PessoaDoente();
        
        
        
        for(int i=0;i<3;i++){
            hospitais[i] = new Hospital();
        }
        
       
    }
    public void desenhaMundo(){
        System.out.printf("Tempo passado: %d segundo(s)\n", tempo);
        System.out.printf("Pessoas Saudaveis: %d \t Pessoas Doentes: %d\n", contPs, contPd);
        System.out.printf("Total de Pessoas: %d\n", contP);
        String[] ANSI = new String[6];
        ANSI[2] = "\u001B[0m"; //Reset
        ANSI[0] = "\u001B[40m"; //Preto
        ANSI[5] = "\u001B[42m"; //Verde
        ANSI[4] = "\u001B[43m"; //Amarelo
        ANSI[3] = "\u001B[44m"; //Azul
        ANSI[1] = "\u001B[47m"; //Branco
         for(int i=0;i<30;i++){
            for(int j=0;j<60;j++){
                if(i == 0)
                    mapa[i][j] = 1;
                else if(j == 0)
                    mapa[i][j] = 1;
                else if(i == 29)
                    mapa[i][j] = 1;
                else if(j == 59)
                    mapa[i][j] = 1;
                else
                    mapa[i][j] = 0;
            }
        }
        for(int i=0;i<3;i++){
            for(int a=hospitais[i].getCy()-hospitais[i].getTamanho();a<= hospitais[i].getCy()+hospitais[i].getTamanho();a++){
                for(int b=hospitais[i].getCx()-hospitais[i].getTamanho();b<= hospitais[i].getCx()+hospitais[i].getTamanho();b++){
                    mapa[a][b] = hospitais[i].getCor();
                }
            }
        }
        for(int i=0;i<contP;i++){
            if(mapa[pessoas[i].getY()][pessoas[i].getX()] == 5 && pessoas[i].getCor() == 4){
                pessoas[i] = new PessoaSaudavel(pessoas[i].getX(), pessoas[i].getY());
                contPd--;
                contPs++;
            }
            if(mapa[pessoas[i].getY()][pessoas[i].getX()] != 4)
                mapa[pessoas[i].getY()][pessoas[i].getX()] = pessoas[i].getCor();
            
        }
        for(int i=0;i<contP;i++){
            if(mapa[pessoas[i].getY()][pessoas[i].getX()] == 4 && pessoas[i].getCor() == 3){
                pessoas[i] = new PessoaDoente(pessoas[i].getX(), pessoas[i].getY(), tempo);
                contPd++;
                contPs--;
            }
            mapa[pessoas[i].getY()][pessoas[i].getX()] = pessoas[i].getCor();
        }
        for(int i=0;i<30;i++){
            for(int j=0;j<60;j++){
                System.out.printf(ANSI[mapa[i][j]] + " ");
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
        tempo++;
        for(int i=0;i<contP;i++){
            if(Math.abs(pessoas[i].getTempo() - tempo) == 30 && pessoas[i].getCor() == 4){
               pessoas[i].setCor(0);
               contPd--;
            }
            if(pessoas[i].getCor()!= 0)
               pessoas[i].mover();
         }
        contP = contPd+contPs;
    }
}