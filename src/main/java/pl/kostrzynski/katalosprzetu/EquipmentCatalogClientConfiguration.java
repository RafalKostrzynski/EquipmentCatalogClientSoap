package pl.kostrzynski.katalosprzetu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class EquipmentCatalogClientConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("pl.kostrzynski.soap.wsdl");
        return marshaller;
    }

    @Bean
    public EquipmentCatalogClient equipmentCatalogClient(Jaxb2Marshaller marshaller) {
        EquipmentCatalogClient client = new EquipmentCatalogClient();
        client.setDefaultUri("http://localhost:8088/mockApiPortSoap11");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


}
