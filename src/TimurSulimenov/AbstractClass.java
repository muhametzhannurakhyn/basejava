package TimurSulimenov;

public abstract class AbstractClass {
    public void showPage(){
        System.out.println("Header");
        midle();
        System.out.println("Footer");
    }

    public abstract void midle();
}
