import java.awt.Color;
import uwcse.graphics.*;

/**
 * A bobbing sailboat in a graphics window
 */

public class SailBoat {

	// The graphics window the boat belongs to
	private GWindow window;

	// The location of the boat
	private int x;
	private int y;

	// Scale of the drawing of the boat
	private double scale;

	// Variables needed for animation
	private int originaly;
	private Oval oval;
	private Triangle triangle1;
	private Triangle triangle2;
	private Rectangle rectangle;
	private int direction;
	public static final int UP = 1;
	public static final int DOWN = 0;

	/**
	 * Draws a sailboat in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the location of the boat
	 * @param y
	 *            the y coordinate of the location of the boat
	 * @param window
	 *            the graphics window where the boat is displayed
	 * @param window
	 *            the graphics window the boat belongs to
	 */

	public SailBoat(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		originaly = this.y;
		this.window = window;
		this.scale = scale;
		this.direction = UP;

		// Draw the boat
		this.draw();
	}

	// Bobbing method for animating the movement of the boat
	public void moveUpOrDown() {
		if (this.direction == this.UP) {
			this.y = this.y + 1;
			if (this.y >= originaly + 6) {
				this.direction = DOWN;
			}
		} else {
			this.y = this.y - 1;
			if (this.y <= originaly - 6) {
				this.direction = UP;
			}
		}
		window.remove(oval);
		window.remove(triangle1);
		window.remove(triangle2);
		this.window.resumeRepaints();
		this.draw();
	}

	/**
	 * Draws this sailboat
	 */
	public void draw() {
		// Size of the star
		int boatSize = (int) (this.scale * 10);

		// Draw the shapes making up the boat
		this.oval = new Oval(this.x - boatSize, this.y - boatSize * 3 / 8,
				boatSize * 2, boatSize * 3 / 4, Color.RED, true);
		this.triangle1 = new Triangle(this.x, this.y, this.x + boatSize,
				this.y, this.x, this.y - (boatSize * 2), Color.WHITE, true);
		this.triangle2 = new Triangle(this.x, this.y, this.x - boatSize,
				this.y, this.x, this.y - (boatSize * 3), Color.CYAN, true);

		// Add the boat shapes to the window
		window.add(oval);
		this.window.add(triangle1);
		this.window.add(triangle2);

		// Rectangle that covers the hull to give the illusion of lapping waves
		this.rectangle = new Rectangle(this.x - boatSize, originaly + boatSize
				* 2 / 8, boatSize * 2, boatSize * 1 / 3, Color.BLUE, true);

		// Add the rectangle to the window
		this.window.add(rectangle);
	}
}
