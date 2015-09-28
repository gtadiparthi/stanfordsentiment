package sentiment1;

public class first {

	  /** Usage: java -cp "*" StanfordCoreNlpDemo [inputFile [outputTextFile [outputXmlFile]]] */
	  public static void main(String[] args)  {
		Sentiment.init();
		try{
			String line = "";
			for (int i = 0; i < args.length; i++)
		        line+=args[i]+" ";
	    System.out.println(Sentiment.findSentiment(line));
		}catch(Exception e){
			e.printStackTrace();
		}
	  }

}

	  