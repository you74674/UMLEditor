package task.line;

import view.uml.line.CompositionView;
import view.uml.line.LineView;

public class CompositionTask extends LineTask{


	@Override
	public LineView getView() {
		return new CompositionView();
	}
}
