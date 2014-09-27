package alphaitems.lib;

public enum State {
	OFF(0),
	ON(1);
	
	private State st;
	private int intState;
	
	private State(int st) {
		this.intState = st;
	}
	
	private State(State st) {
		this.st = st;
	}
	
	public void setState(int st) {
		this.intState = st;
	}
	
	public void setState(State st) {
		this.st = st;
	}
}