/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codersation.vendingmachine;

import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.core.IsNull;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author megascus
 */
public class VendingMachineTest {

    public VendingMachineTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void canCreateInstance() {
        VendingMachine vm = new VendingMachine();
    }

    @Test
    public void canInsert10Yen() {
        VendingMachine vm = new VendingMachine();
        vm.insert(Money.TEN);
    }

    @Test
    public void totalAmountIs0WhenFirst() {
        VendingMachine vm = new VendingMachine();
        assertEquals(vm.getTotalAmount(), 0);
    }

    @Test
    public void canInsert10YenAndTotalAmountIs10Yen() {
        VendingMachine vm = new VendingMachine();
        Money money = vm.insert(Money.TEN);
        assertEquals(vm.getTotalAmount(), 10);
        assertThat(money, IsNull.nullValue());
    }
    
    public void cannotInsert10000Yen() {
        VendingMachine vm = new VendingMachine();
        Money money = vm.insert(Money.TEN_THOUSANDS);
        assertThat(money, is(Money.TEN_THOUSANDS));
    }
}
