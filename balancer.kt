import com.sun.net.httpserver.HttpServer
import com.sun.net.httpserver.HttpExchange
import java.net.HttpURLConnection
import java.net.InetSocketAddress
import java.net.URL
import java.io.InputStream
import java.io.OutputStream
import java.util.concurrent.Executors

// List of backend servers
val backends = listOf("http://localhost:8001", "http://localhost:8002")
var currentIndex = 0

fun nextBackend(): String {
    val backend = backends[currentIndex]
    currentIndex = (currentIndex + 1) % backends.size
    return backend
}

fun main() {
    val port = 8080
    val server = HttpServer.create(InetSocketAddress(port), 0)
    server.executor = Executors.newFixedThreadPool(10)

    server.createContext("/") { exchange ->
        try {
            val backendUrl = nextBackend() + exchange.requestURI.toString()
            val url = URL(backendUrl)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = exchange.requestMethod

            // Forward request headers
            exchange.requestHeaders.forEach { key, values ->
                values.forEach { value ->
                    conn.setRequestProperty(key, value)
                }
            }

            // Forward request body (for POST/PUT)
            if (exchange.requestMethod in listOf("POST", "PUT", "PATCH")) {
                conn.doOutput = true
                exchange.requestBody.use { input ->
                    conn.outputStream.use { output -> input.copyTo(output) }
                }
            }

            // Get response
            val responseCode = conn.responseCode
            val responseStream: InputStream = if (responseCode < 400) conn.inputStream else conn.errorStream

            // Send response back to client
            exchange.sendResponseHeaders(responseCode, conn.contentLengthLong)
            exchange.responseBody.use { output -> responseStream.copyTo(output) }

        } catch (e: Exception) {
            e.printStackTrace()
            val msg = "Backend error: ${e.message}".toByteArray()
            exchange.sendResponseHeaders(500, msg.size.toLong())
            exchange.responseBody.use { it.write(msg) }
        }
    }

    server.start()
    println("Load balancer running on http://localhost:$port")
}
