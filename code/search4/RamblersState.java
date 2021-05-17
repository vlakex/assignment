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
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    Coords goal = rsearcher.getGoal(); 
    return (coordinate == goal);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors(Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    TerrainMap map = rsearcher.getTmap();
    ArrayList<SearchState> succs = new ArrayList<SearchState>();
 

    for (int i=0; i<map.getHeight(); i++) {
      int currX = coordinate.getx();
      int currY = coordinate.gety();
      int lc = 0;
      if (currX < 15 && currY < 15) {
        if ( (currY.getHeight() && currX.getHeight()) <= ( coordinate.gety().getHeight() && coordinate.getx().getHeight()) ) {
              lc = lc +1;
            }

        else {
        lc = lc +1 + ( (currY.getHeight() && currX.getHeight()) - (coordinate.gety().getHeight() && coordinate.getx().getHeight()) );
            };
      
      succs.add((SearchState) new RamblersState(coordinate, lc));
        }
    }
    return succs;
  }

  // sameState
  public boolean sameState(SearchState s2) {
    RamblersState rs2 = (RamblersState) s2;
    return (coordinate == rs2.getCoords());
  }

  // toString
  public String toString() {
    return ("Ramblers State: " + coordinate);
  }

}