package view;

import controller.TabelaFrutasController;

public class Main {

	public static void main(String[] args) {

		TabelaFrutasController controller = new TabelaFrutasController();
		String caminho = "C:\\TEMP";
		String nome = "generic_food.csv";

		try {
			controller.lerArquivo(caminho, nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
