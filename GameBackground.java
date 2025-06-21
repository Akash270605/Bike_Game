import java.awt.Graphics;


public class GameBackground {
	
	//layers
	ImageLayer trees;
	ImageLayer houses;
	ImageLayer mountains;
	ImageLayer road;
	Animation green;
	Moon moon;
	
	public GameBackground(int width, int height){
		trees = new ImageLayer("src/Images/Road/trees.gif",1);
		houses = new ImageLayer("src/Images/Road/houses.gif", 2);
		mountains = new ImageLayer("src/Images/Road/mountains.gif", 8);
		road = new ImageLayer("src/Images/Road/road.gif");
		road.setY(288);
		green = new Animation("src/Images/Road/green", 10,1,".jpg",width,height);
		moon = new Moon(width);
		
	}
	
	public void draw(Graphics g){
		//should be fill the screen
		green.draw(g, 0, 0);
		mountains.drawInfinite(g);
		houses.drawInfinite(g);
		road.drawInfinite(g);
		trees.drawInfinite(g);
	
	}
	
	/**
	 * this method is used for drawing and handling pause for cool  and better effects
	 * @param g graphics where it will be drawn
	 * @param pause is it pause or not
	 */
	public void draw(Graphics g, boolean pause){
		green.draw(g, 0, 0);
		mountains.drawInfinite(g);
		houses.drawInfinite(g);
		road.drawInfinite(g);
		trees.drawInfinite(g);
		moon.drawInfinite(g, 30000,pause);
		//draw road here
	}
	

}
