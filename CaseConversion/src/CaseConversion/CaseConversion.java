package CaseConversion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaseConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean toUppercase = false;
		if(args.length == 0) {
			System.out.println("程式用法:java CaseConversion -U/L");
			System.exit(0);
		}
		else if(args[0].equalsIgnoreCase("-U")) {
			toUppercase = true;
		}
		else if(args[0].equalsIgnoreCase("-L")) {
			toUppercase = false;
		}
		else{
			System.out.println("程式用法:java CaseConversion -U/L");
			System.exit(0);
		}
		
		try (FileReader fr = new FileReader("source.txt");
			 FileWriter fw = new FileWriter("result.txt")){
			
			char []input = new char[32];
			int idx = 0;
			while((idx = fr.read(input))>0) {
				String line = new String(input,0,idx);
				String output = "";
				if(toUppercase)
					output = line.toUpperCase();
				else 
					output = line.toLowerCase();
				fw.write(output);	
			}
			fw.flush();
			System.out.println("檔案轉換成功!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
