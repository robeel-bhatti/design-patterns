package proxy;

import java.util.HashMap;
import java.util.Map;

public class ImageProxy implements Image {

    private final String filename;

    private final String accessLevel;

    private RealImage realImage = null;

    private static Map<String, String> cache = new HashMap<>();

    public ImageProxy(String filename, String accessLevel) {
        this.filename = filename;
        this.accessLevel = accessLevel;
    }

    @Override
    public String display() {
        System.out.println("[LOG] display() called for: " + this.filename);

        if (!this.accessLevel.equals("READ") && !this.accessLevel.equals("ADMIN")) {
            return "Access denied for " + this.filename;
        }

        if (cache.containsKey(this.filename)) {
            return cache.get(this.filename);
        }

        if (this.realImage == null) {
            this.realImage = new RealImage(this.filename);
        }

        String fileDisplay = this.realImage.display();
        cache.put(this.filename, fileDisplay);
        return fileDisplay;
    }

    @Override
    public int getFileSize() {
        System.out.println("[LOG] getFileSize() called for: " + this.filename);
        if (this.realImage == null) {
            return -1;
        }
        return this.realImage.getFileSize();
    }
}
