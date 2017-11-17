
public abstract class item {

	private int x;
	private int y;
	private int value;

	public item() {
		randomPlace();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void randomPlace() {
		double r = Math.random();
		setY((int) (r * 9));
		double r2 = Math.random();
		setX((int) (r2 * 9));
	}

}
