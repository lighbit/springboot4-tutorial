package com.zulkarnaen.sprinboot4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.zulkarnaen.sprinboot4")
@PropertySource(value = { "classpath:application.properties" }) // Classpath in src/main/resources
public class AppConfig {

	// TODO: for Spring @Profile Guide
//	@Autowired
//	public DataSource dataSource;

	/*
	 * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}")
	 * annotations. Remove this bean if you are not using @Value annotations for
	 * injecting properties.
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}

/*
 * Kelas konfigurasi pegas adalah yang dijelaskan dengan @Configuration.
 * Kelas-kelas ini berisi metode yang dijelaskan dengan @Bean. Metode
 * beranotasi @Bean ini menghasilkan bean yang dikelola oleh wadah Spring.
 * 
 * Sebenarnya, mereka akan terdeteksi secara otomatis, berkat
 * penjelasan @ComponentScan.
 * 
 * @ComponentScan (basePackages = "com.zulkarnaen.sprinboot4") Atribut
 * basePackages @ComponentScan mengambil nama paket [s] sebagai input yang akan
 * dicari untuk menemukan kelas apa pun yang dijelaskan dengan anotasi khusus
 * Spring.
 * 
 * 
 * 
 * @Repository - Digunakan untuk menandai bean sebagai DAO Component pada layer
 * persistence
 * 
 * @Service - Digunakan untuk menandai bean sebagai Komponen Layanan pada
 * lapisan bisnis
 * 
 * @Controller - Digunakan untuk menandai bean sebagai Komponen Pengontrol pada
 * lapisan Presentasi
 * 
 * @Configuration - Digunakan untuk menandai bean sebagai Komponen Konfigurasi.
 * 
 * @Component - Penjelasan tujuan umum, dapat digunakan sebagai pengganti
 * penjelasan di atas.
 * 
 * Penjelasan @PropertySource (value = {"classpath: application.properties"})
 * membuat properti tersedia dari file properti bernama [s] (dirujuk oleh
 * atribut nilai) ke Spring Envirronment. Antarmuka lingkungan menyediakan
 * metode pengambil untuk membaca properti individu dalam aplikasi.
 * 
 * @bean. Metode beranotasi @Bean ini menghasilkan bean yang dikelola oleh wadah
 * Spring.
 * 
 * @Profil anotasi pada komponen mendaftarkan komponen itu dalam konteks Pegas
 * hanya ketika profil itu aktif. Aktivasi profil berarti nilai profil ini harus
 * tersedia oleh
 * 
 * Mengatur properti spring.profiles.active (melalui argumen JVM, variabel
 * lingkungan atau parameter konteks Servlet di web.xml jika aplikasi web)
 * ApplicationContext.getEnvironment (). SetActiveProfiles ("ProfileName");
 */