import java.util.ArrayList;

// Custom packages.
import numbers.Reader;
import numbers.Analyzer;

public class run {
    public static void main( String[] args ) {

        Reader io = new Reader();
        Analyzer inspect = new Analyzer();

        // Owned by main class, passed between imported classes.
        ArrayList<Integer> myNumbers = new ArrayList<>();

        io.loopForInput( myNumbers );
        inspect.analyze( myNumbers );

    }
}
