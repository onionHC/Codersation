package test.com.github.springaki.codersation;

import org.junit.Test;

import com.github.springaki.codersation.Money;
import com.github.springaki.codersation.VendingMachine;

public class VendingMachineTest {

	VendingMachine sut = new VendingMachine();

	@Test
	public void testInsertMoney() {
		sut.InsertMoney(Money.Ten);
	}

	@Test
	public void _10�~��_50�~��_100�~��_500�~��_1000�~�D���P�������ł���() {
		sut.InsertMoney(Money.Ten);		
	}

}
