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
public class PessoaDoente extends Pessoa {
    private Virus V;
    public PessoaDoente(){
        setCor(4);
    }
    public PessoaDoente(int x, int y, int tempo){
        setX(x);
        setY(y);
        setCor(4);
        setTempo(tempo);
    }
    
    
}
