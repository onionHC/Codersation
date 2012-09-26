/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 *
 * @author mao
 */
public class JuiceStocksTest {
    
    public JuiceStocksTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    // TODO ストックの初期状態はコーラが格納されている
    // TODO ストックの初期状態で格納されているコーラは5本である
    // TODO コーラは単価が120円である
    // TODO ストックにレッドブルを5本追加できる
    @Test
    public void ストックの初期状態はコーラが格納されている() {
        JuiceStocks juiceStocks = JuiceStocksFactory.createNewStocks();
        JuiceStock juiceStock = juiceStocks.getAllStocks().get(0);
        Juice juice = juiceStock.getJuice();
        assertThat(juice.getName(), is("コーラ"));
    }
}
