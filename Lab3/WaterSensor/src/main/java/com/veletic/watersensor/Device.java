package com.veletic.watersensor;

import org.eclipse.paho.client.mqttv3.*;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

//device je mjeraè protoka vode
//kreirat objekt device u mainu jednom
// faktor pomnožit sa vrijednošæu koju dobivamo
//korisniku omoguæit unos rangea i unita
//pripremit konstruktor device koji prima putanju do file-a (sadrzi json)
//broker i topic mora bit unutar device

public class Device {
	
	private ArrayList<Sensor> sensorCollection = new ArrayList<>();
	private String broker;
	private String topic;
	
	public Device(String br, String top) {
		
		broker = br;
		topic = top;
	}
	
	public Device() {
		
	}
	
	
	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public ArrayList<Sensor> getSensorCollection() {
		return sensorCollection;
	}

	/*public static Device deserialize(String filePath) throws StreamReadException, DatabindException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Device device= mapper.readValue(new File(filePath), Device.class);

        return device;
    }*/
	
	public static Device deserialize(String filePath) {
		Device device = new Device();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			device = objectMapper.readValue(new File(filePath), Device.class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return device;
	}
	
	public void addSensor(Sensor newSensor) {
		this.sensorCollection.add(newSensor);
	}
	
	
	/*public void printSensors(int numberOfSensors) {
		for(int i = 0; i < numberOfSensors; i++)
            System.out.println("Senzor " + (i + 1) +": " + sensorCollection.get(i).toString());
	}*/
	
	public void runDevice(){
		
		try 
        {
            MqttClient client = new MqttClient(broker, topic);
            client.connect();
            MqttMessage message = new MqttMessage();
            for(int i = 0; i < sensorCollection.size(); i++)
            {
                message.setPayload(sensorCollection.get(i).toString().getBytes());
                client.publish(topic, message);
                
            }
            
            client.disconnect(); 
            client.close();
          }
			catch(MqttException e){
            e.printStackTrace();
        }
    }
		
}

/*CONNECTING MQTT SUB 
 * position to mosquitto.exe path in cmd
 * run mosquitto.exe (not in cmd)
 * mosquitto_sub -h localhost -t "topic"
 * run app
 */



