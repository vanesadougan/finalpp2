package org.bienestar.cocina.view;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentListener;

import org.bienestar.cocina.exceptions.AbstractException;
import org.bienestar.cocina.view.base.View;
import org.bienestar.cocina.view.base.components.ImagePanel;

import com.mxrck.autocompleter.TextAutoCompleter;

public class ConsumptionRegisterPage extends View {

	private static final long serialVersionUID = 1L;
	private JTextField txtFecha;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JTextField txtIngrediente;
	private TextAutoCompleter txtIngredienteAutoCompleter;
	private JPanel panel_1;
	private JTextField txtComensales;
	private JTextField txtTipoDePreparacion;

	public ConsumptionRegisterPage() {
		setResizable(false);
		setTitle("Registro de Consumo");
		setBounds(100, 100, 852, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(526, 469, 140, 41);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(692, 469, 140, 41);
		getContentPane().add(btnCancelar);

		ImagePanel panel = new ImagePanel("res/food_banner.jpg");
		panel.setBounds(0, 0, 846, 150);
		getContentPane().add(panel);

		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(14, 162, 818, 280);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(16, 17, 115, 33);
		panel_1.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBounds(152, 14, 236, 39);
		panel_1.add(txtFecha);
		txtFecha.setColumns(10);
		lblFecha.setLabelFor(txtFecha);

		JLabel lblIngrediente = new JLabel("Ingrediente");
		lblIngrediente.setBounds(16, 216, 115, 33);
		panel_1.add(lblIngrediente);

		txtIngrediente = new JTextField();
		txtIngrediente.setBounds(152, 213, 236, 39);
		panel_1.add(txtIngrediente);
		txtIngrediente.setColumns(10);

		txtIngredienteAutoCompleter = new TextAutoCompleter(txtIngrediente);
		
		JLabel lblComensales = new JLabel("Comensales");
		lblComensales.setBounds(414, 17, 115, 33);
		panel_1.add(lblComensales);
		
		txtComensales = new JTextField();
		txtComensales.setColumns(10);
		txtComensales.setBounds(556, 14, 236, 39);
		panel_1.add(txtComensales);
		
		JLabel txtTipoPrep = new JLabel("Tipo de preparacion");
		txtTipoPrep.setBounds(10, 76, 115, 33);
		panel_1.add(txtTipoPrep);
		
		txtTipoDePreparacion = new JTextField();
		txtTipoDePreparacion.setColumns(10);
		txtTipoDePreparacion.setBounds(152, 73, 236, 39);
		panel_1.add(txtTipoDePreparacion);
	}

	public String getDate() {
		return txtFecha.getText();
	}

	public void addBtnSaveActionListener(ActionListener action) {
		btnGuardar.addActionListener(action);
	}

	public void addBtnCancelActionListener(ActionListener action) {
		btnCancelar.addActionListener(action);
	}

	public void addTxtIngredienteUpdateListener(DocumentListener documentListener) {
		txtIngrediente.getDocument().addDocumentListener(documentListener);
	}

	public String getTxtIngrediente() {
		return txtIngrediente.getText();
	}

	public void setSuggestionsList(List<String> suggestions) {
		txtIngredienteAutoCompleter.setItems(suggestions.toArray());
	}
	
	public void update(Observable arg0, Object arg1) {
		JOptionPane.showMessageDialog(this, ((AbstractException) arg1).getMessage(), "Error", JOptionPane.OK_OPTION);
	}

	public String getTxtFecha() {
		return txtFecha.getText();
	}
}
