import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        HashMap<String, Set<Integer>> typeToIds = new HashMap<>();
        Set<Integer> idList = new TreeSet<>();
        Scanner input = new Scanner(System.in);
        input.nextLine();
        while (input.hasNextLine()) {
            String[] file = input.nextLine().split(",");
            String typeDoc = file[2];
            Integer applicationId = Integer.parseInt(file[3]);
            idList.add(applicationId);
            if (typeToIds.containsKey(typeDoc)) {
                typeToIds.get(typeDoc).add(applicationId);
            } else {
                Set<Integer> ids = new TreeSet<>();
                ids.add(applicationId);
                typeToIds.put(typeDoc, ids);
            }
        }
        input.close();
        Set<String> sortedDocs = new TreeSet<>(typeToIds.keySet());
        for (String typeOfDoc: sortedDocs) {
        	String missingId = "";
        	for (Integer i: idList) {
        		if (!typeToIds.get(typeOfDoc).contains(i)) {
        			missingId += i + " ";
        		}
        	}
            if (missingId != "") {
            	System.out.println(typeOfDoc);
                System.out.println(missingId.replaceAll("\\s+$", ""));
            }
        }
        
    }
}