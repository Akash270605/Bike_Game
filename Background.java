/**
 * this class is the background for the introduction and select screen
 
 */
public class Background extends Animation{

	public Background() {
		
		super("src/Images/Background/background_",5, 101, ".jpg");

	}
	public Background(int duration) {
		super("src/Images/Background/background_",duration, 101, ".jpg");
	}
	public Background(int width, int height) {
		super("src/Images/Background/background_",5, 101, ".jpg",width,height);
	}

}
