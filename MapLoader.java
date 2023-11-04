import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// interface (implemented with proposal)

interface MapLoaderInterface {
    public List<MapDataInterface> loadFile(String csvFilePath) throws FileNotFoundException;
}

// public class (implemented primarily in final app week)

public class MapLoader implements MapLoaderInterface {

    @Override
    public List<MapDataInterface> loadFile(String csvFilePath) throws FileNotFoundException {
    	List<MapDataInterface> mapList = new LinkedList<>();
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
    		mapList = readFile(br);
    	} catch(FileNotFoundException e) {
    		e.printStackTrace();
    	} catch(IOException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
        return mapList;
    }
    
    private List<MapDataInterface> readFile(BufferedReader br) throws FileNotFoundException {
    	List<MapDataInterface> mapList = new LinkedList<>();
    	try {
    		String header = br.readLine();
    		String[] columns = header.split(",");
    		
    		// get index of title, authors, year, doi, path
    		int startHeaderIndex = 0;
    		while(!columns[startHeaderIndex].equalsIgnoreCase("StartLocation")) {
    			startHeaderIndex++;
    		}
    		int xStartHeaderIndex = 0;
    		while(!columns[xStartHeaderIndex].equalsIgnoreCase("StartX")) {
    			xStartHeaderIndex++;
    		}
    		int yStartHeaderIndex = 0;
    		while(!columns[yStartHeaderIndex].equalsIgnoreCase("StartY")) {
    			yStartHeaderIndex++;
    		}
    		int endHeaderIndex = 0;
    		while(!columns[endHeaderIndex].equalsIgnoreCase("EndLocation")) {
    			endHeaderIndex++;
    		}
    		int xEndHeaderIndex = 0;
    		while(!columns[xEndHeaderIndex].equalsIgnoreCase("EndX")) {
    			xEndHeaderIndex++;
    		}
    		int yEndHeaderIndex = 0;
    		while(!columns[yEndHeaderIndex].equalsIgnoreCase("EndY")) {
    			yEndHeaderIndex++;
    		}
    		
    		//read article details
    		String rowLine = br.readLine();
    		while (rowLine != null) {
    			String[] row = rowLine.split(",");
    			//get the title, author, year, doi, path
    			String startLocation = row[startHeaderIndex];
    			int startX = Integer.parseInt(row[xStartHeaderIndex]);
    			int startY = Integer.parseInt(row[yStartHeaderIndex]);
    			String endLocation = row[endHeaderIndex];
    			int endX = Integer.parseInt(row[xEndHeaderIndex]);
    			int endY = Integer.parseInt(row[yEndHeaderIndex]);
    			
    			//add MapData object to the maplist
    			mapList.add(new MapData(startLocation, startX, startY, endLocation, endX, endY));
    			
    			//read next line
    			rowLine = br.readLine();
    		}
    		br.close();
    		
    	} catch(FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch(IOException e) {
	    	e.printStackTrace();
	    	
		}
		return mapList;
    }

}

// placeholder(s) (implemented with proposal, and possibly added to later)
class MapLoaderPlaceholder implements MapLoaderInterface {
    public List<MapDataInterface> loadFile(String csvFilePath) throws FileNotFoundException{
        List<MapDataInterface> list = new LinkedList<>();
        list.add(new MapDataPlaceholderA());
        list.add(new MapDataPlaceholderB());
        list.add(new MapDataPlaceholderC());
        return list;
    }
}
