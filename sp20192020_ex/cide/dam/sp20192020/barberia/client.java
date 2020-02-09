package cide.dam.sp20192020.barberia;

public class client extends java.lang.Thread {

	private barberia laBarberia;
	private int clientId;
	private boolean tallCabell = false;

	public client(barberia laBarberia, int clientId) {
		this.laBarberia = laBarberia;
		this.clientId = clientId;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep((int)Math.random()*3000+1);
				tallCabell = laBarberia.entrar(clientId);
				// Tallar cabell
				if (tallCabell) {
					// Esper fins que em creixi el pel
					Thread.sleep(25000);
				} else {
					// Esper i ho torn intentar
					Thread.sleep(4000);
				}
			} catch (InterruptedException e) {
			}
			;
		}
	}
}