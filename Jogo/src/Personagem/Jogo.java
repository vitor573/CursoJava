package Personagem;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Heroi H1 = new Heroi();
		String selecao;
		boolean res;
		System.out.println("Você acorda com uma dor de cabeça sem lembrar seu nome... Quem sou eu você pensa");
		System.out.println("À sua volta a o lugar está destruido, em uma mesa existe um documento talvez ali tenha seu nome. ");		
		
		do {
			System.out.println("deseja pegar o documento?");
			selecao = entrada.next();
			if(selecao.equalsIgnoreCase("sim") || selecao.equalsIgnoreCase("não")) {
				res = true;
			}else {
				res = false;
			}
		switch(selecao) {
		case "sim": case "Sim":
			System.out.println("digite seu nome: ");
			H1.setNome(entrada.next());
			break;
		case "não": case "Não":
			H1.setNome("Heroi");
			break;
		default:
			System.out.println("Digite Sim ou Não");
		}
		}while(res = false);
		
		System.out.println("cabou");
		
		entrada.close();
		
	}
}
