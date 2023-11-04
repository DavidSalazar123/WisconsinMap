import java.util.ArrayList;
import java.util.Arrays;

//interface (implemented with proposal)

interface MapDataInterface {
 public String getStartLocation();
 public int getStartX();
 public int getStartY();
 public String getEndLocation();
 public int getEndX();
 public int getEndY();
}

//public class (implemented primarily in final app week)

public class MapData implements MapDataInterface {

 private String startLocation;
 private int startX;
 private int startY;
 private String endLocation;
 private int endX;
 private int endY;
	
 MapData() {
	 startLocation = "";
	 startX = 0;
	 startY = 0;
	 endLocation = "";
	 endX = 0;
	 endY = 0;
 }
 
 MapData(String startLocation, int startX, int startY, String endLocation, int endX, int endY) {
	 this.startLocation = startLocation;
	 this.startX = startX;
	 this.startY = startY;
	 this.endLocation = endLocation;
	 this.endX = endX;
	 this.endY = endY;
 }
	
 @Override
 public String getStartLocation() {
	 return this.startLocation;
 }

 @Override
 public int getStartX() {
     return this.startX;
 }
 @Override
 public int getStartY() {
     return this.startY;
 }
 @Override
 public String getEndLocation() {
	 return this.endLocation;
 }
 @Override
 public int getEndX() {
     return this.endX;
 }
 @Override
 public int getEndY() {
     return this.endY;
 }

}

//placeholder(s) (implemented with proposal, and possibly added to later)
class MapDataPlaceholderA implements MapDataInterface {
    public String getStartLocation() { return "UW Hospital"; }
    public int getStartX() { return 40; }
    public int getStartY() { return 55; }
    public String getEndLocation() { return "Capitol"; }
    public int getEndX() { return 21; }
    public int getEndY() { return -8; }
}
class MapDataPlaceholderB implements MapDataInterface {
    public String getStartLocation() { return "Van Vleck"; }
    public int getStartX() { return 10; }
    public int getStartY() { return -4; }
    public String getEndLocation() { return "Union South"; }
    public int getEndX() { return 20; }
    public int getEndY() { return 21; }
}
class MapDataPlaceholderC implements MapDataInterface {
    public String getStartLocation() { return "Camp Randall"; }
    public int getStartX() { return 30; }
    public int getStartY() { return 13; }
    public String getEndLocation() { return "Dejope"; }
    public int getEndX() { return 45; }
    public int getEndY() { return -11; }
}