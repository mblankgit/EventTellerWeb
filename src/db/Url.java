package db;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Url entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Url", catalog = "EventTeller")
public class Url implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1245520426185744766L;
	private Integer id;
	private Date crawltime;
	private String url;
	private String website;

	// Constructors

	/** default constructor */
	public Url() {
	}

	/** minimal constructor */
	public Url(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Url(Integer id, Date crawltime, String url, String website) {
		this.id = id;
		this.crawltime = crawltime;
		this.url = url;
		this.website = website;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "crawltime", length = 19)
	public Date getCrawltime() {
		return this.crawltime;
	}

	public void setCrawltime(Date crawltime) {
		this.crawltime = crawltime;
	}

	@Column(name = "url", length = 300)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "website", length = 20)
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}