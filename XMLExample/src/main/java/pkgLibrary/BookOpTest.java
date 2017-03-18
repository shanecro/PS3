package pkgLibrary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookOpTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Book b = new Book();
		b.setBookId("bk101");
		Catalog a = null;
		Catalog cat = a.ReadXMLFile();//not needed, always the ReadXMLFile as cat in the add and getbook methods
		a.addBook(cat, b);
		
		
	}

}
