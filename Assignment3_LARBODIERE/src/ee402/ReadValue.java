package ee402;

import java.io.*;
import java.net.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;
import java.util.Date;

public class ReadValue implements Serializable //necessary for the file lecture
{
	private float degree;
	private String classtest, infoClient;
	private Vector <Float> tab;
	private Date time;
	
	public ReadValue(String info) //function reading the degrees values
	{
		this.tab = new Vector <Float>();
		this.classtest = "ReadValue";
		
		//String file = "/sys/class/thermal/thermal_zone0/temp";
		
		this.degree = (float)(Math.random()*25); //25 random values we can add more
		tab.add(degree); //Adding the random values to the tab vector
		Calendar C = Calendar.getInstance();
		this.time = C.getTime();
		this.infoClient = info;
		
		
	}
	
	public String toString() //Informations about the thread
	{
		return ("Number of degrees : " + degree + "\nNumber client : " + infoClient + "\nAt time : " + time.toString());
	}
	
	public void setDegree(float d) //Setter of the temperature
	{
		degree = d;
	}
	
	public float getValue() //Getter of the temperature
	{
		return (this.degree);
	}
	
	public String getClasstest() //Getter of Classtest
	{
		return (this.classtest); //Name of the class
	}
	
	public String getInfoClient() //Getter of client's informations 
	{
		return (this.infoClient);
	}
	
	public Date getTheDay() //Getter of the time of the temperature
	{
		return (this.time);
	}
}