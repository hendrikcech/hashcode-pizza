package frequency;

import model.Coordinate;
import model.Problem;

public class ToppingFrequencyAnalyzer {
	private Problem p;
	private Coordinate c;
	private int reach;

	public ToppingFrequencyAnalyzer(Problem p, Coordinate c) {
		this.p = p;
		this.c = c;
		reach = p.maxSliceSize - 1;
	}

	public ToppingFrequency getAbove() {
		Coordinate top = Coordinate.addRow(c, -reach);
		Coordinate topLeft = Coordinate.addColumn(top, -reach);
		int height = p.maxSliceSize;
		int width = 2 * reach + 1;
		return countFrequency(topLeft, height, width);
	}

	public ToppingFrequency getRight() {
		Coordinate top = Coordinate.addRow(c, -reach);
		// +1 since c is in between the two reaches
		int height = 2 * reach + 1;
		int width = p.maxSliceSize;
		return countFrequency(top, height, width);
	}

	public ToppingFrequency getBelow() {
		Coordinate left = Coordinate.addColumn(c, -reach);
		// +1 since c is in between the two reaches
		int height = p.maxSliceSize;
		int width = 2 * reach + 1;
		return countFrequency(left, height, width);
	}

	public ToppingFrequency getLeft() {
		Coordinate left = Coordinate.addColumn(c, -reach);
		Coordinate topLeft = Coordinate.addRow(left, -reach);
		// +1 since c is in between the two reaches
		int height = 2 * reach + 1;
		int width = p.maxSliceSize;
		return countFrequency(topLeft, height, width);
	}

	/**
	 *
	 * @param topLeft
	 *            coordinate of top left most cell
	 * @param width
	 *            width of box *including* top left most cell
	 * @param height
	 *            height of box
	 * @return
	 */
	private ToppingFrequency countFrequency(Coordinate topLeft, int height, int width) {
		ToppingFrequency frequency = new ToppingFrequency();

		int untilRow = Coordinate.putRowInBounds(topLeft.getRow() + height, p);
		int untilColumn = Coordinate.putColumnInBounds(topLeft.getColumn() + width, p);
		topLeft = Coordinate.putInBounds(topLeft, p);

		for (int row = topLeft.getRow(); row < untilRow; row++) {
			for (int column = topLeft.getColumn(); column < untilColumn; column++) {
				frequency.add(p.pizza.getTopping(new Coordinate(row, column)));
			}
		}
		return frequency;
	}
}
