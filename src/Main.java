import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    //This is Main class
    public static void main(String[] args)throws IOException {
        //Initially i create two Map Interface for easy to accessing Particulars Name and Prize by using Id
        Map<String , String> IdName = idNameInitialize();
        Map<String , Integer> IdPrize = namePrizeInitialize();

        //I created Three List for storing Dish name & dish prize & dish quantity
        //These details are depend by customer order
        List<String> nameList = new ArrayList<>();
        List<Integer> prizeList = new ArrayList<>();
        List<Integer> quantityList = new ArrayList<>();

        //These variables for store name and prize by using Id
        String name;
        int prize;

        //Scanner class for getting input from user
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //This boolean variable used to run Infinite while
        boolean flag = true, isOrder = false;

        //creating a anonymous Object for HotelMenu it display Hotel Menu card
        new HotelMenu();
        while (flag) {
            System.out.println("Enter your order Id [Same as Menu card]: ");
            //Getting Food Id from user
            String Id = br.readLine();
            System.out.println("-------------------------------------------------------------------------");
            if (!IdName.containsKey(Id)) {
                //if customer entered id is not available in menu card we give second chance to customer
                System.out.println("Id not available !");
                System.out.println("Would you like to continue [ Yes -> Enter 1 | No -> Enter 0 ] ?");
                int ch = 0;
                try {
                    ch =Integer.valueOf(br.readLine());
                }catch (NumberFormatException exe){
                    System.out.println("Invalid choice, Program terminate");
                    break;
                }
                //br.readLine();//getting enter after put choice
                if (ch == 1)//if customer entered 1 we give another chance
                    continue;
                else if (ch == 0) {//if customer entered 0 we stop order and print bill if any order occured
                    System.out.println("Wait for a second ...");
                    break;
                } else { // if customer enter any other choice we terminate program
                    System.out.println("Invalid Choice, Program Terminate ...");
                    System.out.println("Wait for a second ...");
                    break;
                }
            }
            System.out.println("Enter your order Quantity [In numbers]: ");
            int qty = 1;
            try{
                qty = Integer.valueOf(br.readLine());

            }catch (NumberFormatException exe){
                System.out.println("Invalid entry, Program terminate");
                break;
            }
            isOrder = true;
            name = IdName.get(Id);
            prize = IdPrize.get(Id);
            System.out.println("Ordered Food => " + name);
            System.out.println("Ordered Prize => " + prize*qty);
            //if the customer already order the same food we skip the name and add the prize
            if (nameList.contains(name) ){
                int index = nameList.indexOf(name);
                prizeList.set(index , prizeList.get(index) + prize);
                quantityList.set(index , quantityList.get(index)+qty);
            }
            //otherwise we add name to name list & add prize to prize list
            else {
                nameList.add(name);
                prizeList.add(prize);
                quantityList.add(qty);
            }
            System.out.println("-------------------------------------------------------------------------");
            //Cutomer like to order other food this is time for it
            System.out.println("Would you like to Order some other Food [ Yes -> Enter 1 | No -> Enter 0 ] ?");
            int ch = 0;
            try {
                ch = Integer.valueOf(br.readLine());

            }catch (NumberFormatException exe){
                System.out.println("Invalid Entry, Program terminate");
                break;
            }

            if (ch != 1) {
                flag = false;
                System.out.println("Your order has finished !");
                System.out.println("Wait for your bill . . .");
                System.out.println("-------------------------------------------------------------------------");
            }
        }
        if(isOrder) {
            System.out.println("Print Bill [Enter 1] | Cancel order [Enter 0] ?");
            int ch = 0;
            try {
                ch = Integer.valueOf(br.readLine());
                
            }catch (NumberFormatException exe){
                System.out.println("Invalid choice, Program terminate");
            }
            if(ch==1)
                new Billing().printBill(nameList, prizeList, quantityList);
            else
                System.out.println("We Looking forward for your next visit, Bye !");
        }
        else
            System.out.println("We Looking forward for your next visit, Bye !");
    }
    //we initialize id with food name
    private static Map<String, String> idNameInitialize() {
        Map<String , String> map = new HashMap<>();

        map.put("I1","Honey Ice Cream \t\t");
        map.put("I2","Butterscotch Ice Cream  ");
        map.put("I3","Vanilla Ice Cream   \t");
        map.put("I4","Strawberry Ice Cream\t");
        map.put("I5","Chocolate Ice Cream \t");

        map.put("J1","Rose Milk   \t\t\t");
        map.put("J2","Badam Milk  \t\t\t");
        map.put("J3","Fruit Mixer \t\t\t");
        map.put("J4","Lemon Juice \t\t\t");
        map.put("J5","Mango Juice \t\t\t");

        map.put("T1","Idly\t\t\t\t\t");
        map.put("T2","Dosa\t\t\t\t\t");
        map.put("T3","Poori   \t\t\t\t");
        map.put("T4","Pongal  \t\t\t\t");
        map.put("T5","Chapati \t\t\t\t");
        map.put("T6","Parotta \t\t\t\t");
        map.put("T7","Vada\t\t\t\t\t");

        map.put("M1","Bisibelebath\t\t\t");
        map.put("M2","Veg-Biriyani\t\t\t");
        map.put("M3","Full-Meals  \t\t\t");


        return map;
    }
    //we initialize id with prize
    private static Map<String, Integer> namePrizeInitialize() {
        Map<String , Integer> map = new HashMap<>();
        map.put("I1",50);
        map.put("I2",40);
        map.put("I3",20);
        map.put("I4",30);
        map.put("I5",30);

        map.put("J1",20);
        map.put("J2",20);
        map.put("J3",20);
        map.put("J4",20);
        map.put("J5",20);

        map.put("T1",30);
        map.put("T2",40);
        map.put("T3",50);
        map.put("T4",45);
        map.put("T5",50);
        map.put("T6",50);
        map.put("T7",20);

        map.put("M1",70);
        map.put("M2",80);
        map.put("M3",90);
        return map;
    }
}
