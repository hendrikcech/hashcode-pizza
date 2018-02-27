package runner;

import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import parser.Parser;
import parser.ParserException;

public class Main {

	public static void main(String[] args) throws ParserException {
		AtomicInteger maxValueBig = new AtomicInteger();
		AtomicInteger maxValueMedium = new AtomicInteger();

		ExecutorService executor = Executors.newFixedThreadPool(8);

		executor.submit(new Solver(new Parser(Paths.get("input/big.in")).parse(), maxValueBig));
		executor.submit(new Solver(new Parser(Paths.get("input/big.in")).parse(), maxValueBig));
		executor.submit(new Solver(new Parser(Paths.get("input/big.in")).parse(), maxValueBig));
		executor.submit(new Solver(new Parser(Paths.get("input/big.in")).parse(), maxValueBig));
		executor.submit(new Solver(new Parser(Paths.get("input/big.in")).parse(), maxValueBig));
		executor.submit(new Solver(new Parser(Paths.get("input/medium.in")).parse(), maxValueMedium));
		executor.submit(new Solver(new Parser(Paths.get("input/medium.in")).parse(), maxValueMedium));
		executor.submit(new Solver(new Parser(Paths.get("input/medium.in")).parse(), maxValueMedium));
	}

}
