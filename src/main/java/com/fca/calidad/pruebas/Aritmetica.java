package com.fca.calidad.pruebas;

public class Aritmetica {
private float ultimoResultado;

public float suma(float primerSumando, float segundoSumando) {
	return ultimoResultado = primerSumando + segundoSumando;
}

public float resta(float minuendo, float sustraendo) {
	return ultimoResultado = minuendo - sustraendo;
}

public float multiplicacion(float primerFactor, float segundoFactor) {
	return ultimoResultado = primerFactor * segundoFactor;
}

public float divisionEntera(double dividendo, double divisor) {
	return ultimoResultado = (float) (dividendo / divisor);
}

public float division(double arg1, double arg2) {
	return ultimoResultado = (float) (arg1 / arg2);
}

public float getUltimoResultado() {
	return ultimoResultado;
}

}