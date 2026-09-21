class Book {
    int bookId;
    String title;
    String author;
    double price;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " - Rs. " + price;
    }
}

public class LibraryManagementSystem {

    // Task 1
    public static int removeDuplicates(Book[] books, int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int uniqueIndex = 0;

        for (int i = 1; i < n; i++) {
            if (books[i].bookId != books[uniqueIndex].bookId) {
                uniqueIndex++;
                books[uniqueIndex] = books[i];
            }
        }

        return uniqueIndex + 1;
    }

    // Task 2
    public static void searchByTitle(Book[] books, int count, String query) {
        System.out.println("Search Results for '" + query + "':");
        String lowerCaseQuery = query.toLowerCase();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].title.toLowerCase().contains(lowerCaseQuery)) {
                System.out.println("- Found: [" + books[i].bookId + "] " + books[i].title + " (Rs. " + books[i].price + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found matching the query.");
        }
    }

    // Task 3
    public static void sortByPrice(Book[] books, int count) {
        int swapCount = 0;

        for (int i = 0; i < count - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < count; j++) {
                if (books[j].price < books[minIdx].price) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                Book temp = books[i];
                books[i] = books[minIdx];
                books[minIdx] = temp;
                swapCount++;
            }
        }

        System.out.println("Books Sorted by Price:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
        System.out.println("Total Swaps: " + swapCount);
    }

    // Task 4
    public static int searchByPrice(Book[] books, int count, double targetPrice) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (books[mid].price == targetPrice) {
                return mid;
            } else if (books[mid].price < targetPrice) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Task 5
    public static int minBooksForTargetCost(Book[] books, int count, double targetCost) {
        int minLength = Integer.MAX_VALUE;
        double currentSum = 0;
        int left = 0;

        for (int right = 0; right < count; right++) {
            currentSum += books[right].price;

            while (currentSum >= targetCost) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= books[left].price;
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        Book[] books = new Book[6];
        books[0] = new Book(101, "Data Structures", "Mark", 400.0);
        books[1] = new Book(101, "Data Structures", "Mark", 400.0); // Duplicate
        books[2] = new Book(102, "Java Basics", "James", 300.0);
        books[3] = new Book(103, "Python Guide", "Guido", 600.0);
        books[4] = new Book(104, "Database Systems", "Raghu", 500.0);
        books[5] = new Book(105, "Computer Networks", "Andrew", 700.0);

        int totalCount = books.length;

        // 1
        System.out.println("1. After Task 1 (Remove Duplicates):");
        int uniqueCount = removeDuplicates(books, totalCount);
        System.out.println("Unique Books Count: " + uniqueCount);
        System.out.println("Book List:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(books[i]);
        }
        System.out.println();

        // 2
        System.out.println("2. After Task 2 (Search Query: \"data\"):");
        searchByTitle(books, uniqueCount, "data");
        System.out.println();

        // 3
        System.out.println("3. After Task 3 (Sort by Price):");
        sortByPrice(books, uniqueCount);
        System.out.println();

        // 4
        System.out.println("4. After Task 4 (Search for Price: 500.0):");
        double targetPrice = 500.0;
        System.out.println("Searching for Price Rs. " + targetPrice + "...");
        int index = searchByPrice(books, uniqueCount, targetPrice);
        if (index != -1) {
            System.out.println("Result: Book found at index " + index + ": [" + books[index].bookId + "] " + books[index].title + " (Rs. " + books[index].price + ")");
        } else {
            System.out.println("Result: Book not found.");
        }
        System.out.println();

        // 5
        System.out.println("5. After Task 5 (Sliding Window for Target Cost S = Rs. 1000.0):");
        double targetCost = 1000.0;
        System.out.println("Finding minimum consecutive books whose total price >= Rs. " + targetCost + "...");
        int minBooks = minBooksForTargetCost(books, uniqueCount, targetCost);
        System.out.println("Minimum Consecutive Books Needed: " + minBooks);
    }
}
