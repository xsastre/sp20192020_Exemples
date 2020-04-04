package cide.dam.sp20192010.criptografia;

import java.security.MessageDigest;

public class Exemple5 {
   public static void main(String[] args) {
      try {
         MessageDigest md = MessageDigest.getInstance("MD5");
         byte[] c1 = "Primera cadena".getBytes();
         byte[] c2 = "Segona cadena".getBytes();
         byte[] c3 = "Tercera cadena".getBytes();
         md.update(c1);
         md.update(c2);
         md.update(c3);
         byte[] resumen = md.digest();
         md.reset();
         byte[] c4 = "Cuarta cadena".getBytes();
         md.update(c4);
         resumen = md.digest();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
