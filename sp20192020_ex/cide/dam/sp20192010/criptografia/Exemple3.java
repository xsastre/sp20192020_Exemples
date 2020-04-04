package cide.dam.sp20192010.criptografia;


import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Exemple3 {
   public static void main(String[] args) {
      try {

         // Clau a partir d'un text nostre utilitzant AES
         byte[] clau_text = "Tofol   Tofol   ".getBytes("UTF-8");
         
         SecretKeySpec key2 = new SecretKeySpec(clau_text,"AES");
         System.out.println(key2);
         
         Cipher cipher = Cipher.getInstance("AES");
         cipher.init(Cipher.ENCRYPT_MODE, key2);
         
         byte[] missatge = "Missatge de prova".getBytes();
         byte[] missatgeXifrat = cipher.doFinal(missatge);
         System.out.println(new String(missatgeXifrat, "UTF8"));
         
         
         cipher.init(Cipher.DECRYPT_MODE, key2);
         
         //Desxifrat
         byte[] decipheredText = cipher.doFinal(missatgeXifrat);
         System.out.println(new String(decipheredText));
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

