package cide.dam.sp20192020.barberia;

public class laBarberia {

	public static void main(String[] args) {
		final int nCadires = 4;
		final int nClients = 10;
		
		barberia laBarberia = new barberia(nCadires);
		barber elBarber = new barber(laBarberia);
		client[] elsClients = new client[10];

		elBarber.start();

		for (int i = 0; i < nClients; i++) {
			elsClients[i] = new client(laBarberia, i);
			elsClients[i].start();
		}
	}
}
