package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TabelaFrutasController {

	public void lerArquivo(String caminho, String nome) throws IOException {
		File arquivo = new File(caminho, nome);
		existenciaDiretorio(caminho);
		String[] vetor;

		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {

				if (linha.contains("Fruits")) {
					vetor = linha.split(",");
					System.out.println(vetor[0] + "\t" + vetor[1] + "\t" + vetor[3]);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}

	}

	public void existenciaDiretorio(String caminho) throws IOException {
		File diretorio = new File(caminho);

		if (diretorio.exists() && diretorio.isDirectory()) {
//			Diretório existente
		} else {
			throw new IOException("Diretório inválido");
		}
	}

}
