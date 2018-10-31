package views;

import services.RemoveAffairService;

import java.util.Scanner;

public class RemoveAffairView {

    private RemoveAffairService removeAffairService;

    public RemoveAffairView(RemoveAffairService removeAffairService) {
        this.removeAffairService = removeAffairService;
    }

    public void execute() {
        System.out.println();
        System.out.println("Remove affair from To-Do list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter affair title:");
        final String title = sc.nextLine();

        boolean isRemoved = removeAffairService.remove(title);

        if (isRemoved) {
            System.out.println("domain.Affair with title " + title + " has been found and removed from the list!");
        } else {
            System.out.println("domain.Affair with title " + title + " has not been found and removed from the list!");
        }

        System.out.println("Remove affair from To-Do list execution end!");
        System.out.println();
    }
}
