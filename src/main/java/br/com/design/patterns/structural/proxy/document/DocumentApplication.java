package br.com.design.patterns.structural.proxy.document;

public class DocumentApplication {
    public static void main(String[] args) {
        Document adminDoc = new DocumentProxy("Confidential Report", "ADMIN");
        Document guestDoc = new DocumentProxy("Confidential Report", "GUEST");

        adminDoc.display();
        guestDoc.display();
    }
}

// The subject interface
interface Document {
    void display();
}

// The real subject that holds the sensitive document
class RealDocument implements Document {
    private String content;

    public RealDocument(String content) {
        this.content = content;
    }
    @Override
    public void display() {
        System.out.println("Displaying content: " + content);
    }
}

// The protection Proxy that adds access control
class DocumentProxy implements Document {
    private String content;
    private RealDocument realDocument;
    private String userRole;
    private static final String ADMIN = "ADMIN";

    public DocumentProxy(String content, String userRole) {
        this.content = content;
        this.userRole = userRole;
    }
    @Override
    public void display() {
        if(isAccessAllowed()) {
            if(realDocument == null) {
                realDocument = new RealDocument(content);
            }
            realDocument.display();
        } else {
            System.out.println("Access Denied: You do not have permission to view this document.");
        }
    }

    private boolean isAccessAllowed() {
        return ADMIN.equals(userRole);
    }
}