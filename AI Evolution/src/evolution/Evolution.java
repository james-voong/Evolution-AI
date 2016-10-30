package evolution;

import java.util.Random;

import nz.ac.vuw.kol.OptimisationFunction;

public class Evolution {
	static Random rand = new Random();

	public static void main(String[] args) {
		/** Initialise population with random candidate solutions */
		double p1, p2, p3, p4, p5;
		p1 = rand.nextDouble();
		p2 = rand.nextDouble();
		p3 = rand.nextDouble();
		p4 = rand.nextDouble();
		p5 = rand.nextDouble();
		double[] parent = new double[] { p1, p2, p3, p4, p5 };
		// System.out.println(p1);
		// System.out.println(p2);
		// System.out.println(p3);
		// System.out.println(p4);
		// System.out.println(p5);

		double[] child = new double[5];

		/** Evaluate each candidate */
		// ??

		long time = System.currentTimeMillis();

		/** Repeat until (termination condition) is satisfied */
		int counter = 0;
		boolean change = true;
		double fixed = 5;
		int noChangeCounter = 0;
		while (System.currentTimeMillis() - time < 100000) {/** Do: */
			noChangeCounter++;
			if (noChangeCounter == 10000 && fixed > 2) {
				fixed = 2;
				noChangeCounter = 0;
			} else if (noChangeCounter == 10000 && fixed > 1) {
				fixed = 1;
				noChangeCounter = 0;
			} else if (noChangeCounter == 10000 && fixed > 0.5) {
				if (fixed > 0.5) {
					fixed = 0.5;
					noChangeCounter = 0;
				} else if (fixed == 0.5 && fixed != 0.1) {
					fixed -= 0.1;
					noChangeCounter = 0;
				} else if (fixed == 0.1) {
					fixed = 2;
					noChangeCounter = 0;
				}
			}
			/** Test if output is higher or lower than child */
			if (change == true) {
				child[0] = rand.nextDouble();
				child[1] = rand.nextDouble();
				child[2] = rand.nextDouble();
				child[3] = rand.nextDouble();
				child[4] = rand.nextDouble();
			}

			// child[0] = rand.nextDouble() + Math.random() * 0.5;
			// child[1] = rand.nextDouble() + Math.random() * 0.5;
			// child[2] = rand.nextDouble() + Math.random() * 0.5;
			// child[3] = rand.nextDouble() + Math.random() * 0.5;
			// child[4] = rand.nextDouble() + Math.random() * 0.5;

			// parent[0] = parent[0] + Math.random() * 0.5;
			// parent[1] = parent[1] + Math.random() * 0.5;
			// parent[2] = parent[2] + Math.random() * 0.5;
			// parent[3] = parent[3] + Math.random() * 0.5;
			// parent[4] = parent[4] + Math.random() * 0.5;

			if (change == false) {

				if (rand.nextInt(100) > 50) {
					child[0] = parent[0] + Math.random() * fixed;
				} else {
					child[0] = parent[0] - Math.random() * fixed;
				}
				if (rand.nextInt(100) > 50) {
					child[1] = parent[1] + Math.random() * fixed;
				} else {
					child[1] = parent[1] - Math.random() * fixed;
				}
				if (rand.nextInt(100) > 50) {
					child[2] = parent[2] + Math.random() * fixed;
				} else {
					child[2] = parent[2] - Math.random() * fixed;
				}
				if (rand.nextInt(100) > 50) {
					child[3] = parent[3] + Math.random() * fixed;
				} else {
					child[3] = parent[3] - Math.random() * fixed;
				}
				if (rand.nextInt(100) > 50) {
					child[4] = parent[4] + Math.random() * fixed;
				} else {
					child[4] = parent[4] - Math.random() * fixed;
				}

			}
			/***/
			if (OptimisationFunction.unknownFunction(child) < OptimisationFunction.unknownFunction(parent)) {
				parent = child.clone();
				change = false;
				noChangeCounter = 0;
			}
			counter++;
			if (counter == 5000) {
				System.out.println("Parent: " + OptimisationFunction.unknownFunction(parent));
				counter = 0;
			}
		}
		System.out.println("\nFinal Result: " + OptimisationFunction.unknownFunction(parent));
		System.out.println("Parent[0] = " + parent[0]);
		System.out.println("Parent[1] = " + parent[1]);
		System.out.println("Parent[2] = " + parent[2]);
		System.out.println("Parent[3] = " + parent[3]);
		System.out.println("Parent[4] = " + parent[4]);

	}
}
