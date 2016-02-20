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

public class RunEncryption {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws URISyntaxException, IOException {
		DES encryptor = new DES();
		try{
			BufferedReader plainTextBr = new BufferedReader(new FileReader("C://Crypto//input.txt"));
			BufferedReader key = new BufferedReader(new FileReader("C://Crypto//key.txt"));
			String plainText = plainTextBr.readLine();
			String keyValue = key.readLine();

		    System.out.println("Plain Text : " + plainText);
		    System.out.println("Key : " + keyValue);
		   
		    // Encrypt the text
		    byte[] textEncrypted = encryptor.encrypt(plainText, keyValue);

		    System.out.println("Text Encryted : " + DatatypeConverter.printBase64Binary(textEncrypted));
		    
		    String output = DatatypeConverter.printBase64Binary(textEncrypted);

			File file = new File("C://Crypto//output.txt");

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
