package lv.javaguru.java2.views;

import lv.javaguru.java2.domain.AffairStatus;
import lv.javaguru.java2.services.AddAffairService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddAffairView {

    private AddAffairService addAffairService;

    public AddAffairView(AddAffairService addAffairService) {
        this.addAffairService = addAffairService;
    }

    public void execute() {
        System.out.println();
        System.out.println("Add affair to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter affair title:");
        String title = sc.nextLine();
        System.out.print("Enter affair description:");
        String description = sc.nextLine();
//        System.out.print("Enter affair deadline:");
//        String deadline = sc.nextLine();

        addAffairService.add(title, description);

        System.out.println("Add affair to list execution end!");
        System.out.println();
    }
}
