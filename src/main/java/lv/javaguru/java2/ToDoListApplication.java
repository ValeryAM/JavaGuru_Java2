package lv.javaguru.java2;


import lv.javaguru.java2.services.AddAffairService;
import lv.javaguru.java2.services.GetToDoListService;
import lv.javaguru.java2.services.RemoveAffairService;
import lv.javaguru.java2.views.AddAffairView;
import lv.javaguru.java2.views.PrintToDoListView;
import lv.javaguru.java2.views.RemoveAffairView;
import lv.javaguru.java2.db.AffairRepository;
import lv.javaguru.java2.db.MemoryDatabase;

import java.util.Scanner;

public class ToDoListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add affair to list
        // 2. Remove affair from list
        // 3. Print To-Do list to console
        // 4. Exit

        AffairRepository database = new MemoryDatabase();

        AddAffairService addAffairService = new AddAffairService(database);
        RemoveAffairService removeAffairService = new RemoveAffairService(database);
        GetToDoListService getToDoListService = new GetToDoListService(database);

        AddAffairView addAffairView = new AddAffairView(addAffairService);
        RemoveAffairView removeAffairView = new RemoveAffairView(removeAffairService);
        PrintToDoListView printToDoListView = new PrintToDoListView(getToDoListService);

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            }
            switch (menuItem) {
                case 1: {
                    addAffairView.execute();
                    break;
                }
                case 2: {
                    removeAffairView.execute();
                    break;
                }
                case 3: {
                    printToDoListView.execute();
                    break;
                }
            }
        }
    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add affair to list");
        System.out.println("2. Remove affair from list");
        System.out.println("3. Print To-Do list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
