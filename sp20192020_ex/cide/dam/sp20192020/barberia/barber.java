package cide.dam.sp20192020.barberia;

public class barber extends Thread {

	private barberia laBarberia;

	public barber(barberia laBarberia) {
		this.laBarberia = laBarberia;
	}

	public void run() {
		while (true) {
			try {
				laBarberia.esperarClient();
				// Tallar cabell
				Thread.sleep((int)Math.random()*10000+1);
				laBarberia.acabarTall();
				// Decansa un poco
				Thread.sleep((int)Math.random()*3000+1);
			} catch (InterruptedException e) {
			}
			;
		}
	}
}
