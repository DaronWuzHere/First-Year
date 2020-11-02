package naivebayes;
import java.util.*;
import javagently.*;

/**
 * Using a naive Bayes classifier to distinguish utterances of the word yes from the word no
 */

public class YesNoClassifier {

    public static void main(String[] args)
    {
	// Read in MFCC data 
	
	String mfccDataDirectory = "data/yesno/mfcc/"; 
	Data yesData = new Data (mfccDataDirectory+"yes");
	Data noData = new Data (mfccDataDirectory+"no");

	// Build a naive Bayes classifier

	Classifier classifier = new Classifier(yesData.getMeanMfcc(),noData.getMeanMfcc());

	// Compute the probability of being in class one for the first yes example
	// using the 1st time-averaged MFCC as the feature

	int featureNumber = 0; // Using this MFCC component (0 is 1st component)
	int exampleNumber = 0; // Classifying this example
        int totalError = 0; //The total number of errors
        double answer = 0; //The answer
        for (int i = 0; i < yesData.getNumberExamples(); i++)
        {
          exampleNumber++;
          answer = classifier.classify(
                        yesData.getMeanMfcc(i),featureNumber);
          if (answer < 0.5)
          {
            totalError++;
          }//If
        }//For

	classifier = new Classifier(noData.getMeanMfcc(),yesData.getMeanMfcc());
        for (int i = 0; i < noData.getNumberExamples(); i++)
        {
          exampleNumber++;
          answer = classifier.classify(
                        noData.getMeanMfcc(i),featureNumber);
           if (answer < 0.5)
          {
            totalError++;
          }//If
        }//For
	System.out.println((double)totalError / (double)exampleNumber);

	System.out.println("The probability of this example being a yes is "+Float.toString((float) answer));


       classifier = new Classifier(yesData.getMeanMfcc(),noData.getMeanMfcc());
         featureNumber = 0; // Using this MFCC component (0 is 1st component)
	 exampleNumber = 0; // Classifying this example
         totalError = 0; //The total number of errors
         answer = 0; //The answer
        for (int i = 0; i < yesData.getNumberExamples(); i++)
        {
          exampleNumber++;
          answer = classifier.classify(
                        yesData.getMeanMfcc(i));
          if (answer < 0.5)
          {
            totalError++;
          }//If
        }//For

	classifier = new Classifier(noData.getMeanMfcc(),yesData.getMeanMfcc());
        for (int i = 0; i < noData.getNumberExamples(); i++)
        {
          exampleNumber++;
          answer = classifier.classify(
                        noData.getMeanMfcc(i));
           if (answer < 0.5)
          {
            totalError++;
          }//If
        }//For

	System.out.println((double)totalError / (double)exampleNumber);


    }
}
