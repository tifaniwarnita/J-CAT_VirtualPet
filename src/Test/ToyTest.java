package Test;

import Menu.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToyTest {
	Toy toy;
	
	@Before
	public void init() {
		toy = new Toy();
	}
	
	@Test
	public void testChangeLevel() {
		toy.changeLevel(2);
		Assert.assertEquals(toy.getLevel(),2);
	}

}
