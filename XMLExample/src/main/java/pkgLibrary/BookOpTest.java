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
	public void test() throws BookException {
		Book b = new Book();
		b.setBookId("bk123");
		Catalog a = null;
		Catalog cat = a.ReadXMLFile();//not needed, always the ReadXMLFile as cat in the add and getbook methods
		cat.addBook(cat, b);
		Book b1 = new Book();
		b1.setBookId("bk101");
		cat.addBook(cat, b1);
		
		
//		assertEquals(cat.getBook(cat, "bk123"),b );
		assertEquals(cat.getBooks().size(), 13 );
			
		
		
	}
	@Test(expected = BookException.class)
	public void testBookException() throws BookException { 
		Catalog a = null;
		Catalog cat = a.ReadXMLFile();//not needed, always the ReadXMLFile as cat in the add and getbook methods
		Book b1 = new Book();
		b1.setBookId("bk101");
		cat.addBook(cat, b1);
		assertEquals(cat.getBooks().size(), 12 );
	}
}
