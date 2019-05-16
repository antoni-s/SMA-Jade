package ma.ensias.sma.agents;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import ma.ensias.sma.beans.Product;
import ma.ensias.sma.behaviors.ReceiveAndOrderProductsBehavior;

//Classe do agente
public class Consumer extends Agent implements IConsumer {
	
	@Override
	protected void setup() {

		//Constroi o behaviour
		addBehaviour(new OneShotBehaviour() {			
			@Override
			public void action() {
				System.out.println("Novo agente consumidor criado!!");
			}
		});
		
		addBehaviour(new ReceiveAndOrderProductsBehavior());
	}

	public int getDesiredQuantityOf(Product product) {
		double pmax = getPmax(product.getUnitPrice());
		int qmax = getQmax(product.getUnitPrice());
		double m = -qmax/pmax;
		double p = product.getUnitPrice();
		int q = (int) (Math.round(m*p + DEMAND_CONSTANT));
		return q>0 ? q:0;
	}
	
	/** Consumidor permite-se usar seu orçamento até 
	 * MAX_BUDGET * (1-rand) comprar produto
	 * Qmax = O valor de 'Gourmandise'
	 */
	private int getQmax(double productPrice) {
		return  (int)Math.round(MAX_BUDGET*(1-Math.random()) / productPrice);
	}

	/** Consumidor pode adicionar MAX_AUGMENTATION %
	 * Pmax = O preço máximo que o consumidor está disposto a pagar
	 */
	private double getPmax(double productPrice) {
		double augmentation = Math.random();
		while (augmentation > MAX_AUGMENTATION) augmentation = Math.random();
		return productPrice * ( 1 + augmentation );
	}
	//Le prix maximum que le consommateur est prêt à payer
}



