package runner;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import algo.Greedy;
import model.Problem;
import parser.Parser;
import parser.ParserException;

public class Main {

	public static void main(String[] args) throws ParserException {

		List<Problem> problems = new ArrayList<>(4);
		problems.add(new Parser(Paths.get("input/example.in")).parse());
		problems.add(new Parser(Paths.get("input/big.in")).parse());

		for (Problem p : problems) {
			p.printPossibleShapes();
			System.out.println(new Greedy(p).compute());
		}
	}

}
