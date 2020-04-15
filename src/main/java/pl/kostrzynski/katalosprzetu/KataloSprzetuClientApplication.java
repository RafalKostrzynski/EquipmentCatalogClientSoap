package pl.kostrzynski.katalosprzetu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kostrzynski.soap.wsdl.RegisterCallResponse;
import pl.kostrzynski.soap.wsdl.ResultsResponse;

@SpringBootApplication
public class KataloSprzetuClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(KataloSprzetuClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup( EquipmentCatalogClient equipmentCatalogClient) {
    return args -> {
        String student = "Rafal";
        if (args.length > 0) {
            student = args[0];
        }
        RegisterCallResponse registerCallResponse = equipmentCatalogClient.getRegisterCall(student);
        System.out.println(registerCallResponse.getExercise().getName());
        System.out.println(registerCallResponse.getExercise().getNote());
        ResultsResponse resultsResponse = equipmentCatalogClient.getResults(student);
        System.out.println(resultsResponse.getEntry());
    };
    }
}
