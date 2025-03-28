package br.com.design.patterns.structural.proxy.image;

public class ImageApplication {
    public static void main(String[] args) {
        // Virtual proxy (lazy initialization)
        Image img = new ProxyImage("photo.jpg");
        Image anotherImg = new ProxyImage("another-photo.jpg");

        // The images are not loaded until display() is called
        img.display(); // Loads and display photo.jpg
        img.display(); // Already loaded, so just displays
        anotherImg.display(); // Loads and displays another-photo.jpg
    }
}

// The subject interface
interface Image {
    void display();
}

// The real subject that loads the image from disk
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName + " from disk...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// The Proxy that controls access to the RealImage
class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}