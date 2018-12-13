package lv.javaguru.java2.views;

import lv.javaguru.java2.domain.Affair;
import lv.javaguru.java2.services.affairs.get.GetToDoListService;
import org.springframework.stereotype.Component;

@Component
public class PrintToDoListView {

    private GetToDoListService service;

    public PrintToDoListView(GetToDoListService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println();
        System.out.println("Print To-Do list to console execution start!");

        for (Affair affair : service.getAllAffairs()) {
            System.out.println(affair.getTitle() + "[" + affair.getDescription() + "]");
        }

        System.out.println("Print To-Do list to console execution end!");
        System.out.println();
    }
}
