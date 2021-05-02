package tacocat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GravarScore {

    public GravarScore(int score) { 
     File file = new File("");
       try{
           File arquivo = new File(file.getAbsoluteFile()+"\\src\\tacocat\\Files\\Score.txt");
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(score+"\n");
            bw.flush();
            bw.close();
       } catch(IOException e){
            
        }
    
    }
   
}
