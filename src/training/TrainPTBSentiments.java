package training;
import edu.stanford.nlp.sentiment.*;
import java.io.*;

public class TrainPTBSentiments {

	public static void main(String[] args) throws IOException {
		 String trainFile = "input/trees/train.txt";
		 String devFile = "input/trees/dev.txt";
		 String hiddenLayers = "25";
		 String modelFile = "output/model1.ser.gz";
         String[] args1 = {"-numHid", hiddenLayers, "-trainPath",trainFile, "-devPath", devFile,
        		 "-train", "-model",modelFile};
       
         SentimentTraining.main(args1);

	}

}
