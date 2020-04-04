package cide.dam.sp20192010.criptografia;

import javax.crypto.*;

public class Exemple2 {
   
   public static void main(String[] args) {
      try {
         KeyGenerator keygen = KeyGenerator.getInstance("AES");
         // keygen.init Opcional
         //keygen.init(128);
         SecretKey key = keygen.generateKey();
         
         Cipher aesCipher = Cipher.getInstance("AES");
         aesCipher.init(Cipher.ENCRYPT_MODE, key);

         byte[] missatge = "Missatge de prova ques es xifrarà amb AES".getBytes();
         byte[] missatgeXifrat = aesCipher.doFinal(missatge);
         System.out.println(new String(missatgeXifrat, "UTF8"));

         aesCipher.init(aesCipher.DECRYPT_MODE, key);
         byte[] decipheredText = aesCipher.doFinal(missatgeXifrat);
         System.out.println(new String(decipheredText));
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
