package test.com.github.springaki.codersation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.springaki.codersation.Money;
import com.github.springaki.codersation.VendingMachine;

public class VendingMachineTest {

	VendingMachine sut = new VendingMachine();

	@Test
	public void testInsertMoney() {
		sut.insertMoney(Money.Ten);
	}

	@Test
	public void _10�~��_50�~��_100�~��_500�~��_1000�~�D���P�������ł���() {
		sut.insertMoney(Money.Ten);
		sut.insertMoney(Money.Fifty);		
		sut.insertMoney(Money.OneHundred);		
		sut.insertMoney(Money.FiveHundred);		
		sut.insertMoney(Money.OneThousand);		
	}

	@Test
	public void �����͕�����ł���() {
		sut.insertMoney(Money.Ten);
		sut.insertMoney(Money.Ten);
	}

	@Test
	public void �������z�̑��v���擾�ł���() {
		assertEquals(0, sut.getTotalAmount());		
		sut.insertMoney(Money.Ten);
		sut.insertMoney(Money.Ten);
		assertEquals(20, sut.getTotalAmount());		
	}
	
	@Test
	public void �����߂�������s���Ɠ������z�̑��v��ނ�K�Ƃ��ďo�͂���() {
		assertEquals(0, sut.calcel());
		sut.insertMoney(Money.Ten);
		sut.insertMoney(Money.Ten);
		assertEquals(20, sut.calcel());
		assertEquals(0, sut.calcel());
	}

}
