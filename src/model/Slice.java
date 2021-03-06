package model;

public final class Slice implements Cloneable {

	public final Coordinate position;
	public final int numRows;
	public final int numColumns;

	public Slice(Coordinate position, int numRows, int numColumns) {
		this.position = position;
		this.numRows = numRows;
		this.numColumns = numColumns;
	}

	public Slice(int numRows, int numColumns) {
		this.position = null;
		this.numRows = numRows;
		this.numColumns = numColumns;
	}

	@Override
	public String toString() {
		if (position == null) {
			return String.format("Slice %dx%d", numRows, numColumns);
		} else {
			return String.format("Slice at (%d,%d) %dx%d", position.getRow(), position.getColumn(), numRows,
					numColumns);
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
