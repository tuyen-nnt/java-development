import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap van ban: ");
        String text = input.nextLine();
        String step1 = normalizeText(text).toUpperCase();
        System.out.println(step1);

        System.out.print("Nhap so shift: ");
        int shift = input.nextInt();
        System.out.println(shiftString(step1,shift));
    }

    public static String normalizeText(String str) {
        String str2 = "";
        str2 = str.replaceAll("[ .,:;’”!?()]", "");
        return str2;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }
    public static String shiftString(String str, int shift) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String result = "";
        String str2 = shiftAlphabet(shift);
        for (int start = 0; start < str.length(); start++) {
            String c = str.substring(start,start+1);
            //Vi tri cua ki tu trong day alphabet da duoc execute
            int index = alphabet.indexOf(c);
            result = result + str2.charAt(index);
        }
        return result;
    }
}
