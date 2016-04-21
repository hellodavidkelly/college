// Binary encoded population
// S. Sheridan 27/02/2014
// Institute of Technology Blanchardstown

import java.io.*;
import java.util.*;

public class Population{
	
	private int population_size;					// Number of chromosomes in population
	private int chromosome_length;					// Number of genes per chromosome
	
	private BinaryEncodedChromosome[] population;	// Array to store chromosome objects
	
    private int [] rouletteWheel;					// Used for selecting parents
    private int rouletteWheelSize;					// Size of roulette wheel
	
    private float crossoverFraction;				// Control how many offspring will be created via crossover
    private float mutationFraction;					// Control the amount of mutation per evolution
	
			
	public Population(int population_size, int chromosome_length, float crossoverFraction, float mutationFraction){
		this.population_size = population_size;
		this.chromosome_length = chromosome_length;
		this.crossoverFraction = crossoverFraction;
		this.mutationFraction = mutationFraction;
		
		// Create the population of chromosomes
		population = new BinaryEncodedChromosome[population_size];
		
		// Ranomise the population
		initialisePopulation();
		
        // Build a roulette wheel array for selecting parents
		buildRouletteWheel();
		
	}
	// Ranomise the population
	public void initialisePopulation(){
		// Create an array of integer based value encoded chromosomes
		// Each chromosome will have an initial random value between 1 - 30
		// This initial random value is problem dependent
		for(int i = 0; i < population_size; i++){
			population[i] = new BinaryEncodedChromosome(chromosome_length);
		}
	}
	public void buildRouletteWheel(){
        // Build a roulette wheel array for selecting parents
		rouletteWheelSize = 0;
        for (int i=0; i < chromosome_length; i++)
        {
 	   		rouletteWheelSize += i + 1;
        }
        rouletteWheel = new int[rouletteWheelSize];
        int num_trials = chromosome_length;
        int index = 0;
        for (int i=0; i<chromosome_length; i++)
        {
 		   for (int j=0; j<num_trials; j++)
 		   {
 			   rouletteWheel[index++] = i;
 		   }
 		   num_trials--;
        }
	}
	// Set the population size
	public void setPopulationSize(int size){
		population_size = size;
	}
	// Set the crossover fraction
	public void setCrossoverFraction(float cf){
		crossoverFraction = cf;
	}
	// Set the mutation fraction
	public void setMutationFraction(float mf){
		mutationFraction = mf;
	}
	// Return a chromosome at given position in population
	public BinaryEncodedChromosome getChromosomeAt(int pos){
		return population[pos];
	}
	// Set the value of a chromosome at given position in population
	public void setChromosomeAt(int pos, BinaryEncodedChromosome c){
		population[pos] = c;
	}
	// Return the size of the population
	public int getSize(){
		return population_size;
	}
	// Return fitness for given chromosome
	private float fitness(float x){
		// TODO - See notes
	}
	
	// Swap populaiton members
	public void swap(int i, int k){
		BinaryEncodedChromosome temp;
		temp = population[i];
		population[i] = population[k];
		population[k] = temp;
	}
	// Sort the population based on their fitness 
	public void sort(){
		int i, j, first, temp;  
	     for ( i = population_size - 1; i > 0; i -- ){
	          first = 0;   //initialize to subscript of first element
	          //locate smallest element between positions 1 and i.
			  for(j = 1; j <= i; j ++){
	               if( population[j].getFitness() < population[first].getFitness() )         
	                 first = j;
	          }
	          swap(first, i);
	      } 
	}
	
 	// Set the fitness function for each population member
 	public void evaluate(){
 		for(int j = 0; j < population_size; j++){
 			float val = population[j].geneToFloat();
 			population[j].setFitness(fitness(val));
 		}
 	}
	
	// Select and combine genetic material
	public void crossover()
    {
       int num = (int)(population_size * crossoverFraction);
	   for (int i=num; i < population_size; i++){
 		  int c1 = (int)(rouletteWheelSize * Math.random() * 0.9999f);
 		  int c2 = (int)(rouletteWheelSize * Math.random() * 0.9999f);
 		  c1 = rouletteWheel[c1];
 		  c2 = rouletteWheel[c2];
		  if (c1 != c2){
 			  // Perform single point crossover
			  int locus = 1 + (int)((chromosome_length - 2) * Math.random());
			  for (int g=0; g < chromosome_length; g++){
 				  if (g < locus)
 				  	population[i].setGeneAt(g, population[c1].getGeneAt(g)); // Copy from parent c1 up to locus g
 				  else
 				    population[i].setGeneAt(g, population[c2].getGeneAt(g)); // Copy from parent c2 after locus g
 			  }
 		  }
       }
     }
	 // Carry out mutation on population	 
     public void mutate()
     {
	   int num = (int)(population_size * mutationFraction);
	   for (int i=0; i<num; i++){
 		  int c = (int)(population_size * Math.random() * 0.99); 	// Random chromosome
 		  int g = (int)(chromosome_length * Math.random() * 0.99);	// Random gene
		  population[c].mutateGeneAt(g);
       }
     }
	 // Remove any duplicate chromosomes from population to prevent stagnation
     public void removeDuplicates(){
 		// i>3 dont touch the top of the population
		for (int i=population_size - 1; i>3; i--){
 			for (int j=0; j<i; j++){
 				if (population[i].equals(population[j])){
 					int g = (int)(chromosome_length * Math.random() * 0.99);
					population[i].mutateGeneAt(g);
 					break;
 				}
 			}
 		}
     }
	 // Called to envoke one complete evolution		 
     public void evolve(){
		 //TODO - See algorithm steps in notes
		 // NOTE: The correct place to output the population for display
		 // is right after the popultion is sorted and before crossover.
		 // We have an output method below to display the population so just call it.
     }
	 public void output(){
		// Print the population and their fitness values
		for(int j = 0; j < population_size; j++){
			System.out.println("Chromosome[" + j + "] = " + population[j].toString() + " Value = " + population[j].geneToFloat() + " Fitness = " + population[j].getFitness());
		}
	 }
	
}
