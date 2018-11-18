package lv.javaguru.java2.views;

import lv.javaguru.java2.services.add.AddAffairService;
import lv.javaguru.java2.services.add.AddAffairRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddAffairView {

    @Autowired
    private AddAffairService addAffairService;

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
        AddAffairRequest request = new AddAffairRequest(title, description);
        addAffairService.addAffair(request);

        System.out.println("Add affair to list execution end!");
        System.out.println();
    }
}
