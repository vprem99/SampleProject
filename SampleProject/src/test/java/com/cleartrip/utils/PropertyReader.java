package com.cleartrip.utils;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyReader {
	/*Singletone Design Pattern: It make sures in a project there should 
	not be multiple Objects of same Class
	In a Project there should be only one Object*/
	
	private static Properties propInstance;
	
	public static Properties getInstance() {
		
		if (propInstance == null) {
			propInstance = new Properties();
			try {
				propInstance.load(new FileInputStream(".\\src\\test\\resources\\files\\settingsOR.property"));
			} catch (Exception e) {
				System.out.println("Error with reading property File " + e.getMessage());
			}
			return propInstance;
		} else {
			return propInstance;
		}
	}
}
