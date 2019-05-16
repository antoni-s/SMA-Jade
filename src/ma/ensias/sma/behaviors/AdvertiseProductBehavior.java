package ma.ensias.sma.behaviors;

import java.io.IOException;
import java.util.List;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import ma.ensias.sma.agents.Producer;
import ma.ensias.sma.beans.Product;

//Classe de comportamento
public class AdvertiseProductBehavior extends OneShotBehaviour {

	@Override
	public void action() {
		//Agente produtor
		Producer producer = (Producer)myAgent;
		//Produto/Mercadoria a ser anunciado
		Product product = producer.getProduct();
		//Lista de Consumidores
		List<String> consumers = producer.getConsumersNames();
				
		ACLMessage message = new ACLMessage(ACLMessage.INFORM);
		consumers.forEach(consumer ->  message.addReceiver(new AID(consumer, AID.ISLOCALNAME)));
		try { message.setContentObject(product); } catch (IOException ex) {	ex.printStackTrace(); }
		message.setOntology("commerce");
		myAgent.send(message);	
		System.out.println("Enviada mensagem INFORM para mostrar meu novo produto");
	}
	

}

