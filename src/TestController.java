import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import example.controller.ClickNodeController;
import example.controller.ResetController;
import example.controller.SwapController;
import example.controller.UnselectAllController;

public class TestController extends AppTest{

	@Test
	public void test() {
		ClickNodeController clickTest = new ClickNodeController(this.m, this.window);
		SwapController swapTest = new SwapController(this.m, this.window);
		UnselectAllController unselectAllTest = new UnselectAllController(this.m, this.window);
		ResetController resetTest = new ResetController(this.m, this.window);
		Point p = new Point(162, 36);
		Point p1 = new Point(129, 117);
		Point p2 = new Point(190, 122);
		
		clickTest.process(p);
		// unclick
		clickTest.process(p);
		clickTest.process(p);
		clickTest.process(p1);
		clickTest.process(p2);
		swapTest.swapEdge();
		unselectAllTest.unselectAll();
		resetTest.reset();
		
		m.isWinning = true;
		
		clickTest.process(p);
		// unclick
		clickTest.process(p);
		swapTest.swapEdge();
		unselectAllTest.unselectAll();
		resetTest.reset();	
	}

}
