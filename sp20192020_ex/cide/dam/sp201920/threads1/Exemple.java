package cide.dam.sp201920.threads1;

public class Exemple {
	public static void main(String[] args) {
		final int num_threads = 7;
		
		ObjecteCompartit objecte=new ObjecteCompartit(num_threads);
		Codithread[] fils = new Codithread[num_threads];


		for (int i = 0; i < num_threads; i++) {
			fils[i] = new Codithread(objecte, i);
			fils[i].start();
		}
		while (!(objecte.gettotsapunt())) {
			// No fa res

		}

		while (!(objecte.totsacabats())) {
			// No fa res
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("ACABAT!!");
	}
}
