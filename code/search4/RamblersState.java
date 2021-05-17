import java.util.*;

public class RamblersState extends SearchState {

  // coordinates for this state
  private Coords coordinate;

  
  // constructor
  public RamblersState(Coords coords, int lc) {
    coordinate = coords;  
    localCost = lc;
  }

  // accessor
  public Coords getCoords() {
    return coordinate;
  }
  
  // goalPredicate
  public boolean goalPredicate(Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    Coords goal = rsearcher.getGoal(); 
    return (coordinate.equals(goal) == 0);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors(Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    TerrainMap map = rsearcher.getTmap();
    ArrayList<SearchState> succs = new ArrayList<SearchState>();
    
  


   
    int currX = coordinate.getx();
    int currY = coordinate.gety();
    int lc = 0;
    if (currX < 15 && currY < 15) {
      if ( (currY.getHeight()&&currX.getHeight()) <= ( map.getHeight() ) ) {
            lc = lc +1;
          }

      else {
      lc = lc +1 + (currY.getHeight()&&currX.getHeight()) - (map.getHeight()) );
          };
      
    succs.add((SearchState) new RamblersState(coordinate, lc));
      }
  
    return succs;
  }

  // sameState
  public boolean sameState(SearchState n2) {
    RamblersState rs2 = (RamblersState) n2;
    return (coordinate.equals(rs2.getCoords()) == 0);
  }

  // toString
  public String toString() {
    return ("Ramblers State: " + coordinate);
  }

}