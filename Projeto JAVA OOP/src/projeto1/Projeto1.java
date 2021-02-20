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
public class Projeto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Mundo M = new Mundo(100, 1);
       while(true){
           M.desenhaMundo();
           try{
            Thread.sleep(1000);
           }
           catch (InterruptedException e) {
                System.out.println("InterruptedException Exception" + e.getMessage());
            }
           //new java.util.Scanner(System.in).nextLine();
       }
    }
    
}
