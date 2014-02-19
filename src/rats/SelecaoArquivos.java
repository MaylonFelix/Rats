
package rats;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SelecaoArquivos extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextArea outputArea;
	private JScrollPane scrollPane;
	
	public SelecaoArquivos(){
		super("Seleçao de arquivos");
		outputArea = new JTextArea();
		scrollPane = new JScrollPane(outputArea);
		add(scrollPane, BorderLayout.CENTER);
		setSize(400,400);
		setVisible(true);
		
		analyzePath();
	}

	private void analyzePath() {
		File[] name = getFileDirectory();
		
	
		outputArea.setText(String.format("%s\n%s\n",name[0].getName(),name[1].getName()));
		
		Arquivo arquivos = new Arquivo();
		arquivos.lerArquivos(name[0].getPath(), name[1].getPath());
		arquivos.encontrarElementos();
	}
//		
	/*	
		if(name.exists()){
			outputArea.setText(String.format("%s%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", 
			name.getName(), " existe.", 
			(name.isFile()?"É um arquivo.":"Não é um arquivo."),
			name.getPath(),
			(name.isDirectory()?"É um diretório":"Não é um diretório"),
			"AsolutePath: ",name.getAbsolutePath(),
			(name.isAbsolute()?"É um caminho absoluto.":"Não é um caminho absoluto."),
			name.lastModified(), "Parent: ", name.getParent())
			);
		
		
		if(name.isDirectory()){
			String[] directory = name.list();
			outputArea.append("\n\nDirectory contents:\n");
			
			for(String directoryName : directory)
				outputArea.append(directoryName+"\n");
		}
		//else{
		//	JOptionPane.showMessageDialog(this, name+" does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
		//}
	}
	}
	*/
	private File[] getFileDirectory(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		File files[] = new File[2];
		int result;
		
		result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		files[0] = fileChooser.getSelectedFile();
		result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		files[1] = fileChooser.getSelectedFile();
		
		
		if((files[0] == null) || (files[0].getName().equals(""))||(files[1] == null) || (files[1].getName().equals(""))){
			JOptionPane.showMessageDialog(this, "Nome Inválido", "Nome Inválido", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		return files;
		
	}

	/*public String getNomeDoArquivo() {
		return this.getFileDirectory().getAbsolutePath();
	}

	/*public void setNomeDoArquivo(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}*/
	
	
	
}
