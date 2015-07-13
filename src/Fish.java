import java.awt.Color;
import uwcse.graphics.*;

/**
 * A fish in a graphics window
 */

public class Fish {
	// The graphics window the fish belongs to
	private GWindow window;
	// The location of the fish
	private int x;
	private int y;

	// Scale of the drawing of the fish
	private double scale;

	// Variables used to animate the fish
	private int direction;
	public static final int RIGHT_MOVING = 1;
	public static final int LEFT_MOVING = 0;
	private Oval body;
	private Triangle tail;

	/**
	 * Draws a Fish in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the location of the fish
	 * @param y
	 *            the y coordinate of the location of the fish
	 * @param scale
	 *            the scale of the drawing of the fish
	 * @param window
	 *            the graphics window the fish belongs to
	 */

	public Fish(int x, int y, double scale, int direction, GWindow window) {
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.direction = direction;
		this.window = window;
		// Draw the fish
		this.draw();
	}

	// Method that makes the fish swim
	public void swim() {
		window.remove(body);
		window.remove(tail);
		this.window.resumeRepaints();
		if (this.direction == Fish.LEFT_MOVING) {
			this.x = this.x - 5;
			if (this.x <= 0) {
				this.direction = RIGHT_MOVING;
			}
		} else {
			this.x = this.x + 5;
			if (this.x >= 500) {
				this.direction = LEFT_MOVING;
			}
		}
		this.draw();
	}

	/**
	 * Draws this fish
	 */
	private void draw() {
		// random color of the fish
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		Color c = new Color(red, green, blue);

		// the body of the fish
		int w = (int) (30 * scale);
		int h = (int) (10 * scale);
		this.body = new Oval(x - w / 2, y - h / 2, w, h, c, true);
		window.add(body);

		// the tail of the fish
		int x1, x2, x3, y1, y2, y3;
		if (this.direction == this.LEFT_MOVING) {
			// facing left
			x1 = x + w / 3;
			y1 = y;
			x2 = x + w * 4 / 7;
			y2 = y - h / 3;
			x3 = x + w * 4 / 7;
			y3 = y + h / 3;

		} else {
			// facing right
			x1 = x - w / 3;
			y1 = y;
			x2 = x - w * 4 / 7;
			y2 = y - h / 3;
			x3 = x - w * 4 / 7;
			y3 = y + h / 3;

		}
		this.tail = new Triangle(x1, y1, x2, y2, x3, y3, c, true);
		window.add(tail);
	}
}