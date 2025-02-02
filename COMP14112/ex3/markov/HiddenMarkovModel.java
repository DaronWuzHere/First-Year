package markov;
import java.util.*;
import java.math.*;
import java.lang.reflect.*;

/**
 * HMM with normal distribution emission density for each feature vector component within each state
 **/

public class HiddenMarkovModel {

    private int noStates; // Number of hidden states in the model (excluding the start and stop states)
    private int featureDimension=Data.noMfcc; // We will only consider 13 dimensional MFCC vectors

    /*
     * transitionProbability[noStates][i] is probability from START to state i,
     * transitionProbability[i][noStates] is probability to STOP from state i,
     * transitionProbability[i][j] is probability of transition from state i to state j
     */

    private double[][] transitionProbability; 

    /*
     * emissionDensity [featureDimension][noStates] is a normal distribution for each dimension (MFCC component) in each state
     * Probabilities are assumed to be independent for each feature, similar to the naiveBayes assumption, so the probability
     * of all features is found by multiplying the probabilities of each one (as done in the forward algorithm)
     */



    private Normal[][] emissionDensity; 

    /** 
     * Constructor method to create an HMM object with n states and initialise the required arrays
     */

    public HiddenMarkovModel (int n){

	noStates = n;
	transitionProbability = new double[noStates+1][noStates+1];
	emissionDensity = new Normal[featureDimension][noStates];

    }

     /** 
     * Constructor method to build an HMM given known transition and emission probabilities
     */

    public HiddenMarkovModel (int n, double[][] transitions, Normal[][] emissions){

	this(n);
	int i,j;

	for (i=0;i<noStates+1;i++)
	    for (j=0;j<noStates+1;j++)
		transitionProbability[i][j] = transitions[i][j];

	for (i=0;i<featureDimension;i++)
	    for (j=0;j<noStates;j++)
		emissionDensity[i][j] = emissions[i][j];
    }

    /** 
     * Constructor method to train an HMM using sequence data and given the corresponding data labels,
     * dataList is a list of arrays of size [featureDimension][lengthSequence] storing the MFCC feature
     * vectors for each time segment in each example,
     * labelsList is a list of arrays of size [lengthSequence] storing the corresponding state sequence
     */

    public HiddenMarkovModel (int n, ArrayList <double[][]> dataList, ArrayList <int[]> labelsList){

	this(n); // Initialise the transitionProbability and emissionDensity arrays
	int i,j,k;
	int noExamples=dataList.size(); // Number of sequences in the dtaa set
	int[] labelSequence; // Array for storing the state path for a single example
	double[][] dataSequence; // Array for storing the MFCC data for a single example
	int lengthSequence; 

	/* Training to obtain the transition probabilities */

	/* Below we count the number of transitions between states */

	int[][] transitionCount = new int[noStates+1][noStates+1]; 

	/* To do this we have to count up each transition in each example */

	for(i=0;i<noExamples;i++) {

	    labelSequence = labelsList.get(i);
	    lengthSequence = Array.getLength(labelSequence);

	    /* Transition from Start State */

	    transitionCount[noStates][labelSequence[0]]+=1;

	    /* Transitions between intermediate States */

	    for(j=0;j<lengthSequence-1;j++) {
		transitionCount[labelSequence[j]][labelSequence[j+1]]+=1;
	    }

	    /* Transition to End State */

	    transitionCount[labelSequence[lengthSequence-1]][noStates]+=1;
	}


	/* 
	* For task 1 modify the code below so that the transition probabilities for each state are
	* proportional to the transition counts for that state
	*/
        
	for(i=0;i<noStates;i++) {
            int trans = 0;
	    for(j=0;j<noStates;j++)
                trans+=transitionCount[i][j]; 
                for(j=0;j<noStates;j++)
                    setTransitionProbability(((float)transitionCount[i][j] / trans), i, j);
	}

	/* End of modified code */


	/* Training to obtain emission probabilities */

	/* First compute mean and variance of emission in each state */

	double[][] mean  = new double[featureDimension][noStates];
	double[][] variance = new double[featureDimension][noStates];
	int[] count = new int[noStates];

	for(j=0;j<noStates;j++) {
	    count[j]=0;
	    for(k=0;k<featureDimension;k++) {
		mean[k][j]=0.0;
		variance[k][j]=0.0;
	    }
	}
		
	for(i=0;i<noExamples;i++) {
	    labelSequence = labelsList.get(i);
	    dataSequence = dataList.get(i);
	    lengthSequence = Array.getLength(labelSequence);

	    for(j=0;j<lengthSequence;j++) {
		count[labelSequence[j]] += 1;
		for(k=0;k<featureDimension;k++) {
		    mean[k][labelSequence[j]] += dataSequence[k][j];
		}
	    }
	}
	
	for(j=0;j<noStates;j++) {
	    for(k=0;k<featureDimension;k++) {
		mean[k][j] /= (double) count[j];
	    }
	}

	for(i=0;i<noExamples;i++) {
	    labelSequence = labelsList.get(i);
	    dataSequence = dataList.get(i);
	    lengthSequence = Array.getLength(labelSequence);

	    for(j=0;j<lengthSequence;j++) {
		for(k=0;k<featureDimension;k++) 
		    variance[k][labelSequence[j]] += Math.pow(dataSequence[k][j]-mean[k][labelSequence[j]],2);
	    }
	}

	for(j=0;j<noStates;j++) {
	    for(k=0;k<featureDimension;k++) {
		variance[k][j] /= (double) count[j];
	    }
	}
	
		
	/* Use mean and variance to obtain normal densities for each state */
	    
	for(i=0;i<noStates;i++) {
	    for(j=0;j<featureDimension;j++) {
		emissionDensity[j][i]=new Normal(mean[j][i],variance[j][i]);
	    }
	}
    }

