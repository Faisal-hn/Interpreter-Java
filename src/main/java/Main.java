import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // You can use print statements as follows for debugging, they'll be visible when running tests.
        System.err.println("Logs from your program will appear here!");

        if (args.length < 2) {
            System.err.println("Usage: ./your_program.sh tokenize <filename>");
            System.exit(1);
        }

        String command = args[0];
        String filename = args[1];

        if (!command.equals("tokenize")) {
            System.err.println("Unknown command: " + command);
            System.exit(1);
        }

        String fileContents = "";
        try {
            Path path = Paths.get("src/main/java/scanning/" + filename);
            System.out.println(path.toAbsolutePath());
            byte[] bytes = Files.readAllBytes(path);
            fileContents = new String(bytes, Charset.defaultCharset());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        // Uncomment this block to pass the first stage

        if (fileContents.length() > 0) {
//       throw new RuntimeException("Scanner not implemented");
            run(fileContents);
        } else {
            System.out.println("EOF  null"); // Placeholder, remove this line when implementing the scanner
        }
    }

    private static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        // For now, just print the tokens.
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
