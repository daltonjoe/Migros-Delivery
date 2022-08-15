import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class delivery {
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String fileName = "data2.txt";
		File file = new File(fileName);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(fileName + ": city file can not be found!\nExiting program...");
			System.exit(1);
		}
		ArrayList<Place> location = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String[] parts = scanner.nextLine().split(",");
			double xCoord = Double.parseDouble(parts[0]);//split file to x coordinate 
			double yCoord = Double.parseDouble(parts[1]);//split file to y coordinate 
			int placeType; // Integer.parseInt(parts[2]);
			if (parts.length == 3) {
				placeType = 1;//if placeType is 1 it is migros
			} else {
				placeType = 2;//if placeType is 2 it is house
			}
			Place coord = new Place(placeType, xCoord, yCoord);// Each line in the data.txt file contains house
			location.add(coord);
		}
		//parameters of canvas
	    StdDraw.clear(StdDraw.WHITE);
		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(-0.1, 1.1);
		StdDraw.setYscale(-0.1, 1.1);
		StdDraw.setPenColor(Color.RED);
		StdDraw.setPenRadius(0.002);
		
		
		//show houses and migros in different colors
		for(int i =0;i<location.size();i++) {
		StdDraw.filledCircle(location.get(i).x, location.get(i).y, 0.025);
		if(location.get(i).placeType==1) {
			StdDraw.setPenColor(Color.GRAY);
		}else {
			StdDraw.setPenColor(Color.BLUE);
		}
		//StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setPenColor(Color.BLACK);
		for (int j = 0; j <location.size(); j++) {////numbering houses
			Font font = new Font("Arial", Font.PLAIN, 15);
			StdDraw.setFont(font);
			StdDraw.text(location.get(i).x, location.get(i).y, Integer.toString(i+1));
			}
		
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		for (int i1 = 0; i1 < location.size() - 1; i1++) {
			StdDraw.line(location.get(i1).x, location.get(i1).y, location.get(i1+1).x, location.get(i1+1).y);
		}
		
		}
		
	
		// System.out.println(location.get(1).x); // doğru okuyup okumadığnı kontrol
		// ettim
	}

}