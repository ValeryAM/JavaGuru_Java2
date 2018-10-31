package views;

import domain.AffairStatus;
import services.AddAffairService;

import java.util.Scanner;

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
        System.out.print("Enter affair deadline:");
        String deadline = sc.nextLine();

        addAffairService.add(title, description, deadline, AffairStatus.NOT_STARTED);

        System.out.println("Add affair to list execution end!");
        System.out.println();
    }
}
