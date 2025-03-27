package br.com.design.patterns.structural.bridge.document;

// Client Code
public class DocumentApplication {
    public static void main(String[] args) {
        // Create a report rendered in HTML.
        Renderer htmlRenderer = new HtmlRenderer();
        Document report = new ReportDocument(htmlRenderer, "Quartely Financials");
        report.render();

        // Create an invoice rendered in PDF.
        Renderer pdfRenderer = new PdfRenderer();
        Document invoice = new InvoiceDocument(pdfRenderer, "Invoice #12345");
        invoice.render();
    }
}

// Implementation interface
interface Renderer {
    void renderText(String text);
}

// Concrete Implementation: HTML Renderer
class HtmlRenderer implements Renderer {
    @Override
    public void renderText(String text) {
        System.out.println("<html><body>" + text + "</body></html>");
    }
}

// Concrete Implementation: PDF Renderer
class PdfRenderer implements Renderer {
    @Override
    public void renderText(String text) {
        System.out.println("PDF document: " + text);
    }
}

// Abstraction
abstract class Document {
    protected Renderer renderer;

    public Document(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void render();
}

// Refined abstraction: Report
class ReportDocument extends Document {
    private String reportContent;
    public ReportDocument(Renderer renderer, String reportContent) {
        super(renderer);
        this.reportContent = reportContent;
    }
    @Override
    public void render() {
        renderer.renderText("Report: " + reportContent);
    }
}

// Refined abstraction: Invoice
class InvoiceDocument extends Document {
    private String invoiceDetails;

    public InvoiceDocument(Renderer renderer, String invoiceDetails) {
        super(renderer);
        this.invoiceDetails = invoiceDetails;
    }

    @Override
    public void render() {
        renderer.renderText("Invoice: " + invoiceDetails);
    }
}