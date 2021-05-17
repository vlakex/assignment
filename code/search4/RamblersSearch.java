import java.util.*;

public class RamblersSearch extends Search {

  private TerrainMap map; // map we're searching
  private Coords goal; // goal city

  public TerrainMap getTmap() {
    return map;
  }

  public String getGoal() {
    return goal;
  }

  public RamblersSearch(TerrainMap m, Coords g) {
    map = m;
    goal = g;
  }
}