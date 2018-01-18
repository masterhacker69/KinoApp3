import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Favorites {

    public Favorites () throws IOException {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Merkliste.txt"));
            for(int i=0; i< setGesamtEinträge.length; i++){
                for (int j=0;j<arr.[i].length;j++){
                    writer.write(arr[i][j] + ";");
                }
                writer.newLine();
            }
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public Merkliste () throws IOException {
        List<String[]> list = new ArrayList<String[]>();
        try{
            BufferedReader read = new BufferedReader(new FileReader("Merkliste.txt"));
            String in = read.readLine();

            while (in !=null){
                String[] line=in.split(";");
                list.add(line);
                in=read.readLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        String[][] tmp=new String[list.size()][];
        return list.toArray(temp);

    }
}
