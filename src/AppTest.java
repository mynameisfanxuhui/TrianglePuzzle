import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import example.boundary.PuzzleApp;

public class AppTest extends TestModel{
	protected PuzzleApp window;

	@Before
	public void createApp() {
		window = new PuzzleApp(m);
		window.frame.setVisible(true);
	}
	
	
	@Test
	public void test() {
		this.window.showWinBoard();
		this.window.showAlreadyWinBoard();
	}
	

}
