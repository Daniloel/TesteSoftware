package lp2;

public class Desenvolvedor {

    public double salario(double salarioFunc, String cargo) {
        double desconto = 0;

        switch (cargo) {
            case "DESENVOLVEDOR":
                desconto = (salarioFunc >= 3000) ? 0.20 : 0.10;
                break;
            case "DBA":
            case "TESTADOR":
                desconto = (salarioFunc >= 2000) ? 0.25 : 0.15;
                break;
            case "GERENTE":
                desconto = (salarioFunc >= 5000) ? 0.30 : 0.20;
                break;

        }

        return salarioFunc - (desconto * salarioFunc);
    }

}
