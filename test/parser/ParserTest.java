package parser;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import model.Coordinate;
import model.Problem;
import model.Topping;

public class ParserTest {

    @Test
    public void testParseStringSimple() throws ParserException {
	Path input = Paths.get("input/example.in");
	Parser parser = new Parser(input);

	Problem problem = parser.parse();
	assert (problem.pizza.getColumnCount() == 5);
	assert (problem.pizza.getRowCount() == 3);
	assert (problem.pizza.getTopping(new Coordinate(0, 0)) == Topping.TOMATO);
	assert (problem.pizza.getTopping(new Coordinate(1, 3)) == Topping.MUSHROOM);
    }

}
