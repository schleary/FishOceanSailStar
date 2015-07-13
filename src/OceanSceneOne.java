Exercise 1: answer the questions a, b, c and d in the code below.

import uwcse.graphics.*;
import java.awt.Color;

public class OceanSceneOne {

  // instance fields
  private GWindow window;

  /**
   * method makeGreenBorderedDot 
   */
  private void makeGreenBorderedDot(int x, int y, GWindow w) {
    Oval dot, border;
    dot = new Oval(x, y, 100, 100, Color.green, true);
    border = new Oval(x, y, 100, 100, Color.black, false);
    w.add(dot);
    w.add(border);
  }

  /**
   * Question a:
   * window is an instance field of type GWindow (see above)
   * What is wrong with the last three the statements listed in this method?
   */
  public void question_a()
  {
    this.window = new GWindow();
    this.makeGreenBorderedDot();
    this.makeGreenBorderedDot(20, 20);
    this.makeGreenBorderedDot(20, this.window, 20);
  }

  /**
   * Question b:
   * What does the following method generate?
   */
  public void question_b()
  {
    this.window = new GWindow("Question b", 300, 300);
    this.makeGreenBorderedDot(20, 20, this.window);
    this.makeGreenBorderedDot(150, 0, this.window);
    this.makeGreenBorderedDot(80, 80, this.window);
    this.window.doRepaint();
  }

  /**
   * Question c:
   * Explain the run time error from executing the following code
   * Assume that only this method is called, i.e. question_a or
   * question_b haven't been called before question_c
   */
  public void question_c()
  {
    this.makeGreenBorderedDot(20, 20, this.window);
  }

  /**
   * Question d (not the same as in the text)
   * Is this possible to complete the following method (and only this method)
   * to change the color of the dot to red?
   * If yes, write the code. If no, explain why.
   */
  public void question_d()
  {
    this.window = new GWindow("Question d", 400, 400);
    this.makeGreenBorderedDot(100, 100, this.window);
    // Can we change the color of the dot to red?
  }
}
 

Exercise 2:

For each of the following methods, write a precondition (= what must be true for the method to execute correctly) and a postcondition (= what the method guarantees to be true once it has been executed) in plain English:

public double mysteryMethod1(double a, double b, double c) {
	return Math.sqrt(b*b - 4*a*c);
}
       

public void mysteryMethod2(Oval o1, Oval o2) {
	Color c1 = o1.getColor();
	Color c2 = o2.getColor();
	o1.setColor(c2);
	o2.setColor(c1);
}

public String mysteryMethod3(String s) {
	return s + "s";
}
 
  

	/**
	 * Starts the application
	 */
	public static void main(String[] args) {
		new OceanSceneOne();

	}
}
