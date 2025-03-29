package br.com.design.patterns.behavioral.observer.news;

import java.util.ArrayList;
import java.util.List;

public class NewsApplication {
    public static void main(String[] args) {
        NewsPublisher agency = new NewsAgency();
        NewsObserver alice = new Subscriber("Alice");
        NewsObserver bob = new Subscriber("Bob");

        agency.addSubscriber(alice);
        agency.addSubscriber(bob);

        // Publish news and notify subscribers
        agency.publishNews("Breaking News: Observer pattern in action!");
        agency.publishNews("Update: Observer pattern simplifies decoupled communication.");
    }
}

// Observer interface
interface NewsObserver {
    void update(String news);
}

// Subject interface
interface NewsPublisher {
    void addSubscriber(NewsObserver observer);
    void removeSubscriber(NewsObserver observer);
    void notifySubscribers();
    void publishNews(String news);
}

// Concrete Subject
class NewsAgency implements NewsPublisher {
    private List<NewsObserver> subscribers;
    private String latestNews;

    public NewsAgency() {
        subscribers = new ArrayList<>();
    }
    @Override
    public void addSubscriber(NewsObserver observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeSubscriber(NewsObserver observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NewsObserver subscriber : subscribers) {
            subscriber.update(latestNews);
        }
    }

    @Override
    public void publishNews(String news) {
        this.latestNews = news;
        notifySubscribers();
    }
}

// Concrete Observer
class Subscriber implements NewsObserver {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }
    @Override
    public void update(String news) {
        System.out.println(name + " received news update: " + news);
    }
}