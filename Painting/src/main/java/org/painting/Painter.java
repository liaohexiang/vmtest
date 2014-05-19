package org.painting;

public class Painter {

	public static final Painter INSTANCE  = new Painter();
	
	private void prePaint(){
		System.out.println("===============Pre-Paint===============");
	}
	private void postPaint(){
		System.out.println("===============Post-Paint==============");
	}
	public void paint(Shape shape){
		this.prePaint();
		shape.doPaint();
		this.postPaint();
	}
}
