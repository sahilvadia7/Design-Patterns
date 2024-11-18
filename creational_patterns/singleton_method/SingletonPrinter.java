package creational_patterns.singleton_method;
class Printer{

    private static Printer printer;
    private String PrinterName;

    private Printer(String printerName){
        this.PrinterName = printerName;
    }

    public static Printer getPrinter(String printerName){

        if(printer == null){
            printer = new Printer(printerName);
        }
        return printer;

    }

    public String getPrinterName(){
        return PrinterName;
    }

}

public class SingletonPrinter {
    public static void main(String[] args) {
        
        Printer hp = Printer.getPrinter("Hp Printer");
        Printer canon = Printer.getPrinter("Canon Printer");

        System.out.println("Printer 1 Name: "+hp.getPrinterName());
        System.out.println("Printer 2 Name: "+canon.getPrinterName());

        System.out.println("Are both instances the same? " + (hp == canon));
        System.out.println("Printer 1 Address:"+ System.identityHashCode(hp));
        System.out.println("Printer 2 Address:"+ System.identityHashCode(canon));

    }
}
