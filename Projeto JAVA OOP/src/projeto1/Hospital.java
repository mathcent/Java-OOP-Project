/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;
import java.util.Random;
/**
 *
 * @author Windows
 */
public class Hospital {
    private int cx, cy, tamanho, cor;
    
    public Hospital(){
        Random rand = new Random();
        setTamanho(rand.nextInt(3) + 1);
        setCx(rand.nextInt(60 - (tamanho*2)) + tamanho);
        setCy(rand.nextInt(30 - (tamanho*2)) + tamanho);        
        setCor(5);
    }
    
    public void setCor(int c){
        this.cor = c;
    }
    public int getCor(){
        return cor;
    }
    public void setCx(int x){
        this.cx = x;
    }
    public int getCx(){
        return cx;
    }
    public void setCy(int y){
        this.cy = y;
    }
    public int getCy(){
        return cy;
    }
    public void setTamanho(int t){
        this.tamanho = t;
    }
    public int getTamanho(){
        return tamanho;
    }
}
