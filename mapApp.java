import java.util.List;

public class mapApp {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
 
	MapFrontEnd ui = new MapFrontEnd();
       	ui.run();

  }

  public static MapBackEnd feed() {
    System.out.println("Welcome to Map App");
    try {
      // load file into list
      List<MapDataInterface> locationData = new MapLoader().loadFile("mapLocation.csv");
      // create back end and load locationData
      MapBackEnd engine = new MapBackEnd();
      for(MapDataInterface location : locationData){
        engine.addNode((MapData)location);
      }
      return engine;
    } catch (Exception e) {
      return null;
    }
  

  }

}

