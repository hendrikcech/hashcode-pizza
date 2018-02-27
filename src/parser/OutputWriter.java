package parser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import model.Coordinate;
import model.Pizza;
import model.Slice;

public class OutputWriter {

	private Pizza pizza;

	public OutputWriter(Pizza pizza) {
		this.pizza = pizza;
	}

	public String format() {
		StringBuffer s = new StringBuffer();
		s.append(pizza.solutionSlices.size() + "\n");
		for (Slice slice : pizza.solutionSlices) {
			Coordinate p = slice.position;
			s.append(p.getRow() + " " + p.getColumn() + " " + (p.getRow() + slice.numRows - 1) + " "
					+ (p.getColumn() + slice.numColumns - 1) + "\n");
		}
		return s.toString();
	}

	public void write(String path) {
		String s = format();
		try (PrintWriter writer = new PrintWriter(path)) {
			writer.print(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
