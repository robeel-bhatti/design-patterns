package builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HttpRequest {

    private final String url;

    private final String method;

    private final Map<String, String> headers;

    private final String body;

    private final int timeoutMillis;

    private final boolean followRedirects;

    // private so no client can create instances directly
    // enforces going through the builder
    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;

        // create a new object in memory for this hashmap
        // so client cannot manipulate header map on builder
        // and thus affect the created instance headers attribute
        this.headers = new HashMap<>(builder.headers);
        this.body = builder.body;
        this.timeoutMillis = builder.timeoutMillis;
        this.followRedirects = builder.followRedirects;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public int getTimeoutMillis() {
        return timeoutMillis;
    }

    public boolean isFollowRedirects() {
        return followRedirects;
    }

    // inner static class that isolates all object building logic
    // and leaves object state + behavior logic in the outer class
    public static class Builder {

        private final String url;

        private final String method;

        private Map<String, String> headers = new HashMap<>();

        private String body = null;

        private int timeoutMillis = 3000;

        private boolean followRedirects = true;

        // required object fields go in constructor
        // to guarantee they are attributed to the initialized object
        public Builder(String url, String method) {
            if (url == null || url.isBlank()) {
                throw new IllegalArgumentException("url cannot be null or blank");
            }

            List<String> validMethods = List.of("GET", "POST", "PUT", "DELETE");
            if (!validMethods.contains(method)) {
                throw new IllegalArgumentException("Invalid method: " + method);
            }

            this.url = url;
            this.method = method;
        }

        // all methods implement the fluent interface pattern
        // to allow method chaining so client code looks cleaner
        public Builder header(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder body(String body) {
            if (Objects.equals(this.method, "GET") || Objects.equals(this.method, "DELETE")) {
                throw new IllegalArgumentException("Body cannot be provided when method is set to GET or DELETE");
            } else {
                this.body = body;
            }
            return this;
        }

        public Builder timeoutMillis(int timeoutMillis) {
            this.timeoutMillis = timeoutMillis;
            return this;
        }

        public Builder followRedirects(boolean followRedirects) {
            this.followRedirects = followRedirects;
            return this;
        }

        // return instance here
        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}
