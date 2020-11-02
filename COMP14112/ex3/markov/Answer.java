package markov;
import java.util.*;
import java.math.*;
import java.lang.reflect.*;

/**
 * Class with main method for presenting the results of the lab. At the moment this just reads in the sequence data 
 * and the corresponding state labels.
 */

public class Answer {

    public static void main(String[] args)
    {
	String mfccDataDirectory = "data/yesno_uncut/mfcc/"; 
	String labelDirectory = "data/yesno_uncut/labels/";

	// Read in the MFCC data and state labels from each class

	DataWithLabels dataClass1 = new DataWithLabels (mfccDataDirectory+"yes",labelDirectory+"yes");
	DataWithLabels dataClass2 = new DataWithLabels (mfccDataDirectory+"no",labelDirectory+"no");

	// Task 1
        HiddenMarkovModel hmm1 = new HiddenMarkovModel(3, dataClass1.getMfcc(), dataClass1.getLabels());
        HiddenMarkovModel hmm2 = new HiddenMarkovModel(3, dataClass2.getMfcc(), dataClass2.getLabels());
        
        for (int i = 0; i < hmm1.getNoStates(); i++)
        {
          for (int j = 0; j < hmm1.getNoStates(); j++)
          {
            System.out.println(hmm1.getTransitionProbability(i, j));
          }//For
        }//For
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < hmm2.getNoStates(); i++)
        {
          for (int j = 0; j < hmm2.getNoStates(); j++)
          {
            System.out.println(hmm2.getTransitionProbability(i, j));
          }//For
        }//For

	// Task 2
        System.out.println(hmm1.classify());
        System.out.println(hmm2.classify());

	// Task 3

	// Task 4
    }
}
