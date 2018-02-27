package algo;

import java.util.List;
import java.util.Random;

import model.Coordinate;
import model.Pizza;
import model.Problem;
import model.Slice;

public class Greedy {

	private final Pizza pizza;
	private final Problem problem;
	private Random random = new Random();

	public Greedy(Problem p) {
		this.problem = p;
		this.pizza = p.pizza;
	}

	public Pizza compute() {
		for (int col = 0; col < pizza.getColumnCount(); col++) {
			for (int row = 0; row < pizza.getRowCount(); row++) {
				if (pizza.covered[row][col]) {
					continue;
				}
				List<Slice> possible = problem.getPossibleSlices(new Coordinate(row, col), pizza.covered);
				if (!possible.isEmpty()) {
					int index = possible.size() - 1;
					if (random.nextFloat() < 0.04) {
						index = random.nextInt(possible.size());
					}
					pizza.addToSolution(possible.get(index));
				}
			}
		}
		return pizza;
	}
}
