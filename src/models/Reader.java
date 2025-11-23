package models;

import java.util.ArrayList;

public class Reader extends Thread{
    private ResourcesAccessManager ram;
    private int id;
    private ArrayList<Integer> resource;

    public Reader (
            ResourcesAccessManager ram,
            int id,
            ArrayList<Integer> resource
            ) {
        this.ram = ram;
        this.id = id;
        this.resource = resource;
    }

    @Override
    public void run(){
        ram.startReading();
        for(int i = 0; i < this.resource.size(); i++){
            System.out.println("Lector " + this.id + " leyendo: " + this.resource.get(i));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Lector " + this.id + " terminó de leer");
        ram.finishReading();
    }
}
