package com.example.pages.components.Services;

import com.example.pages.components.Entities.Client;
import com.example.pages.components.Entities.Device;
import com.example.pages.components.Entities.Measurement;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class DeviceService {
    public List<Device> GetData( String sort, String pageNum, String pageSize) throws IOException, InterruptedException {
        String urlstring = "http://localhost:8080/device?sortDir="+sort+"&pageNum="+pageNum+"&pageSize="+pageSize;
        HttpClient device = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(urlstring))
                .build();
        HttpResponse<String> response = device.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(response.body());
        System.out.println(node);
        JsonNode subnode = node.path("content");
        System.out.println("Na liniji 33"+subnode);
        List<Device> devices = objectMapper.readValue(objectMapper.treeAsTokens(node), /*response.body(),*/ new TypeReference<List<Device>>() {});
        return devices;
    }


    public void AddData(String id, String year, String month, String day, String gg, String dg) throws IOException, InterruptedException {
        Device newDevice = new Device(Long.parseLong(id));
        Measurement result = new Measurement(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(gg), Integer.parseInt(dg));
        result.setDevice(newDevice);
        ObjectMapper mapper = new ObjectMapper();
        String requestbody = mapper.writeValueAsString(result);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestbody))
                .header("Content-type", "application/json")
                .uri(URI.create("http://localhost:8080/device/"+id+"/measurement"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return;
    }
}
