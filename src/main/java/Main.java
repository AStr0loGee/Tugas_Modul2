import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main menu_1 = new Main();
        menu_1.menu();
    }
    //BookList array
    String[] book_Title = {"Dilan 1991\t","Laskar Pelangi", "Harry Potter"};
    String[] author = {"Pidi Baiq\t", "Andrea Hirata","J.K. Rowling"};
    String[] id_Book = {"0082-aiud-A73C", "384h-d3fr-scne", "sesi-3829-4ccd"};
    static int[] stock_Book = {5, 7, 3};

    //User student array
    String[] user_Student = {"Fajrisam Rifansyah", "202310370311447", "Teknik", "Informatika"};

    //Method Menu
    void menu(){
        //Membuat objek admin01 dari class Admin untuk bisa memanggil method input_Admin
        Admin admin01 = new Admin();
        //while jika input user tidak sesuai
        while (true) {
            //Tampilan dashboard awal menu
            System.out.println("\n==Library Students==");
            System.out.println("1.\tLogin as Student");
            System.out.println("2.\tLogin as Admin");
            System.out.println("3.\tEXIT");
            System.out.print("Pilih (1-3): ");
            //membuat scanner untuk input user
            Scanner scanner_menu= new Scanner(System.in);
            //input user
            int input_User = scanner_menu.nextInt();
            //percabangan kondisi menggunakan if, else-if, dan else.
            if (input_User == 1) {
                //Memanggil method input nim untuk user student
                input_NIM();
                break;
            } else if (input_User == 2) {
                //masuk ke menu admin
                admin01.input_Admin();
                break;
            } else if (input_User == 3) {
                //EXIT
                System.out.println("exit");
                break;
            }else {
                //input user tidak sesuai, loop nya ngulang lagi
                System.out.println("Input tidak valid!");
            }
        }
    }
    //method menu student
    void menu_Student(){
        //membuat objek class student agar bisa memanggil method log out ke class Main->menu student
        Student student = new Student();
        while (true) {
            //membuat scanner untuk input user di method student menu
            Scanner scanner_menu_student = new Scanner(System.in);
            //menampilkan fitur student menu
            System.out.println("\n==Students Menu==");
            System.out.println("1.\tBuku terpinjam");
            System.out.println("2.\tPinjam Buku");
            System.out.println("3.\tLog out");
            System.out.print("Pilih (1-3): ");
            //meminta input dari user
            int input_menuStudent = scanner_menu_student.nextInt();
                switch (input_menuStudent){
                    case 1:
                        //menampilkan daftar buku yang dipinjam.[ logic nya blum selesai ]
                        //memanggil method borrowed_Books
                        student.borrowed_Books();
                        break;
                    case 2:
                        //menampilkan daftar buku yang bisa dipinjam. [ di ambil dari displaybook method]
                        //display_Book Method
                        System.out.println("\nDisplay Books");
                        student.displayBooks();
                        break;
                    case 3:
                        //Log Out
                        System.out.println("\nBerhasil Log Out");
                        //Method call log out
                        student.log_Out();
                        break;
                    default:
                        //while loop ngulang sampe inputan bener
                        System.out.println("\nInvalid pilih antara (1-3)!!");
                }
                if (input_menuStudent <=3 && input_menuStudent >=1){
                    break;
                }
        }
    }
    //Method menu admin
    void menu_Admin(){
        //memnuat objek kelas_admin dari Admin class agar bisa memanggil method check_Admin
        Admin kelas_admin = new Admin();
        //Membuat scanner untuk input user menu admin
        Scanner scanner_menu_Admin = new Scanner(System.in);
            while (true){
                //Menampilkan Dashboard Menu admin
                System.out.println("\n==Menu Admin==");
                System.out.println("1.\tAdd Students");
                System.out.println("2.\tRegistered Students");
                System.out.println("3.\tLog Out");
                System.out.print("Pilih (1-3): ");
                //meminta input dari user untuk memilih fitur admin
                int input_MenuAdmin = scanner_menu_Admin.nextInt();
                    switch (input_MenuAdmin){
                        case 1:
                            //Fitur Add Student
                            System.out.println("\n~~Add Students~~");
                            //Method add_Student dari class Student
                            kelas_admin.add_Student();
                            break;
                        case 2:
                            //Method display_Students dari class Student
                            kelas_admin.display_Student();
                            break;
                        case 3:
                            //Log Out
                            System.out.println("\nBerhasil Log Out");
                            menu();
                            break;
                        default:
                            System.out.println("\nInvalid pilih antara (1-3)!!");
                    }
                    if (input_MenuAdmin>=1 && input_MenuAdmin <=3){
                        break;
                    }
            }
    }
    void input_NIM(){
            //membuat scanner untuk input nim
            Scanner scanner_inputNIM = new Scanner(System.in);
            //Meminta inputan user
            System.out.print("\nMasukkan NIM anda: ");
            String input_inputNIM = scanner_inputNIM.nextLine();
            //memanggil method check nim untuk menjadi validator nim yang di inputkan
            check_NIM(input_inputNIM);
    }
    void check_NIM(String NIM){
        if (NIM.equals(user_Student[1])) {
            menu_Student();
        }else{
            System.out.println("Invalid NIM");
            input_NIM();
        }
    }
}
class Student{
    //membuat objek class Main:
    //1. agar bisa memanggil method menu di class Main ke class Student
    Main menu_library = new Main();
    //atribut
    static String nama, fakultas, prodi, Nim;

