package rats;

public class PropriedadesArquivo {
	private String fileName, absolutePath;
	private int UltimoIndexBarra = -1;
	private boolean elementoEncontrado = false, diretorio = false;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public int getUltimoIndexBarra() {
		return UltimoIndexBarra;
	}

	public void setUltimoIndexBarra(int ultimoIndexBarra) {
		UltimoIndexBarra = ultimoIndexBarra;
	}

	public boolean isEncontrado() {
		return elementoEncontrado;
	}

	public void setElementoEncontrado(boolean elementoEncontrado) {
		this.elementoEncontrado = elementoEncontrado;
	}

	public void setDiretorio(boolean diretorio) {
		this.diretorio = diretorio;
	}

	public boolean isDiretorio() {
		return diretorio;
	}
	
	

	
}
