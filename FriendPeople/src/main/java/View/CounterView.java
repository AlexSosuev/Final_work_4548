package View;

import Controllers.CounterController;

public class CounterView {
    private final CounterController controller;

    public CounterView(CounterController controller) {
        this.controller = controller;
    }
    public void add(){
        controller.add();
    }
    public void printCount(){
        System.out.println(controller.getCount());
    }
}
