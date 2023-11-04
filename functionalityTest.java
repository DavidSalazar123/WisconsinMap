import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.console.ConsoleLauncher;
import static org.junit.jupiter.api.Assertions.*;

public class functionalityTest {
	
	public static void main(String[] args) throws Exception {
		// Run ALL Tests
		String className = MethodHandles.lookup().lookupClass().getName();
	       	String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
      		String[] arguments = new String[] {
        		"-cp",
        		classPath,
        		"--include-classname=.*",
        		"--select-class=" + className };
      		ConsoleLauncher.main(arguments);
	}
	
		// Data Wrangler Tests
	
		/**
		 * @author Jodie Ritchie (Data Wrangler)
		 * Checks that the loaded file's start and end location name is correct
		 */
		@Test
		public void dataWrangler_TestLocationName() {
			MapLoader load = new MapLoader();
	        try {
	        	List<MapDataInterface> file = load.loadFile(".\\src\\mapLocation.csv");
	        	assertEquals("Memorial Library",file.get(0).getStartLocation());
	        	assertEquals("Kohl Center",file.get(7).getStartLocation());
	        	assertEquals("Capitol", file.get(12).getEndLocation());
	        	assertEquals("Dejope", file.get(16).getEndLocation());
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.println("Unrecognized Exception!");
	            e.printStackTrace();
	        }
		}
		
		/**
		 * @author Jodie Ritchie (Data Wrangler)
		 * Checks that the loaded file's start and end x-coordinates are correct
		 */
		@Test
		public void dataWrangler_TestXCoordinate() {
			MapLoader load = new MapLoader();
	        try {
	        	List<MapDataInterface> file = load.loadFile(".\\src\\mapLocation.csv");
	        	assertEquals(28, file.get(0).getStartX());
	        	assertEquals(7, file.get(3).getStartX());
	        	assertEquals(28, file.get(14).getEndX());
	        	assertEquals(72, file.get(15).getEndX());
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.println("Unrecognized Exception!");
	            e.printStackTrace();
	        }
		}
		
		/**
		 * @author Jodie Ritchie (Data Wrangler)
		 * Checks that the loaded file's start and end y-coordinates are correct
		 */
		@Test
		public void dataWrangler_TestYCoordinate() {
			MapLoader load = new MapLoader();
	        try {
	        	List<MapDataInterface> file = load.loadFile(".\\src\\mapLocation.csv");
	        	assertEquals(-12, file.get(0).getStartY());
	        	assertEquals(33, file.get(10).getStartY());
	        	assertEquals(19, file.get(9).getEndY());
	        	assertEquals(-12, file.get(14).getEndY());
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.println("Unrecognized Exception!");
	            e.printStackTrace();
	        }
		}

		
		// Back-end Developer's Test
		 /**
	     * Test the addNode in MapBackEnd and the computation of weight
	     * @author Yuhan Zhang
	     */
		@Test
        public void backEndDeveloper_TestAddNodes() {
		  //Initialize map 
	      MapBackEnd backend = new MapBackEnd();
	      MapData data1 = new MapData("A", 0, 0, "B", 3, 4);
	      backend.addNode(data1);
	      assertTrue(backend.graph.containsVertex("A"));
	      assertTrue(backend.graph.containsVertex("B"));
	      assertTrue(backend.graph.containsEdge("A", "B"));
	      assertTrue(backend.graph.getWeight("A", "B") == 5);
		}
		
		 /**
	     * Test the deleteNode in MapBackEnd
	     * @author Yuhan Zhang
	     */
		@Test
		public void backEndDeveloper_TestDeleteNodes() {
		  MapBackEnd backend = new MapBackEnd();
          MapData data1 = new MapData("A", 0, 0, "B", 3, 4);
          backend.addNode(data1);
          backend.deleteVertex("A");
          assertFalse(backend.graph.containsVertex("A"));
		}
		
	     /**
         * Test the shortestPath in BackEnd and check the List<String> returned
         * @author Yuhan Zhang
         */
		@Test
        public void backEndDeveloper_TestShortestpath() {
          MapBackEnd backend = new MapBackEnd();
          MapData data1 = new MapData("A", 0, 0, "B", 3, 4);
          MapData data2 = new MapData("A", 0, 0, "C", 3, 0);
          MapData data3 = new MapData("C", 3, 0, "B", 3, 4);
          backend.addNode(data1);
          backend.addNode(data2);
          backend.addNode(data3);
          
          assertTrue(backend.findShortestPath("A", "B").get(0).equals("A") && backend.findShortestPath("A", "B").get(1).equals("B")); 
		}
		
		
		// Integration Manager's Test

