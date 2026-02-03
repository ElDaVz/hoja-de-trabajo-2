package app;
/**
 * Define el contrato para una calculadora.
 * Las implementaciones deben evaluar una expresión representada como texto
 * y devolver un resultado entero.
 */
public interface Calc {

    int operate(String input);
}
