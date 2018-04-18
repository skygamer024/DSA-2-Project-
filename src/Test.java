import com.mazr.generator.RecursiveDivisionGenerator;
import com.mazr.grid.Cell;
import com.mazr.grid.Grid;

public class Test {
    public static void main(String[] args) {
        Grid grid = new Grid(5,5);
        grid.removeWall(0,0, Cell.Wall.West);
        Cell c = grid.get(0,0);
        System.out.println(c);
        RecursiveDivisionGenerator generator = new RecursiveDivisionGenerator(8,8);

    }
}
