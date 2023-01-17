package com.veletic.color;

public class ColorCustom {
	int red;
	int green;
	int blue;
	
	public ColorCustom(int r, int g, int b) {
		this.red = r;
		this.green = g;
		this.blue = b;
	}

	public int getRed() {
		return this.red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return this.green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return this.blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public int getRGB() {
		return 0;
	}
	
    public static ColorCustom decode(String hexColor) {
        int i = Integer.decode(hexColor);
        return new ColorCustom((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
    }

	public static float[] RGBtoHSB(int r, int g, int b, float[] hsbCode) {
		 float red;
		 float green;
		 float blue;
		 
	     if (hsbCode == null) {
	       	hsbCode = new float[3];
	     }
	     
	     int max = (r > g) ? r : g;
	     if (b > max) max = b;
	     
	     int min = (r < g) ? r : g;
	     if (b < min) min = b;

	     blue = ((float) max) / 255.0f;
	        
	     if (max != 0)   
	    	 green = ((float) (max - min)) / ((float) max);
	     else
	    	 green = 0;
	     
	     if (green == 0)   
	    	 red = 0;
	     else {  
	    	 float red2 = ((float) (max - r)) / ((float) (max - min));
	         float green2 = ((float) (max - g)) / ((float) (max - min));
	         float blue2 = ((float) (max - b)) / ((float) (max - min));
	            
	         if (r == max)
	        	 red = blue2 - green2;    
	         else if (g == max)
	        	 red = 2.0f + red2 - blue2;
	         else
	        	 red = 4.0f + green2 - red2;
	            
	         red = red / 6.0f;
	            
	         if (red < 0)
	             red = red + 1.0f;
	        
	     }
	     hsbCode[0] = red;
	     hsbCode[1] = green;
	     hsbCode[2] = blue;
	     
	     return hsbCode;
	}

	public static float[] RGBtoHSL(int r, int g, int b, float[] hslCode) {
		float red = r / 255.0f;
		float green = g / 255.0f;
		float blue = b / 255.0f;

		float max = Math.max(red, green);
		max = Math.max(max, blue);

		float min = Math.min(red, green);
		min = Math.min(min, blue);
		hslCode[2] = (max + min) / 2;

		if ((max - min) == 0) {
			hslCode[1] = 0;
		} else {
			hslCode[1] = (max - min) / (1 - Math.abs(2*hslCode[2] - 1));
		}
		
		if (max - min == 0) {
			hslCode[0] = 0;
		} else if (red == max) {
			hslCode[0] = ((green - blue) / (max - min)) % 6;
		} else if (green == max) {
			hslCode[0] = 2.0f + (blue - red) / (max - min);
		} else if (blue == max) {
			hslCode[0] = 4.0f + (red - green) / (max - min);
		}
		
		if (hslCode[0] < 0)
			hslCode[0] += 360;
		
		return hslCode;
	}
	
	public static float[] RGBtoCMYK(int r, int g, int b, float[] cmykCode) {
		float red = r / 255.0f;
		float green = g / 255.0f;
		float blue = b / 255.0f;
		
		float max = Math.max(red, green);
		max = Math.max(max, blue);
		
		float k = 1 - max;
		cmykCode[0] = (1 - red - k) / (1-k);
		cmykCode[1] = (1 - green - k) / (1 - k);
		cmykCode[2] = (1 - blue - k) / (1 - k);
		cmykCode[3] = k;
		
		return cmykCode;
	}
}