package com.starkhorn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.starkhorn.AwdStatusFactory.AwdStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context.xml")
public class AwdStatusFactoryTest {
	
	@Autowired
	private AwdStatusFactory factory;
	
	@Test
	public void testCreateStatus() {
		AwdStatus statusForPurch = factory.createStatusForWorkTypeAndCode("PURCHASE", "CREATED");
		
		assertEquals("CREATED", statusForPurch.getCode());
		assertEquals("Saved in Progress", statusForPurch.getName());
		
		AwdStatus statusForRedeem = factory.createStatusForWorkTypeAndCode("REDEEM", "CREATED");
		
		assertEquals("CREATED", statusForRedeem.getCode());
		assertEquals("Redemption in Progress", statusForRedeem.getName());
	}
}
