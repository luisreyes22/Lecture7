import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
       This component draws two car shapes.
 */
public class CarComponent extends JComponent
{  
	private Car movingCar = new Car(0,40);

	private Car[] cars;

	public CarComponent(Car[] cars) {
		this.cars = cars;
	}

	public void moveCar(int deltax, int deltay) {
		movingCar.move(deltax,  deltay);
	}

	public void locateCar(int x, int y) {
		movingCar = new Car(x, y);
	}

	public void paintComponent(Graphics g)
	{  
		Graphics2D g2 = (Graphics2D) g;

		int maxX = cars[0].getxLeft();
		int firstCar = 0;
		int numCars = cars.length;
		for (int i=0; i<numCars; i++) {
			g2.setColor(Color.BLACK);
			cars[i].draw(g2);
			if (cars[i].getxLeft() >= maxX) {
				maxX = cars[i].getxLeft();
				firstCar = i;
			}
			//cars[i].move(cars[i].getDirection() * 1, 0);
		}
		g2.setColor(Color.BLUE);
		cars[firstCar].draw(g2);
	}

	public boolean someCarHitsTheWall() {
		for (int i=0; i<this.cars.length; i++) {
			if ((this.cars[i].getDirection() > 0) && (this.cars[i].getxLeft()+60 >= getWidth())){
				// Car going right
				return true;
			}
			else if ((this.cars[i].getDirection() < 0) && (this.cars[i].getxLeft() <= 0)) {
				// Car going left
				return true;
			}
		}
		return false;
	}
}
