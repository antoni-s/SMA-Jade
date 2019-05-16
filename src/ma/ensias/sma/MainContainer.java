package ma.ensias.sma;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.ContainerController;

public class MainContainer {

	private ContainerController mainContainer;
	
	public MainContainer() {
		// Crie uma instância da VM
		Runtime rt = Runtime.instance();		
		// Corrigir/Fixa algumas propriedades
		Properties p = new ExtendedProperties();
		// GUI Jade
		p.setProperty("gui", "true");
		ProfileImpl profile = new ProfileImpl(p);
		// Criar container
		mainContainer = rt.createMainContainer(profile);
	}
	
	public ContainerController getContainer() { return mainContainer; }
}
