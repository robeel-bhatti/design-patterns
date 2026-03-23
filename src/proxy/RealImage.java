package proxy;

public class RealImage implements Image {

    private final String filename;
    private final byte[] data;

    public RealImage(String filename) {
        this.filename = filename;
        // Simulate an expensive disk/network load
        System.out.println("[RealImage] Loading image from disk: " + filename);
        this.data = ("raw-bytes-of-" + filename).getBytes();
    }

    @Override
    public String display() {
        return "Displaying " + filename + " (" + data.length + " bytes)";
    }

    @Override
    public int getFileSize() {
        return data.length;
    }
}
