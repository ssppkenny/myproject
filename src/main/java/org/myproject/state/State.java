package org.myproject.state;

public class State {
	
	public State(double rx, double ry, double rz, double rt, String operation)
	{
		this.rx = rx;
		this.ry = ry;
		this.rz = rz;
		this.rt = rt;
		this.setOperation(operation);
	}
	
	private double rx;
	private double ry;
	private double rz;
	private double rt;
	private String operation;
	public double getRx() {
		return rx;
	}
	public void setRx(double rx) {
		this.rx = rx;
	}
	public double getRy() {
		return ry;
	}
	public void setRy(double ry) {
		this.ry = ry;
	}
	public double getRz() {
		return rz;
	}
	public void setRz(double rz) {
		this.rz = rz;
	}
	public double getRt() {
		return rt;
	}
	public void setRt(double rt) {
		this.rt = rt;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	

}
