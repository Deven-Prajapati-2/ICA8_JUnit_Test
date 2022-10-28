import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Urinals {
    public static void main(String[] args) {
        Urinals urinals = new Urinals();
        urinals.readFile();
    }
    public ArrayList<String> readFile() { // read file and parse all strings
        String path = "C:/Users/Devsec/Desktop/DevGit/ICA8_JUnit_Test/data/urinal.dat";
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
            e.printStackTrace();
        }
        return urinalsStrings;
    }
    public Boolean goodString(String str) {  // checks to see if valid string
        int n = str.length();
        for(int i=0;i<n;i++) if(str.charAt(i) != '0' && str.charAt(i) != '1') return false;
        return true;
    }
}
