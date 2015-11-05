package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.UMLeditor;

public class MainFrame extends JFrame{
	
	private UMLeditor model;
	
	private MenuBar menuBar;
	private TaskBar taskBar;
	private EditorView editorView;
	
	private void setComponents(){
		setLayout(new BorderLayout());
		
		menuBar=new MenuBar(this);
		taskBar=new TaskBar(this);
		editorView=new EditorView();
		
		
		setJMenuBar(menuBar);
		add(taskBar, BorderLayout.WEST);
		add(getEditorView(), BorderLayout.CENTER);
		
	}
	public MainFrame(UMLeditor model){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(Config.defaultFrameSize);
		
		setComponents();
		
		setVisible(true);
	}
	public UMLeditor getModel() {
		return model;
	}
	public void setModel(UMLeditor model) {
		this.model = model;
	}
	public EditorView getEditorView() {
		return editorView;
	}
}