    //method buku terpinjam
    void borrowed_Books(){
        System.out.println("\nBuku yang Dipinjam");
        System.out.println("1.\t----");
        System.out.println("2.\t----");
        System.out.println("3.\t----");
        menu_library.menu_Student();
    }

    //method display book, menampilkan buku-buku yang tersedia dan bisa dipinjam oleh student
    void displayBooks() {
        System.out.println("===========================================================================================================================================");
        System.out.println("|| No || Id Buku\t\t\t\t || Nama Buku\t\t\t || Author\t\t\t\t || Stock\t || ");
        for (int i = 0; i < 3; i++){
            System.out.printf("|| %d  || %s\t\t\t || %s\t\t || %s\t\t || %d\t\t || \n", i+1, menu_library.id_Book[i], menu_library.book_Title[i], menu_library.author[i], Main.stock_Book[i]);
        }
        System.out.println("===========================================================================================================================================");
        boolean kondisi = true;
        while (kondisi){
            //membuat objek scanner untuk menginput
            Scanner scanner_pinjam_Buku = new Scanner(System.in);
            System.out.print("Masukkan ID buku yang ingin di pinjam: ");
            //meminta input user untuk id buku yang ingin di pinjam
            String input_pinjamBuku = scanner_pinjam_Buku.nextLine();
                //menggunakan conditional switch untuk logic mengubah id buku inputan user menjadi judul buku
                switch (input_pinjamBuku) {
                    case "0082-aiud-A73C":
                        Main.stock_Book[0] -= 1;
                        System.out.println("Buku " + menu_library.book_Title[0] + " berhasil ditambahkan");
                        System.out.println("ID Buku = " + menu_library.id_Book[0]);
                        break;
                    case "384h-d3fr-scne":
                        Main.stock_Book[1] -= 1;
                        System.out.println("Buku " + menu_library.book_Title[1] + " berhasil ditambahkan");
                        System.out.println("ID Buku = " + menu_library.id_Book[1]);
                        break;
                    case "sesi-3829-4ccd":
                        Main.stock_Book[2] -= 1;
                        System.out.println("Buku " + menu_library.book_Title[2] + " berhasil ditambahkan");
                        System.out.println("ID Buku = " + menu_library.id_Book[2]);
                        break;
                    default:
                        System.out.println("invalid id Book");
                }
                menu_library.menu_Student();
                kondisi = false;
        }
    }
    //method log out untuk menu student
    void log_Out(){
      menu_library.menu();
    }
}
class Admin{
    String admin_Username = "fajri";
    String admin_Password = "1234";

    Main menu_pada_Main = new Main();
    Scanner scanner_add_student = new Scanner(System.in);

    void input_Admin(){
        System.out.print("Masukkan Usename: ");
        String user = scanner_add_student.nextLine();
        System.out.print("Masukkan Password: ");
        String passW = scanner_add_student.nextLine();
        check_Admin(user, passW);
    }

    void check_Admin(String user, String passw){
        if (user.equals(admin_Username) && passw.equals(admin_Password)){
            menu_pada_Main.menu_Admin();
        }else {
            System.out.println("Invalid Username or Password!");
            input_Admin();
        }
    }

    void display_Student(){
        System.out.println("\n~~Registered Students~~");
        System.out.println("Data Mahasiswa ke-1");
        System.out.println("Nama\t\t:"+ Student.nama);
        System.out.println("NIM\t\t\t:"+ Student.Nim);
        System.out.println("Fakultas\t:"+ Student.fakultas);
        System.out.println("Prodi\t\t:"+ Student.prodi);
        menu_pada_Main.menu_Admin();
    }
    void add_Student(){
        //Scanner untuk user input
        //Menampilkan fitur tambah data mahasiswa
        System.out.println("\nTambah data Mahasiswa");

        //input Nama user dengan logic panjang NIM harus 15 digit,
        //jika tidak maka akan terulang hingga benar
        System.out.print("Masukkan Nama: ");
        Student.nama = scanner_add_student.nextLine();
            while (true){
                System.out.print("Masukkan NIM: ");
                Student.Nim = scanner_add_student.nextLine();
                    if(Student.Nim.length()==15){
                        //keluar dari loop
                        break;
                    }else {
                        //loop ngulang
                        System.out.println("Panjang NIM 15 !!");
                    }
            }
        System.out.print("Masukkan Fakultas: ");
        Student.fakultas = scanner_add_student.nextLine();
        System.out.print("Masukkan Prodi: ");
        Student.prodi = scanner_add_student.nextLine();
        menu_pada_Main.menu_Admin();
    }
}
