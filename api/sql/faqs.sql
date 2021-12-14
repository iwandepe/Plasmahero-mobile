-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 08, 2021 at 11:36 PM
-- Server version: 8.0.25-0ubuntu0.20.04.1
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `plasmahero`
--

-- --------------------------------------------------------

--
-- Table structure for table `faqs`
--

CREATE TABLE `faqs` (
  `id` bigint UNSIGNED NOT NULL,
  `q` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `a` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `faqs`
--

INSERT INTO `faqs` (`id`, `q`, `a`, `source`) VALUES
(1, ' Apakah Terapi Plasma Konvalesen (TPK) itu?', 'Terapi Plasma Konvalesen merupakan suatu cara pengobatan atau metode imunisasi pasif yang bertujuan sebagai terapi tambahan COVID-19 dengan memberikan plasma yang mengandung antibodi terhadap virus SARS-CoV-2 dari penyintas COVID-19 kepada pasien COVID-19 yang masih menderita penyakit tersebut atau sedang dirawat.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(2, 'Kenapa saya harus mendonorkan plasma konvalesen?', 'Jika Anda merupakan penyintas COVID-19 atau orang telah sembuh dari COVID-19 maka Anda telah memiliki antibodi COVID-19 untuk melawan virus tersebut. Plasma yang didonorkan dapat membantu meningkatkan antibodi dan menurunkan jumlah virus (antigen COVID-19) pada penderita COVID-19 yang sedang dirawat.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(3, 'Siapa saja yang dapat mendonorkan plasma konvalesen?', '1. Memiliki hasil swab PCR/antigen  positif \r\n2. Memiliki hasil swab PCR/antigen negatif atau surat keterangan sembuh atau surat keterangan menjalani isolasi mandiri dari fasilitaskesehatan (dokter/puskemas atau RS) atau minimal satu bulan dari hasil PCR positif \r\n3. Jangka waktu donor minimal 2 minggu dan maksimal 6 bulan dari hasil swab PCR/antigen negatif atau waktu dinyatakan sembuh/selesai menjalani isolasi mandiri \r\n4. Diprioritaskan pria atau bila wanita belum pernah hamil, melahirkan/keguguran \r\n5. Berat badan minimal 55kg untuk proses dengan metode apheresis atau 45kg dengan metode konvensional \r\n6. Bila sudah vaksin sebelum terinfeksi COVID-19 maka belum dapat donor plasma \r\n7. Bila menerima vaksin setelah terinfeksi COVID-19 dan tidak ada kejadian ikutan paska imunisasi maka dapat donor plasma minimal 3 hari setelah Sinovac atau 20 hari setelah Astra Zeneca dan sejenisnya \r\n8. Memenuhi persyaratan donor pada umumnya : \r\n- Usia 18-60 tahun - Sehat pada saat akan donor \r\n- Tidak memiliki riwayat hipertensi tidak terkontrol, sakit gula tidak terkontrol atau menggunakan insulin, jantung atau stroke \r\n- Tidak memiliki Riwayat Infeksi hepatitis B, hepatitis C, HIV, dan sifilis, tidak memiliki tato atau pernah bekam', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(4, 'Apa yang akan dilakukan selanjutnya jika saya setuju untuk donor?', '1.Calon donor yang memenuhi syarat berdonor menghubungi PMI/Unit Tranfusi Darah Rumah Sakit  (UTD RS) terdekat untuk menanyakan syarat/ketentuan dan jadwal skrining darah\r\n2.Mendaftarkan diri ke link pendaftaran online jika tersedia \r\n3.Datang ke PMI/UTD RS dengan membawa persyaratan donor dan menjalai proses skrining\r\n4.Calon donor yang sudah lolos verifikasi datang ke PMI/ UTD RS untuk menjalani proses skrining terdiri dari pemeriksaan  tekanan darah, berat badan, seleksi pemeriksaan darah lengkap, pemeriksaan uji saring infeksi menular lewat tranfusi darah (IMLTD), kekeruhan plasma, dan titer/kadar antibodi SARS Cov-2 (30-60 menit) \r\n5.Calon donor yang lolos seleksi pemeriksaan darah akan menjalani proses pengambilan plasma dengan metode apheresis (45-60 menit) bila kondisi memungkinakan seperti berat badan minimal 55 kg, posisi pembuluh darah baik dan cukup besar, atau metode konvensional (10-15 menit) bila berat badan 45 kg dan pembuluh darah kecil. \r\n6.Sampel donor dilanjutkan dengan pemeriksaan konfirmasi golongan darah dan uji saring antibodi terhadap sampel darah pasien, yang dapat menyebabkan reaksi transfusi serta proses pembekuan plasma. Proses ini membutuhkan waktu 24 jam. Plasma yang memenuhi persyaratan akan diluluskan untuk didistribusikan ke Rumah Sakit. Plasma beku jika disimpan di -30 derajat Celcius dengan masa simpan 1 tahun.', 'PMI DKI Jakarta'),
(5, 'Apakah proses pengambilan plasma itu aman?', 'Proses pengambilan plasma aman dan dilakukan sesuai SOP yang baku dengan memperhatikan keselamatan dan kenyamanan donor. ', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(6, 'Bagaimana kemungkinan risiko dan ketidaknyamanan yang dialami saat saya melakukan donor?', 'Pengambilan plama dari lengan Anda dalam beberapa kasus, kadang dapat menyebabkan terjadinya memar di lengan dan sedikit ketidaknyamanan seperti nyeri ringan dan kebas pada area bibir. Petugas UDD PMI setempat akan selalu menjamin dan mendampingi Anda untuk meminimalkan risiko terjadinya hal tersebut. ', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(7, 'Bagaimana kerahasiaan informasi donor?', 'Semua informasi yang Anda berikan akan dijamin kerahasiaannya. Petugas akan memberitahukan langsung kepada Anda apakah Anda layak atau tidak layak untuk diambil plasmanya. ', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(8, 'Apakah saya akan mengetahui siapa yang akan menerima plasma saya?', 'Tidak, karena penentuan pasien yang akan diberikan plasma Anda ditentukan oleh Rumah Sakit. Semua akan dijamin secara rahasia untuk pelaksanaannya.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(9, 'Apakah penerima plasma juga akan mengetahui siapa donornya?', 'Tidak, karena tidak terdapat nama Anda pada kantong plasma dan semua proses transfusi plasma dilaksanakan secara rahasia.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(10, ' Apakah mendonorkan plasma konvalesen dikenakan biaya?', 'Anda menyumbangkan plasma secara sukarela sehingga Anda tidak dikenakan biaya untuk proses penyumbangan plasma ini.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(11, ' Seberapa sering seseorang dapat mendonorkan plasmanya?', 'Pendonor bisa memberikan plasmanya setiap 14 hari sekali. Sehingga dalam satu bulan, plasma dapat diambil sebanyak 2 kali. Namun hal ini akan bergantung dari kandungan antibody yang ada pada plasma Anda.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(12, ' Setiap kali mendonorkan plasma dapat menghasilkan berapa kantong (bag) plasma?', 'Setiap kali donor bisa memberikan 400-500 cc atau 2 kantong (bag) plasma.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(13, ' Apakah Terapi Plasma Konvalesen (TPK) ini aman?', 'Berdasarkan data penelitian yang valid, TPK dinyatakan aman. Efek samping berupa alergi memiliki insidensi 1:5.000.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(14, ' Kenapa donor harus dipastikan negatif dengan pemeriksaan swab PCR?', 'Swab PCR merupakan metode baku standar untuk identifikasi apakah virus/komponen virus SARS-CoV-2 masih ada, walaupun demikian swab PCR tidak bisa memberikan informasi apakah virus masih hidup atau mati.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(15, ' Kenapa wanita yang pernah hamil bukan merupakan pilihan utama sebagai donor?', 'Wanita yang pernah hamil memiliki faktor HLA (Human Leukocyte Antigen) yang berdasarkan penelitian berhubungan dengan reaksi alergi berat pada paru-paru yang disebut Transfusion Related Acute Lung Injury (TRALI). Hal ini menyebabkan pendonor diutamakan laki-laki karena selain lebih aman, pemeriksaan HLA bukan merupakan pemeriksaan yang mudah dan dapat dilakukan di semua tempat.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(16, ' Pemeriksaan apa yang harus dilakukan supaya plasma dari donor wanita yang pernah hamil terjamin keamanannya?', 'Pemeriksaan HLA (Human Leukocyte Antigen) dan bila hasil HLA negatif maka plasma dapat diberikan kepada resipien yang membutuhkan.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(17, ' Kenapa donor sebaiknya tidak pernah menerima transfusi darah atau komponen darah lainnya?', 'Hal yang sama berlaku dengan donor baik laki-laki atau wanita yang pernah menerima transfusi darah atau komponen darah lainnya, dikhawatirkan akan ada reaksi alergi yang melibatkan paru-paru pada resipien plasma.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(18, ' Apakah golongan darah plasma dari donor harus sama dengan golongan darah resipien (penerima)?', 'Ya, golongan darah donor harus sama dengan golongan darah resipien (penerima).', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(19, ' Siapa saja yang bisa menerima TPK?', 'Resipien TPK (Terapi Plasma Konvalesen) adalah penderita COVID-19 mulai dari stadium sedang, berat dan kritis. Walaupun demikian efektifitas TPK lebih optimal bila diberikan lebih dini, karena antibodi di dalam plasma berfungsi menghilangkan virusnya bukan memperbaiki kerusakan organ yang sudah terjadi. Banyak penelitian di dunia sedang berlangsung untuk menilai efektifitas dan keamanan terapi tambahan ini. ', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(20, ' Mengapa donor plasma hanya dapat dilakukan dalam kurun waktu 6 bulan setelah sembuh?', 'Hal ini disebabkan karena umumnya kadar antibodi terhadap virus SARS-CoV-2 bertahan dalam kadar tinggi di dalam tubuh donor selama maksimal 6 bulan dan setelah itu akan menurun secara bertahap sehingga donor terbaik adalah yang baru sembuh dari COVID-19 selama kurun waktu tersebut.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(21, ' Mengapa donor diutamakan penyintas yang sebelumnya menderita COVID-19 dengan gejala sedang?', 'Hal ini disebabkan karena kadar antibodi tertinggi banyak ditemukan pada penderita COVID-19 dengan gejala sedang. Walaupun demikian pada penyintas COVID-19 dengan gejala ringan atau OTG ada yang menghasilkan antibodi dengan kadar memadai walaupun tidak banyak.  ', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(22, ' Dimana orang dapat mendonorkan plasmanya?', 'Donor dapat diambil plasmanya di UDD PMI atau Unit Tranfusi Darah Rumah Sakit  yang memiliki alat apheresis yaitu alat yang digunakan untuk mengambil plasma dari donor. Untuk informasi mengenai daftar lokasi UDD PMI dan Unit Tranfusi Darah Rumah Sakit yang dapat melakukan donor plasma konvalesen dapat mengakses link berikut https://plasmahero.help/udd atau cek instagram @plasmahero.id', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(23, 'Saya sudah vaksin apa boleh saya berdonor?	', 'Bila sudah vaksin sebelum terinfeksi COVID-19 maka dapat donor plasma sesuai persyaratan jangka waktu yaitu minimal 2 minggu dan maksimal 3 bulan dari hasil PCR negatif atau waktu dinyatakan sembuh/selesai menjalani isolasi mandiri. Bila vaksin setelah terinfeksi COVID-19 maka dapat donor plasma bila vaksin dilakukan dalam 3 bulan setelah PCR negatif dan tidak ada kejadian ikutan paska imunisasi / vaksinasi minimal 3 hari setelah Sinovac atau 20 hari setelah Astra Zeneca dan sejenisnya', 'PMI Provinsi DKI Jakarta'),
(24, 'Apa saja tips yang harus saya jalankan sebelum berdonor?', '- Dalam keadaan sehat saaat donor, tidak ada keluhan \r\n- Tidur cukup minimal 4-5 jam pada malam sebelumnya \r\n– Hindari konsumsi makanan tinggi kolesterol, tinggi karbohidrat 1-2 hari sebelumnya \r\n- Minum air putih minimal 2 gelas sebelum dan sesudah proses donor plasma \r\n- Sudah makan 4 jam sebelum berdonor\r\n- Rileks dan gerakkan kaku berkala saat donor', 'PMI DKI Jakarta'),
(25, 'Kenapa ibu yang pernah hamil gak bisa jadi pendonor plasma konvalesen?', 'Karena wanita yang pernah hamil memiliki antibody anti-HLA dan anti-HPA. Jika ditransfusikan ke resipien atau pasien akan berbahaya.', 'PMI DKI Jakarta'),
(27, 'Apakah ada cara pengobatan lain selain plasma konvalesen?', 'Terapi plasma konvalesen bukan satu-satunya obat yang dapat menyelamatkan nyawa penderita COVID-19, terapi ini hanya sebagai penunjang.', 'PMI DKI Jakarta'),
(28, 'Bagaimana alur jika saya membutuhkan donor plasma konvalesen?', '1. RS mengirimkan formulir permintaan yang telah diisi lengkap\r\n2. Formulir permintaan dikirimkan ke PMI Provinsi DKI Jakarta\r\n- Ke loket A bila RS tidak ada bank darah  Ruma Sakit atau dari bodetabek dengan disertai sampel / contoh darah pasien\r\n- Ke loket B bila RS memiliki Bank Darah Rumah Sakit di wilayah DKI Jakarta\r\n3. Bila tidak tersedia, maka diarahkan unutk donor pengganti\r\n4. Bila tersedia baik dari stok atau dari donor pengganti, petugas lab akan menyiapkan dan menghubungi RS untuk konfirmasi kebutuhan apakah jadi akan ditransfusikan ke pasien \r\n- Bagi RS yang ada Bank Darah RS (melalui loket B) akan dikirimkan dalam keadaan beku dengan pengepakan menggunakan dry ice\r\n- Bagi RS yang tidak ada Bank Darah RS atau Bodetabek (melalui loket A) akan dikirimkan dalam keadaan cair dengan pengepakan menggunakan ice-packed', 'PMI DKI Jakarta'),
(29, 'Saya sudah vaksin apa boleh saya berdonor?', 'Bila sudah vaksin sebelum terinfeksi COVID-19 maka dapat donor plasma sesuai persyaratan jangka waktu yaitu minimal 2 minggu dan maksimal 3 bulan dari hasil PCR negatif atau waktu dinyatakan sembuh/selesai menjalani isolasi mandiri. Bila vaksin setelah terinfeksi COVID-19 maka dapat donor plasma bila vaksin dilakukan dalam 3 bulan setelah PCR negatif dan tidak ada kejadian ikutan paska imunisasi / vaksinasi minimal 3 hari setelah Sinovac atau 20 hari setelah Astra Zeneca dan sejenisnya', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(31, 'Saya sembuh 11/10/20, apakah masih bisa donor plasma?', 'Persyaratan PMI menyatakan bisa melakukan skrining donor maks 6 bulan dari hasil swab negatif, jika hasil tes skrining awal kadar atau titer antibodi SARS CoV2-nya masih memenuhi syarat dapat dilanjutkan berdonor.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(33, 'Sampai berapa kali maksimal saya dapat berdonor plasma konvalesen?', 'Tidak ada ketentuan batas maksimal berdonor plasma konvalesen, asal tiap 14 hari dilakukan skrining titer/kadar antibody SARS CoV2 nya masih memenuhi syarat dapat dilanjutkan berdonor.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(35, 'Apakah manfaat berdonor ?', '1.Menurunkan risiko terkena penyakit jantung karena membantu menurunkan kekentalan darah\r\n2. Membakar kalori dan menurunkan berat badan. Berdonor 450ml dapat membakar 650 kalori\r\n3. Menurunkan risiko kanker\r\n4.Meningkatkan produksi darah karena membantu merangsang produksei sel darah yang baru\r\n5. Membuat jiwa bahagia karena dapat membantu sesame\r\n6. Bagian dari pemeriksaan Kesehatan secara rutin karena dilkukan skrining darah lengkap dan pengujian laboratorium \r\n7.Memilik kesehatan yang baik karena rutin mendonorkan darahnya.\r\n', 'https://plasmakonvalesen.covid19.go.id/id/faq.html'),
(36, 'Bagaimana alur jika saya membutuhkan donor plasma konvalesen?', '1.RS mengirimkan formulir permintaan yang telah diisi lengkap \r\n2. Formulir permintaan dikirimkan ke PMI disertai sampel / contoh darah pasien a \r\n3. Bila plasma tidak tersedia, maka diarahkan untuk mencari donor pengganti \r\n4. Bila plasma tersedia baik dari stok atau dari donor pengganti, petugas lab akan menyiapkan dan menghubungi RS untuk konfirmasi kebutuhan apakah jadi akan ditransfusikan ke pasien \r\n- Bagi RS yang ada Bank Darah RS akan dikirimkan dalam keadaan beku dengan pengepakan menggunakan dry ice \r\n- Bagi RS yang tidak ada Bank Darah RS akan dikirimkan dalam keadaan cair dengan pengepakan menggunakan ice-packed.', 'https://plasmakonvalesen.covid19.go.id/id/faq.html');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `faqs`
--
ALTER TABLE `faqs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `faqs`
--
ALTER TABLE `faqs`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
