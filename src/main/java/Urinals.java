public class Urinals {
    public static void main(String[] args) {}
    public Boolean goodString(String str) {  // checks to see if valid string
        int n = str.length();
        for(int i=0;i<n;i++) if(str.charAt(i) != '0' && str.charAt(i) != '1') return false;
        return true;
    }
}
