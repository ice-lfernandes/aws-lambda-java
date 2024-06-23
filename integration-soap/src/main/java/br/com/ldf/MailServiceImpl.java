package br.com.ldf;

import javax.inject.Inject;

public class MailServiceImpl implements MailService {

	private final MailClient mailClient;

	@Inject
	public MailServiceImpl(MailClient mailClient) {
    this.mailClient = mailClient;
  }

	public String aggregate() {
		return mailClient.searchZipCodeDetails("20720011").getReturn().getEnd();
	}

}
