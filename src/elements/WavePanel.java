package elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

import javax.swing.JPanel;

import units.*;

public class WavePanel extends JPanel {
	
	private static final BasicStroke STROKE_AXIS = new BasicStroke(0.1f, BasicStroke.CAP_SQUARE,
			BasicStroke.JOIN_MITER);
	private static final BasicStroke STROKE_LINE = new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
	private static final int SCALE = 100;
	private ArrayList<Wave> waveQue;
	private int x_inc = 10, smoothness = 8; // Smoothness should be even, or
											// line will be weird; To much
											// smoothness causes errors

	public WavePanel() {
		waveQue = new ArrayList<Wave>();
		waveQue.add(new Wave(new Amplitude(1), new Velocity(0f), new Visability(true), new PhaseShift(0),
				new Frequency(1f), Color.RED));
		waveQue.add(new Wave(new Amplitude(2), new Velocity(0f), new Visability(true), new PhaseShift(0),
				new Frequency(1f), Color.BLUE));
		waveQue.add(new Wave(new Amplitude(3), new Velocity(0f), new Visability(true), new PhaseShift(0),
				new Frequency(1f), Color.GREEN));
		waveQue.add(new Wave(new Amplitude(4), new Velocity(0f), new Visability(true), new PhaseShift(0),
				new Frequency(1f), Color.YELLOW));
		waveQue.add(new Wave(new Amplitude(5), new Velocity(0f), new Visability(true), new PhaseShift(0),
				new Frequency(1f), Color.ORANGE));

		waveQue.add(new Wave(new Amplitude(5), new Velocity(0f), new Visability(false), new PhaseShift(0),
				new Frequency(1f), Color.CYAN));
		waveQue.add(new Wave(new Amplitude(5), new Velocity(0f), new Visability(false), new PhaseShift(0),
				new Frequency(1f), Color.PINK));
		waveQue.add(new Wave(new Amplitude(5), new Velocity(0f), new Visability(false), new PhaseShift(0),
				new Frequency(1f), Color.BLACK));

		waveQue.get(0).calc(x_inc, smoothness);
		waveQue.get(1).calc(x_inc, smoothness);
		waveQue.get(2).calc(x_inc, smoothness);
		waveQue.get(3).calc(x_inc, smoothness);
		waveQue.get(4).calc(x_inc, smoothness);

		waveQue.get(5).calc(x_inc, smoothness);
		waveQue.get(6).calc(x_inc, smoothness);
		waveQue.get(7).calc(x_inc, smoothness);
		
		waveQue.get(5).setSpecialType(true);
		waveQue.get(6).setSpecialType(true);
		waveQue.get(7).setSpecialType(true);
	}

	public void step() {
		for (Wave wave : waveQue) {
			if(!wave.isSpecialType()) wave.calc(x_inc, smoothness);
			else {
				if(Group.combinedWavesA){
					waveQue.get(5).setVisability(new Visability(true));
					double[] newPoints = new double[waveQue.get(5).getDrawingPoints().length];
					for (Wave wave2 : waveQue) {
						if(!wave2.isSpecialType() && wave2.getGroup().getValue() == 1){
							if(Group.isOnlyShowFinalA()) wave2.setVisability(new Visability(false));
							else wave2.setVisability(new Visability(true));
						
							for(int i = 0; i < waveQue.get(5).getDrawingPoints().length; i++){
								newPoints[i] += wave2.getDrawingPoints()[i];
							}
							waveQue.get(5).setDrawingPoints(newPoints);
						}
					}
				} else {
					waveQue.get(5).setVisability(new Visability(false));
				}
				
				if(Group.combinedWavesB){
					waveQue.get(6).setVisability(new Visability(true));
					double[] newPoints = new double[waveQue.get(6).getDrawingPoints().length];
					for (Wave wave2 : waveQue) {
						if(!wave2.isSpecialType() && wave2.getGroup().getValue() == 2){
							if(Group.isOnlyShowFinalB()) wave2.setVisability(new Visability(false));
							else wave2.setVisability(new Visability(true));
						
							for(int i = 0; i < waveQue.get(6).getDrawingPoints().length; i++){
								newPoints[i] += wave2.getDrawingPoints()[i];
							}
							waveQue.get(6).setDrawingPoints(newPoints);
						}
					}
				} else {
					waveQue.get(6).setVisability(new Visability(false));
				}
				
				if(Group.combinedWavesC){
					waveQue.get(7).setVisability(new Visability(true));
					double[] newPoints = new double[waveQue.get(7).getDrawingPoints().length];
					for (Wave wave2 : waveQue) {
						if(!wave2.isSpecialType() && wave2.getGroup().getValue() == 3){
							if(Group.isOnlyShowFinalC()) wave2.setVisability(new Visability(false));
							else wave2.setVisability(new Visability(true));
						
							for(int i = 0; i < waveQue.get(7).getDrawingPoints().length; i++){
								newPoints[i] += wave2.getDrawingPoints()[i];
							}
							waveQue.get(7).setDrawingPoints(newPoints);
						}
					}
				} else {
					waveQue.get(7).setVisability(new Visability(false));
				}
				
			}
			
			wave.shift(SCALE);
		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D) g;
		graphics.setStroke(STROKE_AXIS);
		graphics.setColor(Color.BLACK);
		drawAxis(graphics);
		graphics.setStroke(STROKE_LINE);
		for (Wave wave : waveQue) {
			graphics.setColor(wave.getColor());
			for (int x = 1; x <= x_inc * smoothness; x++) {
				if (wave.getVisability().getValue()) {
					graphics.drawLine((getWidth() / (x_inc * smoothness)) * (x - 1),
							(int) Math.round(
									(getHeight() / 2) + (getHeight() / (2 * x_inc)) * wave.getDrawingPoints()[x - 1]),
							(getWidth() / (x_inc * smoothness)) * x, (int) Math.round(
									(getHeight() / 2) + (getHeight() / (2 * x_inc)) * wave.getDrawingPoints()[x]));
				}
			}
		}
	}

	public void drawAxis(Graphics2D g) {
		g.drawLine(0, (getHeight() / 2), getWidth(), (getHeight() / 2));
		for (int x = 0; x <= x_inc; x++) {
			g.drawLine((getWidth() / x_inc) * x, (int) Math.round((getHeight() / 2) + (getHeight() / (2 * x_inc) / 2)),
					(getWidth() / x_inc) * x, (int) Math.round((getHeight() / 2) - (getHeight() / (2 * x_inc) / 2)));
		}
	}

	public Wave getWave(int index) {
		return waveQue.get(index);
	}

}
