package br.com.Vitor.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.Vitor.cm.excecao.explosaoException;

class CampoTeste {

	private Campo campo = new Campo(3,3);
	
	@BeforeEach//para cada teste ele ira chamar a funcao
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo vizinho = new Campo(3,2);
		Boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);//verifica se o resultado é true para o teste dar positivo
	}
	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo vizinho = new Campo(3,4);
		Boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);//verifica se o resultado é true para o teste dar positivo
	}
	@Test
	void testeVizinhoRealDistancia1Cima() {
		Campo vizinho = new Campo(2,3);
		Boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);//verifica se o resultado é true para o teste dar positivo
	}
	@Test
	void testeVizinhoRealDistancia1baixo() {
		Campo vizinho = new Campo(4,3);
		Boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);//verifica se o resultado é true para o teste dar positivo
	}
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(2,2);
		Boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);//verifica se o resultado é true para o teste dar positivo
	}
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1,1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testemarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	@Test
	void testeAberto() {
		campo.abrir();
		assertTrue(campo.isAberto());
	}
	@Test
	void testeNaoAberto() {
		
		assertFalse(campo.isFechado());
	}
	@Test
	void testeAbertoComVizinho() {
		Campo Vizinho1 = new Campo(1,1);
		Campo Vizinho2 = new Campo(2,2);
		Vizinho2.adicionarVizinho(Vizinho1);
		campo.adicionarVizinho(Vizinho2);
		campo.abrir();
		assertTrue(Vizinho1.isAberto() && Vizinho2.isAberto());
	}
	@Test
	void testeAbertoComVizinhominado() {
		Campo Vizinho1 = new Campo(1,1);
		Campo Vizinho2 = new Campo(2,2);
		Vizinho2.adicionarVizinho(Vizinho1);
		campo.adicionarVizinho(Vizinho2);
		Vizinho1.Minar();
		campo.abrir();
		assertFalse(Vizinho1.isAberto());
	}
	@Test
	void testeAbrirMinado() {
		campo.Minar();
		assertThrows(explosaoException.class, ()->{
			campo.abrir();
		});
	}
	

}
