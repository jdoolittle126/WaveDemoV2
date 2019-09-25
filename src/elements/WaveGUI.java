package elements;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import units.*;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;

public class WaveGUI{

	private JFrame frame;
	private JRadioButton freq_period_rdbtn_period;
	private JRadioButton freq_period_rdbtn_freq;
	private JLabel freq_period_lbl_value_other;
	private JLabel freq_period_lbl_name;
	private JTextField freq_period_text_input;
	private JPanel panel_freq_period;
	private JPanel panel_wave_properties;
	private JPanel panel_wave_select;
	private JPanel panel_wave_edit;
	private WavePanel panel_wave_visual;
	private JTabbedPane tabbedPane;
	private JPanel panel_group_edit;
	private JSlider amp_slider_editamp;
	private JLabel shift_lbl_name;
	private JRadioButton shift_rdbtn_shiftvalue_none;
	private JRadioButton shift_rdbtn_shiftvalue_1;
	private JRadioButton shift_rdbtn_shiftvalue_2;
	private JLabel amp_lbl_name;
	private JLabel amp_lbl_ampvalue;
	private JLabel group_lbl_name;
	private JRadioButton group_rdbtn_groupnone;
	private JRadioButton group_rdbtn_groupa;
	private JRadioButton group_rdbtn_groupb;
	private JRadioButton group_rdbtn_groupc;
	private JRadioButton wave_select_rdbtn_wave0;
	private JRadioButton wave_select_rdbtn_wave1;
	private JRadioButton wave_select_rdbtn_wave2;
	private JRadioButton wave_select_rdbtn_wave3;
	private JRadioButton wave_select_rdbtn_wave4;
	private final ButtonGroup buttonGroup_SelectWave = new ButtonGroup();
	private final ButtonGroup buttonGroup_FreqPeriod = new ButtonGroup();
	private final ButtonGroup buttonGroup_Shift = new ButtonGroup();
	private final ButtonGroup buttonGroup_SelectGroup = new ButtonGroup();
	private final Action action_wave_selected = new SwingAction();
	private JButton wave_select_button_save;
	private JPanel panel_group_select;
	private JRadioButton group_select_rdbtn_groupa;
	private JRadioButton group_select_rdbtn_groupb;
	private JRadioButton group_select_rdbtn_groupc;
	private JButton group_select_button_apply;
	private JPanel panel_group_properties;
	private final Action action_group_selected = new SwingAction_1();
	private JCheckBox group_properties_chckbx_combined;
	private JCheckBox group_properties_chckbx_showfinal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Timer timer;
	private JRadioButton shift_rdbtn_shiftvalue_3;
	private JTextField freq_period_text_velocity;
	private JLabel freq_period_lbl_velocity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaveGUI window = new WaveGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WaveGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		panel_wave_visual = new WavePanel();
		tabbedPane.addTab("Wave Visual", null, panel_wave_visual, null);
		panel_wave_visual.setBackground(Color.white);
		
		panel_wave_edit = new JPanel();
		tabbedPane.addTab("Edit Waves", null, panel_wave_edit, null);
		panel_wave_edit.setLayout(null);
		
		panel_wave_select = new JPanel();
		panel_wave_select.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_wave_select.setBounds(0, 0, 567, 74);
		panel_wave_edit.add(panel_wave_select);
		panel_wave_select.setLayout(null);
		
		wave_select_rdbtn_wave0 = new JRadioButton("Wave 1");
		wave_select_rdbtn_wave0.setBounds(6, 9, 75, 21);
		wave_select_rdbtn_wave0.setAction(action_wave_selected);
		wave_select_rdbtn_wave0.setSelected(true);
		buttonGroup_SelectWave.add(wave_select_rdbtn_wave0);
		wave_select_rdbtn_wave0.setForeground(Color.RED);
		panel_wave_select.add(wave_select_rdbtn_wave0);
		
