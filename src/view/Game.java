package view;

import java.util.Scanner;

import model.Calcular;

public class Game {

	static Scanner teclado = new Scanner(System.in);
	static int pontos = 0;
	static Calcular calc;

	public static void main(String[] args) {
		Game.jogar();
	}

	private static void jogar() {
		System.out.println("Informe o nível de dificuldade desejado[1, 2, 3 ou 4");

		int dificuldade = Game.teclado.nextInt();

		Game.calc = new Calcular(dificuldade);

		System.out.println("Informe o resultado para a seguinte operação:");

		// somar
		if (calc.getOperacao() == 0) {
			System.out.println(calc.getValor1() + "+" + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.somar(resposta)) {
				// ganhar 1 ponto
				Game.pontos += 1;
				System.out.println("Vocẽ tem " + Game.pontos + " ponto(s).");
			}
		} 
		// diminuir
		else if (calc.getOperacao() == 1) {
			System.out.println(calc.getValor1() + "-" + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.diminuir(resposta)) {
				// ganhar 1 ponto
				Game.pontos += 1;
				System.out.println("Vocẽ tem " + Game.pontos + " ponto(s).");
			}
		}
		// multiplicar
		else if (calc.getOperacao() == 2) {
			System.out.println(calc.getValor1() + "*" + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.multiplicar(resposta)) {
				// ganhar 1 ponto
				Game.pontos += 1;
				System.out.println("Vocẽ tem " + Game.pontos + " ponto(s).");
			}
		}else {
			System.out.println("A operação " + calc.getOperacao() + " Não é reconhecida");
		}
		System.out.println("Deseja continuar? [1 - sim, 0 - naõ]");
		int continuar = Game.teclado.nextInt();
		
		if(continuar == 1) {
			Game.jogar();
		}else {
			System.out.println("Vocẽ fez " + Game.pontos + "ponto (s).");
			System.out.println("Até a próxima!");
			System.exit(0);
		}
	}
}
