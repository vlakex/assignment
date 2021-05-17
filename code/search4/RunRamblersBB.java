import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RunRamblersBB {

  public static void main(String[] arg) {

    TerrainMap tm = new TerrainMap("tmc.pgm");

    Coords start = new Coords(6,2);
    Coords end = new Coords(8,0);

    RamblersSearch s = new RamblersSearch(tm, end);

    int startCost = tm.getTmap()[6][2];
    
    SearchState search = (SearchState) new RamblersState(start, startCost);

    String res_bb = s.runSearch(search, "branchAndBound");
    System.out.println(res_bb);

  }
}