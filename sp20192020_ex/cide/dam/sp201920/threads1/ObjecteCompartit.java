package cide.dam.sp201920.threads1;

public class ObjecteCompartit extends Thread{

	boolean totsapunt;
	int numfils;
	int[] fils;
	
	public ObjecteCompartit(int numfils) {
		this.numfils=numfils;
		fils=new int[this.numfils];
		for (int comptador=0;comptador<this.numfils;comptador++) {
			fils[comptador]=0;
		}
	}
	public boolean gettotsapunt() {
		int comprovador = actualitza_comprovador();
		if (comprovador==this.numfils)
				return true;
		else
			return false;
	}
	private int actualitza_comprovador() {
		int comprovador=0;
		for (int comptador=0;comptador<this.numfils;comptador++) {
			comprovador=comprovador+this.fils[comptador];
		}
		return comprovador;
	}
	public void acabat(int id) {
		this.fils[id]=0;
	}
	public boolean totsacabats() {
		int comprovador = actualitza_comprovador();
		if (comprovador==0) {
				return true;}
		else
			return false;
	}
	public synchronized void esperar(int id)
			throws InterruptedException {
		this.fils[id]=1;
		
		if (gettotsapunt()) {
			System.out.println("COMENÇA LA CURSA");
			notifyAll();
		} else
			wait();	

	}

}


