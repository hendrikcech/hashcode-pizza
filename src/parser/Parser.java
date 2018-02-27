package parser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import model.Pizza;
import model.Problem;
import model.Topping;

public class Parser {

    private final Path path;
    private Pizza pizza;

    public Parser(Path path) {
	this.path = path;
    }

    public Problem parse() throws ParserException {
	List<String> lines;
	try {
	    lines = Files.readAllLines(path, StandardCharsets.US_ASCII);

	    final int[] header = parseHeader(lines.get(0));

	    Topping[][] topping = new Topping[header[0]][header[1]];
	    int rowNum = -1;
	    for (String line : lines) {
		if (rowNum == -1) {
		    rowNum = 0;
		    continue;
		}
		topping[rowNum] = parseSliceRow(line, header[1]);
		rowNum++;
	    }
	    return new Problem(new Pizza(topping), header[2], header[3]);

	} catch (IOException e) {
	    throw new ParserException(e);
	}

    }

    private int[] parseHeader(String line) throws ParserException {
	String[] strParts = line.split(" ");
	if (strParts.length != 4) {
	    throw new ParserException("Header row must contain 4 ints");
	}
	// 0: rows, 1: columns, 2: min ingredients per slice, 3: max cells per
	// slice
	int[] parts;
	try {
	    parts = Arrays.stream(strParts).mapToInt(Integer::parseInt).toArray();
	} catch (NumberFormatException e) {
	    throw new ParserException("Header row must only contain ints", e);
	}
	return parts;
    }

    private Topping[] parseSliceRow(String line, int numberOfColumns) throws ParserException {
	char[] chars = line.toCharArray();
	if (chars.length != numberOfColumns) {
	    throw new ParserException("Slice row must have toppings for every cell in row");
	}
	Topping[] row = new Topping[numberOfColumns];
	for (int column = 0; column < numberOfColumns; column++) {
	    char c = chars[column];
	    if (c == 'T') {
		row[column] = Topping.TOMATO;
	    } else if (c == 'M') {
		row[column] = Topping.MUSHROOM;
	    } else {
		throw new ParserException("Slice rows must only contain T and M characters");
	    }
	}
	return row;
    }
}
