// Find the largest y value for x given
// F(x) = sin(x) * sin(0.4 * x) * sin(3.0f * x)
// S. Sheridan 27/02/2014
// Institute of Technology Blanchardstown

import java.io.*;
import java.util.*;

public class Genetic {
	
	private static final int POPULATION_SIZE = 15; 			// No. of chromosomes in the population
	private static final int CHROMOSOME_LENGTH = 10; 		// No. of genes per chromosome 
    private static final float CROSSOVER_FRACTION = 0.8f; 	// % of population that is recombined every evolution
    private static final float MUTATION_FRACTION = 0.1f; 	// % of populaiton that is mutated
	
	private static final int NUM_GENERATIONS = 800;
	
	public static void main(String[] args){
			
		// Create a population using genetic constants defined above
		Population p = new Population(POPULATION_SIZE, CHROMOSOME_LENGTH, CROSSOVER_FRACTION, MUTATION_FRACTION);

		// Each trial will run over NUM_GENERATIONS
		for(int gen = 0; gen < NUM_GENERATIONS; gen++){
			
			System.out.println("*** Generation " + gen + " ***");
			
			p.evolve(); // Evolve will output population values
		}
	}
}
