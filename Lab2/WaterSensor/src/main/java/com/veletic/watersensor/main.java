package com.veletic.watersensor;

//omogucit kreiranje devicea sa brokerom i topicom kao parametrima
//dodat pojedinacne senzore (metoda za dodvanje)
// iz maina pozivat addSensor

public class main {

	public static void main(String[] args)  {
		
		
		Device WaterSensor = new Device("tcp://localhost:","topic");
		
		
		Sensor sensor = new Sensor("temperatura", "int16", 10, "°C");
		WaterSensor.addSensor(sensor);
		System.out.println("Sensor -Temperatura- added!");
		
		Sensor sensor1 = new Sensor("tlak", "uint16", 1000,"Bar");
		WaterSensor.addSensor(sensor1);
		System.out.println("Sensor -Tlak- added!");
	
		Sensor sensor2 = new Sensor("potrosnja1", "uint16", 0,"litra");
		WaterSensor.addSensor(sensor2);
		System.out.println("Sensor -Potrosnja1- added!");
		
		Sensor sensor3 = new Sensor("potrosnja2", "uint16", 0, "m3");
		WaterSensor.addSensor(sensor3);
		System.out.println("Sensor -Potrosnja2- added!");
		
		WaterSensor.runDevice();
		
		Device device = Device.deserialize("src/main/resources/jsonfile/JSONtest.json");
		
		
	}
}
