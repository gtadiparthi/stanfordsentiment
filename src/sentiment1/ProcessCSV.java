package sentiment1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.*;

public class ProcessCSV {

	public static void main(String[] args) {
		Sentiment.init();
		readCSV("/Users/gopalakrishnatadiparthi/Documents/PythonPrograms/debate-parser/all_debates.csv","/Users/gopalakrishnatadiparthi/Documents/PythonPrograms/debate-parser/all_debates_snlpsent.csv");
		
		// The input file contains the following fields
		// SentenceNo, SequenceNo, Speaker, Text
		//The plan is to have the output file contain 
		// SentenceNo and Sentiment Score

	}
	public static void readCSV(String filename, String outputFilename){
		try{
			String csvFilename = filename;
			CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
			CSVWriter writer = new CSVWriter(new FileWriter(outputFilename));
			
			String[] row = null;
			String[] results = new String[5];
			int rowno = 0;
			while ((row = csvReader.readNext()) != null){
				results[0] = row[0]; //Party
				results[1] = row[1];//Debate NO
				results[2] = row[2];//Sentence No
				results[3] = row[3];//Sequence No
				//if the value is empty, don't process it
				if (!(row[5].isEmpty() || row[5].toUpperCase().matches("NA|NONE|ALL|YES|NO|N/A"))){
					if (rowno != 0)
						results[4] = Integer.toString(Sentiment.findSentimentInt(row[5]));
					else
						results[4] = "Score";
					// If there is an applause, the positive sentiment hits the roof
					if (row[5].toUpperCase().matches("(.*)APPLAUSE(.*)|(.*)LAUGHTER(.*)|(.*)CHEERING(.*)")){
						results[4]="5";
					}
					writer.writeNext(results);
								
				}
				rowno++;
				System.out.println("Processing Row No: "+rowno);
				System.out.println(row[0] + row[5] +" # " + results[4]);
			}
			csvReader.close();
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
