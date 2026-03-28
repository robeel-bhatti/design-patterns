package creational.builder;

public class Main {

    public static void main(String[] args) {
        // Test 1: POST request using all creational.builder methods
        HttpRequest request = new HttpRequest.Builder("https://api.example.com/users", "POST")
                .header("Authorization", "Bearer abc")
                .header("Content-Type", "application/json")
                .body("{\"name\": \"test\"}")
                .timeoutMillis(5000)
                .followRedirects(false)
                .build();

        assert request.getUrl().equals("https://api.example.com/users");
        assert request.getMethod().equals("POST");
        assert request.getHeaders().get("Authorization").equals("Bearer abc");
        assert request.getHeaders().size() == 2;
        assert request.getBody().equals("{\"name\": \"test\"}");
        assert request.getTimeoutMillis() == 5000;
        assert !request.isFollowRedirects();
        System.out.println("Test 1 passed");

        // Test 2: GET with defaults (no body, no headers, default timeout/redirects)
        HttpRequest get = new HttpRequest.Builder("https://api.example.com/users", "GET").build();
        assert get.getBody() == null || get.getBody().isEmpty();
        assert get.getHeaders().isEmpty();
        assert get.getTimeoutMillis() == 3000;
        assert get.isFollowRedirects();
        System.out.println("Test 2 passed");

        // Test 3: null URL should throw
        try {
            new HttpRequest.Builder(null, "GET").build();
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3 passed");
        }

        // Test 4: blank URL should throw
        try {
            new HttpRequest.Builder("   ", "GET").build();
        } catch (IllegalArgumentException e) {
            System.out.println("Test 4 passed");
        }

        // Test 5: invalid method should throw
        try {
            new HttpRequest.Builder("https://example.com", "PATCH").build();
        } catch (IllegalArgumentException e) {
            System.out.println("Test 5 passed");
        }

        // Test 6: GET with body should throw
        try {
            new HttpRequest.Builder("https://example.com", "GET")
                    .body("oops")
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Test 6 passed");
        }

        // Test 7: DELETE with body should throw
        try {
            new HttpRequest.Builder("https://example.com", "DELETE")
                    .body("also oops")
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Test 7 passed");
        }

        // Test 8: PUT with body is valid
        HttpRequest put = new HttpRequest.Builder("https://example.com/users/1", "PUT")
                .body("{\"name\": \"updated\"}")
                .build();
        assert put.getBody().equals("{\"name\": \"updated\"}");
        System.out.println("Test 8 passed");

        System.out.println("\nAll tests passed!");
    }
}
