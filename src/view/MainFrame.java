package view;

import java.awt.BorderLayout;

import model.UMLeditor;
import view.base.AncestorContainer;

public class MainFrame extends AncestorContainer{

	private UMLeditor model;
	
	private MenuBar menuBar;
	private TaskBar taskBar;
	private EditorView editorView;
	
	private void setComponents(){
		setLayout(new BorderLayout());
		
		editorView=new EditorView(this);
		menuBar=new MenuBar(this);
		taskBar=new TaskBar(this);
		
		setJMenuBar(menuBar);
		add(taskBar, BorderLayout.WEST);
		add(editorView, BorderLayout.CENTER);
	}
	public MainFrame(UMLeditor model){
		this.model=model;
		
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
