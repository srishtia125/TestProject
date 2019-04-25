import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.digital.and.entity.PhoneDetail;
import com.digital.and.exception.CustomerNotFoundException;
import com.digital.and.exception.PhoneAlreadyActivatedException;
import com.digital.and.service.CustomerService;

@RunWith(SpringRunner.class)
public class BusinessServicesMockTest {


	Map<Integer, Set<PhoneDetail>> customerData;	
	CustomerService customerService;
	

	@Before
	public void setup() {
		customerData = new HashMap<>();
		
		customerData.put(1 , new HashSet<>(Arrays.asList(
                new PhoneDetail(12344321 , false))));
		customerData.put(2, new HashSet<>(Arrays.asList(new PhoneDetail(42422432, true),new PhoneDetail(5566677, false))));
		
		customerService = new CustomerService(customerData);
	}
	
	@Test
	public void testGetAllPhoneNumbers() {
		assertEquals(3,customerService.getAllPhoneNumbers().size());
	}

	
	@Test
	public void testGetAllPhoneNumbersForCustomer() {
		Set<PhoneDetail> phoneNumber = new HashSet<>();
		phoneNumber.add(new PhoneDetail(12344321,true));
		assertEquals(phoneNumber,customerService.getCustomerPhoeNumbers(1));
		assertEquals(1,customerService.getCustomerPhoeNumbers(1).size());
	}

	@Test
	public void testActivateNumber() {
		assertEquals("SUCCESS",customerService.activateCustomerPhone(1, 12344321));
	}
	
	@Test(expected = CustomerNotFoundException.class)
	public void testActivateNumberForWrongCustomer() {
		customerService.activateCustomerPhone(10, 12344321);
	}
	
	@Test(expected = CustomerNotFoundException.class)
	public void testGetInvalidCustomerOhoneNumber() {
		customerService.getCustomerPhoeNumbers(78);
	}
	
	@Test(expected = PhoneAlreadyActivatedException.class)
	public void testActivateAlreadyActiveCustomerhoneNumber() {
		customerService.activateCustomerPhone(2, 42422432);
	}
	
}