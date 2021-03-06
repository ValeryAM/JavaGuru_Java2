package lv.javaguru.java2;

import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.views.AddAffairView;
import lv.javaguru.java2.views.PrintToDoListView;
import lv.javaguru.java2.views.RemoveAffairView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ToDoListApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        AddAffairView addAffairView = context.getBean(AddAffairView.class);
        RemoveAffairView removeAffairView = context.getBean(RemoveAffairView.class);
        PrintToDoListView printToDoListView = context.getBean(PrintToDoListView.class);

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
