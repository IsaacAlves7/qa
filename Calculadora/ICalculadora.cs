namespace Calculador;

public interface ICalculadora
{
    int Somar(int a, int b);
    int Subtrair(int a, int b);
    int Multiplicar(int a, int b);
    int Dividir(int a, int b);

    List<CalculadoraHistorico> Historico { get; }
}