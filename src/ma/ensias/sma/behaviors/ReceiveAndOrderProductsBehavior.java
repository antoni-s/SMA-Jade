package ma.ensias.sma.behaviors;

import java.io.IOException;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import ma.ensias.sma.agents.Consumer;
import ma.ensias.sma.beans.Order;
import ma.ensias.sma.beans.Product;

public class ReceiveAndOrderProductsBehavior extends CyclicBehaviour {
	
	@Override
	public void action() {
		ACLMessage message = receiveMessage(ACLMessage.INFORM);	
		if (message != null) {
			System.out.println("Recebeu uma mensagem INFORM");
			Order order = generateOrderForTheProduct(message);	
			if (order != null) sendOrder(message, order, ACLMessage.REQUEST);			
		} else {
			block();
		}
		
	}
	
	private ACLMessage receiveMessage(int performative) {
		MessageTemplate template = 
				MessageTemplate.and(MessageTemplate.MatchPerformative(performative), 
						MessageTemplate.MatchOntology("commerce"));				
		ACLMessage message = myAgent.receive(template);
		return message;
	}

	private Order generateOrderForTheProduct(ACLMessage message) {
		try { 
			Product product = (Product) message.getContentObject();
			System.out.println("conteúdo da mensagem (produto): " + product);
			Consumer consumer = (Consumer)myAgent;
			int quantity = consumer.getDesiredQuantityOf(product);
			System.out.println("Consumidor " + consumer.getName() + " quer " + quantity +
					" do " + product.getName());
			return new Order(product, quantity);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void sendOrder(ACLMessage message, Order order, int performative) {
		ACLMessage reply = message.createReply();
		reply.setPerformative(performative);
		try { reply.setContentObject(order);
		} catch (IOException e) { e.printStackTrace(); }		
		myAgent.send(reply);
	}

}
