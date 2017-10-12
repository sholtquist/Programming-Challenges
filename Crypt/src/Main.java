import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static List<String>[] indexedDictionary;

    public static void main( String[] args ) throws IOException{

        String line = reader.readLine();

        int dictLength = Integer.parseInt(line.trim());
        String[] dictionary = new String[dictLength];
        for(int i = 0; i < dictLength; i++){
            line = reader.readLine();
            dictionary[i] = line;
        }

        indexedDictionary = (List<String>[]) new ArrayList[17];
        for(String word : dictionary){
            int index = word.length();
            if(indexedDictionary[index] == null)
                indexedDictionary[index] = new ArrayList<String>();
            indexedDictionary[index].add(word);
        }

        while((line = reader.readLine()) != null){
            String[] encryptedWords = line.split(" ");
            if(encryptedWords != null && encryptedWords.length != 0)
                System.out.println(decrypt(encryptedWords));
        }
    }

    private static String decrypt(String[] encryptedWords){
        char[] mappings = new char[26];
        for(int i = 0; i < mappings.length; i++)
            mappings[i] = '*';

        mappings = backtrack(0, mappings, encryptedWords);

        return buildDecryptedString(mappings, encryptedWords);
    }

    private static String buildDecryptedString(char[] mappings, String[] encryptedWords){
        StringBuilder builder = new StringBuilder();
        for(String word : encryptedWords){
            for(char character : word.toCharArray()){
                if(mappings != null){
                    builder.append(mappings[character - 'a']);
                }else{
                    builder.append('*');
                }
            }
            builder.append(" ");
        }

        return builder.toString().trim();
    }

    private static char[] backtrack(int i, char[] mappings, String[] encryptedWords){
        if(i == encryptedWords.length) // all encrypted words have been successfully decrypted, return final mappings
            return mappings;
        else{
            for(String dictWord : indexedDictionary[encryptedWords[i].length()]){
                char[] localMappings = Arrays.copyOf(mappings, mappings.length);
                if(mappingPossible(encryptedWords[i], dictWord, localMappings)){
                    localMappings = backtrack(i + 1, localMappings, encryptedWords);
                    if(localMappings != null)
                        return localMappings;
                }
            }
            return null;
        }
    }

    public static boolean mappingPossible(String encrypted, String plaintext, char[] mappings){

        if(encrypted.length() != plaintext.length())
            return false;

        char[] encryptedChars = encrypted.toCharArray();
        char[] plaintextChars = plaintext.toCharArray();

        for(int i = 0; i < encryptedChars.length; i++){
            char encryptedChar = encryptedChars[i];
            char plaintextChar = plaintextChars[i];

            int index = encryptedChar - 'a';
            if(mappings[index] != '*' && mappings[index] != plaintextChar)
                return false;
            else
                mappings[index] = plaintextChar;
        }

        return repeat(mappings);
    }

    private static boolean repeat(char[] mappings){
        int[] map = new int[26];
        for(char c : mappings){
            if(c != '*'){
                int index = c - 'a';
                if(map[index] != 0)
                    return false;
                else
                    map[index] = 1;
            }
        }
        return true;
    }
}