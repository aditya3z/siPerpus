-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Okt 2019 pada 03.40
-- Versi server: 10.1.30-MariaDB
-- Versi PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `idanggota` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `telepon` varchar(25) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `program_studi` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`idanggota`, `nama`, `alamat`, `telepon`, `gender`, `program_studi`) VALUES
(3, 'Nanda Agustini', 'Buring Malang', '08567456778', 'Perempuan', '8'),
(4, 'Muhammad Alrizqy', 'Sawojajar, Malang', '08123456755', 'Laki-laki', '7'),
(8, 'Soyyid Darmawan', 'Pakis,Malang', '081236714', 'Laki-laki', '7'),
(9, 'Fenty Trisna', 'Muharto, Malang', '0897651235', 'Perempuan', '8'),
(10, 'Aprilia Anggraeni', 'Lesanpuro, Malang', '', 'Perempuan', '7'),
(11, 'Amalina Puspitasari', 'Bumiayu, Malang', '087653212', 'Perempuan', '7'),
(12, 'Yayuk Wulandari', 'Buring, Malang', '081234656432', 'Perempuan', '9'),
(13, 'Mercury Ara Prima', 'Madyopuro, Malang', '089637353', 'Perempuan', '9'),
(14, 'Bagas Adi Prayogo', 'Buring, Malang', '086543426', 'Laki-laki', '9'),
(15, 'Rafid Hibatulloh', 'Sekarpuro, Malang', '0875324257', 'Laki-laki', '9'),
(16, 'Januar Ramadhan', 'Sulfat, Malang', '08234566433', 'Laki-laki', '8'),
(17, 'Yanuar Ramadhan', 'Sawojajar,Malang', '0863252768', 'Laki-laki', '8'),
(18, 'Zulfi Ihza', 'Kedungkandang, Malang', '0812345769', 'Perempuan', '8'),
(19, 'Bagas Ramadhani', 'Bunul,Malang', '0891234657', 'Laki-laki', '8'),
(20, 'Ervan Puta', 'Polehan, Malang', '0854325647', 'Laki-laki', '7'),
(21, 'Patria Nurahmat', 'Tajinan, Malang', '08653362344', 'Laki-laki', '7'),
(22, 'Nanang Saiful Rizal', 'Buring, Malang', '08712345678', 'Laki-laki', '7'),
(23, 'Intan Putri', 'Wonokoyo, Malang', '08132467432', 'Perempuan', '8'),
(24, 'Hendro Kartika', 'Sekarpuro, Malang', '08123465673', 'Laki-laki', '9'),
(25, 'Refido Putra Wijaya', 'Bumiayu, Malang', '08123456757', 'Laki-laki', '8'),
(26, 'Ilyas Puta', 'Gadang, Malang', '08976654657', 'Laki-laki', '8'),
(27, 'Husni Mubarok', 'Madyopuro,Malang', '0857345786', 'Laki-laki', '8');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `idbuku` int(11) NOT NULL,
  `idkategori` int(11) NOT NULL,
  `judul` varchar(255) NOT NULL,
  `penerbit` varchar(255) NOT NULL,
  `penulis` varchar(255) NOT NULL,
  `tahun_terbit` int(11) NOT NULL,
  `total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`idbuku`, `idkategori`, `judul`, `penerbit`, `penulis`, `tahun_terbit`, `total`) VALUES
(30, 46, 'Penjas Orkes', 'Yrama Widya', 'Khoirul Hadziq', 2019, 3),
(31, 46, 'Matematika', 'Erlangga', 'diknas dan kementrian', 2018, 36),
(32, 37, 'Orang orang biasa', 'Bintang Pustaka', 'Andrea Hirata', 2019, 90),
(33, 37, 'Allah Tidak Cerewet seperti kita', 'Noura Book Publising', 'Emha Ainun Nadjib', 2019, 60),
(34, 45, 'Budaya dan Arkeologi', 'Bentang Pustaka', 'Myrtha Soeroyte', 2013, 10),
(37, 45, 'Sang Patriot', 'Kompas', 'Rooswidiati Tendean', 2019, 28),
(38, 46, 'Bupelas Matematika Kelas 8', 'Genta Group Pruduction', 'Tim Master Eduka', 2019, 100),
(39, 39, 'Pelajaran Agama Islam', 'Gema Insani', 'Prof. Dr. Hamka', 2019, 77),
(40, 46, 'Bicara Itu Ada Seninya', 'Buana Ilmu Polpuler', 'Oh Su Hyang', 2018, 3),
(41, 39, 'Qalam', 'Qalam', 'Dr. Muhammad Al-Dabisi', 2018, 85),
(42, 37, 'Detective Conan', 'Elex Media Kompetindo', 'Aoyama Gosho', 2019, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `idkategori` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`idkategori`, `nama`, `keterangan`) VALUES
(36, 'Umum', 'informasi umum'),
(37, 'Novel', 'koleksi buku yang berisi ceriita cerita novel'),
(39, 'Agama', 'Koleksi buku yang berisi tentang ajaran agama'),
(40, 'Sosial', 'Koleksi buku yang berisi ilmu sosial, sosiologi, dan antropologi'),
(41, 'Bahasa', 'Koleksi buku yang berisi pelajaran bahasa'),
(42, 'Sains dan Matematika', 'Koleksi buku yang berisi tentang pelajaran sains dan matematika'),
(43, 'Teknologi', 'Koleksi buku yang berisi teknologi dan kesehatan'),
(44, 'Seni dan Rekreasi', 'Koleksi buku yang berisi kesenian dan rekreasi'),
(45, 'Sejarah dan Geografi', 'Koleksi buku yang berisi sejarah dan goegrafi'),
(46, 'Pendidikan', 'Koleksi buku yang berisi Pendidikan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('hernanda', 'hernanda'),
('alfarizi', 'alfarizi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `idpeminjaman` int(11) NOT NULL,
  `idanggota` int(11) NOT NULL,
  `idbuku` int(11) NOT NULL,
  `tanggalpinjam` date NOT NULL,
  `tanggalkembali` date DEFAULT NULL,
  `denda` int(10) DEFAULT NULL,
  `total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`idpeminjaman`, `idanggota`, `idbuku`, `tanggalpinjam`, `tanggalkembali`, `denda`, `total`) VALUES
