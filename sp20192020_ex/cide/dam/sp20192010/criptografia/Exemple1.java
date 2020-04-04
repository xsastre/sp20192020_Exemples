package cide.dam.sp20192010.criptografia;


import javax.crypto.*;

public class Exemple1 {

   public static void main(String[] args) {
      try {
      
         KeyGenerator keygen = KeyGenerator.getInstance("DES");
         SecretKey key = keygen.generateKey();
         Cipher cipher = Cipher.getInstance("DES");
         cipher.init(Cipher.ENCRYPT_MODE, key);
         byte[] missatge = "Missatge de prova".getBytes();
         byte[] missatgeXifrat = cipher.doFinal(missatge);
         System.out.println(new String(missatgeXifrat, "UTF8"));
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