    /**
     * Method for getting the emission probability distribution for a particular feature and state
     */

    public Normal getEmissionDensity(int feature, int state){

	return emissionDensity[feature][state];

    }

    /**
     * Method for setting the emission probability distribution for a particular feature and state
     */

    public void setEmissionDensity(Normal density, int feature, int state){

	emissionDensity[feature][state] = density;

    }

    /**
     * Method for getting the transition probabilities from state i to state j,
     * i,j = 0 to noStates-1 for standard states, i,j = noStates for START/STOP states
     */

    public double getTransitionProbability(int i, int j){

	return transitionProbability[i][j];

    }

    /**
     * Method for setting the transition probabilities from state i to state j,
     * i,j = 0 to noStates-1 for standard states, i,j = noStates for START/STOP states
     */

    public void setTransitionProbability(double probability, int i, int j){

	transitionProbability[i][j]=probability;

    }

    /**
     * Method returning the number of states (excluding START/STOP states)
     */

    public int getNoStates(){

	return noStates;

    }

    /**
     * Forward algorithm - see equation (11) in Section 4.2 of the notes,
     * Input is dataSequence[featureDimension][sequenceLength],
     * Output is the probability of the data sequence under the model
     */

    public BigDecimal forward (double[][] dataSequence){

	int sequenceLength = Array.getLength(dataSequence[0]);
	MathContext mc = new MathContext(10); // Sets precision of BigDecimal arithmetic used below
	BigDecimal[] f = new BigDecimal[noStates]; // Stores the quantity on the left of equation (11)
	BigDecimal[] newf = new BigDecimal[noStates]; // f[] for the next time
	BigDecimal temp = new BigDecimal(0.0,mc); 
	double px; // For computing the emission probabilities of all feature dimensions multiplied together
	int t,i,j,k;
	
	// Initialisation - we have to multiply the probabilities of all the feature vector components together

	for(i=0;i<noStates;i++){
	    px=1.0;
	    for(j=0;j<featureDimension;j++)
		px*=emissionDensity[j][i].density(dataSequence[j][0]);
	    f[i] = new BigDecimal(px*transitionProbability[noStates][i],mc); // Transition from first state
	}

	// Recursion

	for(t=1;t<sequenceLength;t++){
	    for(i=0;i<noStates;i++){
		px=1.0;
		for(j=0;j<featureDimension;j++)
		    px*=emissionDensity[j][i].density(dataSequence[j][t]);
		temp=new BigDecimal(0.0,mc);
		for(k=0;k<noStates;k++){
		    temp = temp.add(f[k].multiply(new BigDecimal(transitionProbability[k][i],mc),mc),mc);
		}
		newf[i]=temp.multiply(new BigDecimal(px),mc);
	    }
	    for(i=0;i<noStates;i++)
		f[i]=newf[i];
	}
	
	// Final result

	temp=new BigDecimal(0.0,mc);
	for(i=0;i<noStates;i++)
	    temp = temp.add(f[i].multiply(new BigDecimal(transitionProbability[i][noStates],mc),mc),mc);

	return temp;
    }

    /**
     * Viterbi algorithm returns the optimal path through the hidden states for an input data sequence: 
     * Input is dataSequence[featureDimension][sequenceLength],
     * Output is the inferred most likely path through the hidden states as an array of ints
     */

    public int[] viterbi (double[][] dataSequence){

	/* Don't worry about the Viterbi code - it is beyond the scope of the course */
	
	int sequenceLength = Array.getLength(dataSequence[0]);
	int[] bestPath = new int[sequenceLength];
	double[] v = new double[noStates];
	int[][] ptr = new int[noStates][sequenceLength];
	int bestFinalState=0;
	double temp = 0.0;
	double max = 0.0;
	int index = 0;
	double lpx; // Log probability of sequence up to this time and the optimal path up to that state at that time
	int t,i,j,k;
	
	// Initialisation

	for(i=0;i<noStates;i++){
	    lpx=0.0;
	    for(j=0;j<featureDimension;j++)
		lpx += Math.log(emissionDensity[j][i].density(dataSequence[j][0]));
	    v[i] = lpx + Math.log(transitionProbability[noStates][i]);
	    ptr[i][0] = noStates; //Always start at the start state - we don't use this element
	}

	// Recursion

	for(t=1;t<sequenceLength;t++){
	    for(i=0;i<noStates;i++){
		lpx=0.0;
		for(j=0;j<featureDimension;j++)
		    lpx += Math.log(emissionDensity[j][i].density(dataSequence[j][t]));
		max=-1.0/0.0; //-Infinity
		index=0;
		for(k=0;k<noStates;k++){
		    temp = v[k] + Math.log(transitionProbability[k][i]);
		    if(temp>max){
			max=temp;
			index=k;
		    }
		}
		v[i]=lpx + max;
		ptr[i][t]=index;
	    }
	}
	
	// Final result

	max=-1.0/0.0; //-Infinity
	index=0;
	for(k=0;k<noStates;k++){
	    temp = v[k] + Math.log(transitionProbability[k][noStates]);
	    if(temp>max){
		max=temp;
		index=k;
	    }
	    bestFinalState=index;
	}

	// Traceback to get the optimal path

	bestPath[sequenceLength-1]=bestFinalState;
	i=sequenceLength-1;
	while(i>0){
	    bestPath[i-1]=ptr[bestPath[i]][i];
	    i=i-1;
	}
	return bestPath;
    }
	
}
