package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController {

	public void lerArquivo(String caminho, String nome, String ano, String mes, Double media) throws IOException {
		File arquivo = new File(caminho, nome);
		existenciaDiretorio(caminho);
		String[] vetor;

		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {
				vetor = linha.split(",");
				Double mediaConvertida = Double.parseDouble(vetor[3]);

				if (linha.contains(ano) && linha.contains(mes) && mediaConvertida >= media) {
					vetor = linha.split(",");
					System.out.println(vetor[0] + " | " + vetor[3]);
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

	public void gerarArquivo(String caminho, String nomeArquivo, String ano, String mes) throws IOException {
		File arquivoSteam = new File("C:\\TEMP","SteamCharts.csv");
		File arquivo = new File(caminho, nomeArquivo);
		StringBuffer buffer2 = new StringBuffer();
		existenciaDiretorio(caminho);
		String[] vetor;

		if (arquivoSteam.exists() && arquivoSteam.isFile()) {
			FileInputStream fluxo = new FileInputStream(arquivoSteam);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {

				if (linha.contains(ano) && linha.contains(mes)) {
					vetor = linha.split(",");
					buffer2.append(vetor[0] + " ; " + vetor[3] + "\n");
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}

		FileWriter fileWriter = new FileWriter(arquivo);
		PrintWriter print = new PrintWriter(fileWriter);
		print.write(buffer2.toString());
		print.flush();
		print.close();
		fileWriter.close();
		
		System.out.println("\n" + "Arquivo gravado com sucesso!");
	}

}
