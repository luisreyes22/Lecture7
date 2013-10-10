import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class CarViewer
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		frame.setSize(1000, 600);
		frame.setTitle("Moving car");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int nextY = 0;
		Car[] theCars = new Car[12];
		for (int i=0; i<theCars.length; i++) {
			if (i%2 == 0) {
				theCars[i] = new Car(0, nextY, 1, i);
			}
			else {
				theCars[i] = new Car(0, nextY, 1, i);
			}
			nextY += 40;
		}

		CarComponent component = new CarComponent(theCars);

		frame.add(component);

		frame.setVisible(true);
		
		Random deltas = new Random();

		while (!component.someCarHitsTheWall()) {
			frame.repaint();
			try{
				Thread.sleep(10); // Wait for 0.1 second = 100 milliseconds
			}
			catch(InterruptedException e){}
			for (int i=0; i<theCars.length; i++) {
				int nextDelta = deltas.nextInt(3); // Car can move between 0 and 4 pixels each time
				theCars[i].move(theCars[i].getDirection() * nextDelta, 0);
			}

		}
	}

	public static int getStart(JFrame frame, int increment) {
		if (increment < 0) {
			return frame.getWidth()-60;
		}
		else {
			return 0;
		}
	}
	public static int getEnd(JFrame frame, int increment) {
		if (increment > 0) {
			return frame.getWidth()-60;
		}
		else {
			return 0;
		}
	}
}
