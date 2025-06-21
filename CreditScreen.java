import java.awt.Graphics;
/**
 * this represents a screen in this case it is the beginning when you press select 
 
 */
public class CreditScreen {
	
	
	static int w;
	static int h;
	Credit c;
	public CreditScreen(int w, int h){
		this.w = w;
		this.h = h;
		c = new Credit(w,h);
	}
	public void draw(Graphics g){
		
		c.draw(g, 0, 0);
	}

}
