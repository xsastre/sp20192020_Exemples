package cide.dam.sp20192010.criptografia;
import javax.crypto.*;
import java.security.*;

public class Exemple4_1 {
   
   public static void main(String[] args) {
      try {
         KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
         KeyPair keypair = keygen.generateKeyPair();
         Cipher rsaCipher = Cipher.getInstance("RSA");
         rsaCipher.init(Cipher.ENCRYPT_MODE, keypair.getPrivate());
         String mensaje = "Mensaje de prueba del cifrado asimétrico";
         String mensajeCifrado = new String(rsaCipher.doFinal(mensaje.getBytes()));
         rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPublic());
         String mensajeDescifrado = new String(rsaCipher.doFinal(mensajeCifrado.getBytes()));
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
