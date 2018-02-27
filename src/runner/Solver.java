package runner;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

import algo.Greedy;
import model.Pizza;
import model.Problem;
import parser.OutputWriter;

public class Solver implements Runnable {

	private Problem problem;
	private AtomicInteger max;

	public Solver(Problem problem, AtomicInteger maxValue) {
		this.problem = problem;
		max = maxValue;
	}

	@Override
	public void run() {
		System.out.println("started " + problem.name);
		while (true) {
			Pizza result = new Greedy(problem).compute();
			if (result.getScore() > max.get()) {
				synchronized (max) {
					max.set(result.getScore());
					System.out.println();
					System.out.println(new Timestamp(System.currentTimeMillis()).toString());
					System.out.println("bigger solution found for " + problem.name);
					System.out.println("new score = " + result.getScore());
					OutputWriter writer = new OutputWriter(result);
					writer.write("output/" + problem.name);
				}
			}
			problem.pizza.reset();
		}

	}

}
