-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 08, 2021 at 11:37 PM
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
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` bigint UNSIGNED NOT NULL,
  `judul` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `deskripsi` text COLLATE utf8mb4_unicode_ci,
  `link_daftar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `link_yt` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `img_filename` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `judul`, `tgl`, `deskripsi`, `link_daftar`, `link_yt`, `img_filename`, `created_at`, `updated_at`) VALUES
(1, 'Webinar: Mengapa Plasma Kamu Bisa Menyelamatkan Pasien Covid-19', '2001-03-10', 'Dihadiri Ketua Gugus Tugas Percepatan Penanganan COVID-19 Doni Monardo. Materi: Manfaat Donor Plasma Konvalesen, Alur & Syarat Donor Plasma Konvalesen, Sharing Pengalaman Donor Plasma Konvalesen', '', '', 'storage/events/1.jpeg', NULL, NULL),
(2, 'Webinar: Menjaga Kebugaran Penyintas Covid-19', '2021-02-06', 'Dihadiri Jubir Satgas Percepatan Penanganan COVID-19 Wiku Adisasmito. Materi: Bagaimana agar penyintas Covid-19 tetap FIT, Apakah saya memenuhi syarat donor plasma', '', '', 'storage/events/2.jpeg', NULL, NULL),
(3, 'Talkshow: Hari Kanker Anak Sedunia', '2021-02-21', 'Belarasa Kemanusiaan dan Gotong Royong Berskala besar \"MALANGGLEERRR PEDULI\". Talkshow bersama dr.Dian Agung, Plasmahero.id, dan Lelang foto Kak Azis Franklin (Museum Musik Indonesia)', '', '', 'storage/events/5.jpeg', NULL, NULL),
(4, 'Indonesia Bicara: Antara Vaksin dan Plasma Darah', '2021-01-29', 'Live Streaming MNC Vision. Dibawakan oleh host terkemuka tanah air:Herjuno Syaputra. Narasumber: dr.Ariani (plasmahero), Ronald Tampubulon (Pendonor plasma), Jane Soepardi (Pakar Imunisasi), Pandu Riono (Epidemiolog UI)', '', '', 'storage/events/8.jpeg', NULL, NULL),
(5, 'Screening Donor Plasma Konvalesen dan Donor Darah', '2021-04-08', 'Dilaksanakan selama 4 hari 8-11 April 2021, berlokasi di Malang City Expo', '', '', 'storage/events/9.jpeg', NULL, NULL),
(6, 'Lomba TikTok: Berhadiah Jutaan Rupiah', '2021-04-15', 'Edukasi Covid-19 & Donor Plasma Konvalesen Plasmahero.id. Tema Vidio TikTok : Ayo Donor Plasma Konvalesen, Mitos dna Fakta Donor Plasma Konvalesen, Protokol Kesehatan di Masa Pandemi, Segar dan BUgar di Masa Pandemi, Mitos dan Fakta Covid-19, My Covid Journey', '', '', 'storage/events/10.jpeg', NULL, NULL),
(7, 'Perempuan Hebat Indonesia: Tetap Hebat di Masa Pandemi', '2021-04-21', 'Dihadiri beberapa tokoh ternama, beberapa diantarnya Menteri Keuangan RI Sri Mulyani, Menteri Luar Negeri RI Retno Marsudi, dan Founder Plasmahero.id dr.Ariani ', '', '', 'storage/events/11.jpeg', NULL, NULL),
(8, 'Bhawikarsu Care: 100 Ransel Sejuta Semangat', '2021-05-02', 'Dalam rangka memperingati Hari Pendidikan Nasional. Penyaluran Donasi 100 Paket Pendidikan untuk korban gempa Malang Selatan, Edukasi Protokol kesehatan untuk anak, Edukasi Mitigasi gempa untuk anak. Ditayangkan LIVE via Instagram BhawikaRsuCare. Didukung oleh Plasmahero.id', '', '', 'storage/events/12.jpeg', NULL, NULL),
(9, 'Webinar: Donor Konvalesen saat Puasa - Why Not?', '2021-05-08', 'Pembicara : dr.Ariani (Founder Plasmahero.id), Prakoso Permono (Pendonor Plasma Konvalesen). Ditayangkan Live di Instagram @pramukadonordarah', '', '', 'storage/events/13.jpeg', NULL, NULL),
(10, 'Webinar Rotaract 2021: Yuk Mengenal Donor Plasma Konvalesen', '2021-06-26', 'Pembicara : dr.Ariani (Founder Plasmahero.id), Totok Sudarto (Dewan Kehormatan PMI Surabaya). Ditayangkan Live di Instagram @pramukadonordarah. Free Sertifikat', '', '', 'storage/events/14.jpeg', NULL, NULL),
(11, 'Webinar: Plasma Konvalesen Harapan Baru Untuk melawan Covid-19', '2021-06-28', 'Pembicara : dr.Ariani (Founder Plasmahero.id) - Seluk Beluk Plasma Konvalesen, dr.Anna Kartika (Kepala UDD Kota Semarang)', '', '', 'storage/events/15.jpeg', NULL, NULL),
(12, 'IDJEN Talk: Pentingya Donor Plasma Konvalesen', '2021-06-23', 'Pembicara : dr.Ariani (Founder Plasmahero.id), Puryadi (Wakil Ketua II PDDI Kota Malang), Faizal Kurniawan (Waskejen Ikatan Sosiologi Indonesia Malang Raya)', '', '', 'storage/events/16.jpeg', NULL, NULL),
(13, 'Webinar: Ibu Tangguh Pahlawan Keluarga Melawan Covid-19', '2021-07-17', 'Bersama Forum Pemberdayaan Perempuaan Indonesia (FPPI) Kota Malang. Pembicara : Fadli Kesuma (Koordinator Gerakan 1000 Labu Plasma Konvalesen Plasmahero.id), dr.Kurniawan Taufik Kadafi (Staff Pengajar FK UB)', '', '', 'storage/events/17.jpeg', NULL, NULL),
(14, 'Webinar Melawan Covid-19: Donor Plasma Konvalesen', '2021-08-21', 'Ditengah kasus covid yang terus bertambah setiap harinya dan program vaksinasi yang sedang dijalankan, ada lagi lohhh yang bisa membantu menyembuhkan penderita covid. Pada penasaran ga sih plasma konvalesen ini  apaa??emang bener bisa bantu penderita covid??terus gimana nih caranya buat donor plasma konvalesen??\r\n\r\nNah biar temen-temen gapenasaran lagi yukk cari jawabannya dengan ikutan Webinar berjudul \"Melawan Covid-19: Donor Plasma Konvalesen\" yang dilaksanakan pada:\r\n\r\nHari/Tanggal: Sabtu, 21 Agustus 2021\r\nPukul: 13.00 - 15.00 WIB\r\nPlatform: Zoom\r\n\r\nFree E-Certificate\r\n\r\nBersama\r\n1. dr. Uke Muktimanah, MH. Kes  - Kepala UTD PMI Kota Bandung\r\n2. dr. Ariani M.Kes., Sp.A(K) - Founder Plasmahero.id (Komunitas Pendonor Plasma Konvalesen)\r\n\r\nModerator: Michael Suhendra - Komanda  PMI KSR Unit ITB\r\n\r\n#PlasmaKonvalesen\r\n#WebinarMelawanCovid19\r\n', 'bit.ly/DaftarWebinarPK', NULL, 'storage/events/18.jpeg', '2021-08-17 06:50:46', '2021-08-17 06:50:46');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
