import java.awt.Color;
import uwcse.graphics.*;

/**
 * A snow-covered mountain with an animated avalanche in a graphics window
 */

public class Mountain {

	// The graphics window the mountain belongs to
	private GWindow window;

	// The location of the mountain
	private int x;
	private int y;

	// Scale of the drawing of the mountain
	private double scale;
	private int mountainSize;

	// Variables for moving snow on the mountain
	private int originaly;
	private Triangle snow;
	private int direction;
	private int bottom = 100;
	private int side1;
	private int side2;
	public static final int IN = 0;
	public static final int OUT = 1;

	/**
	 * Draws a mountain in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the location of the mountain
	 * @param y
	 *            the y coordinate of the location of the mountain
	 * @param window
	 *            the graphics window where the mountain is displayed
	 * @param window
	 *            the graphics window the mountain belongs to
	 */

	public Mountain(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		originaly = bottom;
		this.window = window;
		this.scale = scale;
		mountainSize = (int) (this.scale * 100);
		side1 = this.x + mountainSize / 8;
		side2 = this.x + (mountainSize / 8) * 3;
		this.direction = OUT;

		// Draw the boat
		this.draw();
	}

	// Method for creating an avalanche
	public void doAction() {
		// Erase the current drawing
		window.remove(snow);
		// Repaint the snow
		this.window.resumeRepaints();
		// Animate the avalanche by moving the snow areas covered
		if (this.direction == this.OUT) {
			bottom = bottom + 1;
			side1 = side1 - 1;
			side2 = side2 + 1;
			if (bottom >= originaly + 5) {
				this.direction = IN;
			}
		} else {
			bottom = bottom - 1;
			side1 = side1 + 1;
			side2 = side2 - 1;
			if (bottom <= originaly - 5) {
				this.direction = OUT;
			}
		}
		// draw the snow
		this.draw();
	}

	/**
	 * Draws this mountain and snow
	 */
	public void draw() {
		// Draw the triangle making up the mountain
		Triangle mountain = new Triangle(this.x, 100,
				this.x + mountainSize / 2, 100, this.x + mountainSize / 4,
				100 - this.y / 4, Color.DARK_GRAY, true);
		// Draw the triangle making up the snow cap
		this.snow = new Triangle(side1, bottom - this.y / 8, side2, bottom
				- this.y / 8, this.x + mountainSize / 4, 100 - this.y / 4,
				Color.WHITE, true);
		this.window.add(mountain);
		this.window.add(snow);
	}
}
