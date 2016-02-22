package app;

import javax.swing.*;
import java.awt.*;

public class Main
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JLabel("Hello, world!"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
		frame.setVisible(true);
	}
}