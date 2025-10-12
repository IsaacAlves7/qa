var nome = "Minha calculadora V1";

function soma(a, b) {    
    return a + b;
}

test("soma dois números positivos", () => {
  expect(soma(2, 3)).toBe(5); // ✅ teste válido
});

function mult(a,b){
    return a * b;
}

function sub(a,b){
    return a-b;
}

function div(a,b){
    return a/b;
}

module.exports = {
    soma,
    mult,
    sub,
    div,
    nome
};