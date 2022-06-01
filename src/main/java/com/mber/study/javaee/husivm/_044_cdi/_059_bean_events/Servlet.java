package com.mber.study.javaee.husivm._044_cdi._059_bean_events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("059")
public class Servlet extends HttpServlet {
    @Inject
    private BookService service;
    @Inject
    Subscriber subscriber;

    @Override
    protected void doGet(HttpServletRequest req, @NonNull HttpServletResponse resp) throws IOException {
        var one = new Book("one");
        var two = new Book("two");
        var three = new Book("three");
        service.addBook(one);
        service.addBook(two);
        service.addBook(three);
        service.removeBook(one);
        resp.getWriter().write(String.valueOf(subscriber.getList().size()));
    }
}

@Qualifier
@Retention(RUNTIME)
@Target({PARAMETER, FIELD})
@interface Add {
}

@Qualifier
@Retention(RUNTIME)
@Target({PARAMETER, FIELD})
@interface Remove {
}

@AllArgsConstructor
class Book {
    private @Getter String name;
}

class BookService {
    @Inject @Add
    private Event<Book> addEvent;
    @Inject @Remove
    private Event<Book> removeEvent;

    public void addBook(@NonNull Book book) {
        System.out.println(book.getName() + " book was added");
        addEvent.fire(book);
    }

    public void removeBook(@NonNull Book book) {
        System.out.println(book.getName() + " book was deleted");
        removeEvent.fire(book);
    }
}

@Singleton
class Subscriber {
    private final @Getter List<Book> list = new ArrayList<>();

    public void add(@Observes @Add @NonNull Book book) {
        list.add(book);
        System.out.println(book.getName() + " added to list");
    }

    public void remove(@Observes @Remove Book book) {
        list.remove(book);
        System.out.println(book.getName() + " removed from list");
    }
}

