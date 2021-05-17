import java.util.*;

public class RamblersState extends SearchState {

  // coordinates for this state
  private Coords coordinate;

  // accessor
  public Coords getCoords() {
    return coordinate;
  }

  // constructor
  public RamblersState(Coords coords, int lc) {
    coordinate = coords;  
    localCost = lc;
  }

  // goalPredicate
  public boolean goalPredicate(Search searcher) {
    RamblersSearch rsearcher = searcher;
    String goal = rsearcher.getGoal(); 
    return (coordinate.compareTo((goal) == 0);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors(Search searcher) {
    RamblersSearch rsearcher = searcher;
    TerrainMap map = rsearcher.getTmap();
    ArrayList<SearchState> succs = new ArrayList<SearchState>();
 

    for (int i=0; i<map.length; i++) {
      Coords currX = coordinate.getx();
      Coords currY = coordinate.gety();
      int lc = 0;
      if (currX <= 15 && currY <= 15) {
        if ( (currY.getHeight() && currX.getHeight()) <= ( map.gety().getHeight() && map.getx().getHeight()) ) {
              lc +1;
            }

        else {
        lc +1 + ( (currY.getHeight() && currX.getHeight()) - (map.gety().getHeight() && map.getx().getHeight()) );
            };
      
      succs.add((SearchState) new RamblersState(coordinate, lc);
        }
    }
    return succs;
  }

  // sameState
  public boolean sameState(SearchState s2) {
    RamblersState rs2 = s2;
    return (coordinate.compareTo(rs2.getCoords()) == 0);
  }

  // toString
  public String toString() {
    return ("Ramblers State: " + coordinate);
  }

}