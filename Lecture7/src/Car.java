import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
       A car shape that can be positioned anywhere on the screen.
 */
public class Car
{
	private int xLeft;
	private int yTop;
	private int direction;
	private int number;

	/**
         Constructs a car with a given top left corner.
         @param x the x coordinate of the top left corner
         @param y the y coordinate of the top left corner
	 */
	public Car(int x, int y)
	{
		xLeft = x;
		yTop = y;
		direction = 1;
		this.number = 1;
	}
	
	public Car(int x, int y, int direction)
	{
		xLeft = x;
		yTop = y;
		this.direction = direction;
		this.number = 1;
	}
	
	public Car(int x, int y, int direction, int number)
	{
		xLeft = x;
		yTop = y;
		this.direction = direction;
		this.number = number;
	}
	/**
	 * @return the xLeft
	 */
	public int getxLeft() {
		return xLeft;
	}

	/**
	 * @return the yTop
	 */
	public int getyTop() {
		return yTop;
	}

	/**
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @param xLeft the xLeft to set
	 */
	public void setxLeft(int xLeft) {
		this.xLeft = xLeft;
	}

	/**
	 * @param yTop the yTop to set
	 */
	public void setyTop(int yTop) {
		this.yTop = yTop;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/*
	 * Moves the location of the car
	 * @param deltaX Unit to move car horizontally to the right
	 * @param deltaY Units to move car vertically down
	 */
	public void move(int deltaX, int deltaY) {
		xLeft += deltaX;
		yTop += deltaY;
	}

	/**
      Draws the car.
      @param g2 the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		Rectangle body 
		= new Rectangle(xLeft, yTop + 10, 60, 10);      
		Ellipse2D.Double frontTire 
		= new Ellipse2D.Double(xLeft + 10, yTop + 20, 10, 10);
		Ellipse2D.Double rearTire
		= new Ellipse2D.Double(xLeft + 40, yTop + 20, 10, 10);

		// The bottom of the front windshield
		Point2D.Double r1 
		= new Point2D.Double(xLeft + 10, yTop + 10);
		// The front of the roof
		Point2D.Double r2 
		= new Point2D.Double(xLeft + 20, yTop);
		// The rear of the roof
		Point2D.Double r3 
		= new Point2D.Double(xLeft + 40, yTop);
		// The bottom of the rear windshield
		Point2D.Double r4 
		= new Point2D.Double(xLeft + 50, yTop + 10);

		Line2D.Double frontWindshield 
		= new Line2D.Double(r1, r2);
		Line2D.Double roofTop 
		= new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield
		= new Line2D.Double(r3, r4);

		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontWindshield);      
		g2.draw(roofTop);      
		g2.draw(rearWindshield);      
		
		g2.drawString(this.number+"", xLeft + 20, yTop + 20);
	}
}
