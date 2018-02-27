package frequency;

import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import model.Coordinate;
import model.Problem;
import parser.Parser;
import parser.ParserException;

public class ToppingFrequencyAnalyzerTest {

    private Problem problem;

    @Before
    public void setup() throws ParserException {
	this.problem = new Parser(Paths.get("input/smallish.in")).parse();
    }

    @Test
    public void testGetAbove() {
	ToppingFrequencyAnalyzer analyzer = new ToppingFrequencyAnalyzer(problem, new Coordinate(7, 8));
	ToppingFrequency freq = analyzer.getAbove();
	assert (freq.getTomatoes() == 20);
	assert (freq.getMushrooms() == 25);
    }

    @Test
    public void testGetRight() throws ParserException {
	Problem problem = new Parser(Paths.get("input/smallish.in")).parse();
	ToppingFrequencyAnalyzer analyzer = new ToppingFrequencyAnalyzer(problem, new Coordinate(7, 8));
	ToppingFrequency freq = analyzer.getRight();
	assert (freq.getTomatoes() == 20);
	assert (freq.getMushrooms() == 25);
    }

    @Test
    public void testGetBelow() {
	ToppingFrequencyAnalyzer analyzer = new ToppingFrequencyAnalyzer(problem, new Coordinate(7, 8));
	ToppingFrequency freq = analyzer.getBelow();
	assert (freq.getTomatoes() == 22);
	assert (freq.getMushrooms() == 23);
    }

    @Test
    public void testGetLeft() {
	ToppingFrequencyAnalyzer analyzer = new ToppingFrequencyAnalyzer(problem, new Coordinate(7, 8));
	ToppingFrequency freq = analyzer.getLeft();
	assert (freq.getTomatoes() == 19);
	assert (freq.getMushrooms() == 26);
    }

    @Test
    public void testTopLeftBorderHandling() {
	ToppingFrequencyAnalyzer analyzer = new ToppingFrequencyAnalyzer(problem, new Coordinate(2, 0));
	ToppingFrequency freq = analyzer.getAbove();
	assert (freq.getTomatoes() == 11);
	assert (freq.getMushrooms() == 4);
    }

    @Test
    public void testBottomBorderHandling() {
	ToppingFrequencyAnalyzer analyzer = new ToppingFrequencyAnalyzer(problem, new Coordinate(11, 9));
	ToppingFrequency freq = analyzer.getBelow();
	assert (freq.getTomatoes() == 13);
	assert (freq.getMushrooms() == 14);
	// TODO unterste Reihe wird nicht mitgezählt
    }
}