		wave_select_rdbtn_wave1 = new JRadioButton("Wave 2");
		wave_select_rdbtn_wave1.setBounds(83, 9, 75, 21);
		wave_select_rdbtn_wave1.setAction(action_wave_selected);
		buttonGroup_SelectWave.add(wave_select_rdbtn_wave1);
		wave_select_rdbtn_wave1.setForeground(Color.BLUE);
		panel_wave_select.add(wave_select_rdbtn_wave1);
		
		wave_select_rdbtn_wave2 = new JRadioButton("Wave 3");
		wave_select_rdbtn_wave2.setBounds(160, 9, 75, 21);
		wave_select_rdbtn_wave2.setAction(action_wave_selected);
		buttonGroup_SelectWave.add(wave_select_rdbtn_wave2);
		wave_select_rdbtn_wave2.setForeground(Color.GREEN);
		panel_wave_select.add(wave_select_rdbtn_wave2);
		
		wave_select_rdbtn_wave3 = new JRadioButton("Wave 4");
		wave_select_rdbtn_wave3.setBounds(41, 33, 75, 21);
		wave_select_rdbtn_wave3.setAction(action_wave_selected);
		buttonGroup_SelectWave.add(wave_select_rdbtn_wave3);
		wave_select_rdbtn_wave3.setForeground(Color.YELLOW);
		panel_wave_select.add(wave_select_rdbtn_wave3);
		
		wave_select_rdbtn_wave4 = new JRadioButton("Wave 5");
		wave_select_rdbtn_wave4.setBounds(118, 33, 75, 21);
		wave_select_rdbtn_wave4.setAction(action_wave_selected);
		buttonGroup_SelectWave.add(wave_select_rdbtn_wave4);
		wave_select_rdbtn_wave4.setForeground(Color.ORANGE);
		panel_wave_select.add(wave_select_rdbtn_wave4);
		
		panel_wave_properties = new JPanel();
		panel_wave_properties.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_wave_properties.setBounds(0, 77, 567, 306);
		panel_wave_edit.add(panel_wave_properties);
		panel_wave_properties.setLayout(null);
		
		panel_freq_period = new JPanel();
		panel_freq_period.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_freq_period.setBounds(10, 11, 270, 140);
		panel_wave_properties.add(panel_freq_period);
		
		freq_period_lbl_name = new JLabel("Edit Freq / Period");
		freq_period_lbl_name.setBounds(0, 0, 108, 14);
		
		freq_period_text_input = new JTextField();
		freq_period_text_input.setText("1.0");
		freq_period_text_input.setBounds(122, 36, 108, 20);
		freq_period_text_input.setColumns(10);
		
		freq_period_lbl_value_other = new JLabel("Frequency: 1.0");
		freq_period_lbl_value_other.setBounds(10, 115, 170, 14);
		
		freq_period_rdbtn_freq = new JRadioButton("Edit Freq");
		buttonGroup_FreqPeriod.add(freq_period_rdbtn_freq);
		freq_period_rdbtn_freq.setBounds(10, 52, 98, 23);
		
		freq_period_rdbtn_period = new JRadioButton("Edit Period");
		freq_period_rdbtn_period.setSelected(true);
		buttonGroup_FreqPeriod.add(freq_period_rdbtn_period);
		freq_period_rdbtn_period.setBounds(10, 21, 102, 23);
		panel_freq_period.setLayout(null);
		panel_freq_period.add(freq_period_lbl_name);
		panel_freq_period.add(freq_period_text_input);
		panel_freq_period.add(freq_period_lbl_value_other);
		panel_freq_period.add(freq_period_rdbtn_freq);
		panel_freq_period.add(freq_period_rdbtn_period);
		
		freq_period_text_velocity = new JTextField();
		freq_period_text_velocity.setText("0.0");
		freq_period_text_velocity.setBounds(174, 112, 86, 20);
		panel_freq_period.add(freq_period_text_velocity);
		freq_period_text_velocity.setColumns(10);
		
		freq_period_lbl_velocity = new JLabel("Velocity");
		freq_period_lbl_velocity.setBounds(194, 95, 66, 14);
		panel_freq_period.add(freq_period_lbl_velocity);
		
