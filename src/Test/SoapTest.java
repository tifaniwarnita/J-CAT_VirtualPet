package Test;

import Menu.Soap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class SoapTest {
	Soap soap;
	
	@Before
	public void init() {
		soap = new Soap();
	}
	
	@Test
	public void test() {
		soap.changeLevel(2);
		Assert.assertEquals(soap.getLevel(),2);
	}

}
