package task.line;

import view.uml.line.GeneralizationView;
import view.uml.line.LineView;

public class GeneralizationTask extends LineTask{
	@Override
	public LineView getView() {
		return new GeneralizationView();
	}
}
