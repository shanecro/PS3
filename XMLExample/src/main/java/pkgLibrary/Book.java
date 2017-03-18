package pkgLibrary;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Book {

	private String id;
	private String author;
	private String title;
	private String genre;
	private double price;
	private double cost;
	private Date publish_date;
	private String description;
	        
	public Book() {
		this.id = "bk123";
		this.author = "Shane Croce";
		this.title = "Practice Set 3: Doing Stuff, with Stuff!";
		this.genre = "Horror";
		this.price = 40.00;
		this.cost = 32.00;
		Date date = new Date();
		this.publish_date = date;
		this.description = "Read and write an XML file and throw exceptions. Go Eagles";
				
		
	}

	public Book(String id, String author, String title, String genre, double price, double cost, Date publish_date, String description)
	{
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;		
		this.price = price;
		this.cost = cost; 
		this.publish_date = publish_date;
		this.description = description;
	}

	
 

	public String getBookId() {
		return id;
	}

	@XmlAttribute
	public void setBookId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getCost() {
		this.cost = this.price * .8;
		return this.cost;
	}

	@XmlElement
	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	@XmlElement
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

}
