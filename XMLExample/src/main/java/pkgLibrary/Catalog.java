package pkgLibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

public class BookException extends Exception {
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog extends Book {

	@XmlAttribute
	String id;

	@XmlElement(name = "book")
	ArrayList<Book> books;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	private static void WriteXMLFile(Catalog cat) {
		try {

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(cat, file);
			jaxbMarshaller.marshal(cat, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;
	}

	public void addBook(Catalog cat, Book b) throws BookException {

		cat = ReadXMLFile();

		Book new_book = b;
		/*
		 * this.id = new_book.setId(id); this.author =
		 * new_book.setAuthor(author); this.title = new_book.setTitle(title);
		 * this.genre = new_book.setGenre(genre); this.price =
		 * new_book.setPrice(price); this.cost = new_book.setCost(cost);
		 * this.Publish_date = new_book.setPublish_date(publish_date);
		 * this.description = new_book.setDescription(description);
		 * 
		 *//**
			 * or this? new_book.setBookId(this.id);
			 * new_book.setAuthor(this.author); new_book.setTitle(this.title);
			 * new_book.setGenre(this.genre); new_book.setPrice(this.price);
			 * new_book.setCost(this.cost);
			 * new_book.setPublish_date(this.publish_date);
			 * new_book.setDescription(this.description);
			 * 
			 * not needed because the book is being passed in already made 
			 */

		for (Book book : cat.getBooks()) {
			if (book.getBookId() == new_book.getBookId()) {
				throw new BookException();
			} else {
				cat.getBooks().add(new_book);
			}
		}
	}

	public Book getBook(Catalog cat, String id) throws BookException {
		cat = ReadXMLFile();
		for (Book b : cat.getBooks()) {
			if (b.getBookId() == id) {
				String new_id = b.getBookId();
				String author = b.getAuthor();
				String title = b.getTitle();
				String genre = b.getGenre();
				double price = b.getPrice();
				double cost = b.getCost();
				Date publish_date = b.getPublish_date();
				String description = b.getDescription();
				return Book(new_id, author, title, genre, price, cost, publish_date, description);
			} else {
				throw new BookException();
			}
		}
	}
}
