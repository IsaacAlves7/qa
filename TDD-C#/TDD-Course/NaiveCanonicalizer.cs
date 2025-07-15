using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TDD_Course
{
    public class NaiveCanonicalizer
    {
        public static string GetCanonicalForm(string searchTerm) {
            if(searchTerm==null)
                throw new ArgumentNullException("searchTerm");

            return searchTerm
                .Split(new[] {' '}, StringSplitOptions.RemoveEmptyEntries)
                .Select(x => x.ToUpper())
                .OrderBy(x => x)
                .Aggregate("", (x, y) => x + " " + y)
                .Trim();
        }
    }
}
