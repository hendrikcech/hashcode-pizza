package model;

// immutable
public class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column) {
	this.row = row;
	this.column = column;
    }

    public int getRow() {
	return row;
    }

    public int getColumn() {
	return column;
    }

    public boolean isAtTopBorder() {
	return row == 0;
    }

    public boolean isAtRightBorder(Problem problem) {
	return column == problem.pizza.getColumnCount();
    }

    public boolean isAtLeftBorder() {
	return column == 0;
    }

    public static Coordinate addRow(Coordinate c, int row) {
	return new Coordinate(c.getRow() + row, c.getColumn());
    }

    public static Coordinate addColumn(Coordinate c, int column) {
	return new Coordinate(c.getRow(), c.getColumn() + column);
    }

    public static Coordinate putInBounds(Coordinate c, Problem p) {
	return new Coordinate(putRowInBounds(c.getRow(), p), putColumnInBounds(c.getColumn(), p));
    }

    public static int putRowInBounds(int row, Problem p) {
	if (row > p.pizza.getRowCount() - 1) {
	    row = p.pizza.getRowCount() - 1;
	}
	if (row < 0) {
	    row = 0;
	}
	return row;
    }

    public static int putColumnInBounds(int column, Problem p) {
	if (column > p.pizza.getColumnCount() - 1) {
	    column = p.pizza.getColumnCount() - 1;
	}
	if (column < 0) {
	    column = 0;
	}
	return column;
    }
}
