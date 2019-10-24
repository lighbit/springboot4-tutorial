package com.zulkarnaen.sprinboot4.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.zulkarnaen.sprinboot4.service.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService {

	@Value("${sourceLocation: c:/temp/input}")
	private String source;

	@Value("${destinationLocation: c:/temp/output}")
	private String destination;
	
	@Value("${jdbc.driverClassName: ini tidak akan dibaca bosque}")
	private String driver;

	@Autowired
	private Environment environment;

	public void readValues() {
		System.out
				.println("Getting property via Spring Environment :" + environment.getProperty("jdbc.driverClassName") + " and " + driver);

		System.out.println("Source Location : " + environment.getProperty("sourceLocation"));
		System.out.println("Destination Location : " + destination);

	}

}

/*
 * Poin pertama yang perlu diperhatikan adalah Lingkungan mendapat auto-wired
 * oleh Spring. Berkat penjelasan @PropertySoruce, Lingkungan ini akan
 * mendapatkan akses ke semua properti yang dideklarasikan dalam file
 * .properties yang ditentukan. Anda bisa mendapatkan nilai properti spesifik
 * menggunakan metode getProperty. Beberapa metode didefinisikan dalam antarmuka
 * Lingkungan.
 * 
 * Poin menarik lainnya di sini adalah penjelasan @Value. Format anotasi nilai
 * adalah
 * 
 * @nilai ("$ {key: default") private String var; Deklarasi di atas
 * menginstruksikan Spring untuk menemukan properti dengan kunci bernama ‘kunci’
 * (dari file .properti mis.) Dan menetapkan nilainya ke variabel var. Jika
 * properti ‘kunci’ tidak ditemukan, tetapkan nilai ‘default’ ke variabel var.
 * 
 * Perhatikan bahwa placeholder di atas $ {...} hanya akan diselesaikan ketika
 * kami telah mendaftarkan bean PropertySourcesPlaceholderConfigurer (yang
 * telah kami lakukan di atas) jika tidak, anotasi @Value akan selalu menetapkan
 * nilai default ke variabel var.
 */
