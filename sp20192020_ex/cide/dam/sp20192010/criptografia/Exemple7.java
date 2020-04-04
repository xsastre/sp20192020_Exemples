package cide.dam.sp20192010.criptografia;

import java.security.*;
import java.io.*;
import java.lang.*;

//Crea fitxers de claus i visualitza la clau pública per pantalla

public class Exemple7 {

	public static void visualitzaClau(byte[] clau) {

		int longClau = clau.length,i;
		String s = new String();
		
		for (i=0; i<longClau; i++) {
			String k= "00"+ Integer.toHexString((int)clau[i]);
			k=k.substring(k.length()-2,k.length());
			s=s+":" + k;
		}
		System.out.println(s);

	} // fi imprimeix claus

	public static void creaFitxersDeClaus(KeyPair claus){

		PublicKey clauPublica = claus.getPublic();
		PrivateKey clauPrivada = claus.getPrivate();

		//f1 fitxer en el que escriurem la clau publica

		try{

			FileOutputStream f1=new FileOutputStream("ClauPublica.dat");
			ObjectOutputStream ost = new ObjectOutputStream(f1);
			ost.writeObject(clauPublica);
			ost.flush(); //buidam el buffer
			ost.close();
			f1.close();

			//f2 fitxer en el que escriurem la clau privada

			FileOutputStream f2=new FileOutputStream("ClauPrivada.dat");
			ObjectOutputStream ost2 = new ObjectOutputStream(f2);
			ost2.writeObject(clauPrivada);
			ost2.flush(); //buidam el buffer
			ost2.close();
			f2.close();

		} catch (IOException e) {

			System.err.println(e);
		}

	} //Fin creaFitxersDeClaus

	public static void main (String a[]) throws NoSuchAlgorithmException, IOException {

		KeyPairGenerator genClaus = KeyPairGenerator.getInstance ("DSA");
		genClaus.initialize(512, new SecureRandom()); //Inicialitzo el //generador amb 512
		KeyPair parellClaus = genClaus.generateKeyPair(); //genero parella de //claus
		PublicKey clauPublica = parellClaus.getPublic();
		PrivateKey clauPrivada = parellClaus.getPrivate();
		byte[] encKey = clauPublica.getEncoded();
		System.out.println("Format clau:" + clauPublica.getFormat());
		visualitzaClau(encKey);
		creaFitxersDeClaus(parellClaus);

	} //fin main

}