package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAO {
	

	public static boolean criarArquivo(String caminho) {
		File file = new File(caminho);
		try {
			return file.createNewFile();
		} catch (IOException e) {
			return false;
		}
	}

	public static boolean escreverArquivo(String caminho, ArrayList<String> conteudo) {
		try {
			FileWriter fileWriter = new FileWriter(caminho);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (String texto : conteudo) {
				bufferedWriter.write(texto);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static ArrayList<String> lerArquivo(String caminho) {
		ArrayList<String> texto = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(caminho);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha;
			while ((linha = bufferedReader.readLine()) != null) {
				texto.add(linha);
			}
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			return null;
		}
		return texto;
	}

	public static boolean verificarArquivoJaExistente(String caminho) {
		if(new File(caminho).exists()){
			return true;
		}
		return false;
	}


}
