import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class server {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", (HttpExchange exchange) -> {
            String response = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Java Server</title>
                </head>
                <body style="font-family:Arial;text-align:center;margin-top:100px;">
                    <h1>🚀 Java Server is Running!</h1>
                    <h2>Deployment Successful</h2>
                </body>
                </html>
                """;

            exchange.getResponseHeaders().set("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Server started at http://localhost:8080");
    }
}
