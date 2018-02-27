package model;

import java.util.HashSet;
import java.util.Set;

public class Problem {

    public final Pizza pizza;
    public final int minIngPerSlice;
    public final int maxSliceSize;

    public Problem(Pizza pizza, int minIngPerSlice, int maxSliceSize) {
	this.pizza = pizza;
	this.minIngPerSlice = minIngPerSlice;
	this.maxSliceSize = maxSliceSize;
    }

    public Set<Slice> getPossibleSlices() {// NOT SO EASY
	Set<Slice> slices = new HashSet<Slice>();
	for (int size = minIngPerSlice * 2; size <= maxSliceSize; size++) {
	    System.out.printf("Size%d%n", size);
	    slices.add(new Slice(1, size));
	    slices.add(new Slice(size, 1));
	}
	return slices;
    }

    public void printPossibleShapes() {
	for (Slice s : getPossibleSlices()) {
	    System.out.println(s);
	}
    }

}
