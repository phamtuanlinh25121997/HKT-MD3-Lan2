package ra.run;

import ra.bussiness.IBook;
import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    private static ArrayList<IBook> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputBooks(scanner);
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    sortBooksByProfit();
                    break;
                case 4:
                    deleteBookById(scanner);
                    break;
                case 5:
                    searchBooksByName(scanner);
                    break;
                case 6:
                    updateBookStatusById(scanner);
                    break;
                case 7:
                    System.out.println("Chương trình kết thúc.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void inputBooks(Scanner scanner) {
        System.out.print("Nhập số sách cần thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.inputData();
            bookList.add(book);
            System.out.println("Sách đã được thêm vào danh sách.");
        }
    }

    private static void displayAllBooks() {
        for (IBook book : bookList) {
            book.displayData();
        }
    }

    private static void sortBooksByProfit() {
        Collections.sort(bookList, new Comparator<IBook>() {
            @Override
            public int compare(IBook book1, IBook book2) {
                return Float.compare(((Book) book2).getInterest(), ((Book) book1).getInterest());
            }
        });
        System.out.println("Danh sách đã được sắp xếp theo lợi nhuận giảm dần.");
    }

    private static void deleteBookById(Scanner scanner) {
        System.out.print("Nhập mã sách cần xóa: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Iterator<IBook> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            IBook book = iterator.next();
            if (((Book) book).getBookId() == bookId) {
                iterator.remove();
                System.out.println("Đã xóa sách có mã " + bookId);
                return;
            }
        }

        System.out.println("Không tìm thấy sách có mã " + bookId);
    }

    private static void searchBooksByName(Scanner scanner) {
        System.out.print("Nhập tên sách cần tìm: ");
        String bookName = scanner.nextLine();
        boolean found = false;

        for (IBook book : bookList) {
            if (((Book) book).getBookName().equalsIgnoreCase(bookName)) {
                book.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách có tên " + bookName);
        }
    }

    private static void updateBookStatusById(Scanner scanner) {
        System.out.print("Nhập mã sách cần thay đổi trạng thái: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        for (IBook book : bookList) {
            if (((Book) book).getBookId() == bookId) {
                boolean currentStatus = ((Book) book).getBookStatus();
                ((Book) book).setBookStatus(!currentStatus);
                System.out.println("Trạng thái của sách có mã " + bookId + " đã thay đổi thành " + !currentStatus);
                return;
            }
        }

        System.out.println("Không tìm thấy sách có mã " + bookId);
    }
}
