using Calculador;

namespace Testes;

public class CalculadoraTestes
{
    [Theory]
    [InlineData(1, 1, 2)]
    [InlineData(2, 2, 4)]
    [InlineData(2, 3, 5)]
    [InlineData(10000, 1, 10001)]
    public void TestaSoma(int a, int b, int c)
    {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.Somar(a, b);

        Assert.Equal(c, resultado);
    }

    [Theory]
    [InlineData(1, 1, 0)]
    [InlineData(2, 3, -1)]
    [InlineData(2, 7, -5)]
    [InlineData(10000, 1, 9999)]
    public void TestaSubtracao(int a, int b, int c)
    {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.Subtrair(a, b);

        Assert.Equal(c, resultado);
    }

    [Theory]
    [InlineData(1, 1, 1)]
    [InlineData(2, 3, 6)]
    [InlineData(2, 7, 14)]
    [InlineData(10000, 1, 10000)]
    [InlineData(-1, 9, -9)]
    [InlineData(-1, -9, 9)]
    public void TestaMultiplicacao(int a, int b, int c)
    {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.Multiplicar(a, b);

        Assert.Equal(c, resultado);
    }

    [Theory]
    [InlineData(1, 1, 1)]
    [InlineData(4, 2, 2)]
    [InlineData(12, 4, 3)]
    [InlineData(8, -4, -2)]
    public void TestaDivisao(int a, int b, int c)
    {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.Dividir(a, b);

        Assert.Equal(c, resultado);
    }

    [Theory]
    [InlineData(1, 0)]
    [InlineData(0, 0)]
    public void TestaDivisaoPorZero(int a, int b)
    {
        Calculadora calculadora = new Calculadora();

        try
        {
            int resultado = calculadora.Dividir(a, b);
            Assert.Fail();
        }
        catch (DivisionByZeroException)
        {
            
        }
        catch
        {
            Assert.Fail();
        }
    }

    [Fact]
    public void TetaHistorico()
    {
        Calculadora calculadora = new Calculadora();

        calculadora.Somar(1, 1);
        calculadora.Subtrair(1, 1);
        calculadora.Multiplicar(1, 1);
        calculadora.Dividir(1, 1);

        var historico = calculadora.Historico;

        Assert.Equal(4, historico.Count);
    }
}