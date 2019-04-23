package pobj.pinboard.document;

import javafx.scene.paint.Color;

public abstract class AbstractClip {
	
	private double left;
	private double top;
	private double right;
	private double bottom;
	private Color color;
	
	
	
	public AbstractClip(double left, double top, double right, double bottom, Color color) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.color = color;
	}

	// Geometry	
	public double getLeft() {
		return left;
	}

	public double getTop() {
		return top;
	}

	public double getRight() {
		return right;
	}

	public double getBottom() {
		return bottom;
	}
	

	public void setGeometry(double left, double top, double right, double bottom) {
		this.left=left;
		this.top=top;
		this.right=right;
		this.bottom=bottom;
		

	}


	public void move(double x, double y) {
		// TODO Auto-generated method stub
		left=left+x;
		right=right+x;
		top=top+y;
		bottom=bottom+y;
	}


	public boolean isSelected(double x, double y) {
		return (x>left && x<right && y>top && y<bottom);
	}


	public void setColor(Color c) {
		this.color=c;
	}


	public Color getColor() {
		return color;
	}
}
