package assignment2;
//Integer based, value encoded chromosome

//S. Sheridan 27/02/2014
//Institute of Technology Blanchardstown

import java.io.*;
import java.util.*;

public class ValueEncodedChromosome {

	private int[] genes; // Chromosome genes
	private int upper_bound; // Upper bound for randomising
	private int length; // Chromosome length
	private int fitness; // Fitness value for chromosome

	public ValueEncodedChromosome(int length, int upper_bound) {
		this.length = length;
		this.upper_bound = upper_bound;

		// TODO
		// Initialise fitness to high number. Bad fitness to start with
		fitness = 600;
		// Create the gene array based on length
		genes = new int[length];
		// Initialises the genes to random values between 1 - upper_bound, 30 in
		// this case
		for(int x=0;x<length;x++){
			genes[x] = (int) (Math.floor(Math.random()*upper_bound)+1);
		}
	}

	// Returns gene value at given locus
	public int getGeneAt(int pos) {
		// TODO
		return genes[pos];
	}

	// Used for changing a gene value at given locus in chromosome
	public void setGeneAt(int pos, int val) {
		// TODO
		genes[pos] = val;
	}

	// Will mutate a gene at given locus based on random value between 1 and
	// upper_bound
	public void mutateGeneAt(int pos) {
		// TODO
		int new_random = (int) Math.floor(Math.random()*upper_bound)+1;
		genes[pos] = new_random;
	}

	// Sets the chromosome length
	public void setLength(int length) {
		// TODO
		this.length = length;
	}

	// Returns the length of a chromosome
	public int getLength() {
		// TODO
		return length;
	}

	// Sets the fitness value for a chromosome
	public void setFitness(int fitness) {
		// TODO
		this.fitness = fitness;
	}

	// Returns the fitness value for a chromosome
	public int getFitness() {
		// TODO
		return fitness;
	}

	// Used to compare chromosomes in order to remove duplicates
	// Compare this chromosome against argument c
	public boolean equals(ValueEncodedChromosome c) {
		// TODO
		int result=length;
		for(int x=length; x==0;x--){
			if(c.getGeneAt(x)==genes[x]){
				result=result--;
			}
		}
		return (result==0);
	}

	// Helps to show chromosome values on screen
	public String toString() {
		// TODO
		String val = (genes[0] + "+" + genes[1] + "+" + genes[2] + "+" +genes[3]);
		return val;
	}
}
















