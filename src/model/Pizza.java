package model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
	private Topping[][] pizza;
	public boolean[][] covered;
	public List<Slice> solutionSlices = new ArrayList<>();

	public Pizza(Topping[][] pizza) {
		this.pizza = pizza;
		this.covered = new boolean[getRowCount()][getColumnCount()];
	}

	public void addToSolution(Slice slice) {
		solutionSlices.add(slice);
		for (int row = slice.position.getRow(); row < slice.position.getRow() + slice.numRows; row++) {
			for (int col = slice.position.getColumn(); col < slice.position.getColumn() + slice.numColumns; col++) {
				covered[row][col] = true;
			}
		}
	}

	public boolean isCovered(Slice slice) {
		for (int row = slice.position.getRow(); row < slice.position.getRow() + slice.numRows; row++) {
			for (int col = slice.position.getColumn(); col < slice.position.getColumn() + slice.numColumns; col++) {
				if (covered[row][col]) {
					return true;
				}
			}
		}
		return false;
	}

	public Topping getTopping(Coordinate c) {
		return pizza[c.getRow()][c.getColumn()];
	}

	public void setTopping(Coordinate c, Topping topping) {
		pizza[c.getRow()][c.getColumn()] = topping;
	}

	public int getRowCount() {
		return pizza.length;
	}

	public int getColumnCount() {
		return pizza[0].length;
	}
}
