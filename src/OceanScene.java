import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class        

/**
 * An OceanScene displays fish, sailboats, stars, and mountains in a graphics
 * window.
 * 
 * @author Holly Leary
 */

public class OceanScene extends GWindowEventAdapter {

	/** The graphics window that displays the picture */
	private GWindow window;

	/** The elements in the picture */
	// 3 sailboats that sail back and forth
	private SailBoat sailboat1, sailboat2, sailboat3;

	// 8 stars that twinkle
	private Star star1, star2, star3, star4, star5, star6, star7, star8;

	// 7 fish that swim back and forth
	private Fish fish1, fish2, fish3, fish4, fish5, fish6, fish7;

	// 5 mountains with snow avalanches
	private Mountain myElement1, myElement2, myElement3, myElement4,
			myElement5;

	// To keep track of the duration of the animation
	private int animationCounter;

	/**
	 * Create a picture
	 */
	public OceanScene() {
		// The graphics window
		this.window = new GWindow("Mountain scene");
		this.window.setExitOnClose();

		// The ocean and the sky
		Rectangle ocean = new Rectangle(0, 0, window.getWindowWidth(),
				window.getWindowHeight(), Color.blue, true);
		window.add(ocean);

		// the sky covers the upper quarter of the window
		Rectangle sky = new Rectangle(0, 0, window.getWindowWidth(),
				window.getWindowHeight() / 4, Color.black, true);
		window.add(sky);

		// Add the graphics elements
		this.addGraphicsElements();

		// Code to do the animation
		this.window.addEventHandler(this);
		this.window.startTimerEvents(150);
	}

	// To do the animation
	public void timerExpired(GWindowEvent we) {
		this.window.suspendRepaints();

		this.star1.twinkle();
		this.star2.twinkle();
		this.star3.twinkle();
		this.star4.twinkle();
		this.star5.twinkle();
		this.star6.twinkle();
		this.star7.twinkle();
		this.star8.twinkle();

		this.myElement1.doAction();
		this.myElement2.doAction();
		this.myElement3.doAction();
		this.myElement4.doAction();
		this.myElement5.doAction();

		this.fish1.swim();
		this.fish2.swim();
		this.fish3.swim();
		this.fish4.swim();
		this.fish5.swim();
		this.fish6.swim();
		this.fish7.swim();

		this.sailboat1.moveUpOrDown();
		this.sailboat2.moveUpOrDown();
		this.sailboat3.moveUpOrDown();

		this.window.resumeRepaints();

		// Run the animation 100 times (about 15 s)
		this.animationCounter++;
		if (this.animationCounter >= 100)
			this.window.stopTimerEvents();
	}

	// Instantiate in this method the elements of the scene.
	private void addGraphicsElements() {
		this.star1 = new Star(15, 15, 0.8, this.window);
		this.star2 = new Star(250, 40, 1.5, this.window);
		this.star3 = new Star(100, 40, 1, this.window);
		this.star4 = new Star(175, 60, 1, this.window);
		this.star5 = new Star(475, 40, 1.5, this.window);
		this.star6 = new Star(150, 20, 2, this.window);
		this.star7 = new Star(400, 20, 1.5, this.window);
		this.star8 = new Star(320, 35, .8, this.window);

		this.myElement1 = new Mountain(-25, 275, 3, window);
		this.myElement2 = new Mountain(75, 100, 2, window);
		this.myElement3 = new Mountain(150, 150, 3, window);
		this.myElement4 = new Mountain(275, 250, 4, window);
		this.myElement5 = new Mountain(375, 200, 3, window);

		this.fish1 = new Fish(400, 350, 2.25, Fish.LEFT_MOVING, this.window);
		this.fish2 = new Fish(50, 275, 1.65, Fish.LEFT_MOVING, this.window);
		this.fish3 = new Fish(450, 265, 1.65, Fish.RIGHT_MOVING, this.window);
		this.fish4 = new Fish(20, 200, 1.25, Fish.RIGHT_MOVING, this.window);
		this.fish5 = new Fish(350, 200, 1.2, Fish.LEFT_MOVING, this.window);
		this.fish6 = new Fish(150, 120, 1, Fish.LEFT_MOVING, this.window);
		this.fish7 = new Fish(475, 120, .8, Fish.RIGHT_MOVING, this.window);

		this.sailboat1 = new SailBoat(300, 300, 7, this.window);
		this.sailboat2 = new SailBoat(125, 225, 4, this.window);
		this.sailboat3 = new SailBoat(400, 150, 3, this.window);
	}

	/**
	 * Starts the application
	 */
	public static void main(String[] args) {
		new OceanScene();
	}
}