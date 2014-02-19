package rats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;

public class Arquivo {


	private String caminhoArquivo1, caminhoArquivo2;	

	private ArrayList<PropriedadesArquivo> arrayDiretorio = new ArrayList<PropriedadesArquivo>(),
			arrayChamado = new ArrayList<PropriedadesArquivo>();

	
	public void lerArquivos(String caminhoArquivo1, String caminhoArquivo2) {
		this.caminhoArquivo1 = caminhoArquivo1;
		this.caminhoArquivo2 = caminhoArquivo2;
		try {
			FileReader fileReader1 = new FileReader(new File(caminhoArquivo1)), fileReader2 = new FileReader(
					new File(caminhoArquivo2));
			BufferedReader bufferedReader1 = new BufferedReader(fileReader1), bufferedReader2 = new BufferedReader(
					fileReader2);

			while (bufferedReader1.ready()) {
				PropriedadesArquivo arquivo = new PropriedadesArquivo();
				arquivo.setAbsolutePath(bufferedReader1.readLine());
				setPropriedadesArquivo(arquivo);

				if (arquivo.isDiretorio())
					arrayDiretorio.add(arquivo);
				else
					arrayChamado.add(arquivo);
			}

			while (bufferedReader2.ready()) {
				PropriedadesArquivo arquivo = new PropriedadesArquivo();
				arquivo.setAbsolutePath(bufferedReader2.readLine());
				setPropriedadesArquivo(arquivo);

				if (arquivo.isDiretorio())
					arrayDiretorio.add(arquivo);
				else
					arrayChamado.add(arquivo);
			}

			bufferedReader2.close();
			bufferedReader1.close();
			fileReader2.close();
			fileReader1.close();

		} catch (FileNotFoundException e) {
			System.err.println("Erro ao abrir arquivo.");
			System.exit(1);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void setPropriedadesArquivo(PropriedadesArquivo arquivo) {
		arquivo.setUltimoIndexBarra(arquivo.getAbsolutePath().lastIndexOf('/'));
		if (arquivo.getUltimoIndexBarra() == -1) {
			arquivo.setFileName(arquivo.getAbsolutePath());
			arquivo.setDiretorio(false);
		} else {
			arquivo.setFileName(arquivo.getAbsolutePath().substring(
					arquivo.getUltimoIndexBarra() + 1));
			arquivo.setAbsolutePath(arquivo.getAbsolutePath().substring(0,
					arquivo.getUltimoIndexBarra() + 1));
			arquivo.setDiretorio(true);
		}

	}

	public void encontrarElementos() {
		Formatter outNaoEncontrados, outEncontrados;
		Iterator<PropriedadesArquivo> ic = arrayChamado.iterator();
		//TODO VERIFICAR ISSO AKI, SE É NECESSÁRIO
		//caminhoArquivo1.replaceAll("\\", "\\\\"); 
		//caminhoArquivo2.replaceAll("\\", "\\\\");

		try {
			outNaoEncontrados = new Formatter(
					"C:\\Users\\maylon.brito\\Documents\\Tarefa 1302\\chamadosNaoEncontrados.txt");
			outEncontrados = new Formatter(
					"C:\\Users\\maylon.brito\\Documents\\Tarefa 1302\\chamadosEncontrados.txt");
			while (ic.hasNext()) {
				PropriedadesArquivo elementoC = (PropriedadesArquivo) ic.next();
				Iterator<PropriedadesArquivo> id = arrayDiretorio.iterator();
				while (id.hasNext()) {
					PropriedadesArquivo elementoD = (PropriedadesArquivo) id
							.next();
					if (elementoC.getFileName().equals(elementoD.getFileName())) {
						elementoC.setElementoEncontrado(true);
						elementoC.setAbsolutePath(elementoD.getAbsolutePath());
					}
				}
				if (!elementoC.isEncontrado()) {
					System.out.println(elementoC.getFileName());
					outNaoEncontrados.format("%s\n", elementoC.getFileName());
				} else {
					outEncontrados.format("%s\n", elementoC.getAbsolutePath()
							+ elementoC.getFileName());
				}
			}
			outNaoEncontrados.close();
			outEncontrados.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
