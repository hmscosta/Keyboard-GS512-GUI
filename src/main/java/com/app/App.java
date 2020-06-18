package com.app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

import com.actions.ActionsColor;

public class App extends JPanel implements ChangeListener{
	
    protected JColorChooser tcc;
    protected JLabel banner;
    protected JLabel janelaTeste;

	public static void main(String[] args)  {
		 //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
	//Constructor		
	public App() {
		super(new BorderLayout());
        //Set up the banner at the top of the window
		janelaTeste = new JLabel("Testando",JLabel.CENTER);
        banner = new JLabel("Change color!",JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(100, 65));
        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(banner, BorderLayout.CENTER);
        bannerPanel.add(janelaTeste, BorderLayout.NORTH);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));
        //Set up color chooser for setting text color
        tcc = new JColorChooser(banner.getForeground());
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
        add(bannerPanel, BorderLayout.CENTER);
        add(tcc, BorderLayout.PAGE_END);
	  }
	
	public void colorAppCustom() {
		System.out.println("Inicializing window...");

	}
	

	@Override
	public void stateChanged(ChangeEvent arg0) {
		Integer red,green,blue;
		String color;
		ActionsColor objColor = new ActionsColor();
		Color newColor = tcc.getColor();
        banner.setForeground(newColor);
       // System.out.println("COR: " + newColor);
        red = newColor.getRed();
	    green = newColor.getGreen();
	    blue = newColor.getBlue();
	    String hRed = Integer.toHexString(red);
	    String hGreen = Integer.toHexString(green);
	    String hBlue = Integer.toHexString(blue);
	    //System.out.println("Red: " + hRed);
	    //System.out.println("Green: " + hGreen);
	    //System.out.println("Blue: " + hBlue);
	    if(hRed.length() == 1)
	    	hRed = "0" + hRed;
	    if(hGreen.length() == 1)
	    	hGreen = "0" + hGreen;
	    if(hBlue.length() == 1)
	    	hBlue = "0" + hBlue;
	    color = hRed + hGreen + hBlue;
	    //System.out.println("Concatenado: " + color);
     	objColor.changeColor(color);
		
	}

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ColorChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new App();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	
	
	
	
	
}
