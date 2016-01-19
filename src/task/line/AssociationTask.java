package task.line;

import view.uml.line.AssociationView;
import view.uml.line.LineView;

public class AssociationTask extends LineTask{
	
	@Override
	public LineView getView() {
		return new AssociationView();
	}
}
