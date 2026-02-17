namespace Calculador;

public class Calculadora: ICalculadora
{
    private List<CalculadoraHistorico> historico = [];

    public Calculadora()
    {
        
    }

    public int Somar(int a, int b) 
    {
        Historico.Add(new CalculadoraHistorico() 
        {
            OperacaoTipo = EOperacaoTipo.Somar,
            Argumentos = new List<int> {a, b}
        });

        return a + b;
    }

    public int Subtrair(int a, int b)
    {
         Historico.Add(new CalculadoraHistorico() 
         {
            OperacaoTipo = EOperacaoTipo.Subtrair,
            Argumentos = new List<int> {a, b}
        });

        return a - b;
    }

    public int Multiplicar(int a, int b)
    {
         Historico.Add(new CalculadoraHistorico() 
         {
            OperacaoTipo = EOperacaoTipo.Multiplicar,
            Argumentos = new List<int> {a, b}
        });

        return a * b;
    }

    public int Dividir(int a, int b)
    {
        if(b == 0)
            throw new DivisionByZeroException();

         Historico.Add(new CalculadoraHistorico() 
         {
            OperacaoTipo = EOperacaoTipo.Dividir,
            Argumentos = new List<int> {a, b}
        });

        return a / b;
    }

    public List<CalculadoraHistorico> Historico => historico;
}
