package br.com.Vitor.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.Vitor.cm.excecao.explosaoException;

public class Campo {

	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha -  vizinho.linha);//math.abs retorna o valor absoluto
		int deltaColuna = Math.abs(coluna -  vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
		
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
			}else if(deltaGeral == 2 && diagonal) {
				vizinhos.add(vizinho);
				return true;
			}else {
				return false;
			}
	}
	void alternarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
	}
	
	boolean abrir() {
		if(!aberto && !marcado) {
			aberto = true;
			
			if(minado) {
				throw new explosaoException();
			}
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		} else {
		return false;
		}
	}
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	boolean Minar() {
		return minado = true;
	}
	boolean isMinado() {
		return minado;
	}
	
	boolean isMarcado() {
		return marcado;
	}
	boolean isAberto() {
		return aberto;
	}
	boolean isFechado() {
		return aberto;
	}
	
	public int getLinha() {
		return linha;
	}
	public int getcoluna() {
		return coluna;
	}
	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}
	
	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void resetar() {
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	public String toString() {
		if(marcado) {
			return "[x]";
		}else if(aberto && minado) {
			return "[*]";
		}else if (aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
		}else if(aberto) {
			return "[] ";
		}else {
			return "[?]";
		}
	}

	
}
