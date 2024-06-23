package br.com.ldf;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Module
public class SampleModule {

	@Provides
	@Singleton
	public MailService mailService(MailClient mailClient) {
		return new MailServiceImpl(mailClient);
	}

	@Provides
	@Singleton
	public MailClient mailClient(Jaxb2Marshaller marshaller) {
		MailClient client = new MailClient();
		client.setDefaultUri("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Provides
	@Singleton
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("br.com.ldf.soap.bindings");
		return marshaller;
	}
}
