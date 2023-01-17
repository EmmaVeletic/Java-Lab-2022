package com.veletic.watersensor;

import java.lang.Math;

public class Sensor {

		private String name;
		private String type;
		private int factor;
		private int value;
		private String unit;
		
		
		public Sensor(String newName, String newType, int newFactor, String newUnit){
			this.name = newName;
			this.type = newType;
			this.factor = newFactor;
			this.unit = newUnit;
			
			
			switch(unit)
	        {
	            case "°C":
	                this.value = (int) ((int) (Math.random() * (3266.8) - (-3266.8)) + (-3266.8));
	                break;
	            case "Bar":
	                this.value = (int) (Math.random() * 65.336);
	                break;
	            case "litra":
	                this.value = (int) (Math.random() * 65336);
	                break;
	            case "m3":
	                this.value = (int) (Math.random() * 6533.6);
	                break;
	            default:
	                System.out.println("Error! Invalid input!");
	        }
			
		}
		
		
		
		public Sensor() {
			
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getType() {
			return type;
		}



		public void setType(String type) {
			this.type = type;
		}



		public int getFactor() {
			return factor;
		}



		public void setFactor(int factor) {
			this.factor = factor;
		}



		public int getValue() {
			return value;
		}



		public void setValue(int value) {
			this.value = value;
		}



		public String getUnit() {
			return unit;
		}



		public void setUnit(String unit) {
			this.unit = unit;
		}



		@Override
	    public String toString()
	    {
	        return "Sensor{" + "name='" + name + '\'' + ", type='"
	                + type + '\'' + ", factor=" + factor + ", value="
	                + value + ", unit='" + unit + '\'' + '}';
	    }
		
		
} 