package ee402;


import java.awt.*;
//import java.util.*;
//import javax.swing.*;
import java.awt.geom.AffineTransform;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Vector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tracer extends JPanel //For the use of the method paint (drawing the curve and the graph)
{
	//Overriding
	private Map<String, Curve> myothersclients; //multiple connections
	private ClientConstru myClient;
	
	//Not sure about it
	//public boolean firstC;
	//public boolean secondC;
	//public boolean thirdC;
	//public boolean fourthC;
	
	public Tracer(ClientConstru firstC, Map<String, Curve> myothersclients) //Constructor of the Tracer class
	{
		this.myothersclients = myothersclients; //Initialization of the others possible clients
		this.myClient = firstC;
	}
	
	public void paint(Graphics graph) //Drawing the graph
	{
		
		super.paint(graph);
		graph.setFont(new Font("default", Font.BOLD, 14)); //Write the title in bold
		graph.drawString("EE402 Representation of the temperature on several clients", 6, 12); //Title
		
		//Draw the graph
		graph.setColor(Color.darkGray); //Set the color of the lines
		graph.drawLine(20, 38, 20, 432); //Abcissa
		graph.drawLine(8, 420, 640, 420); //Ordinate
		
		//Drawing crosses
		graph.setColor(Color.darkGray);
		graph.drawLine(16, 42, 20, 38);
		graph.drawLine(24, 42, 20, 38);
		graph.drawLine(636, 416, 640, 420);
		graph.drawLine(636, 424, 640, 420);
		
		//Drawing little lines
		int x1=605, y1=424, x2=605, y2=416;
		for (int i=17; i>0; i--)
		{
			graph.drawLine(x1, y1, x2, y2);
			x1=x1-35;
			x2=x2-35;
		}
		
		int a1=16, a2=24, b1=44, b2=44;
		for (int i=0;i<12;i++)
		{
			graph.drawLine(a1, b1, a2, b2);
			b1=b1+32;
			b2=b2+32;
		}
		
		
		
		//Writing Strings on the graph
		graph.setFont(new Font("default", Font.PLAIN, 12)); //Restablish the original writing
		AffineTransform vertically = new AffineTransform();
		vertically.setToRotation(Math.toRadians(90), 80, 100);
		//graph.setTransform(vertically); Don't work with Graphics but with Graphics2D yes
		graph.drawString("Temperature (°C)", 10, 30);
		graph.drawString("0", 10, 432);
		graph.drawString("Time (sec)", 630, 435);
		graph.drawString("48", 5, 55);
		graph.drawString("4", 7, 400);
		graph.drawString("1", 42, 436);
		
		Set<String> testIn = this.myothersclients.keySet();
		Iterator<String> it = testIn.iterator(); //Don't work for several clients
		
		int ab = 0;
		while(it.hasNext())
		{
			ab=ab+1;
			Curve myCurve = myothersclients.get(it.next()); 
			Vector<CurvePoints> myPoint = myCurve.getSerie();
			Color curvecolor = myCurve.getCurveColor();
			
			//There are 4 different clients
			if(ab==1 && myPoint.size()>1 && myClient.firstC == 1)
			{
				for(int a = 0; a<myPoint.size() -1; a++)
				{
					//Tracing the points of firstC
					CurvePoints firstP = myPoint.get(a);
					CurvePoints secondP = myPoint.get(a+1);
					
					//Get the placement of each point
					int abc1 = (int)firstP.getAbci();
					int abc2 = (int)secondP.getAbci();
					int ord1 = (int)firstP.getOrd();
					int ord2 = (int)secondP.getOrd();
					
					//Connect the different points with a line
					graph.setColor(curvecolor);
					graph.drawLine(abc1, ord1, abc2, ord2);
					graph.setColor(curvecolor);
			}
			
			if(ab==2 && myPoint.size()>1 && myClient.secondC == 1)
			{
				for(int a = 0; a<myPoint.size()-1; a++)
				{
					//Tracing the points of secondC
					CurvePoints firstP = myPoint.get(a);
					CurvePoints secondP = myPoint.get(a+1);
					
					//Get the placement of each point
					int abc1 = (int)firstP.getAbci();
					int abc2 = (int)secondP.getAbci();
					int ord1 = (int)firstP.getOrd();
					int ord2 = (int)secondP.getOrd();
					
					//Connect the different points with a line
					
					
					graph.setColor(curvecolor);
					graph.drawLine(abc1, ord1, abc2, ord2);
					graph.setColor(curvecolor);
					graph.drawLine(abc1-4, ord1, abc2-4, ord2);
					graph.drawLine(abc1, ord1-4, abc2, ord2-4);
				}
			}
			
			if(ab==3 && myPoint.size()>1 && myClient.thirdC == 1)
			{
				for(int a = 0; a<myPoint.size()-1; a++)
				{
					//Tracing the points of thirdC
					CurvePoints firstP = myPoint.get(a);
					CurvePoints secondP = myPoint.get(a+1);
					
					//Get the placement of each point
					int abc1 = (int)firstP.getAbci();
					int abc2 = (int)secondP.getAbci();
					int ord1 = (int)firstP.getOrd();
					int ord2 = (int)secondP.getOrd();
					
					//Connect the different points with a line
					
					graph.setColor(curvecolor);
					graph.drawLine(abc1, ord1, abc2, ord2);
					graph.setColor(curvecolor);
					graph.drawLine(abc1-4, ord1, abc2-4, ord2);
					graph.drawLine(abc1, ord1-4, abc2, ord2-4);
				}
			}
			
			if(ab==4 && myPoint.size()>1 && myClient.fourthC == 1)
			{
				for(int a = 0; a<myPoint.size()-1; a++)
				{
					//Tracing the points of fourthC
					CurvePoints firstP = myPoint.get(a);
					CurvePoints secondP = myPoint.get(a+1);
					
					//Get the placement of each point
					int abc1 = (int)firstP.getAbci();
					int abc2 = (int)secondP.getAbci();
					int ord1 = (int)firstP.getOrd();
					int ord2 = (int)secondP.getOrd();
					
					//Connect the different points with a line
					
					graph.setColor(curvecolor);
					graph.drawLine(abc1, ord1, abc2, ord2);
					graph.setColor(curvecolor);
					graph.drawLine(abc1-4, ord1, abc2-4, ord2);
					graph.drawLine(abc1, ord1-4, abc2, ord2-4);
				}
			}
		}
		
		}
		
	}
}