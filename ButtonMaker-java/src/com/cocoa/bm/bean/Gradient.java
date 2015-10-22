package com.cocoa.bm.bean;

import java.awt.Color;

public class Gradient {

//	
//	<gradient
//	android:angle="315"
//	android:centerX="35%"
//	android:centerColor="#7995A8"
//	android:startColor="#E8E8E8"
//	android:endColor="#000000"
//	android:type="linear"
//	/>
	
	public  enum TYPE{
		linear,radial
	}
	
	
	
	private  TYPE type;
	private  int angle  ;
	private int centerX;
	private String  centerColor;
	private String startColor;
	private String endColor;
	
	
	
	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
	public int getCenterX() {
		return centerX;
	}
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	public String getCenterColor() {
		return centerColor;
	}
	public void setCenterColor(String centerColor) {
		this.centerColor = centerColor;
	}
	public String getStartColor() {
		return startColor;
	}
	public void setStartColor(String startColor) {
		this.startColor = startColor;
	}
	public String getEndColor() {
		return endColor;
	}
	public void setEndColor(String endColor) {
		this.endColor = endColor;
	}
	
	
	
	
	
	
	
}
