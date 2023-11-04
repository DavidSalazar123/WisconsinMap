// --== CS400 Project Three File Header ==--
// Name: <Yuhan Zhang>
// Email: <yzhang2495@wisc.edu>
// Team: <Purple>
// Group: <AA>
// TA: <Ilay>
// Lecturer: <Florian>
// Notes to Grader: <Null>

import java.util.LinkedList;
import java.util.List;

/**
 * The back end interface of the MaoApp
 * 
 * @author Yuhan
 */
interface MapBackEndInterface {

  public boolean addNode(MapData start);

  public boolean deleteVertex(String name);

  public boolean deleteEdge(String node1, String node2);

  public List<String> findShortestPath(String start, String end);

}


/**
 * The class contain the back end of the MapAPp
 * 
 * @author Yuhan
 */
public class MapBackEnd implements MapBackEndInterface {
  CS400Graph<String> graph = new CS400Graph<String>();
  LinkedList<String> list = new LinkedList<String>();



  /**
   * delete the node and its edge by given node's name
   * 
   * @param the name of the node
   * @return true if remove the node successfully
   */
  @Override
  public boolean deleteVertex(String name) {
    if (graph.removeVertex(name)) {
      return true;
    }
    return false;
  }

  /**
   * find the shortest path according to the given nodes
   * 
   * @param start The start points
   * @param end   The end points
   * @return the value of the shortest path
   */
  @Override
  public List<String> findShortestPath(String start, String end) {
    return graph.shortestPath(start, end);
  }

  /**
   * Add the given node to the map and edges to nearby nodes
   * 
   * @param the node will be added
   * @return true if add node successfully
   *
   */
  @Override
  public boolean addNode(MapData nodes) {
    if (nodes == null) {
      throw new NullPointerException();
    }
    graph.insertVertex(nodes.getStartLocation());
    if (!list.contains(nodes.getStartLocation())) {
      list.add(nodes.getStartLocation());
    }

      graph.insertVertex(nodes.getEndLocation());
      if (!list.contains(nodes.getEndLocation())) {
        list.add(nodes.getEndLocation());
      }
      
      int xSquare = Math.abs((int) (nodes.getStartX() - nodes.getEndX()));
      xSquare = xSquare * xSquare;
      int ySquare = Math.abs((int) (nodes.getStartY() - nodes.getEndY()));
      ySquare = ySquare * ySquare;
      int weight = (int) Math.sqrt(xSquare + ySquare);
      graph.insertEdge(nodes.getStartLocation(), nodes.getEndLocation(), weight);
    
    return true;

  }

  /**
   * Delete the edge between the given nodes
   * 
   * @param the node at the start of the edge
   * @param the node at the end of the edge
   */
  @Override
  public boolean deleteEdge(String start, String end) {
    if (graph.containsVertex(start) && graph.containsVertex(end)) {
      graph.removeEdge(start, end);
    }
    return false;
  }

  /**
   * Return a list of current nodes
   * 
   * @return a list of current nodes
   */
  public LinkedList<String> getList() {
    return this.list;
  }

}


/**
 * Placeholder class of the MapBackEnd
 * 
 * @author Yuhan
 */
class MapBackEndPlaceholder implements MapBackEndInterface {
  MapData onlyMap;

  @Override
  public List<String> findShortestPath(String start, String end) {
    return null;
  }


  @Override
  public boolean addNode(MapData start) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean deleteVertex(String name) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean deleteEdge(String node1, String node2) {
    // TODO Auto-generated method stub
    return false;
  }

}
