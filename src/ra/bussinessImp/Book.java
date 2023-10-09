package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook {
    int bookId;
    String bookName;
    String title;
    int numberOfPages;
    float importPrice;
    float exportPrice;
    float interest;
    Boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập thông tin sách:");
        System.out.print("Mã sách: ");
        bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tên sách: ");
        bookName = scanner.nextLine();
        System.out.print("Tiêu đề sách: ");
        title = scanner.nextLine();
        System.out.print("Số trang sách: ");
        numberOfPages = scanner.nextInt();
        System.out.print("Giá nhập sách: ");
        importPrice = scanner.nextFloat();
        System.out.print("Giá bán sách: ");
        exportPrice = scanner.nextFloat();
        interest = exportPrice - importPrice;
        System.out.print("Trạng thái sách (true/false): ");
        bookStatus = scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("Thông tin sách:");
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tiêu đề sách: " + title);
        System.out.println("Số trang sách: " + numberOfPages);
        System.out.println("Giá nhập sách: " + importPrice);
        System.out.println("Giá bán sách: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Trạng thái sách: " + (bookStatus ? "Đang bán" : "Ngừng bán"));
    }
}
