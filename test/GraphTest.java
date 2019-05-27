import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GraphTest{

    private  Graph case30;
    private  Graph case32;
    private  Graph case34;
    private  Graph case36;
    private  Graph case38;
    private  Graph case40;
    private  Graph case42;
    private  Graph case44;
    private  Graph case46;
    private  Graph case48;
    private  Graph case50;
    private  Graph case60;

    @Before
    public void prepareGraphs(){

        case30 = new Graph(new In("cases/caso30.txt"));
        case32 = new Graph(new In("cases/caso32.txt"));
        case34 = new Graph(new In("cases/caso34.txt"));
        case36 = new Graph(new In("cases/caso36.txt"));
        case38 = new Graph(new In("cases/caso38.txt"));
        case40 = new Graph(new In("cases/caso40.txt"));
        case42 = new Graph(new In("cases/caso42.txt"));
        case44 = new Graph(new In("cases/caso44.txt"));
        case46 = new Graph(new In("cases/caso46.txt"));
        case48 = new Graph(new In("cases/caso48.txt"));
        case50 = new Graph(new In("cases/caso50.txt"));
        case60 = new Graph(new In("cases/caso60.txt"));
    }

    @Test
    public void testCase30()    {
        assertEquals(8, case30.conquered());
    }

    @Test
    public void testCase32()    {
        assertEquals(8, case32.conquered());
    }

    @Test
    public void testCase34()    {
        assertEquals(8, case34.conquered());
    }

    @Test
    public void testCase36()    {
        assertEquals(9, case36.conquered());
    }

    @Test
    public void testCase38()    {
        assertEquals(11, case38.conquered());
    }

    @Test
    public void testCase40()    {
        assertEquals(10, case40.conquered());
    }

    @Test
    public void testCase42()    {
        assertEquals(11, case42.conquered());
    }

    @Test
    public void testCase44()    {
        assertEquals(11, case44.conquered());
    }

    @Test
    public void testCase46()    {
        assertEquals(13, case46.conquered());
    }

    @Test
    public void testCase48()    {
        assertEquals(13, case48.conquered());
    }

    @Test
    public void testCase50()    {
        assertEquals(13, case50.conquered());
    }

    @Test
    public void testCase60()    {
        assertEquals(16, case60.conquered());
    }
}
