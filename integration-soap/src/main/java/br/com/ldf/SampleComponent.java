package br.com.ldf;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { SampleModule.class })
public interface SampleComponent {

	MailService aggregate();
}
