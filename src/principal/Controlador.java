package principal;

import java.awt.Desktop;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class Controlador {
	public static void buscar(DefaultTableModel t){
		JFileChooser jf= new JFileChooser();
		jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int op= jf.showOpenDialog(null);
		if(op == JFileChooser.OPEN_DIALOG){
			File folder=jf.getSelectedFile();
			File[] archivos=folder.listFiles();
			for (int i=0; i<archivos.length;i++){
				if (archivos[i].isFile()){
					String path=folder.getPath()+"\\ "+ archivos[i].getName();
					t.addRow(new Object[]{path,null,null});
				}
			}
		}
	}
	public static void abrir(DefaultTableModel t, int fila){
		if(fila>=0){
			String path=(String)t.getValueAt(fila, 0);
			try {
				File file= new File(path);
				Desktop.getDesktop().open(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
