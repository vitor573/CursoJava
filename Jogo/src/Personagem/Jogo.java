package Personagem;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Heroi H1 = new Heroi();
		String selecao;
		boolean res;
		System.out.println("Voc� acorda com uma dor de cabe�a sem lembrar seu nome... Quem sou eu voc� pensa");
		System.out.println("� sua volta a o lugar est� destruido, em uma mesa existe um documento talvez ali tenha seu nome. ");		
		
		do {
			System.out.println("deseja pegar o documento?");
			selecao = entrada.next();
			if(selecao.equalsIgnoreCase("sim") || selecao.equalsIgnoreCase("n�o")) {
				res = true;
			}else {
				res = false;
			}
		switch(selecao) {
		case "sim": case "Sim":
			System.out.println("digite seu nome: ");
			H1.setNome(entrada.next());
			break;
		case "n�o": case "N�o":
			H1.setNome("Heroi");
			break;
		default:
			System.out.println("Digite Sim ou N�o");
		}
		}while(res = false);
		
		System.out.println("cabou");
		
		entrada.close();
		
	}
}
