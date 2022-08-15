import java.awt.Font;

public class Place {

	int placeType;
	double x;
	double y;

	/*
	 * Constructor
	 * 
	 * @param migros
	 * @param x
	 * @param y
	 */
	Place(int placeType,double x, double y) {

		this.placeType = placeType;
		this.x = x;
		this.y = y;

	}

	public void draw(int placeType, double x, double y) {

		// circle
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		StdDraw.setPenRadius(0.01);
		StdDraw.filledCircle(x, y, 1);
	}
	public void writeNumber(int placeType, double x, double y) {
		
		Font font = new Font("Arial", Font.BOLD, 30);
		StdDraw.setFont(font);

		StdDraw.text(x, y, "1");
	}
}