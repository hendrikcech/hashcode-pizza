package model;

public final class Slice {

	public final int numRows;
	public final int numColumns;

	public Slice(int numRows, int numColumns) {
		this.numRows = numRows;
		this.numColumns = numColumns;
	}

	@Override
	public String toString() {
		return String.format("Slice %dx%d", numRows, numColumns);
	}
}
