
import java.awt.Graphics;

/**
 * this was used for testing out things such as drawInfinite
 
 */
public class Moon extends Character{
	
	static String filename = "src/Images/Moon/moon", extension = ".png";
	//not used here for now
	static int xbound = Camera.x, ybound = 0-Camera.y, x2bound, y2bound;
	
	int width;

	public Moon(int width) {
		super(filename,extension, 1400,30, 1, 3, 4);
		this.width = width;
	}
	
	
	//this should handle the movements too
	public void drawInfinite(Graphics g, int n, boolean pause){
		if(!pause) this.moveRt(9);
		if(this.x < Camera.x){
			//made n sort of an offset
			this.x += DumbCharacter.random.nextInt(n) + width; //draw it somewhere else in the end
		
		}
		super.draw(g);
		
	}

	
	
	
	

	
}
