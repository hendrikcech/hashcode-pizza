package model;

import java.util.ArrayList;
import java.util.List;

import com.google.common.math.IntMath;

import frequency.ToppingFrequency;

public class Problem {

	public final Pizza pizza;
	public final int minIngPerSlice;
	public final int maxSliceSize;
	private final List<Slice> sliceShapes;
	public String name;

	public Problem(Pizza pizza, int minIngPerSlice, int maxSliceSize, String path) {
		this.pizza = pizza;
		this.minIngPerSlice = minIngPerSlice;
		this.maxSliceSize = maxSliceSize;
		sliceShapes = getSliceShapes();
		name = path;
	}

	public List<Slice> getSliceShapes() {
		List<Slice> slices = new ArrayList<Slice>();
		for (int size = minIngPerSlice * 2; size <= maxSliceSize; size++) {
			if (IntMath.isPrime(size)) {
				slices.add(new Slice(1, size));
				slices.add(new Slice(size, 1));
			} else {
				for (int divider = 2; divider < (int) (1 + Math.sqrt(size)); divider++) {
					if (size % divider == 0) {
						slices.add(new Slice(size / divider, divider));
						slices.add(new Slice(divider, size / divider));
					}
				}
			}
		}
		return slices;
	}

	public List<Slice> getPossibleSlices(Coordinate pos, boolean[][] covered) {
		List<Slice> slices = new ArrayList<Slice>();
		for (Slice s : sliceShapes) {
			if (isValidSlice(pos, s, covered)) {
				Slice add = new Slice(pos, s.numRows, s.numColumns);
				slices.add(add);
			}
		}
		return slices;
	}

	private boolean isValidSlice(Coordinate pos, Slice s, boolean[][] covered) {
		ToppingFrequency frequency = new ToppingFrequency();
		if (pos.getColumn() + s.numColumns > pizza.getColumnCount() || pos.getRow() + s.numRows > pizza.getRowCount()) {
			return false;
		}
		for (int row = pos.getRow(); row < pos.getRow() + s.numRows; row++) {
			for (int col = pos.getColumn(); col < pos.getColumn() + s.numColumns; col++) {
				if (covered[row][col]) {
					return false;
				}
				frequency.add(pizza.getTopping(new Coordinate(row, col)));
			}
		}
		return (frequency.getMushrooms() >= minIngPerSlice && frequency.getTomatoes() >= minIngPerSlice);

	}

	public void printPossibleShapes() {
		for (Slice s : getSliceShapes()) {
			System.out.println(s);
		}
	}

}
