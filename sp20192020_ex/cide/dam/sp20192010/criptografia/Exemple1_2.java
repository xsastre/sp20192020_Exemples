package cide.dam.sp20192010.criptografia;

import javax.crypto.*;


public class Exemple1_2 {
   public static void main(String[] args) {
      try {
               
         KeyGenerator keygen = KeyGenerator.getInstance("DES");
         SecretKey key = keygen.generateKey();
         System.out.println(key);
         
         Cipher cipher = Cipher.getInstance("DES");
         cipher.init(Cipher.ENCRYPT_MODE, key);
         
         byte[] missatge = "Missatge de prova".getBytes();
         byte[] missatgeXifrat = cipher.doFinal(missatge);
         System.out.println(new String(missatgeXifrat, "UTF8"));
         
         
         cipher.init(Cipher.DECRYPT_MODE, key);
         
         //Desxifrat
         byte[] decipheredText = cipher.doFinal(missatgeXifrat);
         System.out.println(new String(decipheredText));
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

