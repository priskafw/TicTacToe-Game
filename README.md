Aplikasi Game Tic-Tac-Toe Sederhana dengan Java Swing, Login, dan Statistik

Informasi Mahasiswa
Nama: Priska Fiantika Widyatama
NRP: 5026251170
Kelas: A

Deskripsi Project
Project ini adalah aplikasi game Tic-Tac-Toe sederhana yang dibuat menggunakan Java Swing sebagai tampilan grafisnya. Pemain harus login terlebih dahulu menggunakan username dan password yang tersimpan di database MySQL. Setelah login, pemain bisa bermain Tic-Tac-Toe melawan komputer di papan berukuran 3x3. Setiap hasil permainan (menang, kalah, atau seri) akan otomatis tersimpan ke database dan bisa dilihat di menu statistik. Pemain juga bisa melihat 5 pemain dengan poin tertinggi di menu Top 5 Pemain.

Fitur Aplikasi
- Login menggunakan data dari database
- Bermain Tic-Tac-Toe melawan komputer menggunakan tampilan Swing GUI
- Mencatat jumlah menang, kalah, seri, dan total poin setiap pemain
- Menampilkan statistik pribadi pemain
- Menampilkan 5 pemain terbaik menggunakan JTable
- Pilihan main lagi atau kembali ke menu setelah game selesai
- Konfirmasi sebelum keluar dari aplikasi

Database
Database yang digunakan: MySQL
Nama database: game_project
Nama tabel: players

Kolom tabel:
- id — nomor unik setiap pemain (auto increment)
- username — nama pengguna untuk login
- password — kata sandi untuk login
- wins — jumlah kemenangan
- losses — jumlah kekalahan
- draws — jumlah seri
- score — total poin (menang +10, seri +3, kalah +0)

Cara Menjalankan Program
1. Buat database dengan menjalankan file schema.sql di MySQL.
2. Buka project di IntelliJ IDEA.
3. Download file mysql-connector-j.jar dari https://dev.mysql.com/downloads/connector/j/
4. Tambahkan file .jar ke folder lib, lalu klik kanan dan pilih Add as Library.
5. Buka DatabaseManager.java, isi URL, username, dan password sesuai konfigurasi MySQL kamu.
6. Pastikan MySQL sudah berjalan.
7. Jalankan Main.java.
8. Login menggunakan username: student1 dan password: 12345.

Penjelasan Class

- Main: Class pertama yang dijalankan saat program dimulai. Tugasnya membuka tampilan Login Window.
- DatabaseManager: Bertugas menghubungkan program Java ke database MySQL menggunakan JDBC. Semua koneksi database dilakukan melalui class ini.
- Player: Class model yang menyimpan data pemain seperti id, username, jumlah menang, kalah, seri, dan total poin. Class ini tidak terhubung langsung ke database, hanya menyimpan data sementara.
- PlayerService: Bertugas mengurus semua operasi database yang berhubungan dengan pemain, yaitu login, update statistik setelah game selesai, mengambil data pemain terbaru, dan mengambil data top 5 pemain.
- GameLogic: Berisi semua aturan permainan Tic-Tac-Toe, yaitu validasi gerakan, pengecekan pemenang (baris, kolom, diagonal), pengecekan seri, dan pemilihan langkah komputer secara acak.
- LoginFrame: Tampilan window untuk input username dan password. Jika login berhasil akan membuka MainMenuFrame, jika gagal akan menampilkan pesan error.
- MainMenuFrame: Tampilan menu utama setelah login berhasil. Berisi tombol untuk mulai game, lihat statistik, lihat top 5 pemain, dan keluar.
- GameFrame: Tampilan window untuk bermain Tic-Tac-Toe. Berisi papan 3x3 berupa 9 tombol. Pemain memakai simbol X dan komputer memakai simbol O. Setelah game selesai, hasil langsung disimpan ke database.
- StatisticsFrame: Tampilan window yang menampilkan statistik pribadi pemain yang sedang login, yaitu jumlah menang, kalah, seri, dan total poin yang diambil langsung dari database.
- TopScorersFrame: Tampilan window yang menampilkan 5 pemain dengan poin tertinggi dalam bentuk tabel menggunakan JTable. Data diambil langsung dari database dan diurutkan berdasarkan poin tertinggi.

Screenshots
[Tambahkan screenshot login window di sini]

[Tambahkan screenshot game window di sini]

[Tambahkan screenshot top scorers window di sini]

Link Video
YouTube: [ISI LINK YOUTUBE KAMU]
