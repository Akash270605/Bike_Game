/**
 * this represents a screen in this case it is the beggining when you press select 
 * it is a credit screen which includes player scores, controls, and maybe settings if i have time
 * @author leveno
 *
 */
public class Credit extends Animation{

	public Credit() {
		super("src/Images/CreditScreen/credit_", 10, 1, ".png");
		// TODO Auto-generated constructor stub
	}
	public Credit(int w, int h) {
		super("src/Images/CreditScreen/credit_", 10, 1, ".png",w,h);
		// TODO Auto-generated constructor stub
	}

}
