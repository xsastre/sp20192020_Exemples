package cide.dam.sp20192020.barberia;

// Suposicions:
// - El barber talla el pel fora de l'objecte protegit
//   Si ho fes a dins, seria menys realista la simulacio
//   del temps en que es tarda en fer aquesta operacio. Si
//   no es fa aquest retard, es a dir si el temps de tall
//   de pel fos practicament 0, no hi haurien quasi mai
//   processos esperant.
// - Es simula la cadira del barber i les cadires de la sala
//   d'espera.
public class barberia {

	private int nCadiresEspera;
	private int nCadiresEsperaOcupades = 0;
	private boolean cadiraBarberOcupada = false;
	private boolean fiTallCabell = false;
	private boolean barberDormit = false;

	// JAVA: nomes hi poden haver N_cadires_Espera_max 
	// esperant dins del monitor a que li toqui. 

	public barberia(int nCadiresEspera) {
		this.nCadiresEspera = nCadiresEspera;
	}

	public synchronized boolean entrar(int clientID)
			throws InterruptedException {
		if (nCadiresEsperaOcupades == nCadiresEspera) {
			// Si no hi ha cadires buides, me'n vaig sense tallar el pel
			System.out.println("---- El client " + clientID
					+ " parteig sense tallar-se el pel");
			return false;
		} else {
			// Em quedo esperant si la cadira del barber esta
			// ocupada
			nCadiresEsperaOcupades++;
			System.out.println("---- El client " + clientID
					+ " es seu a la cadira d'espera");
			while (cadiraBarberOcupada) {
				wait();
			}

			// Allibero la cadira d'espera
			nCadiresEsperaOcupades--;

			// Em seg a la cadira del barber
			cadiraBarberOcupada = true;
			fiTallCabell = false;

			// Si el barber esta dormit el despert
			if (barberDormit) {
				System.out.println("---- El client " + clientID
						+ " desperta al barber");
				notifyAll();
			}

			// Espero a que em talli el cabell
			System.out.println("---- El client " + clientID
					+ " a la cadira del barber");
			while (!fiTallCabell) {
				wait();
			}

			cadiraBarberOcupada = false;

			// Que pasi el seguent
			notifyAll();

			System.out.println("---- El client " + clientID
					+ " parteig amb el cabell tallat");
			return true;
		}
	}

	public synchronized void esperarClient() throws InterruptedException {
		// El barber espera a que arribi un client
		// Es suposa que li talla el cabell fora del 
		// monitor
		barberDormit = true;
		while (!cadiraBarberOcupada) {
			System.out.println("++++ Barber esperant client");
			wait();
		}
		barberDormit = false;
		System.out.println("++++ Barber tallant el cabell");
	}

	public synchronized void acabarTall() {
		fiTallCabell = true;
		System.out.println("++++ Barber acaba de tallar el cabell");
		notifyAll();
	}

}