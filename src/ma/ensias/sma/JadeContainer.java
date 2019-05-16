package ma.ensias.sma;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.ContainerController;

public class JadeContainer {

	private ContainerController container;
	
	public JadeContainer() {
		// Crie uma instância da VM
		Runtime rt = Runtime.instance();
		// Criar perfil sem propriedade
		ProfileImpl profile = new ProfileImpl(false);
		// Iniciação do perfil
		profile.setParameter(ProfileImpl.MAIN_HOST, "localhost");
		profile.setParameter(ProfileImpl.CONTAINER_NAME, "Market");
		container = rt.createAgentContainer(profile); // criar os container
	}

	public ContainerController getContainer() { return container; }
}