	 // Data Wrangler
    /**
     * @author Aaron Torres (Integration Manager)
     * Additional test that checks that the loaded file's start and end location name is correct
     */
    @Test
    public void integrationManager_TestLocationName() {
        MapLoader load = new MapLoader();
        try {
            List<MapDataInterface> file = load.loadFile("./src/mapLocation.csv");
            assertEquals("Picnic Point",file.get(1).getStartLocation());
            assertEquals("Culver's",file.get(8).getStartLocation());
            assertEquals("UW Hospital", file.get(2).getEndLocation());
            assertEquals("Nicholas Recreation Center", file.get(13).getEndLocation());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unrecognized Exception!");
            e.printStackTrace();
        }
    }

    /**
     * @author Aaron Torres (Integration Manager)
     * Additional test that checks that the loaded file's start and end x-coordinates are correct
     */
    @Test
    public void integrationManager_TestXCoordinate() {
        MapLoader load = new MapLoader();
        try {
            List<MapDataInterface> file = load.loadFile("./src/mapLocation.csv");
            assertEquals(40, file.get(1).getStartX());
            assertEquals(41, file.get(2).getStartX());
            assertEquals(51, file.get(12).getEndX());
            assertEquals(10, file.get(13).getEndX());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unrecognized Exception!");
            e.printStackTrace();
        }
    }

    /**
     * @author Aaron Torres (Integration Manager)
     * Additional test that checks that the loaded file's start and end y-coordinates are correct
     */
    @Test
    public void integrationManager_TestYCoordinate() {
        MapLoader load = new MapLoader();
        try {
            List<MapDataInterface> file = load.loadFile("./src/mapLocation.csv");
            assertEquals(5, file.get(1).getStartY());
            assertEquals(6, file.get(2).getStartY());
            assertEquals(9, file.get(10).getEndY());
            assertEquals(-8, file.get(11).getEndY());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unrecognized Exception!");
            e.printStackTrace();
        }
    }

        // Back-end
    /**
     * @author Aaron Torres (Integration Manager)
     * Additional test that tests the addNode in MapBackEnd and the computation of weight
     */
    @Test
    public void integrationManager_TestAddNodes() {
      //Initialize map
      MapBackEnd backend = new MapBackEnd();
      MapData data1 = new MapData("D", 1, 1, "E", 4, 5);
      backend.addNode(data1);
      assertTrue(backend.graph.containsVertex("D"));
      assertTrue(backend.graph.containsVertex("E"));
      assertTrue(backend.graph.containsEdge("D", "E"));
      assertTrue(backend.graph.getWeight("D", "E") == 5);
    }

    /**
     * @author Aaron Torres (Integration Manager)
     * Additional test that tests the deleteNode in MapBackEnd
     */
    @Test
    public void integrationManager_TestDeleteNodes() {
      MapBackEnd backend = new MapBackEnd();
      MapData data1 = new MapData("D", 1, 1, "E", 4, 5);
      backend.addNode(data1);
      backend.deleteVertex("D");
      assertFalse(backend.graph.containsVertex("D"));
      backend.deleteVertex("E");
      assertFalse(backend.graph.containsVertex("E"));
    }

    /**
     * @author Aaron Torres (Integration Manager)
     * Additional test that tests the shortestPath in BackEnd and check the List<String> returned
     */
    @Test
    public void integrationManager_TestShortestpath() {
      MapBackEnd backend = new MapBackEnd();
      MapData data1 = new MapData("D", 2, 2, "E", 5, 6);
      MapData data2 = new MapData("D", 2, 2, "F", 5, 2);
      MapData data3 = new MapData("F", 5, 2, "E", 5, 6);
      backend.addNode(data1);
      backend.addNode(data2);
      backend.addNode(data3);

      assertTrue(backend.findShortestPath("D", "E").get(0).equals("D") && backend.findShortestPath("D", "E").get(1).equals("E"));
    }

    /**
     * @author Aaron Torres (Integration Manager)
     * Test if the map is successfully fed to the frontend
     * */
    @Test
    public void frontEndDeveloper_TestFeedingMap() {
        MapFrontEnd m = new MapFrontEnd();
        assertTrue(m.testFeedingMap());
    }

    
		// Front-end Developer's Test

    /**
     * @author Jiayan Zhang
     * Test if the character in the paired list is successfully loaded
     * */
    @Test
    public void frontEndDeveloper_TestCharacterPairedList() {
        MapFrontEnd n = new MapFrontEnd();
        assertTrue(n.testCharacterPairedList());
    }

    /**
     * @author Jiayan Zhang
     * Test various cases of valid and invalid inputs
     * */
    @Test
    public void frontEndDeveloper_TestValidAndInvalidInput() {
        MapFrontEnd o = new MapFrontEnd();
        assertFalse(o.testValidAndInvalidInputs());
    }

    /**
     * @author Jiayan Zhang
     * Test if all the elements of the page are loaded
     * */
    @Test
    public void frontEndDeveloper_TestIfAllElementsAreLoadedp() {
        MapFrontEnd p = new MapFrontEnd();
        assertTrue(p.testIfAllElementsAreLoaded());
    }
}