(1, 9, 37, '2019-01-13', '2019-01-20', 0, 1),
(3, 15, 31, '2019-04-08', '2019-04-14', 0, 2),
(4, 13, 41, '2019-02-09', '2019-02-20', 20000, 1),
(5, 4, 34, '2019-02-09', NULL, 0, 2),
(6, 8, 37, '2019-07-07', '2019-07-22', 40000, 1),
(7, 20, 39, '2019-09-08', '2019-09-17', 10000, 1),
(8, 13, 39, '2019-06-07', NULL, NULL, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `idpetugas` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `telepon` int(20) NOT NULL,
  `gender` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`idpetugas`, `nama`, `alamat`, `telepon`, `gender`) VALUES
(2, 'Muhammad Alfarizi', 'Bumiayu, Malang', 859331160, 'Laki-laki'),
(3, 'Hernanda Candra Prasetya', 'Ngadirejo, Trenggalek', 838464344, 'Laki-laki');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`idanggota`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`idbuku`),
  ADD KEY `idkategori` (`idkategori`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`idkategori`);

--
-- Indeks untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`idpeminjaman`),
  ADD KEY `idanggota` (`idanggota`),
  ADD KEY `null` (`idbuku`) USING BTREE;

--
-- Indeks untuk tabel `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`idpetugas`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `anggota`
--
ALTER TABLE `anggota`
  MODIFY `idanggota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT untuk tabel `buku`
--
ALTER TABLE `buku`
  MODIFY `idbuku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT untuk tabel `kategori`
--
ALTER TABLE `kategori`
  MODIFY `idkategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `idpeminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `petugas`
--
ALTER TABLE `petugas`
  MODIFY `idpetugas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `buku_ibfk_1` FOREIGN KEY (`idkategori`) REFERENCES `kategori` (`idkategori`);

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`idanggota`) REFERENCES `anggota` (`idanggota`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`idbuku`) REFERENCES `buku` (`idbuku`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
