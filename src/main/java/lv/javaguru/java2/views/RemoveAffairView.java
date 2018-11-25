package lv.javaguru.java2.views;

import lv.javaguru.java2.services.remove.RemoveAffairRequest;
import lv.javaguru.java2.services.remove.RemoveAffairResponse;
import lv.javaguru.java2.services.remove.RemoveAffairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveAffairView {

    @Autowired
    private RemoveAffairService removeAffairService;

    private RemoveAffairResponse removeAffairResponse;

    public RemoveAffairView(RemoveAffairService removeAffairService) {
        this.removeAffairService = removeAffairService;
    }

    public void execute() {
        System.out.println();
        System.out.println("Remove affair from To-Do list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter affair title:");
        final String title = sc.nextLine();

        RemoveAffairRequest request = new RemoveAffairRequest(title);
        removeAffairResponse = removeAffairService.removeAffair(request);
        boolean isRemoved = removeAffairResponse.isSuccess();

        if (isRemoved) {
            System.out.println("main.java.lv.javaguru.java2.domain.Affair with title " + title + " has been found and removed from the list!");
        } else {
            System.out.println("main.java.lv.javaguru.java2.domain.Affair with title " + title + " has not been found and removed from the list!");
        }

        System.out.println("Remove affair from To-Do list execution end!");
        System.out.println();
    }
}
