package algo;

import java.util.List;

import model.Coordinate;
import model.Pizza;
import model.Problem;
import model.Slice;

public class Greedy {

	private final Pizza pizza;
	private final Problem problem;

	public Greedy(Problem p) {
		this.problem = p;
		this.pizza = p.pizza;
	}

	public Pizza compute() {
		for (int row = 0; row < pizza.getRowCount(); row++) {
			for (int col = 0; col < pizza.getColumnCount(); col++) {
				System.out.println("looking at " + row + "/" + col);
				if (pizza.covered[row][col]) {
					System.out.println("covered");
					continue;
				}
				List<Slice> possible = problem.getPossibleSlices(new Coordinate(row, col), pizza.covered);
				if (!possible.isEmpty()) {
					System.out.println(possible.get(possible.size() - 1));
					pizza.addToSolution(possible.get(possible.size() - 1));
				} else {
					System.out.println("isEmpty");
				}
			}
		}
		System.out.println("Solution");
		for (Slice s : pizza.solutionSlices) {
			System.out.println(s);
		}
		return pizza;
	}

	private int getScore() {
		int score = 0;
		for (boolean[] row : pizza.covered) {
			for (boolean cell : row) {
				if (cell) {
					score += 1;
				}
			}

		}
		return score;
	}

}
