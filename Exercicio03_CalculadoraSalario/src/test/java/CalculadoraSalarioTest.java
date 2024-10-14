import lp2.Desenvolvedor;
import org.junit.Assert;
import org.junit.Test;

public class CalculadoraSalarioTest {

    @Test
    public void testSalarioDesenvolvedor() {
        Desenvolvedor cut = new Desenvolvedor();
        double salarioMensal = cut.salario(2500, "DESENVOLVEDOR");
        Assert.assertEquals(2250, salarioMensal, 0.001); // 10% de desconto
    }

    @Test
    public void testSalarioDesenvolvedor2() {
        Desenvolvedor cut = new Desenvolvedor();
        double salarioMensal = cut.salario(3000, "DESENVOLVEDOR");
        Assert.assertEquals(2400, salarioMensal, 0.001); // 20% de desconto
    }

    @Test
    public void testSalarioDBAComDescontoAlto() {
        Desenvolvedor cut = new Desenvolvedor();
        double salarioMensal = cut.salario(2500, "DBA");
        Assert.assertEquals(1875, salarioMensal, 0.001); // 25% de desconto
    }

    @Test
    public void testSalarioDBAComDescontoBaixo() {
        Desenvolvedor cut = new Desenvolvedor();
        double salarioMensal = cut.salario(1500, "DBA");
        Assert.assertEquals(1275, salarioMensal, 0.001); // 15% de desconto
    }

    @Test
    public void testSalarioTestadorComDescontoAlto() {
        Desenvolvedor cut = new Desenvolvedor();
        double salarioMensal = cut.salario(2500, "TESTADOR");
        Assert.assertEquals(1875, salarioMensal, 0.001); // 25% de desconto
    }

    @Test
    public void testSalarioTestadorComDescontoBaixo() {
        Desenvolvedor cut = new Desenvolvedor();
        double salarioMensal = cut.salario(1500, "TESTADOR");
        Assert.assertEquals(1275, salarioMensal, 0.001); // 15% de desconto
    }

    @Test
    public void testSalarioGerenteComDescontoAlto() {
        Desenvolvedor cut = new Desenvolvedor();
        double salarioMensal = cut.salario(6000, "GERENTE");
        Assert.assertEquals(4200, salarioMensal, 0.001); // 30% de desconto
    }

    @Test
    public void testSalarioGerenteComDescontoBaixo() {
        Desenvolvedor cut = new Desenvolvedor();
        double salarioMensal = cut.salario(4000, "GERENTE");
        Assert.assertEquals(3200, salarioMensal, 0.001); // 20% de desconto
    }

}
