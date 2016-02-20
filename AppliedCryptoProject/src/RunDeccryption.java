import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

public class RunDeccryption {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws URISyntaxException, IOException {
		DES decryptor = new DES();
		try{
			BufferedReader cipherBr = new BufferedReader(new FileReader("C://Crypto//output.txt"));
			BufferedReader key = new BufferedReader(new FileReader("C://Crypto//key.txt"));
			String cipher = cipherBr.readLine();
			String keyValue = key.readLine();

		    System.out.println("Cipher Text : " + cipher);
		    System.out.println("Key : " + keyValue);
		   
		    // Decrypt the text
		    byte[] textDyccrypted = decryptor.decrypt(DatatypeConverter.parseBase64Binary(cipher), keyValue);

		    System.out.println("Text Deccryted : " + new String(textDyccrypted));
		    
		    String output = new String(textDyccrypted);

			File file = new File("C://Crypto//gen_input.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8")));
			out.append(output);
			out.flush();
			out.close();
		        
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		} 
	}

}
