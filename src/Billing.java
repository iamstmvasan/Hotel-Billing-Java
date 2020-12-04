import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Billing {
    public void printBill(List<String> nameList , List<Integer> prizeList , List<Integer> qtyList ){
        //This class used print Bill for customer order

        int sno = 1;
        //first we calculate total order prizes
        int sum = 0;
        for(int i=0;i<prizeList.size();i++)
            sum += prizeList.get(i)*qtyList.get(i);
        // display hotel details
        System.out.println("==========================================================================");
        System.out.println("\t\t\t\t\t\t\t\t HOTEL BDU");
        System.out.println("\t\t\t\t\t\t\t  Veg  Restaurant");
        System.out.println("\t\t\t\t\t\t\t  Ph - 9876543210");
        System.out.println("\t\t\t\t\t\tTiruchirappalli, Tamil Nadu");
        System.out.println("\t\t\t\t\t\t\t\tPin - 620024");
        System.out.println();
        System.out.println("------------------------------ TAX INVOICE -------------------------------");
        //Getting current date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.print("\tBill Date : "+formatter.format(date)+"\t\t\t\t\t");
        //Getting current time
        formatter = new SimpleDateFormat("hh:mm:yy");
        System.out.println("\tBill Time : "+formatter.format(date)+"\t\t\t\t\t");

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\tS.No\t\tItem\t\t\t\t\tQty\t\tRate\t\tAmount");
        System.out.println();
        //Printing order details
        for(int i=0;i<nameList.size();i++){
            System.out.println("\t  "+ sno++ +"  \t\t"+nameList.get(i)+" "+qtyList.get(i)+" \t\t "+prizeList.get(i)+" \t\t"+ (prizeList.get(i)*qtyList.get(i)));
        }
        System.out.println("--------------------------------------------------------------------------");
        //discount amount
        float discount = sum*8/100;
        //total gst amount
        float gst = sum*10/100;
        float newTotal = (sum - discount);
        System.out.println("\t\t\t\t\t\t\t\t\t\tTOTAL AMOUNT\t\t"+  sum);
        System.out.println("\t\t\t\t\t\t\t\t\t\tDiscount 8% \t\t"+  discount);
        System.out.println("\t\t\t\t\t\t\t\t\t--------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\tNew TOTAL\t\t\t"+ newTotal );
        System.out.println("\t\t\t\t\t\t\t\t\t\tCGST 6% \t\t\t"+ newTotal*6/100 );
        System.out.println("\t\t\t\t\t\t\t\t\t\tSGST 4% \t\t\t"+ newTotal*4/100 );
        System.out.println("\t\t\t\t\t\t\t\t\t--------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\tGRAND TOTAL\t\t\t"+  (newTotal + gst));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tThank you - Visit Again");
        System.out.println("==========================================================================");


    }
}
