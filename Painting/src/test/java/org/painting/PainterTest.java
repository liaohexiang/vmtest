package org.painting;


import org.junit.Test;

public class PainterTest {

	@Test
	public void testPaintingCycle() {
		Cycle cycle = new Cycle();
		Painter.INSTANCE.paint(cycle);
	}
	@Test
	public void testPaintingRectangle(){
		Rectangle rec = new Rectangle();
		Painter.INSTANCE.paint(rec);
		
	}

}
