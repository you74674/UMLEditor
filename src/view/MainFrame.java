package view;

import java.awt.BorderLayout;
import view.base.AncestorContainer;

public class MainFrame extends AncestorContainer{
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
	public MainFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Config.defaultFrameSize);
		
		setComponents();
		
		setVisible(true);
	}
	public EditorView getEditorView() {
		return editorView;
	}
}
