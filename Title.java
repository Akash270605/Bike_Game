/**
 * this class is the title animation used in the start screen

 */
public class Title extends Animation{

	public Title() {
		super("src/Images/StartScreen/title_", 15, 6, ".png");
	}
	public Title(int w, int h) {
		super("src/Images/StartScreen/title_", 15, 6, ".png",w,h);
	}

	
}
