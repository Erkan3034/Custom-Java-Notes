package firstApp;

import java.awt.Button;

import javax.swing.*;

/*
 * AWT: Abstract Window Toolkit
 * MVC: Model View Controller
 * */
public class Main {

	public static void main(String[] args) {

		JFrame f = new JFrame();// creating instance of JFrame  

		JButton b = new JButton("click me bro!");// creating instance of JButton  
		b.setBounds(150, 150, 150, 40);// x axis, y axis, width, height  
		f.add(b);// adding button in JFrame  
		f.setResizable(false);
		Button btn = new Button("TAMAM");//AWT button
		btn.setBounds(100, 100, 80, 80);
		f.add(btn);

		f.setSize(400, 500);// 400 width and 500 height  
		f.setLayout(null);// using no layout managers  
		f.setVisible(true);// making the frame visible  

		// Example - 2
		// Creating instance of JFrame
		JFrame frame = new JFrame();

		// Creating instance of JButton
		JButton button = new JButton("WebSite Click");

		// x axis, y axis, width, height
		button.setBounds(150, 200, 220, 50);

		// adding button in JFrame
		frame.add(button);
		//f.add(button);

		// 400 width and 500 height
		frame.setSize(500, 600);
		//f.setSize(500, 600);
		// using no layout managers
		frame.setLayout(null);

		// making the frame visible
		frame.setVisible(true);

	}
}
