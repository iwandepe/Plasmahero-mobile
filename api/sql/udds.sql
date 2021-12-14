-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 08, 2021 at 11:44 PM
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
-- Table structure for table `udds`
--

CREATE TABLE `udds` (
  `id` bigint UNSIGNED NOT NULL,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `link_map` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `jam` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `kontak` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `udds`
--

INSERT INTO `udds` (`id`, `nama`, `alamat`, `link_map`, `jam`, `kontak`, `email`) VALUES
(1, ' UDDP', 'Jl. Joe No. 7, Lenteng Agung, Jakarta Selatan 12610 ', ' https://goo.gl/maps/nNsAYsZmtT7biUYKA', ' Setiap Hari (08.00 - 20.00)', '\r\nDr.dr.Saptuti Chunaeni -  08111872362\r\n dr. Lilis Wijaya-082123459337\r\n dr. Dian Savitri - 085216619122\r\n dr. Nova Hippy- 0818907407', ' admin@utdp-pmi.or.id'),
(2, ' UDD PMI DKI', 'Jalan Kramat Raya No. 47 Jakarta 10450, Indonesia', ' https://g.page/donordarahjakarta?share', ' Setiap Hari 24 Jam', '\r\n08568864678 (WA Chat)', ' info@utdpmidkijakarta.or.id'),
(3, ' UDD PMI Kota Banda Aceh', 'Jl. Stadion H. Dimurthala No.3 Lampineung- Banda Aceh', ' https://goo.gl/maps/yWA6pR2ztZQ5UUCT7', ' Setiap Hari 24 Jam', '\r\nDr. Ratna Sari Dewi - 081362946000\r\n Dr. Fajar Ariansyah - 085288447810\r\n Dr. Mutia Abdullah - 082361181600', NULL),
(4, ' UDD PMI Kota Medan', 'Jl. Perintis Kemerdekaan No. 37 Medan', ' https://goo.gl/maps/S8bCiUdjm9mtVmy69', ' Setiap Hari 24 Jam', '\r\nDr. Eka - 08126335440\r\n Dr. Ira - 081265555548', ' info@pmimedan.or.id'),
(5, ' UDD PMI Pekanbaru', 'Jl. Diponegoro IX No.15 Pekanbaru - 28133', ' https://goo.gl/maps/L7bRCa6b7MAeXDnv7', ' Setiap Hari 24 Jam', '\r\ndr. Dian I.K Singgih - 081365300086\r\n dr. Reni Oktora - 081365340078', ' donor@utdpmipekanbaru.or.id'),
(6, ' UDD PMI Palembang', 'Jl. Srijaya Komplek SKB Km 5.5 Palembang', ' https://goo.gl/maps/kACsvCYhwpHnAYrDA', ' Setiap Hari 24 Jam', '\r\n0711 356282', ' pmikotapalembang@gmail.com'),
(7, ' UDD PMI Lampung', 'Jl.dr.Sam Ratualngi No. 105 Penengahan, Bandar Lampung - 35112', ' https://goo.gl/maps/hQWnDYwmV5eZxs9L8', ' Setiap Hari (08.00 - 20.00)', '\r\nDr. Aditya - 08127934120', NULL),
(8, ' UDD PMI Kota Tangerang', 'Jl. Mayjen Sutoyo No. 15 Tangerang - 15111', ' https://goo.gl/maps/fuVBSjadhRSBn4Vu5', ' Setiap Hari (08.00 - 22.00)', '\r\ndr David Sidabutar - 0811157242', ' humas_kotatangerang@pmi.or.id'),
(9, ' UDD PMI Tangerang Selatan', 'Jl. Cendekia BSD No. 1 Sektor XI Kel. Ciater Serpong, Kota Tangerang Selatan', ' https://goo.gl/maps/VNwXR1Ykm8vatmqXA', ' Setiap Hari 24 Jam', '\r\n0811805188\r\n dr. Suhara M - 081318142324\r\n dr. Edna - 082297177181\r\n Lilis - 083890358921', ' admin@pmi-tangerangselatan.or.id'),
(10, ' UDD PMI Kab. Tangerang', 'Jl. Kp. Pos Bitung No.47A, Kadu Jaya, Kec. Curug, Tangerang, Banten 15810', ' https://goo.gl/maps/tqMfzKEqm8azMy3n9', ' Setiap Hari (08.00 - 22.00)', '\r\nTutri - 087880450654', ' uddpmi.kab.tangerang@gmail.com'),
(11, ' UDD PMI Bandung', 'Jl. Aceh No.79,Bandung Wetan, Kota Bandung, 40114', ' https://goo.gl/maps/GDrmD3MZroXbnMpK7', ' Setiap Hari (07.00 - 21.00)', '\r\n089603524024 (WA chat)\r\n dr Uke Muktimanah - 08112049060\r\n Ade Safitri - 081221538010\r\n Nurjanah - 08112049011', ' admin@pmikabbandung.or.id'),
(12, ' UDD PMI Kab Bekasi', 'Jl. Raya Teuku Umar No.49, Wanasari, Kec. Cibitung,17510', ' https://goo.gl/maps/EK1Sj8HFpPb9FdvS7', ' Setiap Hari (08.00 - 22.00)', '\r\n(021) 88331414\r\n dr. Eva Dini - 081319603803\r\n Syahruni - 08121917053', ' pmi_kab.bekasi@yahoo.com'),
(13, ' UDD PMI kab Cirebon', 'Jl. Otto Iskandar Dinata(Otista) No.40A, Tegalsari, Plered, Cirebon,45154', ' https://goo.gl/maps/dZRegYiESryysjBz9', ' Setiap Hari 24 Jam', '\r\nDr.J. Suwanta M.Kes - 081222105688\r\n Ilah Jamilah - 082216151288', NULL),
(14, ' UDD PMI Kab. Bogor ', 'Jl. KSR Dadi Kusmayadi, Tengah, Cibinong, Bogor, Jawa Barat 16914', ' https://goo.gl/maps/fS9WS4Yd19cvAzLs7', ' Senin - Sabtu (09.00 - 21.00)', '\r\n02187903021\r\n Ali Firdawansyah - 081282743746', ' posko_pmikabbogor@gmail.com, humas-pmikabbogor@yahoo.com'),
(15, ' UDD PMI Semarang', 'Jl. MGR. Sugiyopranoto No.31 Semarang 50131', ' https://g.page/udd-pmikotasemarang?share', ' Setiap Hari (7.30 - 20.30)', '\r\ndr. Anna Kartika - 081328884455\r\n  Rahman- 085879136656', ' uddpmismg@yahoo.com'),
(16, ' UDD PMI Kab. Banyumas', 'Jl. Pekaja No. 37 Sokaraja, Banyumas - 53181', ' https://goo.gl/maps/ZkwnTf1F694z26fy7', ' Setiap Hari (7.00 - 20.30)', '\r\ndr. Mey Dian Intan Sari - 081542703927\r\n dr. Ivone Rusyandari - 082242997459\r\n M. Mulkhanasir - 08562648685', ' kab_banyumas@pmi.or.id'),
(17, ' UDD PMI Cilacap', 'Jl. Urip Sumoharjo No. 174A, Gumilir, Cilacap', ' https://goo.gl/maps/KPJ8QcdhsBqnFksF8', ' Setiap Hari (8.00 - 21.00)', '\r\ndr. Yuyung - 0816692469', ' kab_cilacap@pmi.or.id'),
(18, ' UDD PMI Surakarta', 'Jl. Kol.Sutarto No.58 Surakarta - 57126', ' https://goo.gl/maps/Wt93AwCxZWGJK4916', ' Setiap Hari 24 Jam', '\r\ndr. Kunti Dewi Saraswati Sp.PK M.Kes - 08562820827\r\n dr. Agni Romadhona V - 082133888855\r\n dr A Reza - 08123418786', ' kota_surakarta@pmi.or.id'),
(19, ' UDD PMI Surabaya', 'Jl. Embong Ploso No.7-15 Surabaya - 60271', ' https://goo.gl/maps/tUfhiZ2cjiUtbsrU6', ' Setiap Hari (7.00 - 20.00)', '\r\ndr. Sasi Widuri - 085856533318\r\n dr. Vebrie - 085852222686\r\n dr Fitrianawaty - 089625179787', ' pmisurabaya@yahoo.co.id'),
(20, ' UDD PMI Kota Malang', 'Jl Buring No.10, Malang - 65112', ' https://goo.gl/maps/9LqMxaWyyk5A1fWh7', ' Senin- Kamis & Sabtu - Minggu (07.30-19.30) , Jumat (09.00-19.30)', '\r\nAgus Tri Prasetyo - 081555760927', ' pmi_malang@yahoo.co.id'),
(21, ' UDD PMI Sidoarjo', 'jl. Raya Jati No.1 Babatan Jati, Kab. Sidoarjo - 61234', ' https://goo.gl/maps/TeMYMUFVZPWe24tQ8', ' Setiap Hari (7.30 - 21.30)', '\r\ndr. Nunuk Masluhiyah - 081235184888\r\n dr. Septi Laili - 085850388058\r\n Moch. Asyik Yusak - 08133138009', ' pmisidoarjo.utd@gmail.com & pmikabsidoarjo@yahoo.com'),
(22, ' UDD PMI Lumajang', 'Jl. Imam Sudja\'i No.3 Lumajang - 62315', ' https://goo.gl/maps/idK8XmNJToUkZRdH8', ' Setiap Hari 24 Jam', '\r\nAnis Mufarida - 082226552872\r\n Trio - 082232694752', ' uddpmi_lumajang@yahoo.com'),
(23, ' UDD PMI Kab. Tuban', 'Jl. Pramuka No.02 Tuban - 62315', ' https://goo.gl/maps/fUBLTeicMo5oRRwn8', ' Setiap Hari 24 Jam', '\r\nDr. Eka - 08126335440\r\n Dr. Ira - 081265555548', NULL),
(24, ' UDD PMI Kab. Jember', 'Jl. Dr. Soebandi No. 293 Jember', ' https://g.page/UDDPMIJEMBER?share', ' Setiap Hari 24 Jam', '\r\ndr.  Dudung Ali Rusli - 08123456257\r\n Attin Mahatma - 081230495506', ' utdpmijember@gmail.com'),
(25, ' UDD PMI Bali', 'Komp. RSUP Sanglah, Jl. Diponegoro, Denpasar - 80114', ' https://g.page/balibloodbank?share', ' Setiap Hari 24 Jam', '\r\ndr. Chandra Indriasari - 081320269999', ' udd@pmibali.or.id'),
(26, ' UDD PMI Kota Banjarmasin', 'Jl. S. Parman No. 14, Kl. Antasan Besar - 70114', ' https://goo.gl/maps/3c9BfJsfVZFDGYHw7', ' Setiap Hari (8.00 - 16.00)', '\r\ndr. Aulia Ramadhan Supit - 081330179093 - (WA) +60178897716\r\n Iqa - 085100674545', ' utdpmi.kotabanjarmasin1@gmail.com'),
(27, ' UDD PMI Sulut', 'Jl. R. W. Monginsidi Malalayang II Manado- 95262', ' https://goo.gl/maps/A4apDxJ8XUfqGBfC6', ' Setiap Hari 24 Jam', '\r\ndr. Agusteivie Telew - 085240852008\r\n dr. Sonny Pasuhuk - 081244770330', ' udddsulut@yahoo.com'),
(28, ' UDD PMI Makassar', 'Jl. Kandea No.16 Kel. Baraya, Kec, Bantoala, Kota Makassar - 90153', ' https://goo.gl/maps/dbVpgpXit9FAo6737', ' Setiap Hari 24 Jam', '\r\nDr. dr. Sri Julyani\r\n Sp.PK\r\n M.Kes - 085242561250\r\n Achmad Syauki - 081242185669', ' PlasmaHeroMakassar@gmail.com'),
(29, ' UDD PMI Depok', 'Jl. Boulevard Grand Depok City Kota Kembang Cilodong Depok', ' https://goo.gl/maps/DCEyPL28qorkFxZ47 ', ' Setiap hari (8.00-16.00)', '\r\ndr. Yuli Astuti - 087871299824; M. Kartono - 081314140917', ' pmi.or.id'),
(30, 'UTD Rumah Sakit Fatmawati', 'Jl. RS. Fatmawati Raya, RT.4/RW.9, Cilandak Bar., Kec. Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12430', 'https://goo.gl/maps/R7K2R16EKVzakEQw5', 'Setiap hari 08.00 - 16.00', '(021) 7501524', NULL),
(31, 'UDD PMI Kota Yogyakarta', 'Jl Tegal Gendu 25 Kotagede, Yogyakarta', 'https://goo.gl/maps/5dP75PM63cc3xnP26', 'Setiap hari 07.30 - 20.30', '(0274) 372176', NULL),
(32, 'UDD PMI Kota Kediri', 'Jl. Mayor Bismo 15, Kediri - 64121', 'https://goo.gl/maps/3brndUHPYmGHPbpk8', 'Setiap hari 08.00 - 21.00', '(0354) 689072', NULL),
(33, 'UDD PMI Kabupaten Purbalingga', 'Jl. Tentara Pelajar (Sebelah Timur RSUD Goetang TB), Purbalingga - 53319', 'https://goo.gl/maps/Xtejdp8Nq8Hqn2c89', 'Setiap Hari 24 Jam', '(0281) 891961', NULL),
(34, 'UDD PMI Kota Padang', 'Jl. Sawahan Dalam II No.12, Sawahan Tim., Kec. Padang Tim., Kota Padang, Sumatera Barat 25121', 'https://goo.gl/maps/PA6PWWFGk3hSj8bN7', NULL, '(0751) 31795', NULL),
(35, 'UDD PMI Kota Batam', 'Jl. Cemp., Tlk. Tering, Kec. Batam Kota, Kota Batam, Kepulauan Riau 29444', 'https://goo.gl/maps/ydZKM7Ht4YZTSbNw7', 'Setiap Hari 24 Jam', '(0778) 450626', NULL),
(36, 'Rumah Sakit Pusat Angkatan Darat Gatot Soebroto', 'Jl. Abdul Rahman Saleh Raya No.24, RT.10/RW.5, Senen, Kec. Senen, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10410', 'https://goo.gl/maps/y15vYTaFQJfFyZeZ7', 'Setiap Hari 24 Jam', '(021) 3840702', NULL),
(37, 'Rumah Sakit Umum Pusat Dr. Kariadi Semarang', 'Jl. DR. Sutomo No.16, Randusari, Kec. Semarang Sel., Kota Semarang, Jawa Tengah 50244', 'https://goo.gl/maps/4WYWsrBDAsEktrTY7', 'Setiap Hari 24 Jam', '(024) 8413476', NULL),
(38, 'Rumah Sakit Umum Pusat Dr. Hasan Sadikin Bandung', 'Jl. Pasteur No.38, Pasteur, Kec. Sukajadi, Kota Bandung, Jawa Barat 40161', 'https://goo.gl/maps/eHYzCAMVUpYPxU5C7', 'Setiap Hari 24 Jam', '(022) 2034953', NULL),
(39, 'UDD PMI Kabupaten Gresik', 'Jl. Dr. Wahidin Sudiro Husodo 93, Gresik - 61121', 'https://goo.gl/maps/Udjj2ZA3UdCbHZCb9', 'Senin - Minggu 07.00 - 21.00', '(031) 3991190', NULL),
(40, 'Rumah Sakit Umum Pusat Dr. Sardjito', 'Jl. Kesehatan No.1, Senolowo, Sinduadi, Kec. Mlati, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281', 'https://goo.gl/maps/WLmKLa4dsASov1VG7', 'Setiap hari 24 jam', '(0274) 631190', NULL),
(41, 'UDD PMI Kota Bekasi ', 'Jl. Pramuka No.1, RT.006/RW.006, Marga Jaya, Kec. Bekasi Sel., Kota Bks, Jawa Barat 17141', 'https://goo.gl/maps/3mA2C6wA3BN5Fdmv7', 'Setiap hari 24 jam', '(021) 88960247', NULL),
(42, 'UDD PMI Kabupaten Tulungagung', 'Jl. dr Wahidin Sudirohusodo No. 39 , Tulungagung', 'https://goo.gl/maps/dGXTx9RBnw55DRb26', 'Setiap Hari 24 Jam', NULL, NULL),
(43, 'RSUD Dr. Soetomo', 'Jl. Mayjen Prof. Dr. Moestopo No.6-8, Airlangga, Kec. Gubeng, Kota SBY, Jawa Timur 60286', 'https://goo.gl/maps/UAtsZnGwhfE9Vw8b8', 'Setiap hari 24 jam', '(031) 5501078', NULL),
(44, 'RSUD Dr. SAIFUL ANWAR MALANG', 'Jl. Jaksa Agung Suprapto No.2, Klojen, Kec. Klojen, Kota Malang, Jawa Timur 65112', 'https://goo.gl/maps/kabKaMNA7dSEWVQr7', 'Setiap hari 24 jam', '(0341) 362101', NULL),
(45, 'UDD PMI Kota Samarinda', 'Jl. Palang Merah No. 1, Samarinda - 75123', 'https://goo.gl/maps/XoVaeAVKtT1UDLw66', 'Setiap hari 24 jam', '(0541) 732261', NULL),
(46, 'UDD PMI Kabupaten Tangerang', 'Jl. Kp. Pos Bitung No.47A, Kadu Jaya, Kec. Curug, Tangerang, Banten 15810', 'https://goo.gl/maps/9T27nsiguTJV6TjX7', 'Setiap hari 24 jam', '(021) 59498519', NULL),
(47, 'UDD PMI Kota Kupang', 'Jl. Veteran No.8 . Fataluli, Kupang - 85228', 'https://goo.gl/maps/2KbiyE6gFhK6hHK57', NULL, '(0380) 821773', NULL),
(48, 'UDD PMI Kota Balikpapan', 'Jl. Jend. Sudirmarman No. 01 RT.08 Kelandasan Ulu. Balikpapan - 76112', 'https://goo.gl/maps/miZF3Q4ib7jQZoBU8', 'Setiap hari 24 jam', '(0542) 425166', NULL),
(49, 'UDD PMI Provinsi Sulawesi Utara', 'D/a, Depan Gedung Poltekes Manado Jl. R.W. Mongosidi, Malalayang II, Manado - 95262', 'https://goo.gl/maps/cLMv9RT6soVzsBAt9', NULL, '(0431) 838321', NULL),
(50, 'UDD PMI Provinsi Sulawesi Selatan', 'Jl. Lanto Dg. Pasewang No. 55, Makassar', 'https://goo.gl/maps/WEi88g4TdzMod8mU8', 'Setiap hari 24 jam', '(0411) 3621954', NULL),
(51, 'UDD PMI Kota Tegal', 'Jalan Aiptu KS. Tubun No. 8, Randugunti, Tegal Selatan, Kejambon, Kec. Tegal Tim., Kota Tegal, Jawa Tengah 52131', 'https://goo.gl/maps/hxbi24DAWGvyuocF6', NULL, '(0283) 343244', NULL),
(52, 'UDD PMI Kabupaten Tegal', 'Jl. Gajah Mada, Prenam, Kalisapu, Kec. Slawi, Tegal, Jawa Tengah 52419', 'https://goo.gl/maps/q8QQLKz2qSNxESRg9', 'Senin - Sabtu : 07.30 - 16.00', '(0283) 4561201', 'kab_tegal@pmi.or.id'),
(53, 'UTD DINKES SULSEL', 'Jl. Perintis Kemerdekaan KM 11 Makassar', 'https://goo.gl/maps/yHJC4zKqpp32', 'Setiap hari (08.00 - 22.00)', NULL, NULL),
(54, 'UTD RSUD Umbu Rara Meha Waingapu', 'Jl. Ikan Kombong, Kambajawa, Kota Waingapu, Kabupaten Sumba Timur, Nusa Tenggara Tim.', 'https://goo.gl/maps/bVyftfLuLrinB79T9', 'Setiap Hari 24 Jam', NULL, NULL),
(55, 'UTD RSUD Dr.R.Soedjono Selong', 'Jl. Prof. M Yamin SH No.55, Khusus Kota Selong, Selong, Kabupaten Lombok Timur, Nusa Tenggara Bar. 83611', 'https://goo.gl/maps/mVTcJWBFXk5FcBU16', 'Setiap Hari 24 Jam', NULL, NULL),
(56, 'UTD RSUP. H.Adam Malik', 'Jl. Bunga Lau No.17, Kemenangan Tani, Kec. Medan Tuntungan, Kota Medan, Sumatera Utara 20136', 'https://goo.gl/maps/pEiVARpwAj6Gpg297', 'Setiap Hari 24 Jam', NULL, NULL),
(57, 'UTD RSUD dr. Abdul Aziz Singkawang', 'Jl. Dr. Sutomo No.28, Pasiran, Singkawang Bar., Kota Singkawang, Kalimantan Barat 79123', 'https://g.page/rsudaa?share', 'Setiap Hari 24 Jam', NULL, NULL),
(58, 'UTD RSUP Sanglah Denpasar', 'Jl. Diponegoro, Dauh Puri Klod, Kec. Denpasar Bar., Kota Denpasar, Bali 80113', 'https://goo.gl/maps/tXkASohcpLiiEp8k9', 'Setiap Hari 24 Jam', NULL, NULL),
(59, 'Rumah Sakit Umum Pusat Dr. M. Djamil Padang', 'Jl. Perintis Kemerdekaan, Sawahan Tim., Kec. Padang Tim., Kota Padang, Sumatera Barat 25171', 'https://goo.gl/maps/5mR4sckW6uBgZ5kJA', 'Setiap Hari 24 Jam', NULL, NULL),
(60, 'UTDRS Idaman Banjarbaru, Kalsel', 'Jl. Trikora No.115, Guntungmanggis, Kec. Landasan Ulin, Kota Banjar Baru, Kalimantan Selatan 70721', 'https://goo.gl/maps/dGT2eypkHg38VTKQA', 'Setiap Hari 24 Jam', NULL, NULL),
(61, 'UTDRS Kanker Dharmais, Jakarta', 'Jl. Letjen Jend Jl. Letjen S. Parman No.84-86, RT.4/RW.9, Kota Bambu Sel., Kec. Palmerah, Kota Jakarta Barat, Daerah Khusus Ibukota Jakarta 11420', 'https://goo.gl/maps/yhdUusEMh52r4pHAA', 'Senin - Jumat (07.30 - 16.00)', NULL, NULL),
(62, 'UTD RSUP Prof. Dr. R. D. Kandou Manado', 'Jalan R. Wolter Mongisidi_, Malalayang Satu Barat, Kec. Malalayang, Kota Manado, Sulawesi Utara 95000', 'https://goo.gl/maps/h8sHvRxctbGrZkAV7', 'Setiap Hari 24 Jam', NULL, NULL),
(63, 'UTD RSUD Dr. Kanujoso Djatiwibowo Balikpapan ', 'Jl. MT Haryono No.656, Batu Ampar, Kec. Balikpapan Utara, Kota Balikpapan, Kalimantan Timur 76115', 'https://goo.gl/maps/cKhgNVfZBZbFZTHB9', 'Setiap Hari 24 Jam', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `udds`
--
ALTER TABLE `udds`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `udds`
--
ALTER TABLE `udds`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
