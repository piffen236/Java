package se.kth.convertproject.mapalgebra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/* THIS FILE CONVERTS A ASCII FILE EXPORTED FROM ARCHIS
 * 					TOOL: Export Feature Attribute To ASCII
 * THE ARCGIS FILE IS IN THE FOLLOWING FORMAT: COORDINATE X, COORDINATE Y, ID, TAIL, HEAD, WEIGHT
 * THE OUTPUT FILE IS IN THE FOLLOWING FORMAT: ID, TAIL, HEAD, WEIGHT ("." INSTEAD OF ",")
 * AND THE FIRST ROW IS NAME OF EACH COLUMN "TLID" "FNODE" "TNODE" "LENGTH"
 */
public class Convert {

	public static void main(String[] args) throws IOException {
		String line, arcID, tailName, headName;
		String weight;
		
		// DEFINE FILES
		File file = new File("./data/tgr24031IkA_ProjectNew.txt");
		File fileout = new File("./data/largenetworkOutput1.txt");

		FileWriter fWriter;

		try {
			fWriter = new FileWriter(fileout);
			fWriter.write("TLID,FNODE,TNODE,LENGTH\n");
			// Get access to the contents of an ASCII file
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);

			line = bReader.readLine();
			// Store each element of the network in forward star.
			while (line != null) {
				//SPLITING THE LINE INTO 6 STRINGS
				String[] tokens = line.split(" ");
				arcID = tokens[2];
				tailName = tokens[3];
				headName = tokens[4];
				weight = tokens[5];
				//REPLACE , WITH .
				weight=weight.replace(",", ".");
				//RE WRITE IN OUTPUT FILE
				fWriter.write(arcID + "," + tailName + "," + headName + "," + weight + "\n");
				line = bReader.readLine();
			}
			//CLOSE
			bReader.close();
			fWriter.close();
			//DID THE TRY FUNCTION LAUNCH?
			System.out.println("done!");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
