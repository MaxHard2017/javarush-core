package level8.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionFileOutputStream implements AmigoOutputStream {
    
    private AmigoOutputStream original;
    

    public QuestionFileOutputStream(AmigoOutputStream original) {
        this.original = original;
    }

    @Override
    public void flush() throws IOException {
        original.flush();        
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);        
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);        
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);        
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ){
            String InputString = br.readLine();
            if (InputString.equals("Д")) {
                original.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}