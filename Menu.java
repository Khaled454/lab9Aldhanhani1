package edu.psu.abington.ist.ist242;
import java.util.ArrayList;

public class Menu {

    private int menuId;
    private ArrayList <Item> menu;

    public Menu(int menuId, ArrayList <Item> menu) {
        this.menuId = menuId;
        this.menu = menu;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public ArrayList <Item> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList <Item> menu) {
        this.menu = menu;
    }

    public void printMenu() {
        for (Item item : menu) {
            System.out.println(item.getItemId() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }
}
