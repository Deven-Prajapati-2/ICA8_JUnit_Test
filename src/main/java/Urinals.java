import java.io.*;
import java.util.ArrayList;
/**
 * Urinals class to find count of maximum free urinals
 * it has methods to:
 * read input file and parse string and then validate each strings
 * write output for each string in a file
 *
 * @author Deven Prajapati
 */
public class Urinals {
    public static void main(String[] args) {}

    public ArrayList<String> readFile(String path) throws Exception { // read file and parse all strings
        ArrayList<String> urinalsStrings = new ArrayList<>();
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line != null) {
                if(line.equals("-1") || line.equals("EOF")) break;
                urinalsStrings.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw e;
        }
        return urinalsStrings;
    }

    public Boolean goodString(String str) {  // checks to see if valid string
        int n = str.length();
        if(n < 1 || n > 20) return false;
        for(int i=0;i<n;i++) if(str.charAt(i) != '0' && str.charAt(i) != '1') return false;
        for(int i=0;i<n-1;i++) if(str.charAt(i) == '1' && str.charAt(i+1) == '1') return false;
        return true;
    }

    public int countMaximumFreeUrinals(String str) {
        int[] maxCount = {0};
        backtrack(str,0,0,maxCount);
        return maxCount[0];
    }

    public void backtrack(String str, int index, int changeCount, int[] maxCount) {
        int n = str.length();
        if(index == n) {
            maxCount[0] = Math.max(maxCount[0],changeCount);
            return;
        }

        if(str.charAt(index) == '1') {
            backtrack(str,index+1,changeCount, maxCount);
            return;
        }

        backtrack(str, index+1, changeCount, maxCount);

        char prevUrinalState = '0';
        if(index > 0)
            prevUrinalState = str.charAt(index-1);
        char nextUrinalState = '0';
        if(index+1 < n)
            nextUrinalState = str.charAt(index+1);
        if(prevUrinalState == '0' && nextUrinalState == '0') {
            char[] temp = str.toCharArray();
            temp[index] = '1';
            String newStr = new String(temp);
            backtrack(newStr,index+1,changeCount+1,maxCount);
        }
    }

    public String createOutputFile(int[] maxFreeUrinalCount) {
        File outputFile = new File("rule.txt");
        try {
            int count = 1, LOOP_COUNT = 100;
            while (LOOP_COUNT > 0) {
                if (!outputFile.exists()) break;
                String outputFileName = "rule" + count + ".txt";
                outputFile = new File(outputFileName);
                count++;
                LOOP_COUNT--;
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for(int i=0;i<maxFreeUrinalCount.length;i++) {
                writer.write(maxFreeUrinalCount[i] + "\n");
            }
            writer.write("EOF");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return outputFile.getPath();
    }
}

