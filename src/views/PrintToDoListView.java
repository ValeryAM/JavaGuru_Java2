package views;

import domain.Affair;
import services.GetToDoListService;

public class PrintToDoListView {

    private GetToDoListService service;

    public PrintToDoListView(GetToDoListService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println();
        System.out.println("Print To-Do list to console execution start!");

        for (Affair affair : service.getAllAffairs()) {
            System.out.println(affair.getAffairTitle() + "[" + affair.getAffairDescription() + "]");
        }

        System.out.println("Print To-Do list to console execution end!");
        System.out.println();
    }
}
