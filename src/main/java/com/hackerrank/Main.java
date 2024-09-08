package com.hackerrank;

import java.io.*;
import java.util.stream.IntStream;

import static com.hackerrank.Constants.OUTPUT_PATH;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_PATH));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.stringSimilarity(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'stringSimilarity' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int stringSimilarity(String s) {

        int similarityCount = 0;
        int stringLength = s.length();
        String searchString = s;

        if ( areAllCharactersSame(s) ){

            similarityCount = ( stringLength * ( stringLength+1 ) ) / 2;

        }
        else{

            while (searchString.length() > 0) {

                int indexOfString = s.indexOf(searchString);
                while (indexOfString != -1) {
                    similarityCount++;
                    indexOfString = s.indexOf(searchString, indexOfString + 1);
                }

                searchString = searchString.substring(0, --stringLength);
            }

        }

        return similarityCount;
    }


    public static boolean areAllCharactersSame(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        if (str.length() == 1) {
            return true;
        }

        char firstChar = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != firstChar) {
                return false;
            }
        }

        return true;
    }

}