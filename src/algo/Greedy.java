package algo;

import model.Pizza;
import model.Problem;

public class Greedy implements Solution {

    private final Pizza pizza;
    private boolean[][] covered;

    public Greedy(Problem p) {
	this.pizza = p.pizza;
	this.covered = new boolean[pizza.getRowCount()][pizza.getColumnCount()];
    }

    @Override
    public String compute() {

	return String.format("%d", getScore());
    }

    private int getScore() {
	int score = 0;
	for (boolean[] row : covered) {
	    for (boolean cell : row) {
		if (cell) {
		    score += 1;
		}
	    }

	}
	return score;
    }

}
