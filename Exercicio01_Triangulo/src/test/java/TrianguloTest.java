import br.fatec.lp2.Triangulo;
import org.junit.Assert;
import org.junit.Test;

public class TrianguloTest {

    @Test
    public void validarTrianguEscaleno()
    {
        Triangulo cut = new Triangulo();
        String resultado = cut.verificar(3,4,5);
        Assert.assertEquals("escaleno",resultado);


    }

    @Test
    public void validarTrianguloInvalido()
    {
        Triangulo cut = new Triangulo();
        String resultado = cut.verificar(3,2,6);
        Assert.assertEquals("invalido",resultado);
    }

    @Test
    public void validarTrianguloInvalido2()
    {
        Triangulo cut = new Triangulo();
        String resultado = cut.verificar(6,3,2);
        Assert.assertEquals("invalido",resultado);
    }

    @Test
    public void validarTrianguloInvalido3()
    {
        Triangulo cut = new Triangulo();
        String resultado = cut.verificar(2,6,3);
        Assert.assertEquals("invalido",resultado);
    }
}
