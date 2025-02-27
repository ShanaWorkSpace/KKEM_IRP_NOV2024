package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LocatorsReader {
    
	protected Properties propi;
	
   public LocatorsReader() throws IOException{
            propi = new Properties();
            FileInputStream locatorsFile = new FileInputStream("C:\\Users\\gssar\\Documents\\KKEM_IRP_NOV2024\\src\\test\\resources\\locator.properties");
			propi.load(locatorsFile);      
   }
}