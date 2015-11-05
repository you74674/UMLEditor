package model;

public class UMLeditor{
	private FileManager fileManager;
	private Editor editor;
	
	public UMLeditor(){
		editor=new Editor();
		fileManager=new FileManager();
	}
	public Editor getEditor(){
		return editor;
	}
	public void loadFile(String fileName){
		editor.setUML(fileManager.load(fileName));
	}
	
	public static void main(String args[]){


	}






}
