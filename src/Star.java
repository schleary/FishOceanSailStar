import java.awt.Color;
import uwcse.graphics.*;

/**
 * A twinkling star in a graphics window
 */

public class Star {

	// The graphics window the star belongs to
	private GWindow window;

	// The location of the center of the star
	private int x;
	private int y;

	// Scale of the drawing of the star
	private double scale;

	// The lines that make up the star
	private Line line1;
	private Line line2;
	private Line line3;
	private Line line4;

	/**
	 * Draws a star in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the center of the star
	 * @param y
	 *            the y coordinate of the center of the star
	 * @param scale
	 *            the scale of the drawing of the star
	 * @param window
	 *            the graphics window the star belongs to
	 */
	public Star(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		this.window = window;
		this.scale = scale;

		// Draw the star
		this.draw();

		// public void twinkle();
	}

	// Twinkle method
	public void twinkle() {
		// remove and redraw different-colored stars for animation effect
		window.remove(line1);
		window.remove(line2);
		window.remove(line3);
		window.remove(line4);
		this.window.resumeRepaints();
		this.draw();
	}

	/**
	 * Draws this star
	 */
	public void draw() {
		// color of the star
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		Color c = new Color(red, green, blue);

		// Size of the star
		int starSize = (int) (this.scale * 10);

		// Draw the lines making up the star
		this.line1 = new Line(this.x, this.y - starSize / 2, this.x, this.y
				+ starSize / 2, c);
		this.line2 = new Line(this.x - starSize / 2, this.y, this.x + starSize
				/ 2, this.y, c);
		this.line3 = new Line(this.x - starSize / 4, this.y - starSize / 4,
				this.x + starSize / 4, this.y + starSize / 4, c);
		this.line4 = new Line(this.x + starSize / 4, this.y - starSize / 4,
				this.x - starSize / 4, this.y + starSize / 4, c);

		// Add the star to the window
		this.window.add(line1);
		this.window.add(line2);
		this.window.add(line3);
		this.window.add(line4);

	}
}
