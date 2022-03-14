package Personagem;

public class Personagem {

	private double vida = 100;
	private double ataque, defesa;
	private String nome;
	
	public Personagem() {
		
	}
	
	public Personagem(String nome) {
	
		setNome(nome);
	}
	
	public double getVida() {
		return vida;
	}
	public void setVida(double novaVida) {
		this.vida = novaVida;
	}
	public double getAtaque() {
		return ataque;
	}
	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}
	public double getDefesa() {
		return defesa;
	}
	public void setDefesa(double defesa) {
		this.defesa = defesa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null ) {
		this.nome = nome;
		}
	}
	 
	public void atacar(Personagem oponente) {
		double NovaVida = oponente.getVida() - getAtaque();
		oponente.setVida(NovaVida);
	}
	public void defender(Personagem oponente) {
		double valor = getDefesa() - oponente.getAtaque();
		if(getDefesa() > oponente.getAtaque()){
			System.out.println("Defendido");
		}else {
			setVida(getVida() - valor);
		}
	}
}
