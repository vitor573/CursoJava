package br.com.Vitor.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void testarSeIagualADois() {
		int a = 1 + 1;
	
		assertEquals(2, a);// caso o qeu for pedido esteja de acordo o teste tera resultado aprovado
	}
	@Test // é necessario colocar ppara que seja testado 
	void testarSeIgualATres() {
		int x = 2 + 10 - 9;
		
		assertEquals(3, x);
	}

}
