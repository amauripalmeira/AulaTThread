package TelaThread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FIlaThread extends Thread {

	public static ConcurrentLinkedQueue<ObjetoThread> fila = new ConcurrentLinkedQueue<>();
	
	public static void add (ObjetoThread objetoThread) {
		fila.add(objetoThread);
	}
	@Override
	public void run() {
		while(true) {
			Iterator intera�ao = fila.iterator();
			synchronized (intera�ao) {/*bloquer o acesso a lista por outros processos*/
				while(intera�ao.hasNext()) {/* vai processar enquanto tiver dados */ 
					ObjetoThread processar = (ObjetoThread) intera�ao.next();/*criando um objeto */
					
					try {
						Thread.sleep(1000);/*vai dar um tempo para descarga de memoria */
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("****************");
					
					System.out.println("nome " + processar.getNome());
					System.out.println("email " + processar.getEmail());
					intera�ao.remove();
				}
				
			}
			try {
				Thread.sleep(1000);/*vai dar um tempo para limpeza de memoria*/
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
