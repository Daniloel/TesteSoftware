package br.fatec.lp2;

public class Triangulo {
    public String verificar(int lado1, int lado2, int lado3) {

        if(lado1+lado2 <= lado3 || lado2+lado3 <= lado1 || lado3+lado1 <= lado2 ){
            return "invalido";
        }else{
            return "escaleno";
        }

    }
}
