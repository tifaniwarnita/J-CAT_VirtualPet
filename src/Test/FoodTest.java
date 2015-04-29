package Test;

import Menu.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FoodTest {
	Food food;
	
	@Before
	public void init() {
		food = new Food();
	}
	
	@Test
	public void testChangeLevel() {
		food.changeLevel(2);
		Assert.assertEquals(food.getLevel(),2);
	}

	@Test
	public void testUpdateQuantity() {
		food.updateQuantity(2);
		Assert.assertEquals(food.getQuantity(),2);
	}
	
	@Test
	public void testGetCurrentPrice() {
		Assert.assertEquals(food.getCurrentPrice(), 5);
	}
	
	@Test
	public void tesSetCurrentPrice() {
		food.setCurrentPrice(20);
		Assert.assertEquals(food.getCurrentPrice(), 20);
	}
	
	@Test
	public void tesGetQuantity(){
		Assert.assertEquals(food.getQuantity(), 0);
	}
	
	@Test
	public void tesSetQuantity() {
		food.setQuantity(10);
		Assert.assertEquals(food.getQuantity(), 10);
	}
}
