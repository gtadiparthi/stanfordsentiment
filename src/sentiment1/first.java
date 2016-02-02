package sentiment1;

public class first {

	  /** Usage: java -cp "*" StanfordCoreNlpDemo [inputFile [outputTextFile [outputXmlFile]]] */
	  public static void main(String[] args)  {
		Sentiment.init();
		try{
			String line = "A majority of the candidates on this stage have supported amnesty. I have never supported amnesty, and I led the fight against Chuck Schumer's gang of eight amnesty legislation in the Senate.";
			for (int i = 0; i < args.length; i++)
		        line+=args[i]+" ";
	    System.out.println(Sentiment.findSentiment(line));
	    System.out.println(Sentiment.findSentimentInt(line));
		}catch(Exception e){
			e.printStackTrace();
		}
	  }

}

	  