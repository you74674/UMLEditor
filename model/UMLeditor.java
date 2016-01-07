package model;

import model.uml.UML;

public class UMLeditor{
//	private FileManager fileManager;
	private Editor editor;
	
	public UMLeditor(){
		editor=new Editor(new UML());
//		fileManager=new FileManager();
	}
	public Editor getEditor(){
		return editor;
	}
//	public void loadFile(String fileName){
//		editor.setUML(fileManager.load(fileName));
//	}

}
