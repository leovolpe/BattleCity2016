package Graficas_paneles;

import java.awt.Color;

import javax.swing.JPanel;

public class grafico_informacion {
	
	private JPanel panel_info;
	
	public grafico_informacion()
	{
		panel_info = new JPanel();
		panel_info.setLayout(null);
		panel_info.setBounds(780, 0, 300, 600);
		panel_info.setBackground(Color.green);
	}

	public JPanel getPanel_info() {
		return panel_info;
	}

}
