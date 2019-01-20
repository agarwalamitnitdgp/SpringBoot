package com.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private long id;

	private String title;
	private String body;
	private Date postedOn;

	// one author could have many posts
	@ManyToOne
	private Author author;

	// Private no argument constructor is required for JPA
	private Post() {
	}

	// Our public constructor makes sure a title is set when creating a new post
	public Post(String title) {
		this.setTitle(title);
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

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", postedOn=" + postedOn + "]";
	}
}
