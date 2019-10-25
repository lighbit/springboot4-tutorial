package com.zulkarnaen.sprinboot4;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("jobScheduler")
public class JobScheduler {

	// @Scheduled(fixedRate=5000)
	// @Scheduled(cron = "*/5 * 9-17 * * MON-FRI") // setiap 5 detik dari jam 9 - 17
	// Senin sampai Jumat
	/* im using xml scheduler.xml now iam comment this @scheduled. */
	public void printMessage() {
		System.out.println("Iam Run Scheduler. in time " + new Date());
	}

}

/*
 * CONFIG: "0 0 * * * *" = the top of every hour of every day. "/10 * * * * *" =
 * every ten seconds. "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
 * "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
 * "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays "0 0 0 25 12 ?" =
 * every Christmas Day at midnight
 * 
 */

/*
 * Di atas @ metode terjadwal akan dipanggil oleh Penjadwal setiap 4 detik.
 * Perhatikan bahwa metode yang dijelaskan dengan @Scheduler harus kembali batal
 * dan tidak boleh memiliki parameter apa pun. Tentu saja Anda dapat
 * menyuntikkan bean lain di bean di atas untuk mendapatkan beberapa fungsi
 * eksternal yang disebut di printMessage.
 * 
 * @ Penjadwalan terjadwal memiliki beberapa atribut untuk menentukan jadwal
 * waktu penjadwalan yang berbeda. atribut initialDelay menentukan jumlah
 * milidetik untuk menunggu sebelum eksekusi pertama metode. fixedRate
 * menentukan jumlah milidetik di antara setiap metode yang dimulai, terlepas
 * dari berapa lama metode yang dibutuhkan untuk menyelesaikan. fixedDelay
 * menentukan jumlah milidetik antara penyelesaian proses sebelumnya, dan mulai
 * proses berikutnya. Atribut cron memberikan kontrol yang lebih baik pada
 * penjadwalan eksekusi tugas. Misalnya, @Jadwal (cron = * / 5 * * * * MON-FRI
 * ") mengonfigurasi metode ini untuk dieksekusi setiap 5 detik tetapi hanya
 * pada hari kerja.
 */
