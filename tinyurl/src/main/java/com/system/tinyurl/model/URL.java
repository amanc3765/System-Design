package com.system.tinyurl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Url")
public class URL {

	@Id
	@Column(name = "url_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_seq_gen")
	@SequenceGenerator(name = "url_seq_gen", initialValue = 1, allocationSize = 1)
	private long urlId;

	@Column(name = "url_string")
	private String urlString;

	@Column(name = "tiny_url")
	private String tinyUrl;

	public URL() {
		super();
	}

	public URL(String urlString, String tinyUrl) {
		super();
//		this.urlId = urlId;
		this.urlString = urlString;
		this.tinyUrl = tinyUrl;
	}

}
