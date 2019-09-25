package elements;

import java.awt.Color;

import units.*;

public class Wave {
	private Amplitude amplitude;
	private Velocity velocity;
	private Visability visability;
	private PhaseShift phaseshift, velshift;
	private Period period;
	private Color color;
	private Group group;
	private boolean specialType;
	private double[] drawingPoints;
	
	public Wave(Amplitude amplitude, Velocity velocity, Visability visability, PhaseShift phaseshift, Frequency frequency, Color color){
		this.amplitude = amplitude;
		this.velocity = velocity;
		this.visability = visability;
		this.phaseshift = phaseshift;
		this.color = color;
		specialType = false;
		group = new Group(0);
		period = new Period(1 / frequency.getValue());
		velshift = new PhaseShift(0);
	}

	public Wave(Amplitude amplitude, Velocity velocity, Visability visability, PhaseShift phaseshift, Period period, Color color){
		this.amplitude = amplitude;
		this.velocity = velocity;
		this.visability = visability;
		this.phaseshift = phaseshift;
		this.period = period;
		this.color = color;
		specialType = false;
		group = new Group(0);
		velshift.setValue(0);
	}
	
	public void shift(int scale){
		velshift.setValue(velshift.getValue() + (velocity.getValue() / scale));
		if(period.getValue() >= 1){
			if(velshift.getValue() >= period.getValue() * 2 * Math.PI) velshift.setValue(0);
		} else {
			if(velshift.getValue() >= (1 / period.getValue()) * 2 * Math.PI) velshift.setValue(0);
		}
		
	}
	
	public void calc(int x_inc, int smoothness){
		drawingPoints = new double[(x_inc * smoothness) + smoothness];
		for(int x = 0; x <= x_inc * smoothness; x++){
			drawingPoints[x] = (amplitude.getValue() * Math.sin(period.getValue() * (x  * (Math.PI / (2 * smoothness))) + phaseshift.getValue() + velshift.getValue()));
		}
	}
	
	//Getters and Setters
	
	public Amplitude getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(Amplitude amplitude) {
		this.amplitude = amplitude;
	}

	public Velocity getVelocity() {
		return velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	public Visability getVisability() {
		return visability;
	}

	public void setVisability(Visability visability) {
		this.visability = visability;
	}

	public PhaseShift getPhaseshift() {
		return phaseshift;
	}

	public void setPhaseshift(PhaseShift phaseshift) {
		this.phaseshift = phaseshift;
	}

	public Frequency getFrequency() {
		return new Frequency(1 / period.getValue());
	}

	public void setFrequency(Frequency frequency) {
		period.setValue(1 / frequency.getValue());
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public double[] getDrawingPoints() {
		return drawingPoints;
	}

	public void setDrawingPoints(double[] drawingPoints) {
		this.drawingPoints = drawingPoints;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean isSpecialType() {
		return specialType;
	}

	public void setSpecialType(boolean specialType) {
		this.specialType = specialType;
	}
	
	

}
