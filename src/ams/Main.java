import java.util.Scanner;

public class Main {
    private static Forum forum;
    private static Scanner scanner;

    public static void main(String[] args) {
        forum = new Forum();
        scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createPost();
                    break;
                case 2:
                    displayAllPosts();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("----- Forum Menu -----");
        System.out.println("1. Create a new post");
        System.out.println("2. Display all posts");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createPost() {
        System.out.print("Enter the title of the post: ");
        String title = scanner.nextLine();

        System.out.print("Enter the content of the post: ");
        String content = scanner.nextLine();

        System.out.print("Enter the author name: ");
        String author = scanner.nextLine();

        Post post = new Post(title, content, author);
        forum.addPost(post);

        System.out.println("Post created successfully!");
        System.out.println();
    }

    private static void displayAllPosts() {
        if (forum.getPosts().isEmpty()) {
            System.out.println("No posts available.");
        } else {
            System.out.println("----- All Posts -----");
            for (Post post : forum.getPosts()) {
                System.out.println(post);
            }
        }
        System.out.println();
    }
}
