package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Menu.Animal;

/**
 * Nama File : AnimalTest.java
 * 
 * @author J-CAT
 * 	Candy Olivia Mawalim (13513031)
 * 	Tifani Warnita (13513055)
 * 	Jessica Handayani (13513069)
 *	Asanilta Fahda (13513079)
 */
public class AnimalTest {
	Animal animal;
	
	@Before
	public void init(){
		animal = new Animal();
	}
	
	@Test
	public void testSetAnimal() {
		animal.setAnimal("Bobby", "Cat");
		Assert.assertEquals(animal.getName(), "Bobby");
		Assert.assertEquals(animal.getType(), "Cat");
	}

	@Test
	public void testLoadAnimal() {
		animal.loadAnimal("Bobby", "Cat", 40, 50, 60, 70, 1);
		Assert.assertEquals(animal.getName(), "Bobby");
		Assert.assertEquals(animal.getType(), "Cat");
		Assert.assertEquals(animal.getHunger(), 40);
		Assert.assertEquals(animal.getHappiness(), 50);
		Assert.assertEquals(animal.getHygiene(), 70);
		Assert.assertEquals(animal.getHealth(), 60);
		Assert.assertEquals(animal.getState(), 1);
	}
	
	@Test
	public void testGetName() {
		Assert.assertEquals(animal.getName(), null);
	}
	
	@Test
	public void testSetName(){
		animal.setName("Bobby");
		Assert.assertEquals(animal.getName(),"Bobby");
	}
	
	@Test
	public void testGetHunger() {
		Assert.assertEquals(animal.getHunger(),100);
	}
	
	@Test
	public void testGetHappiness() {
		Assert.assertEquals(animal.getHappiness(),100);
	}
	
	@Test
	public void testGetHealth() {
		Assert.assertEquals(animal.getHealth(),100);
	}
	
	@Test
	public void testGetHygiene() {
		Assert.assertEquals(animal.getHygiene(),100);
	}
	
	@Test
	public void testGetState() {
		Assert.assertEquals(animal.getState(),0);
	}
	
	@Test
	public void testSetHunger(){
		animal.setHunger(50);
		Assert.assertEquals(animal.getHunger(), 50);
	}
	
	@Test
	public void testSetHappiness(){
		animal.setHappiness(50);
		Assert.assertEquals(animal.getHappiness(), 50);
	}
	
	@Test
	public void testSetHealth(){
		animal.setHealth(50);
		Assert.assertEquals(animal.getHealth(), 50);
	}
	
	@Test
	public void testSetHygiene(){
		animal.setHygiene(50);
		Assert.assertEquals(animal.getHygiene(), 50);
	}
	
	@Test
	public void testSetState(){
		animal.setState(1);
		Assert.assertEquals(animal.getState(), 1);
	}
	
	@Test
	public void testGetType() {
		Assert.assertEquals(animal.getType(),null);
	} 
	
	@Test
	public void testSetType() {
		animal.setType("Cat");
		Assert.assertEquals(animal.getType(),"Cat");
	}
	
	
}
