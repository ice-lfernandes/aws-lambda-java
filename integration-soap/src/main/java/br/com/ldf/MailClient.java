package br.com.ldf;

import br.com.ldf.soap.bindings.ConsultaCEP;
import br.com.ldf.soap.bindings.ConsultaCEPResponse;
import br.com.ldf.soap.bindings.ObjectFactory;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


/**
 * Cliente para serviços de Correio
 */
public class MailClient extends WebServiceGatewaySupport {

  public ConsultaCEPResponse searchZipCodeDetails(String zipCode) {
    var objectFactory = new ObjectFactory();
    ConsultaCEP consultaCEP = objectFactory.createConsultaCEP();
    consultaCEP.setCep(zipCode);
    JAXBElement<ConsultaCEP> jaxbRequest = objectFactory.createConsultaCEP(consultaCEP);

    var jaxbResponse = (JAXBElement<ConsultaCEPResponse>) getWebServiceTemplate().marshalSendAndReceive(jaxbRequest);
    return jaxbResponse.getValue();
  }

}
