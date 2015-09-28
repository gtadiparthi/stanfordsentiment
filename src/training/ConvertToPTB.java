package training;
import edu.stanford.nlp.sentiment.*;

import java.io.IOException;
import java.io.*;
public class ConvertToPTB {

	private static void redirectSystemOutput(){
        
        try{
            File file  = new File("output/ptb_file.txt");
            PrintStream printStream = new PrintStream(new FileOutputStream(file));
            System.setOut(printStream);            
        }catch(Exception e){
        	e.printStackTrace();
        }         
        
	}
	public static void main(String[] args) throws IOException {

           String inputFile = "input/binarizedDataset_input.csv";
           String[] args1 = {"-input", inputFile};
           redirectSystemOutput();
            BuildBinarizedDataset.main(args1);
     }

}

