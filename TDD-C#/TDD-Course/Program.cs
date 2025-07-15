using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TDD_Course
{
    class Program
    {
        static void Main(string[] args)
        {
            string empty = NaiveCanonicalizer.GetCanonicalForm("");
            Console.WriteLine(empty == "");
            empty = NaiveCanonicalizer.GetCanonicalForm(" ");
            Console.WriteLine(empty == "");
            empty = NaiveCanonicalizer.GetCanonicalForm("    ");
            Console.WriteLine(empty == "");

            Console.WriteLine(NaiveCanonicalizer.GetCanonicalForm(" Katie Melua life wonderfuL  "));
            Console.WriteLine(NaiveCanonicalizer.GetCanonicalForm("Katie     Melua   life    wonderfuL  "));

            Console.WriteLine(NaiveCanonicalizer.GetCanonicalForm("Wonderful Life Katie Melua"));
            Console.WriteLine(NaiveCanonicalizer.GetCanonicalForm("life Wonderful katie Melua"));
            Console.WriteLine(NaiveCanonicalizer.GetCanonicalForm("Katie Melua life wonderfuL"));

            Console.Read();
        }
    }
}
