package model.object;

public class Depth {
	private int depth;

	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		if(depth<0)
			depth=0;
		else if(depth>99)
			depth=99;
		this.depth=depth;
	}
	
}
