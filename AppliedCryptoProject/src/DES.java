
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class DES{
    

    public synchronized byte[] encrypt(String plaintext, String keys) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    	 Cipher desCipher;
		    byte[] keyValue = keys.getBytes();
		    Key key = new SecretKeySpec(keyValue, "DES");
		    // Create the cipher 
		    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		    
		    // Initialize the cipher for encryption
		    desCipher.init(Cipher.ENCRYPT_MODE, key);

		    //sensitive information
		    byte[] text = plaintext.getBytes();

		    //System.out.println("Text [Byte Format] : " + text);
		   // System.out.println("Text : " + new String(text));
		   
		    // Encrypt the text
		    byte[] textEncrypted = desCipher.doFinal(text);

		   // System.out.println("Text Encryted : " + textEncrypted);
		    
		    return textEncrypted;
    }
    
    public synchronized byte[] decrypt(byte[] cipher, String keys) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    	 Cipher desCipher = null;
    	 byte[] keyValue = keys.getBytes();
		  Key key = new SecretKeySpec(keyValue, "DES");
		// Create the cipher 
		   desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	    // Initialize the same cipher for decryption
	    desCipher.init(Cipher.DECRYPT_MODE, key);

	    // Decrypt the text
	    byte[] textDecrypted = desCipher.doFinal(cipher);
	    
	  //  System.out.println("Text Decryted : " + new String(textDecrypted));
		return textDecrypted;
   }
    
 
    
   
}