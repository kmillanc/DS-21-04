package e1;
import java.util.Arrays;
public class StringUtilities {
        /*/**
         * Checks if a given string is a valid c of two others . That is , it contains
         * all characters of the other two and order of all characters in the individual
         * strings is preserved .
         * @param a First String to be mixed
         * @param b Second String to be mixed
         * @param c Mix of the two other Strings
         * @return true if the c is valid , false otherwise
         */
        public static boolean isValidMix ( String a, String b, String c) {
                int i = 0, j = 0;
                if(c.length() == (a.length()+b.length())){
                        for(int x = 0; x <= ((b.length()+a.length()) - 1) ; x++)
                                if (c.charAt(x) == b.charAt(i)) {
                                        if(i != b.length()-1){
                                                i++;
                                        }
                                } else if (c.charAt(x) == a.charAt(j)) {
                                        if(j != a.length()-1){
                                                j++;
                                        }
                                } else return false;
                        return true;
                }
                else return false;
        }
        public static boolean getRandomBoolean() {
                return Math.random() < 0.5;
        }
        //public static int numeroAleatorioEnRango(int min, int max){
        //    int n = (int)Math.floor(Math.random()*(min-max)+max);
        //    return n;
        //}
        /*/**
         * Generates a random valid mix for two Strings
         * @param a First String to be mixed
         * @param b Second String to be mixed
         * @return A String that is a random valid mix of the other two .
         */
        public static String generateRandomValidMix ( String a, String b) {
                String AplusB = a.concat(b);
                int MaxC = (AplusB.length()-1);
                char[] c = new char[MaxC+1];
                int IndiceA = 0;
                int IndiceB = 0;
                int MaxA = (a.length()-1);
                int MaxB = (b.length()-1);
                for(int x = 0 ; x <= MaxC; x++){
                        boolean r = getRandomBoolean();
                        if(r && IndiceA <= MaxA){
                                c[x] = a.charAt(IndiceA);
                                IndiceA++;
                        }
                        else if(!r && IndiceB <= MaxB){
                                c[x] = b.charAt(IndiceB);
                                IndiceB++;
                        }else x--;
                }
                String   Sc = convertCharArrayToString( c, ",");
                String ResultString = "";
                for (int i = 0; i <= MaxC; i++){
                        if(Sc.charAt(i) != ','){
                                ResultString = ResultString.concat(String.valueOf(Sc.charAt(i)));
                        }
                        else{
                                MaxC++;
                        }
                }
                return ResultString;
        }
        private static String convertCharArrayToString(char[] chArr, String delimiter) {
                StringBuilder sb = new StringBuilder();
                for(char chr : chArr)
                        sb.append(chr).append(delimiter);
                return sb.substring(0, sb.length() - 1);
        }
}