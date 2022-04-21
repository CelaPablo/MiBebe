package view;
import java.awt.Color;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

import enums.AccionRecomendada;
import enums.Causas;
import enums.NivelAmbiente;
import enums.NivelBaba;
import model.Ambiente;
import model.Bebe;
import utils.KnowledgeSessionHelper;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;

import java.awt.Button;

public class BabyInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static String[] alimento = {"0", "20", "40", "60", "80", "100", "120", "140", "160", "180", "200", "220", "240"};
	private static String[] tiempo = {"0", "20", "30", "40", "60", "80", "90", "100", "120", "140", "150", "160", "180"};
	private static String[] baba = {"--", "Bajo", "Medio", "Alto"};
	private static String[] tacto = {"Normal", "Frio", "Caliente"};
	private static String[] tempAmbiente = {"Frio", "Normal", "Caliente"};
	private JLabel result, result_1;
	
	String K_SESSION_NAME = "kbackward-mibebe-session";
	
	KieSession sessionStatefull;
	static KieContainer kieContainer;

	public BabyInterface(Bebe bebe, Ambiente ambiente) {
		super("~ Recomendacion al llanto del bebe ~");
		kieContainer = KnowledgeSessionHelper.createRuleBase();
		
		setBounds(0, 0, 450, 800);
		setBackground(new Color(46, 139, 87));
		
		getContentPane().setBackground(new Color(100, 149, 237));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 450, 40);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("¿Por qué llora mi bebe?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(0, 52, 450, 40);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Información sobre mi bebe");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Presenta zonas coloradas");
		chckbxNewCheckBox.setBounds(33, 144, 191, 23);
		getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bebe.setZonaColorada(chckbxNewCheckBox.isSelected());
			}
		});
		
		JComboBox comboBox = new JComboBox(alimento);
		comboBox.setFont(UIManager.getFont("ColorChooser.font"));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(140, 119, 141, 27);
		getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int value =Integer.parseInt((String) comboBox.getSelectedItem());
				bebe.setAlimentoIngerido(value);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de alimento ingerido en las ultimas 3 horas (en ml)");
		lblNewLabel_2.setBounds(27, 92, 388, 23);
		getContentPane().add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Presenta marcas rojas");
		chckbxNewCheckBox_1.setBounds(33, 169, 229, 23);
		getContentPane().add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bebe.setMarcaRoja(chckbxNewCheckBox_1.isSelected());
			}
		});
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Esta desvelado");
		chckbxNewCheckBox_2.setBounds(33, 193, 128, 23);
		getContentPane().add(chckbxNewCheckBox_2);
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bebe.setDesvelado(chckbxNewCheckBox_2.isSelected());
			}
		});
		
		JComboBox comboBox_1 = new JComboBox(baba);
		comboBox_1.setFont(UIManager.getFont("ColorChooser.font"));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(236, 217, 179, 27);
		getContentPane().add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = comboBox_1.getSelectedIndex();
				bebe.setNivelBaba(NivelBaba.values()[index]);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad de baba producida");
		lblNewLabel_3.setBounds(33, 221, 191, 16);
		getContentPane().add(lblNewLabel_3);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Presenta un movimiento intenso de las piernas");
		chckbxNewCheckBox_3.setBounds(33, 249, 364, 23);
		getContentPane().add(chckbxNewCheckBox_3);
		chckbxNewCheckBox_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bebe.setMovimientoIntensoPiernas(chckbxNewCheckBox_3.isSelected());
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Tiempo desde la ultima siesta (en minutos)");
		lblNewLabel_4.setBounds(33, 284, 282, 16);
		getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox_2 = new JComboBox(tiempo);
		comboBox_2.setFont(UIManager.getFont("ColorChooser.font"));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(307, 280, 102, 27);
		getContentPane().add(comboBox_2);
		comboBox_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int value = Integer.parseInt((String) comboBox_2.getSelectedItem());
				bebe.setUltimaSiesta(value);
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Estado del cuerpo al tacto");
		lblNewLabel_5.setBounds(33, 314, 191, 16);
		getContentPane().add(lblNewLabel_5);
		
		JComboBox comboBox_3 = new JComboBox(tacto);
		comboBox_3.setFont(UIManager.getFont("ColorChooser.font"));
		comboBox_3.setSelectedIndex(0);
		comboBox_3.setBounds(230, 310, 179, 27);
		getContentPane().add(comboBox_3);
		comboBox_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int value = comboBox_3.getSelectedIndex();
				if(value == 2) {
					bebe.setEstaCaliente(true);
				} else {
					bebe.setEstaCaliente(false);
				}
			}
		});
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Mala reacción al tacto");
		chckbxNewCheckBox_4.setBounds(34, 335, 244, 23);
		getContentPane().add(chckbxNewCheckBox_4);
		chckbxNewCheckBox_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bebe.setMalaReaccionTacto(chckbxNewCheckBox_4.isSelected());
			}
		});
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Presenta erupciones");
		chckbxNewCheckBox_5.setBounds(33, 359, 204, 23);
		getContentPane().add(chckbxNewCheckBox_5);
		chckbxNewCheckBox_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bebe.setConErupciones(chckbxNewCheckBox_5.isSelected());
			}
		});
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Presenta inflamación");
		chckbxNewCheckBox_6.setBounds(33, 383, 210, 23);
		getContentPane().add(chckbxNewCheckBox_6);
		chckbxNewCheckBox_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bebe.setConInflamacion(chckbxNewCheckBox_6.isSelected());
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Temperatura corporal - Medida con termometro");
		lblNewLabel_6.setBounds(57, 409, 311, 16);
		getContentPane().add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 467, 450, 35);
		getContentPane().add(panel_2);
		
		JLabel lblNewLabel_7 = new JLabel("Información sobre el pañal");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_7);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Presenta Humuedad");
		chckbxNewCheckBox_7.setBounds(34, 507, 210, 23);
		getContentPane().add(chckbxNewCheckBox_7);
		chckbxNewCheckBox_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bebe.setPañalHumedad(chckbxNewCheckBox_7.isSelected());
			}
		});
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("Presenta Heces");
		chckbxNewCheckBox_8.setBounds(34, 535, 128, 23);
		getContentPane().add(chckbxNewCheckBox_8);
		chckbxNewCheckBox_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bebe.setPañalHeces(chckbxNewCheckBox_8.isSelected());
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 570, 450, 35);
		getContentPane().add(panel_3);
		
		JLabel lblNewLabel_8 = new JLabel("Información sobre el ambiente");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Temperatura del ambiente");
		lblNewLabel_9.setBounds(40, 614, 209, 16);
		getContentPane().add(lblNewLabel_9);
		
		Button button = new Button("Recomendación");
		button.setBackground(new Color(100, 149, 237));
		button.setFont(new Font("Avenir Next", Font.BOLD, 12));
		button.setBounds(143, 655, 161, 29);
		getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getRecomendacion(bebe, ambiente);
			}
		});
		
		result = new JLabel("");
		result.setForeground(new Color(0, 0, 0));
		result.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		result.setBounds(57, 690, 340, 40);
		getContentPane().add(result);
		
		JComboBox comboBox_4 = new JComboBox(tempAmbiente);
		comboBox_4.setFont(UIManager.getFont("ColorChooser.font"));
		comboBox_4.setSelectedIndex(1);
		comboBox_4.setBounds(221, 610, 177, 27);
		getContentPane().add(comboBox_4);
		comboBox_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = comboBox_4.getSelectedIndex();
				ambiente.setNivel(NivelAmbiente.values()[index]);
			}
		});
		
		
	    NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(42);
	    
	    JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
		formattedTextField.setBounds(140, 429, 141, 26);
		getContentPane().add(formattedTextField);
		
		result_1 = new JLabel("");
		result_1.setForeground(new Color(0, 0, 0));
		result_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		result_1.setBounds(57, 726, 340, 40);
		getContentPane().add(result_1);
		
		formattedTextField.addFocusListener(new FocusAdapter() {
			 public void focusLost(FocusEvent e) {
				 	float value = Float.parseFloat(formattedTextField.getText());
			        bebe.setTempCorporal(value);
			    }
		});
		
	}
	
	private void getRecomendacion(Bebe bebe, Ambiente ambiente) {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, K_SESSION_NAME);
        
		Agenda agenda = sessionStatefull.getAgenda();

		agenda.getAgendaGroup("Recomendacion al llanto del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de afecciones").setFocus();
		agenda.getAgendaGroup("Diagnostico de colicos").setFocus();
		agenda.getAgendaGroup("Diagnostico de dientes creciendo").setFocus();
		agenda.getAgendaGroup("Diagnostico de frio del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de calor del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de suenio del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de suenio del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de gases").setFocus();
		agenda.getAgendaGroup("Diagnostico de suciedad en el panial").setFocus();
		agenda.getAgendaGroup("Diagnostico nivel de aburrimiento del bebe").setFocus();
		agenda.getAgendaGroup("Diagnostico de lesiones en el cuerpo").setFocus();
		agenda.getAgendaGroup("Diagnostico de Hambre").setFocus();
		
		sessionStatefull.insert(bebe);
		sessionStatefull.insert(ambiente);
		
		sessionStatefull.fireAllRules();
		
		String rec = bebe.getRecomendacion().accion.toString();
		String accion = "Causa: " + causa(rec); 
		String recomendacion = "Recomendacion: " + splitCamelCase(rec); 
		result.setText(accion);
		result_1.setText(recomendacion);
		System.out.println(bebe.toString());
	}
	
	private String splitCamelCase(String s) {
	   return s.replaceAll(
	      String.format("%s|%s|%s",
	         "(?<=[A-Z])(?=[A-Z][a-z])",
	         "(?<=[^A-Z])(?=[A-Z])",
	         "(?<=[A-Za-z])(?=[^A-Za-z])"
	      ),
	      " "
	   );
	}
	
	private String causa(String rec) {
		int index = AccionRecomendada.valueOf(rec).ordinal();
		return splitCamelCase(Causas.values()[index].toString());
	}
}
