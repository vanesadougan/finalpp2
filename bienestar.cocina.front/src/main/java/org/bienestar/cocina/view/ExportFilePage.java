package org.bienestar.cocina.view;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.bienestar.cocina.view.base.View;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Window.Type;

public class ExportFilePage extends View {

	private static final long serialVersionUID = 1L;

	private JDateChooser fechaDesde;
	private JButton btnExportar;
	private JDateChooser fechaHasta;

	public ExportFilePage() {
		setResizable(false);
		setTitle("Exportar");
		setBounds(100, 100, 405, 170);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		fechaDesde = new JDateChooser();
		fechaDesde.setBounds(85, 11, 120, 20);
		((JTextFieldDateEditor) fechaDesde.getDateEditor()).setEditable(false);
		fechaDesde.setDate(new Date());
		getContentPane().add(fechaDesde, null);

		fechaHasta = new JDateChooser();
		fechaHasta.setBounds(255, 11, 120, 20);
		((JTextFieldDateEditor) fechaHasta.getDateEditor()).setEditable(false);
		fechaHasta.setDate(new Date());
		getContentPane().add(fechaHasta);

		JLabel lblFechaDesde = new JLabel("Fecha desde");
		lblFechaDesde.setBounds(10, 11, 65, 20);
		getContentPane().add(lblFechaDesde);

		JLabel lblHasta = new JLabel("hasta");
		lblHasta.setBounds(215, 11, 30, 20);
		getContentPane().add(lblHasta);

		btnExportar = new JButton("Exportar");
		btnExportar.setBounds(286, 77, 89, 23);
		getContentPane().add(btnExportar);

	}

	public void addBtnExportarActionListener(ActionListener action) {
		btnExportar.addActionListener(action);
	}

	public Date getDateFrom() {
		return fechaDesde.getDate();
	}
	
	public Date getDateTo() {
		return fechaHasta.getDate();
	}
	
	public void update(Observable o, Object arg) {

	}
}
