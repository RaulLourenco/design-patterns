package br.com.design.patterns.behavioral.mediator.chatroom;

public class ChatroomApplication {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoom();
        User alice = new ChatUser(mediator, "Alice");
        User bob = new ChatUser(mediator, "Bob");
        User charlie = new ChatUser(mediator, "Charlie");

        alice.send("Hello everyone!");
        bob.send("Hi Alice!");
        charlie.send("Hey folks!");
    }
}

// Mediator interface
interface ChatMediator {
    void showMessage(User user, String message);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {
    @Override
    public void showMessage(User user, String message) {
        System.out.println(user.getName() + ": " + message);
    }
}

// Abstract colleague - chat user
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void send(String message);
}

// Concrete colleague - chat user
class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }
    @Override
    public void send(String message) {
        mediator.showMessage(this, message);
    }
}