package sentiment1;
/* Got this piece of code from 
 * 
 * http://stackoverflow.com/questions/11832490/stanford-core-nlp-java-output
 * 
 */
import java.io.*;
import java.util.*;

import edu.stanford.nlp.io.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.*;

public class TreePrintout {
	 public static void main(String[] args) throws IOException {
		    PrintWriter out;
		    if (args.length > 1) {
		      out = new PrintWriter(args[1]);
		    } else {
		      out = new PrintWriter(System.out);
		    }
		    PrintWriter xmlOut = null;
		    if (args.length > 2) {
		      xmlOut = new PrintWriter(args[2]);
		    }

		    StanfordCoreNLP pipeline = new StanfordCoreNLP();
		    Annotation annotation;
		    if (args.length > 0) {
		      annotation = new Annotation(IOUtils.slurpFileNoExceptions(args[0]));
		    } else {
		      annotation = new Annotation("A majority of the candidates on this stage have supported amnesty. I have never supported amnesty, and I led the fight against Chuck Schumer's gang of eight amnesty legislation in the Senate.");
		    }

		    pipeline.annotate(annotation);
		    pipeline.prettyPrint(annotation, out);
		    if (xmlOut != null) {
		      pipeline.xmlPrint(annotation, xmlOut);
		    }
		    // An Annotation is a Map and you can get and use the various analyses individually.
		    // For instance, this gets the parse tree of the first sentence in the text.
		    List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
		    if (sentences != null && sentences.size() > 0) {
		      CoreMap sentence = sentences.get(0);
		      Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
		      out.println();
		      out.println("The first sentence parsed is:");
		      tree.pennPrint(out);
		    }
		  }

		}