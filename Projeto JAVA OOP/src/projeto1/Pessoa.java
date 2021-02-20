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
abstract class Pessoa {
    private int x, y, cor, tempo;
   
    public Pessoa(){
        Random pos = new Random();
        setX(pos.nextInt(60));
        setY(pos.nextInt(30));
        setCor(0);
        setTempo(0);
    }
    
    public void setX(int iX){
        this.x = iX;
    }
    public int getX(){
        return x;
    }
    
    public void setY(int iY){
        this.y = iY;
    }
    public int getY(){
        return y;
    }
    
    public void setCor(int cor){
        this.cor = cor;
    }
    public int getCor(){
        return cor;
    }
    public void setTempo(int t){
        this.tempo = t;
    }
    public int getTempo(){
        return tempo;
    }
    public void mover(){
        if(getCor() == 0)
            return;
        Random move_type = new Random();
        int r = move_type.nextInt(4);
        if(r == 0)
            setX((getX()+1) % 60);
        if(r == 1)
            setX(((getX()-1) + 60) % 60);
        if(r == 2)
            setY((getY()+1) % 30);
        if(r == 3)
            setY(((getY()-1) + 30) % 30);
    }
}
