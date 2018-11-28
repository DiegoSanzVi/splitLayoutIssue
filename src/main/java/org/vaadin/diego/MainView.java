package org.vaadin.diego;

import java.util.ArrayList;
import java.util.List;

import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends HorizontalLayout {

    private final Fairy fairy = Fairy.create();

    public MainView() {


        Grid<Person> grid = new Grid<>(Person.class);
        grid.setItems(createPeople(40));

        grid.getStyle().set("flex","1");

        Div form = createTextFields(40);

        form.getStyle().set("flex","1");

        SplitLayout splitLayout = new SplitLayout(grid,form);


        add(splitLayout);

        setSizeFull();

        Button button = new Button("action", event -> {
            Div newForm = createTextFields(40);
            splitLayout.addToSecondary(newForm);
            newForm.getStyle().set("flex","1");
        });

        add(button);
    }

    private Div createTextFields(int n) {

        Div div = new Div();

        for (int i = 0; i < n; i++){
            TextField tf = new TextField("rrr");
            div.add(tf);
        }

        return div;
    }

    private List<Person> createPeople(int n){
        List<Person> people = new ArrayList<>(n);
        for (int i = 0; i < n; i++){
            TextField tf = new TextField("rrr");
            people.add(fairy.person());
        }
        return people;
    }
}
