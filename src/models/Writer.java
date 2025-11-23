package models;

import java.util.ArrayList;

public class Writer extends Thread{
    private ResourcesAccessManager ram;
    private int id;
    private ArrayList<Integer> resource;

    public Writer (
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
        for(int i = 1; i <= 10; i++) {
            ram.startWriting();
            this.resource.add(i);
            System.out.println("Escritor " + this.id + " insertando: " + i);
            try{
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ram.finishWriting();
        }
    }
}
