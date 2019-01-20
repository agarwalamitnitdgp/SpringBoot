package com.dataSource.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private long id;
	private String title;

	@Column(columnDefinition="TEXT")
	private String body;

	@Column(columnDefinition="TEXT")
	private String teaser;

	private String slug;

	@CreatedDate @Column(columnDefinition="TIMESTAMP")
	private Date postedOn;

	// one author could have many posts
	@ManyToOne
	private Author author;

	// Private no argument constructor is required for JPA
	@SuppressWarnings("unused")
	private Post() {
	}

	// Our public constructor makes sure a title is set when creating a new post
	public Post(String title) {
		this.setTitle(title);
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", teaser=" + teaser + ", slug=" + slug
				+ ", postedOn=" + postedOn + ", author=" + author + "]";
	}

}
