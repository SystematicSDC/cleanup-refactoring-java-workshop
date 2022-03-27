package com.systematic.workshop.coderefactoring.solid.ocp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static java.util.Collections.singletonList;

/**
 * Consider this executor of HTTP requests.
 * <p>
 * We "closed" the actual execution in a fixed algorithm and left some code "to be completed" by other implementations.
 * This is also sometimes recognized as the Template method design pattern https://en.wikipedia.org/wiki/Template_method_pattern
 * <p>
 * https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle
 */
public class HttpClientWithExtensionPoints {

    static class MyHttpClient {
        // Closed for modification - final!
        final HttpResponse<String> execute(HttpRequest httpRequest) throws IOException, InterruptedException {
            interceptPreExecute(httpRequest);
            HttpClient internalHttpClient = HttpClient.newHttpClient();
            HttpResponse<String> httpResponse = internalHttpClient.send(httpRequest, BodyHandlers.ofString());
            interceptPostExecute(httpRequest, httpResponse);
            return httpResponse;
        }

        protected void interceptPreExecute(HttpRequest httpRequest) {
            // Nothing in the barebone, but open for extension
        }

        protected void interceptPostExecute(HttpRequest httpRequest,
                                            HttpResponse<String> httpResponse) {
            // Nothing in the barebone, but open for extension
        }
    }

    static class AuthenticatedHttpClient extends MyHttpClient {
        @Override
        protected void interceptPreExecute(HttpRequest httpRequest) {
            httpRequest.headers().map().put("Authorization", singletonList("secretCrypto_hackz0r"));
        }
    }

    static class ResponseLoggingHttpClient extends MyHttpClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(ResponseLoggingHttpClient.class);

        @Override
        protected void interceptPostExecute(HttpRequest httpRequest,
                                            HttpResponse<String> httpResponse) {
            LOGGER.info("Got response from the server with status code {}", httpResponse.statusCode());
        }
    }
}
