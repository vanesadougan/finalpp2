package org.bienestar.cocina.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import exporter.Container;
import exporter.types.IExportable;
import org.bienestar.cocina.Exporter;
import org.bienestar.cocina.view.base.View;
import javax.swing.JMenuItem;

//nuevo

import java.io.File;
import java.net.URL;

public class MainPage extends View implements Observer {


	private static final long serialVersionUID = 1L;
	private JMenu mnConsumos;
	private JMenu mnExportacion;
	private JMenuItem mntmRegistro;
	private JMenuItem mntmExportarACsv;
	private JMenuItem mntmExportarAXLS;
	
	public MainPage(Container container) {
		setMinimumSize(new Dimension(700, 500));
		setTitle("Registro de Consumos");
		setBounds(100, 100, 785, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		getContentPane().setBounds(0, 0, getWidth(), getHeight());

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, getWidth(), 21);
		getContentPane().add(menuBar);

		mnConsumos = new JMenu("Consumos");
		menuBar.add(mnConsumos);

		mntmRegistro = new JMenuItem("Registro");
		mnConsumos.add(mntmRegistro);

		mnExportacion = new JMenu("Exportacion");
		menuBar.add(mnExportacion);

		mntmExportarACsv = new JMenuItem("Exportar a CSV");
		mnExportacion.add(mntmExportarACsv);

		mntmExportarAXLS = new JMenuItem("Exportar a XLS");
		mnExportacion.add(mntmExportarAXLS);



		IExportable exportableCSV = container.get("CSVExportable",IExportable.class);

if(exportableCSV==null)
{
	mntmExportarACsv.setEnabled(false);

}
else
{
	mntmExportarACsv.setEnabled(true);
}

IExportable exportableXLS=container.get("XLSExportable", IExportable.class);

if(exportableXLS==null)
{
	mntmExportarAXLS.setEnabled(false);
}
else
{
	mntmExportarAXLS.setEnabled(true);
}


	}





	public void addMnRegistroListener(ActionListener action) {
		mntmRegistro.addActionListener(action);
	}


	public void addMnExportacionListenerCSV(ActionListener action) {
		mntmExportarACsv.addActionListener(action);
	}

	public void addMnExportacionListenerXLS(ActionListener action) {
		mntmExportarAXLS.addActionListener(action);
	}
//original
	
	public void update(Observable arg0, Object arg1) {
		
	}
}
