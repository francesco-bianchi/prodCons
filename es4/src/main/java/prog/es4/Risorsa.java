package prog.es4;


public class Risorsa {
    private boolean prod=true;
    private boolean cons=false;
    int val;

    public synchronized void produci(int val) {
        String name = Thread.currentThread().getName();
        try {
            while(!prod){
                wait();
                System.out.println(name +" è in attesa di entrare");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        prod=false;
        cons=true;
        notifyAll();
        System.out.println(name + " sta producendo: " + val);
        this.val = val;
    }
    
    public synchronized int consuma() {
        String name = Thread.currentThread().getName();
        try {
            while(!cons){
                wait();
                System.out.println(name +" è in attesa di entrare");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        prod=true;
        cons=false;
        notifyAll();
        System.out.println(name + " sta consumando: " + val);
        return this.val;
    }
}
