package pl.kostrzynski.katalosprzetu;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import pl.kostrzynski.soap.wsdl.RegisterCallRequest;
import pl.kostrzynski.soap.wsdl.RegisterCallResponse;
import pl.kostrzynski.soap.wsdl.ResultsRequest;
import pl.kostrzynski.soap.wsdl.ResultsResponse;

public class EquipmentCatalogClient extends WebServiceGatewaySupport {

    public ResultsResponse getResults(String value) {
        ResultsRequest request = new ResultsRequest();
        request.setStudent(value);
        return (ResultsResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8088/mockApiPortSoap11"
                , request);
    }

    public RegisterCallResponse getRegisterCall(String student) {
        RegisterCallRequest request = new RegisterCallRequest();
        request.setStudent(student);
        return (RegisterCallResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8088/mockApiPortSoap11"
                , request);
    }
}
