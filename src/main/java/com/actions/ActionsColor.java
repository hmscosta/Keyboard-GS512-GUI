package com.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActionsColor {

	
	public void changeColor(String color) {
	
	ProcessBuilder processBuilder = new ProcessBuilder();
	// -- Linux --
	// Run a shell command
	processBuilder.command("bash", "-c", "g810-led -a "+ color);
	try {
		Process process = processBuilder.start();
		StringBuilder output = new StringBuilder();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
		}
		int exitVal = process.waitFor();
		if (exitVal == 0) {
		////	System.out.println("Success!");
			///System.out.println(output);
			///System.exit(0);
		} else {
			//abnormal...
		}

	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	
}
