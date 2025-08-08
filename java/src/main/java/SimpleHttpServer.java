import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("HTTP-сервер запущен на порту " + port);

        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClientRequest(clientSocket);
            }
        } finally {
            serverSocket.close();
        }
    }

    private static void handleClientRequest(Socket clientSocket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

        String requestLine = reader.readLine(); // Читаем первую строку запроса (метод, URL, протокол)
        System.out.println(requestLine); // Логируем запрос

        // Отправляем ответ клиенту
        writer.write("HTTP/1.1 200 OK\r\n");
        writer.write("Content-Type: text/html; charset=utf-8\r\n");
        writer.write("\r\n"); // Пустая строка обозначает конец заголовков
        writer.write(inputArgumentFromMxBean().toString());
        writer.flush();
        clientSocket.close();
    }

    private static List<String> inputArgumentFromMxBean() {
        RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(mxBean.getInputArguments());
        return mxBean.getInputArguments();
    }
}