		JPanel panel_shift = new JPanel();
		panel_shift.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_shift.setBounds(290, 11, 270, 140);
		panel_wave_properties.add(panel_shift);
		panel_shift.setLayout(null);
		
		shift_lbl_name = new JLabel("Edit Shift");
		shift_lbl_name.setBounds(0, 0, 145, 14);
		panel_shift.add(shift_lbl_name);
		
		shift_rdbtn_shiftvalue_none = new JRadioButton("No Shift");
		shift_rdbtn_shiftvalue_none.setSelected(true);
		buttonGroup_Shift.add(shift_rdbtn_shiftvalue_none);
		shift_rdbtn_shiftvalue_none.setBounds(10, 21, 109, 23);
		panel_shift.add(shift_rdbtn_shiftvalue_none);
		
		shift_rdbtn_shiftvalue_1 = new JRadioButton("Shift PI / 4");
		buttonGroup_Shift.add(shift_rdbtn_shiftvalue_1);
		shift_rdbtn_shiftvalue_1.setBounds(10, 47, 109, 23);
		panel_shift.add(shift_rdbtn_shiftvalue_1);
		
		shift_rdbtn_shiftvalue_2 = new JRadioButton("Shift PI / 2");
		buttonGroup_Shift.add(shift_rdbtn_shiftvalue_2);
		shift_rdbtn_shiftvalue_2.setBounds(10, 73, 109, 23);
		panel_shift.add(shift_rdbtn_shiftvalue_2);
		
		shift_rdbtn_shiftvalue_3 = new JRadioButton("Shift PI ");
		buttonGroup_Shift.add(shift_rdbtn_shiftvalue_3);
		shift_rdbtn_shiftvalue_3.setBounds(10, 99, 109, 23);
		panel_shift.add(shift_rdbtn_shiftvalue_3);
		
		JPanel panel_amp = new JPanel();
		panel_amp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_amp.setBounds(10, 155, 270, 140);
		panel_wave_properties.add(panel_amp);
		panel_amp.setLayout(null);
		
