package com.chung.oct128.planet;

import com.chung.oct128.human.Human;

public class Planet {
	private String name;
	private double size;
	private boolean visible;

	public void Planet() {
		// TODO Auto-generated constructor stub
	}

	public Planet(String name, double size, boolean visible) {
		super();
		this.name = name;
		this.size = size;
		this.visible = visible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void add(Human h) {
		System.out.printf("%s에 %s 이/가 입주!!\r\n", name, h.getName());
	}

}
