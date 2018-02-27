package model;

import java.util.HashSet;
import java.util.Set;

import com.google.common.math.IntMath;

public class Problem {

	public final Pizza pizza;
	public final int minIngPerSlice;
	public final int maxSliceSize;
	private final Set<Slice> sliceShapes;

	public Problem(Pizza pizza, int minIngPerSlice, int maxSliceSize) {
		this.pizza = pizza;
		this.minIngPerSlice = minIngPerSlice;
		this.maxSliceSize = maxSliceSize;
		sliceShapes = getSliceShapes();
	}

	public Set<Slice> getSliceShapes() {// NOT SO EASY
		Set<Slice> slices = new HashSet<Slice>();
		for (int size = minIngPerSlice * 2; size <= maxSliceSize; size++) {
			if (IntMath.isPrime(size)) {
				System.out.printf("Size%d%n", size);
				slices.add(new Slice(1, size));
				slices.add(new Slice(size, 1));
			} else {
				for (int devider = 2; devider < (int) (1 + Math.sqrt(size)); devider++) {
					if (size % devider == 0) {
						slices.add(new Slice(size / devider, devider));
						slices.add(new Slice(size, size / devider));
					}
				}
			}
		}
		return slices;
	}

	public Set<Slice> getPossibleSlices(Coordinate pos) {
		Set<Slice> slices = new HashSet<Slice>();
		for (Slice s : sliceShapes) {
			if (true) {
				Slice add = new Slice(pos, s.numRows, s.numColumns);
				slices.add(add);
			}
		}

		return slices;
	}

	public void printPossibleShapes() {
		for (Slice s : getSliceShapes()) {
			System.out.println(s);
		}
	}

}
