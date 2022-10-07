package level5.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Solution extends Statics {
    
    public static List<String> lines = new ArrayList<String>();

    static {
        try( BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME,StandardCharsets.UTF_8));
        ){
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        
        System.out.println(lines);
    }
}