package view;

import controller.SteamController;

public class Main {
	
	public static void main(String[] args) {

		SteamController controller = new SteamController();
		String caminho = "C:\\TEMP";
		String nome = "SteamCharts.csv";
		String nomeArquivo = "nome.csv";

		try {
			controller.lerArquivo(caminho, nome, "2020", "December", 100000.0);
			controller.gerarArquivo(caminho, nomeArquivo, "2020", "December");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
