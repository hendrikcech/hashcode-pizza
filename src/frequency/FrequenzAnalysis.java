package frequency;

import algo.Solution;
import model.Coordinate;
import model.Problem;

public class FrequenzAnalysis implements Solution {

    private Problem problem;

    public FrequenzAnalysis(Problem example) {
	this.problem = example;
    }

    @Override
    public String compute() {
	Coordinate topLeft = new Coordinate(0, 0);
	slice(topLeft);
	return null;
    }

    private void slice(Coordinate c) {
	ToppingFrequencyAnalyzer analyzer = new ToppingFrequencyAnalyzer(problem, c);
	// top
	if (!c.isAtTopBorder()) {

	} else if (!c.isAtRightBorder(problem)) {
	    analyzer.getRight();
	}
    }

}
