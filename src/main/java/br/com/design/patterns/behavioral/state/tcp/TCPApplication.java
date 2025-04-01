package br.com.design.patterns.behavioral.state.tcp;

public class TCPApplication {
    public static void main(String[] args) {
        TCPConnection connection = new TCPConnection();
        connection.acknowledge(); //Trying to acknowledge on a closed connection
        connection.open(); // Opens the connection
        connection.open(); // Already open
        connection.acknowledge(); // Acknowledge data
        connection.close(); // Closes the connection
        connection.close(); // Already closed
    }
}

// The State interface for TCP connection
interface TCPState {
    void open(TCPConnection connection);
    void close(TCPConnection connection);
    void acknowledge(TCPConnection connection);
}

// Concrete State
class TCPClosed implements TCPState {
    @Override
    public void open(TCPConnection connection) {
        System.out.println("Opening connection...");
        connection.setState(new TCPEstablished());
    }

    @Override
    public void close(TCPConnection connection) {
        System.out.println("Connection already closed.");
    }

    @Override
    public void acknowledge(TCPConnection connection) {
        System.out.println("Cannot acknowledge. Connection is closed.");
    }
}

class TCPEstablished implements TCPState {
    @Override
    public void open(TCPConnection connection) {
        System.out.println("Connection already open.");
    }

    @Override
    public void close(TCPConnection connection) {
        System.out.println("Closing connection...");
        connection.setState(new TCPClosed());
    }

    @Override
    public void acknowledge(TCPConnection connection) {
        System.out.println("Acknowledging data.");
    }
}

// Context class
class TCPConnection {
    private TCPState state;

    public TCPConnection() {
        // Initially, the connection is closed
        state = new TCPClosed();
    }

    public void setState(TCPState state) {
        this.state = state;
    }
    public void open() {
        state.open(this);
    }
    public void close() {
        state.close(this);
    }
    public void acknowledge() {
        state.acknowledge(this);
    }
}