		amp_slider_editamp = new JSlider();
		amp_slider_editamp.setPaintLabels(true);
		amp_slider_editamp.setSnapToTicks(true);
		amp_slider_editamp.setPaintTicks(true);
		amp_slider_editamp.setValue(1);
		amp_slider_editamp.setMaximum(10);
		amp_slider_editamp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				amp_lbl_ampvalue.setText("Amplitude: " + amp_slider_editamp.getValue());
			}
		});
		amp_slider_editamp.setBounds(27, 25, 200, 50);
		panel_amp.add(amp_slider_editamp);
		
		amp_lbl_name = new JLabel("Edit Amp");
		amp_lbl_name.setBounds(0, 0, 138, 14);
		panel_amp.add(amp_lbl_name);
		
		amp_lbl_ampvalue = new JLabel("Amplitude: 1");
		amp_lbl_ampvalue.setBounds(27, 86, 111, 14);
		panel_amp.add(amp_lbl_ampvalue);
		
		JPanel panel_group = new JPanel();
		panel_group.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_group.setBounds(290, 155, 270, 140);
		panel_wave_properties.add(panel_group);
		panel_group.setLayout(null);
		
		group_lbl_name = new JLabel("Edit Group");
		group_lbl_name.setBounds(0, 0, 109, 14);
		panel_group.add(group_lbl_name);
		
		group_rdbtn_groupnone = new JRadioButton("No Group");
		group_rdbtn_groupnone.setSelected(true);
		buttonGroup_SelectGroup.add(group_rdbtn_groupnone);
		group_rdbtn_groupnone.setBounds(10, 21, 109, 23);
		panel_group.add(group_rdbtn_groupnone);
		
		group_rdbtn_groupa = new JRadioButton("Group a");
		buttonGroup_SelectGroup.add(group_rdbtn_groupa);
		group_rdbtn_groupa.setBounds(10, 47, 109, 23);
		panel_group.add(group_rdbtn_groupa);
		
		group_rdbtn_groupb = new JRadioButton("Group b");
		buttonGroup_SelectGroup.add(group_rdbtn_groupb);
		group_rdbtn_groupb.setBounds(10, 73, 109, 23);
		panel_group.add(group_rdbtn_groupb);
		
		group_rdbtn_groupc = new JRadioButton("Group c");
		group_rdbtn_groupc.setSelected(true);
		buttonGroup_SelectGroup.add(group_rdbtn_groupc);
		group_rdbtn_groupc.setBounds(10, 99, 109, 23);
		panel_group.add(group_rdbtn_groupc);
		
		panel_group_edit = new JPanel();
		tabbedPane.addTab("Edit Group", null, panel_group_edit, null);
		panel_group_edit.setLayout(null);
		
		panel_group_select = new JPanel();
		panel_group_select.setLayout(null);
		panel_group_select.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_group_select.setBounds(0, 0, 567, 74);
		panel_group_edit.add(panel_group_select);
		
		group_select_rdbtn_groupa = new JRadioButton("Group A");
		buttonGroup.add(group_select_rdbtn_groupa);
		group_select_rdbtn_groupa.setAction(action_group_selected);
		group_select_rdbtn_groupa.setSelected(true);
		group_select_rdbtn_groupa.setForeground(Color.CYAN);
		group_select_rdbtn_groupa.setBounds(6, 9, 75, 21);
		panel_group_select.add(group_select_rdbtn_groupa);
		
		group_select_rdbtn_groupb = new JRadioButton("Group B");
		buttonGroup.add(group_select_rdbtn_groupb);
		group_select_rdbtn_groupb.setAction(action_group_selected);
		group_select_rdbtn_groupb.setForeground(Color.PINK);
		group_select_rdbtn_groupb.setBounds(83, 9, 75, 21);
		panel_group_select.add(group_select_rdbtn_groupb);
		
		group_select_rdbtn_groupc = new JRadioButton("Group C");
		buttonGroup.add(group_select_rdbtn_groupc);
		group_select_rdbtn_groupc.setAction(action_group_selected);
		group_select_rdbtn_groupc.setForeground(Color.BLACK);
		group_select_rdbtn_groupc.setBounds(160, 9, 75, 21);
		panel_group_select.add(group_select_rdbtn_groupc);
		
		group_select_button_apply = new JButton("Apply");
		group_select_button_apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(group_select_rdbtn_groupa.isSelected()) editGroupInfo(0);
				else if(group_select_rdbtn_groupb.isSelected()) editGroupInfo(1);
				else editGroupInfo(2);
			}
		});
		group_select_button_apply.setBounds(427, 11, 110, 46);
		panel_group_select.add(group_select_button_apply);
		
		panel_group_properties = new JPanel();
		panel_group_properties.setLayout(null);
		panel_group_properties.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_group_properties.setBounds(0, 77, 567, 306);
		panel_group_edit.add(panel_group_properties);
		
		group_properties_chckbx_combined = new JCheckBox("Combined Waves?");
		group_properties_chckbx_combined.setBounds(6, 7, 174, 23);
		panel_group_properties.add(group_properties_chckbx_combined);
		
		group_properties_chckbx_showfinal = new JCheckBox("Only show resultant wave?");
		group_properties_chckbx_showfinal.setBounds(6, 33, 295, 23);
		panel_group_properties.add(group_properties_chckbx_showfinal);
		
		wave_select_rdbtn_wave0.setActionCommand("Wave1");
		wave_select_rdbtn_wave1.setActionCommand("Wave2");
		wave_select_rdbtn_wave2.setActionCommand("Wave3");
		wave_select_rdbtn_wave3.setActionCommand("Wave4");
		wave_select_rdbtn_wave4.setActionCommand("Wave5");
		
		group_select_rdbtn_groupa.setActionCommand("GroupA");
		group_select_rdbtn_groupb.setActionCommand("GroupB");
		group_select_rdbtn_groupc.setActionCommand("GroupC");
		
		wave_select_button_save = new JButton("Apply");
		wave_select_button_save.setBounds(447, 21, 110, 46);
		wave_select_button_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(wave_select_rdbtn_wave0.isSelected()) editWaveInfo(0);
				else if(wave_select_rdbtn_wave1.isSelected()) editWaveInfo(1);
				else if(wave_select_rdbtn_wave2.isSelected()) editWaveInfo(2);
				else if(wave_select_rdbtn_wave3.isSelected()) editWaveInfo(3);
				else editWaveInfo(4);
				
			}
		});
		panel_wave_select.add(wave_select_button_save);
		
		timer = new Timer(10, new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e) {
                  panel_wave_visual.step();
              }
          });
          timer.start();
	}
	
	public void loadWaveInfo(int index){
		//Freq Period
		buttonGroup_FreqPeriod.clearSelection();
		freq_period_rdbtn_period.setSelected(true);
		freq_period_text_input.setText(String.valueOf(panel_wave_visual.getWave(index).getPeriod().getValue()));
		freq_period_lbl_value_other.setText("Frequency: " + panel_wave_visual.getWave(index).getFrequency().getValue());
		freq_period_text_velocity.setText(String.valueOf(panel_wave_visual.getWave(index).getVelocity().getValue()));
		
		//Shift
		buttonGroup_Shift.clearSelection();
		if(panel_wave_visual.getWave(index).getPhaseshift().getValue() == 0) shift_rdbtn_shiftvalue_none.setSelected(true);
		else if(panel_wave_visual.getWave(index).getPhaseshift().getValue() == (Math.PI / 4)) shift_rdbtn_shiftvalue_1.setSelected(true);
		else if(panel_wave_visual.getWave(index).getPhaseshift().getValue() == (Math.PI / 2)) shift_rdbtn_shiftvalue_2.setSelected(true);
		else shift_rdbtn_shiftvalue_3.setSelected(true);
		
		//Amp
		amp_slider_editamp.setValue(panel_wave_visual.getWave(index).getAmplitude().getValue());
		amp_lbl_ampvalue.setText("Amplitude: " + amp_slider_editamp.getValue());
		
		//Group
		buttonGroup_SelectGroup.clearSelection();
		if(panel_wave_visual.getWave(index).getGroup().getValue() == 0) group_rdbtn_groupnone.setSelected(true);
		else if(panel_wave_visual.getWave(index).getGroup().getValue() == 1) group_rdbtn_groupa.setSelected(true);
		else if(panel_wave_visual.getWave(index).getGroup().getValue() == 2) group_rdbtn_groupb.setSelected(true);
		else group_rdbtn_groupc.setSelected(true);
	}
	
	public void loadGroupInfo(int index){
		if(index == 0){
			if(Group.isOnlyShowFinalA()) group_properties_chckbx_showfinal.setSelected(true);
			else group_properties_chckbx_showfinal.setSelected(false);
			
			if(Group.isCombinedWavesA()) group_properties_chckbx_combined.setSelected(true);
			else group_properties_chckbx_combined.setSelected(false);
		} else if(index == 1){
			if(Group.isOnlyShowFinalB()) group_properties_chckbx_showfinal.setSelected(true);
			else group_properties_chckbx_showfinal.setSelected(false);
			
			if(Group.isCombinedWavesB()) group_properties_chckbx_combined.setSelected(true);
			else group_properties_chckbx_combined.setSelected(false);
		} else {
			if(Group.isOnlyShowFinalC()) group_properties_chckbx_showfinal.setSelected(true);
			else group_properties_chckbx_showfinal.setSelected(false);
				
			if(Group.isCombinedWavesC()) group_properties_chckbx_combined.setSelected(true);
			else group_properties_chckbx_combined.setSelected(false);
		}
	}
	
	
	public void editWaveInfo(int index){
		//Freq Period
		float newValue = 0;
		if(freq_period_rdbtn_freq.isSelected()) newValue = panel_wave_visual.getWave(index).getFrequency().getValue();
		else newValue = panel_wave_visual.getWave(index).getPeriod().getValue();
		
		try {
			newValue = Float.valueOf(freq_period_text_input.getText());
		} catch (Exception e){
			
		}
		
		if(freq_period_rdbtn_freq.isSelected()){
			panel_wave_visual.getWave(index).setFrequency(new Frequency(newValue)); freq_period_lbl_value_other.setText("Period: " +  panel_wave_visual.getWave(index).getPeriod().getValue());
		}
		else {
			panel_wave_visual.getWave(index).setPeriod(new Period(newValue)); freq_period_lbl_value_other.setText("Frequency: " +  panel_wave_visual.getWave(index).getFrequency().getValue());
		}
		
		try {
			panel_wave_visual.getWave(index).setVelocity(new Velocity(Float.valueOf(freq_period_text_velocity.getText())));
		} catch (Exception e){
			
		}
		
		//Shift
		if(shift_rdbtn_shiftvalue_none.isSelected()) panel_wave_visual.getWave(index).setPhaseshift(new PhaseShift(0));
		else if(shift_rdbtn_shiftvalue_1.isSelected()) panel_wave_visual.getWave(index).setPhaseshift(new PhaseShift(Math.PI / 4));
		else if(shift_rdbtn_shiftvalue_2.isSelected()) panel_wave_visual.getWave(index).setPhaseshift(new PhaseShift(Math.PI / 2));
		else panel_wave_visual.getWave(index).setPhaseshift(new PhaseShift(Math.PI));
		
		//Amp
		panel_wave_visual.getWave(index).setAmplitude(new Amplitude(amp_slider_editamp.getValue()));
		
		//Group
		if(group_rdbtn_groupnone.isSelected()) panel_wave_visual.getWave(index).setGroup(new Group(0));
		else if(group_rdbtn_groupa.isSelected()) panel_wave_visual.getWave(index).setGroup(new Group(1));
		else if(group_rdbtn_groupb.isSelected()) panel_wave_visual.getWave(index).setGroup(new Group(2));
		else panel_wave_visual.getWave(index).setGroup(new Group(3));
	}
	
	public void editGroupInfo(int index){
		if(index == 0){
			
			if(group_properties_chckbx_showfinal.isSelected()) Group.setOnlyShowFinalA(true);
			else Group.setOnlyShowFinalA(false);
			
			if(group_properties_chckbx_combined.isSelected()) Group.setCombinedWavesA(true); 
			else Group.setCombinedWavesA(false); 
			
		} else if(index == 1){
			
			if(group_properties_chckbx_showfinal.isSelected()) Group.setOnlyShowFinalB(true);
			else Group.setOnlyShowFinalB(false);
			
			if(group_properties_chckbx_combined.isSelected()) Group.setCombinedWavesB(true); 
			else Group.setCombinedWavesB(false); 
			
		} else {
			
			if(group_properties_chckbx_showfinal.isSelected()) Group.setOnlyShowFinalC(true);
			else Group.setOnlyShowFinalC(false);
			
			if(group_properties_chckbx_combined.isSelected()) Group.setCombinedWavesC(true); 
			else Group.setCombinedWavesC(false); 
		}
	}
	
	private class SwingAction extends AbstractAction {
		
		public SwingAction() {
			putValue(NAME, "Wave");
			putValue(SHORT_DESCRIPTION, "Change wave");
		}
		
		public void actionPerformed(ActionEvent e) {
			if("Wave1".equals(e.getActionCommand())) loadWaveInfo(0);
			else if("Wave2".equals(e.getActionCommand())) loadWaveInfo(1);
			else if("Wave3".equals(e.getActionCommand())) loadWaveInfo(2);
			else if("Wave4".equals(e.getActionCommand())) loadWaveInfo(3);
			else if("Wave5".equals(e.getActionCommand())) loadWaveInfo(4);
		}
	}
	

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Group");
			putValue(SHORT_DESCRIPTION, "Select Group");
		}
		public void actionPerformed(ActionEvent e) {
			if("GroupA".equals(e.getActionCommand())) loadGroupInfo(0);
			else if("GroupB".equals(e.getActionCommand())) loadGroupInfo(1);
			else if("GroupC".equals(e.getActionCommand())) loadGroupInfo(2);
			
		}
	}

	
	
}
