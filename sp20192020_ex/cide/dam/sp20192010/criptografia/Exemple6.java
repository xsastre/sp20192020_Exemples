package cide.dam.sp20192010.criptografia;

import java.security.*;

public class Exemple6 {
   public static void main(String[] args) {
      try {
         KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
         //keygen.initialize(2048);
         KeyPair keypair = keygen.generateKeyPair();
         Signature signature = Signature.getInstance("DSA");
         signature.initSign(keypair.getPrivate());
         String mensaje = "Mensaje para firmar";
         signature.update(mensaje.getBytes());
         byte[] firma = signature.sign();

         signature.initVerify(keypair.getPublic());
         signature.update(mensaje.getBytes());
         if (signature.verify(firma))
            System.out.println("El mensaje es auténtico :-)");         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
