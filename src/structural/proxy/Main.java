package structural.proxy;

public class Main {

    public static void main(String[] args) {

        // --- Lazy loading ---
        // Creating the proxy should NOT load the real image yet.
        // You should NOT see "[RealImage] Loading image from disk: ..." here.
        Image photo = new ImageProxy("vacation.png", "READ");
        Image icon  = new ImageProxy("icon.png", "READ");
        System.out.println("Proxies created. No images loaded yet.\n");

        // --- First display triggers the real load ---
        // Expected output:
        //   [LOG] display() called for: vacation.png
        //   [RealImage] Loading image from disk: vacation.png
        //   Displaying vacation.png (25 bytes)
        System.out.println(photo.display());
        System.out.println();

        // --- Second display uses the cache (no reload) ---
        // Expected: same display output, but NO "[RealImage] Loading..." line
        System.out.println(photo.display());
        System.out.println();

        // --- getFileSize before loading ---
        // icon has never been displayed, so getFileSize should return -1
        //   [LOG] getFileSize() called for: icon.png
        //   -1
        System.out.println(icon.getFileSize());
        System.out.println();

        // --- getFileSize after loading ---
        // After displaying icon, getFileSize should return the real size
        icon.display();
        System.out.println(icon.getFileSize());
        System.out.println();

        // --- Access control ---
        // A "GUEST" user should be denied
        Image restricted = new ImageProxy("secret.png", "GUEST");
        // Expected: [LOG] display() called for: secret.png
        //           Access denied for secret.png
        System.out.println(restricted.display());
        System.out.println();

        // An "ADMIN" user should be allowed
        Image admin = new ImageProxy("secret.png", "ADMIN");
        System.out.println(admin.display());
    }
}
