package view.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.event.EventListenerList;

public class AncestorContainer extends JFrame{
//	listener
	private EventListenerList actionListeners=new EventListenerList();
	public void addActionListener(ActionListener actionListener){
		actionListeners.add(ActionListener.class, actionListener);
	}
	public void fireActionEvent(ActionEvent e){
		for(Object actionListener: actionListeners.getListeners(ActionListener.class))
			((ActionListener)actionListener).actionPerformed(e);
	}
//	
//	private EventListenerList changeListeners=new EventListenerList();
//	public void addChangeListener(ChangeListener changeListener){
//		changeListeners.add(ChangeListener.class, changeListener);
//	}
//	public void fireChangeEvent(ChangeEvent e){
//		for(Object changeListener: changeListeners.getListeners(ChangeListener.class))
//			((ChangeListener)changeListener).stateChanged(e);
//	}
	
	private EventListenerList itemListeners=new EventListenerList();
	public void addItemListener(ItemListener itemListener){
		itemListeners.add(ItemListener.class, itemListener);
	}
	public void fireItemEvent(ItemEvent e){
		for(Object itemListener: itemListeners.getListeners(ItemListener.class))
			((ItemListener)itemListener).itemStateChanged(e);
	}
}
