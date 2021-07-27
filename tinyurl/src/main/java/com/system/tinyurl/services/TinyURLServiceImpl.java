package com.system.tinyurl.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.tinyurl.model.URL;
import com.system.tinyurl.repository.URLRepository;

@Service
public class TinyURLServiceImpl implements TinyURLService {

	@Autowired
	private URLRepository urlRepository;

	@Override
	public String generateURL(String url) {
		String tinyUrl = generateTinyURL(url);

		URL urlObject = new URL(url, tinyUrl);
		urlRepository.save(urlObject);

		return url + " : " + tinyUrl;
	}

	private String generateTinyURL(String url) {
		try {
			//Append a random number to url
			Random rand = new Random();
			url += String.valueOf(rand.nextInt(1000000));
			
			//Generate hash from url
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(url.getBytes());

			//Encode hash to BASE64 and use first 6 chars
			byte[] encodedBytes = Base64.getEncoder().encode(messageDigest);
			String tinyUrl = new String(encodedBytes);
			tinyUrl = tinyUrl.substring(0, 6);

			return tinyUrl;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
