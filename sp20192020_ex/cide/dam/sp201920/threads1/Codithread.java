package cide.dam.sp201920.threads1;

public class Codithread extends Thread {
	ObjecteCompartit objectecompartit;
	int identificadorThread;
	public Codithread(ObjecteCompartit objecte, int id) {
		this.objectecompartit = objecte;
		this.identificadorThread = id;
	}
	public void run() {

			try {
				Thread.sleep((int)(Math.random()*2000+1));
				System.out.println(identificadorThread+" espera als altres");
				objectecompartit.esperar(identificadorThread);
				Thread.sleep((int)(Math.random()*5000+1));
				System.out.println("Ha arribat "+this.identificadorThread);
				objectecompartit.acabat(identificadorThread);
			} catch (InterruptedException e) {
			}
	}
}
