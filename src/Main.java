import java.util.*;
import java.util.function.Supplier;


class courseWork{

    private static Scanner input = new Scanner(System.in);
    private static String userName = "sachi";
    private static String password = "2002";
    private static String[][] supplier = new String[0][0];

    private static String[] itemCategory = new String[0];

    private static String[][] item=new String[0][6];
    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
//handle the exception
            System.err.println(e.getMessage());
        }
    }

    public static void main(String args[]) {

        loginPage();

    }

    private static void loginPage() {

        System.out.println("                    +-----------------------------------------------------------------------------------+");
        System.out.println("                    |                                   LOGIN PAGE                                      | ");
        System.out.println("                    +-----------------------------------------------------------------------------------+");
        System.out.println();
        String un = "";
        String pw = "";
        boolean unflag = false;
        boolean pwflag = false;

        while (true) {

            System.out.print("User Name:");
            un = input.next();
            while (true) {
                if (!un.equals(userName)) {
                    System.out.println("user name is invalid.please try again!");
                    System.out.print("User Name:");
                    un = input.next();
                } else {
                    unflag = true;
                    break;
                }
            }
            System.out.print("password:");
            pw = input.next();
            while (true) {
                if (!pw.equals(password)) {
                    System.out.println("password is incorrect.please try again!");
                    System.out.print("password:");
                    pw = input.next();
                } else {
                    pwflag = true;
                    break;
                }
            }
            if (unflag && pwflag) {
                clearConsole();
                menu();
            }
        }


    }

    private static void menu() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                        WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                   | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();

        System.out.println("		[1]Change the Credentials                                       [2]Suplier Manage");
        System.out.println("		[3]Stock Manage                                                 [4]Log out");
        System.out.println("		[5]Exit the System ");

        System.out.println();
        System.out.print("                ENTER AN OPTION TO COTINUE :");
        int x = input.nextInt();

        switch (x) {
            case 1:
                clearConsole();
                ChangeTheCredentials();

                break;
            case 2:
                clearConsole();
                SuplierManage();
                break;
            case 3:
                clearConsole();
                StockManage();
                break;
            case 4:
                clearConsole();
                loginPage();
                break;
            case 5:
                System.exit(0);
                break;

            default:
                System.out.println("wrong input!!! please input number belongs to menu....");
        }


    }

    private static void StockManage() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                 STOCK MANAGEMENT                                | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();

        System.out.println("		[1]Manage Item Categories                                                               [2]Add Item");
        System.out.println("		[3]Get Items Supplier Wise                                                              [4]View Items");
        System.out.println("		[5]Rank Items Per Unit Price                                                            [6]Home Page");

        System.out.println();
        System.out.print("                ENTER AN OPTION TO COTINUE :");
        int x = input.nextInt();
        switch (x) {
            case 1:
                clearConsole();
                ManageItemCategories();

                break;
          case 2:
                clearConsole();
                AddItem();
                break;
            case 3:
                clearConsole();
                GetItemsSupplierWise();
                break;
             case 4:
                clearConsole();
                ViewItems();
                break;
         /*    case 5:
                clearConsole();
                RankItemsPerUnitPrice ();
                break;*/
            case 6:
                clearConsole();
                menu();
                break;
            default:
                System.out.println("wrong input!!! please input number belongs to menu....");
        }
    }

    private static void ViewItems() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                    VIEW ITEM                                    | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();

            for (int i = 0; i < itemCategory.length; i++) {
                System.out.println(itemCategory[i]+":");

                System.out.println();

                System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
                System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", "SID", "CODE", "DESC", "PRICE", "QTY");
                System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

                for (int j = 0; j < item.length; j++) {

                    if (itemCategory[i].equals(item[j][2])){
                       /* System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
                        System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", "SID", "CODE", "DESC", "PRICE", "QTY");
                        System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");*/

                        System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", item[j][1], item[j][0], item[j][3], item[j][4], item[j][5]);
                      //  System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");


                    }
                }

                System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");


            }

    }

    private static void GetItemsSupplierWise() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                 SEARCH SUPPLIER                                | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();
      L1: while (true) {
           System.out.print("Enter Supplier Id : ");
           String sId = input.next();
           System.out.print("Supplier Name : ");
           String sName = input.next();
          for (int i = 0; i <item[i].length; i++) {
              if (sId.equals(item[i][1])){
                  System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
                  System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
                  System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

                      System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", item[i][0], item[i][3], item[i][4], item[i][5], item[i][2]);
                      System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

                  System.out.print("search successfully!!Do you want to another search(Y/N):");
                  String yesNo= input.next();
                  if(yesNo.equals("Y")){
                      continue L1;
                  }else{
                      loginPage();
                  }
              }
          }
           System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
           System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
           System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
           for (int i = 0; i < item[i].length; i++) {
               System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", item[i][0], item[i][3], item[i][4], item[i][5], item[i][2]);
               System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
           }
           System.out.print("search successfully!!Do you want to another search(Y/N):");
           String yesNo= input.next();
           if(yesNo.equals("Y")){
               continue L1;
           }else{
              loginPage();
           }
       }
    }

    private static void AddItem() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                         ADD ITEM                                 | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();
        int j = 0;
        L4:
        while(true) {
            growItem();

           if (itemCategory.length == 0) {

               L1:
               while (true) {

                   System.out.print("oops it seems that you don't have any item categorys in the System.do you want to add a new item category(Y/N)");
                   String YesNo = input.next();
                   YesNo = YesNo.toUpperCase();
                   if (YesNo.equals("Y") || (YesNo.equals("YES"))) {
                       clearConsole();
                       AddNewItemCategory();
                       break;
                   } else if (YesNo.equals("N") || (YesNo.equals("NO"))) {
                       StockManage();
                       break;
                   } else {

                   }
               }
           }

           if (supplier.length == 0) {
               L2:
               while (true) {

                   System.out.print("oops it seems that you don't have any suppliers in the System.do you want to add a new supplier(Y/N)");
                   String YesNo = input.next();
                   YesNo = YesNo.toUpperCase();
                   if (YesNo.equals("Y") || (YesNo.equals("YES"))) {
                       clearConsole();
                       AddSupplier();

                   } else if (YesNo.equals("N") || (YesNo.equals("NO"))) {
                       clearConsole();
                       StockManage();
                       break;
                   } else {
                       continue L2;
                   }
               }
           }
           L3:
           while (true) {
               System.out.print("Item Code : ");

               String itemCode = input.next();
               for (int i = 0; i < item.length; i++) {
                   if (itemCode.equals(item[i][0])) {
                       System.out.println("item code is already exsist!!");
                       continue L3;
                   }
                   item[j][0]=itemCode;
                   break L3;
               }
           }
           System.out.println("+-----------------------+-----------------------+-----------------------+");
           System.out.printf("|%15s        |%15s        |%15s        |\n", "#", "SUPPLIER ID", "SUPPLIER NAME");
           System.out.println("+-----------------------+-----------------------+-----------------------+");
           for (int i = 0; i < supplier.length; i++) {
               System.out.printf("|%15s        |%15s        |%15s        |\n", i + 1, supplier[i][1], supplier[i][0]);
               System.out.println("+-----------------------+-----------------------+-----------------------+");
           }
           System.out.print("Enter the supplier number>");
           int supNum = input.nextInt();
           supNum = supNum - 1;
           for (int i = 0; i <supplier.length; i++) {
               if (i==supNum){
                   String SupplierId=supplier[i][0];
                   item[j][1]=SupplierId;
               }

           }
           System.out.println("+-----------------------+-----------------------+");
           System.out.printf("|%15s        |%15s        |\n", "#", "CATEGORY NAME");
           System.out.println("+-----------------------+-----------------------+");
           for (int i = 0; i < itemCategory.length; i++) {
               System.out.printf("|%15s        |%15s        |\n", i+1, itemCategory[i]);
               System.out.println("+-----------------------+-----------------------+");
           }
           System.out.print("Enter the category number>");
           int CategoryNum= input.nextInt();
           CategoryNum=CategoryNum-1;
           for (int i = 0; i <itemCategory.length; i++) {
               if (i==CategoryNum){
                   String category=itemCategory[i];
                   item[j][2]=category;
               }

           }
           System.out.print("Discription : ");
           item[j][3]= input.next();
           System.out.print("Unit price : ");
           item[j][4]= input.next();
           System.out.print("Qty on hand : ");
           item[j][5]= input.next();


           System.out.print("added successfully!!Do you want to add another item(Y/N):");
            System.out.println(Arrays.deepToString(item));
           String yesNo = input.next();
           yesNo=yesNo.toUpperCase();
           if (yesNo.equals("Y")||yesNo.equals("YES")) {
               j++;
               System.out.println(j);
               continue L4;
           } else if (yesNo.equals("N")||yesNo.equals("NO")) {
               clearConsole();
               StockManage();
               break L4;
           }


        }

    }

    private static void growItem() {
            String temp[][] = new String[item.length + 1][6];
            for (int i = 0; i < item.length; i++) {
                for (int j = 0; j < item[i].length; j++) {
                    temp[i][j] = item[i][j];
                }
            }
            item = temp;
    }

    private static void ManageItemCategories() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                MANAGE ITEM CATEGORY                             | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();

        System.out.println("		[1]Add New Item Category                                                               [2]Delete Item Category");
        System.out.println("		[3]Update Item Category                                                                [4]Stock Management");

        System.out.println();
        System.out.print("                ENTER AN OPTION TO COTINUE :");
        int x = input.nextInt();
        switch (x) {
            case 1:
                clearConsole();
                AddNewItemCategory();

                break;
           case 2:
                clearConsole();
                DeleteItemCategory();
                break;
            case 3:
                clearConsole();
                UpdateItemCategory();
                break;
            case 4:
                clearConsole();
               StockManage();
                break;
            default:
                System.out.println("wrong input!!! please input number belongs to menu....");
        }
    }

    private static void UpdateItemCategory() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                    UPDATE ITEM CATEGORY                        | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();
        L1:
        while (true) {
            System.out.print("Categeory name:");
            String cName = input.next();
            boolean flag=false;
            for (int i = 0; i < itemCategory.length; i++) {
                if (cName.equals(itemCategory[i])) {
                    System.out.println("before>>>>"+Arrays.deepToString(itemCategory));
                    System.out.print("Enter the new Category name:");
                    itemCategory[i]= input.next();
                    System.out.println("after>>>"+Arrays.deepToString(itemCategory));
                    System.out.print("Updated successfully!Do you want to update another category?(Y/N):");
                    String yesNo= input.next();
                    if(yesNo.equals("Y")){
                        continue L1;
                    } else if (yesNo.equals("N")) {
                        clearConsole();
                        ManageItemCategories();

                        break;
                    }
                }else{
                    flag=true;
                }

            }
            if(flag){
                System.out.println("can't find Category.try again!");
                continue L1;
            }

        }
    }

    private static void DeleteItemCategory() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                    DELETE ITEM CATEGORY                        | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();
        if (itemCategory.length == 0) {
            System.out.print("oops seems like you havent add item category yet.please add supplier first press num 1 to  supplier manage page");
            int x = input.nextInt();
            if (x == 1) {
                AddNewItemCategory();
            }
        }

        System.out.println();
        boolean flag = false;
        L1:
        while (true) {

            System.out.println("before>" + Arrays.deepToString(itemCategory));
            int j = 0;
            String[] temp = new String[itemCategory.length-1];
            System.out.print("category name:");
            String cName = input.next();

            for (int i = 0; i < itemCategory.length; i++) {

                if (cName.equals(itemCategory[i])) {
                    itemCategory[i] = "deleted";
                    flag = true;

                }
            }
            if(flag==false){
                System.out.println("can't find item category!!try again");
                continue L1;
            }
            if (flag) {
                for (int i = 0; i < itemCategory.length; i++) {
                    if (!itemCategory[i].equals("deleted")) {
                        temp[j] = itemCategory[i];
                        j++;
                    }

                }
                itemCategory = temp;
                System.out.println("after>" + Arrays.deepToString(itemCategory));
                System.out.println("deleted Successfully!");
                L2:
                while (true){
                    System.out.print("\ndo you want   to delete another supplier(Y/N):");
                    String yesNo = input.next();
                    yesNo=yesNo.toUpperCase();
                    if (yesNo.equals("Y")||yesNo.equals("YES")) {

                        if(itemCategory.length==0){
                            System.out.println("\noops category list is empty!!");

                            while (true) {
                                System.out.print("\nEnter num'1' to go to Manage Category page:");
                                int x = input.nextInt();
                                if (x == 1) {
                                    ManageItemCategories();

                                } else {

                                }
                            }
                        }
                        continue L1;
                    } else if (yesNo.equals("N")||yesNo.equals("NO")) {

                        ManageItemCategories();

                    }else{
                        continue L2;
                    }
                }
            }

        }
    }

    private static void AddNewItemCategory() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                 ADD ITEM CATEGEORY                              | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();
        String x="";
        growItemCategory();
        boolean flag = false;
        L1:
        while (true) {

            System.out.print("Enter the new item category:");
            x = input.next();

            for (int i = 0; i <itemCategory.length; i++) {
                if (!x.equals(itemCategory[i])) {
                    flag = true;
                } else {
                    System.out.println("this category already exsist. try another categeory!");
                    continue L1;
                }
            }
            if (flag) {

                itemCategory[itemCategory.length - 1] = x;
                System.out.println(Arrays.toString(itemCategory));



                System.out.print("added succesfully!Do you want to add another category(Y/N):");
                String yesNo = input.next();
                if (yesNo.equals("Y")) {
                    growItemCategory();
                    continue L1;
                } else if (yesNo.equals("N")) {
                    clearConsole();
                    ManageItemCategories();
                    break;
                }


            }

        }
    }
    private static void growItemCategory() {
        String[]temp=new String[itemCategory.length+1];
        for (int i = 0; i < itemCategory.length; i++) {
            temp[i]=itemCategory[i];
        }
        itemCategory=temp;
    }


    private static void SuplierManage() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                 SUPPLIER MANAGE                                  | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();

        System.out.println("		[1]Add Supplier                                                               [2]Update Supplier");
        System.out.println("		[3]Delete Supplier                                                            [4]View Suppliers");
        System.out.println("		[5]Search Supplier                                                            [6]Home Page");

        System.out.println();
        System.out.print("                ENTER AN OPTION TO COTINUE :");
        int x = input.nextInt();
        switch (x) {
            case 1:
                clearConsole();
                AddSupplier();

                break;
            case 2:
                clearConsole();
                updateSupplier();
                break;
            case 3:
                clearConsole();
                deleteSupplier();
                break;
            case 4:
                clearConsole();
                viewSuppliers();
                break;
            case 5:
                clearConsole();
                searchSupplier();
                break;
            case 6:
                clearConsole();
                menu();
                break;
            default:
                System.out.println("wrong input!!! please input number belongs to menu....");
        }
    }

    private static void searchSupplier() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                SEARCH SUPPLIER                                  | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();
        L1:
        while (true) {
            System.out.print("Supplier ID:");
            String sId = input.next();
            boolean flag = false;

            for (int i = 0; i < supplier.length; i++) {
                if (sId.equals(supplier[i][0])) {
                    System.out.println("Supplier ID:" + supplier[i][0] + "\nSupplier Name:" + supplier[i][1]);
                    System.out.print("do you want to find another supplier(Y/N):");
                    String yesNo = input.next();
                    if (yesNo.equals("Y")) {
                        continue L1;
                    } else if (yesNo.equals("N")) {
                        clearConsole();
                        SuplierManage();
                        break;
                    }
                } else {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("can't find supplier id.try again!");
                continue L1;
            }
        }
    }

    private static void viewSuppliers() {
        System.out.println("+-----------------------+-----------------------+");
        System.out.printf("|%15s        |%15s        |\n", "SUPPLIER NAME", "SUPPLIER ID");
        System.out.println("+-----------------------+-----------------------+");
        for (int i = 0; i < supplier.length; i++) {
            System.out.printf("|%15s        |%15s        |\n", supplier[i][0], supplier[i][1]);
            System.out.println("+-----------------------+-----------------------+");
        }
        System.out.print("Do you want to go supplier manage page(Y/N):");
        String yesNo = input.next();
        if (yesNo.equals("Y")) {
            clearConsole();
            SuplierManage();
        }

    }

    private static void deleteSupplier() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                    DELETE SUPPLIER                              | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();
        if (supplier.length == 0) {
            System.out.print("oops seems like you havent add supplier yet.please add supplier first press num 1 to  supplier manage page");
            int x = input.nextInt();
            if (x == 1) {
                SuplierManage();
            }
        }

        System.out.println();
        boolean flag = false;
        L1:
        while (true) {

            System.out.println("before>" + Arrays.deepToString(supplier));
            int j = 0;
            String[][] temp = new String[supplier.length-1][2];
            System.out.print("supplier ID:");
            String id = input.next();

            for (int i = 0; i < supplier.length; i++) {

                if (id.equals(supplier[i][0])) {
                    supplier[i][0] = "deleted";
                    supplier[i][1] = "deleted";
                    flag = true;

                }
            }
            if(flag==false){
                System.out.println("can't find supplier!!try again");
                continue L1;
            }
            if (flag) {
                for (int i = 0; i < supplier.length; i++) {
                    if (!supplier[i][0].equals("deleted")) {
                        temp[j] = supplier[i];
                        j++;
                    }

                }
                supplier = temp;
                System.out.println("after>" + Arrays.deepToString(supplier));
                System.out.println("deleted Successfully!");
                L2:
                while (true){
                    System.out.print("\ndo you want   to delete another supplier(Y/N):");
                    String yesNo = input.next();
                    yesNo=yesNo.toUpperCase();
                    if (yesNo.equals("Y")||yesNo.equals("YES")) {

                        if(supplier.length==0){
                            System.out.println("\noops supplier list is empty!!");

                            while (true) {
                                System.out.print("\nEnter num'1' to go to Supplier manage page:");
                                int x = input.nextInt();
                                if (x == 1) {
                                    SuplierManage();

                                } else {

                                }
                            }
                        }
                        continue L1;
                    } else if (yesNo.equals("N")||yesNo.equals("NO")) {

                        SuplierManage();

                    }else{
                        continue L2;
                    }
                }
            }

        }
    }



    private static void updateSupplier() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                    UPDATE SUPPLIER                               | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();
        L1:
        while (true) {
            System.out.print("Supplier ID:");
            String id = input.next();
            boolean flag=false;
            for (int i = 0; i < supplier.length; i++) {
                if (id.equals(supplier[i][0])) {
                    System.out.print("Supplier name:");
                    String X= input.next();
                    System.out.println(Arrays.deepToString(supplier));
                    System.out.print("Enter the new supplier name:");
                    supplier[i][1]= input.next();
                    System.out.println(Arrays.deepToString(supplier));
                    System.out.print("Updated successfully!Do you want to update another supplier?(Y/N):");
                    String yesNo= input.next();
                    if(yesNo.equals("Y")){
                        continue L1;
                    } else if (yesNo.equals("N")) {
                        clearConsole();
                        SuplierManage();
                        break;
                    }
                }else{
                    flag=true;
                }

            }
            if(flag){
                System.out.println("can't find supplier id.try again!");
                continue L1;
            }

        }

    }

    private static void AddSupplier() {
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                       ADD SUPPLIER                               | ");
        System.out.println("                    +----------------------------------------------------------------------------------+");
        System.out.println();
        String sId = "";
        String sName = "";
        grow();
        boolean flag = false;
        L1:
        while (true) {

            System.out.print("Supplier ID:");
            sId = input.next();

            for (int i = 0; i < supplier.length; i++) {
                if (!sId.equals(supplier[i][0])) {
                    flag=true;
                }else{
                    System.out.println("already exsist. try another supplier id!");
                    continue L1;
                }
            }
            if(flag){

                supplier[supplier.length - 1][0] = sId;
                System.out.println(Arrays.deepToString(supplier));
                System.out.print("Supplier name:");
                supplier[supplier.length - 1][1] = input.next();
                System.out.println(Arrays.deepToString(supplier));

                System.out.print("added succesfully!Do you want to add another suplier(Y/N):");
                String yesNo= input.next();
                if(yesNo.equals("Y")){
                    grow();
                    continue L1;
                }else if(yesNo.equals("N")){
                    clearConsole();
                    SuplierManage();
                    break;
                }


            }

        }
    }

    private static void grow() {
        String [][]temp=new String[supplier.length+1][2];
        for (int i=0;i< supplier.length;i++){
            temp[i][0]=supplier[i][0];
            temp[i][1]=supplier[i][1];
        }
        supplier=temp;

    }

    private static void ChangeTheCredentials() {
        System.out.println ("                    +----------------------------------------------------------------------------------+");
        System.out.println("                    |                                  CREDENTIAL MANAGE                               | ");
        System.out.println ("                    +----------------------------------------------------------------------------------+");
        System.out.println();
        while (true){
            System.out.print("please enter the user name to verify it's you:");
            String checkUserName=input.next();
            if(!userName.equals(checkUserName)){
                System.out.println("user name is invalid.please try again!");
            }else{
                System.out.println("hey "+userName);
                break;
            }
        }
        while (true){
            System.out.print(" enter current password:");
            String checkPwd=input.next();
            if(!password.equals(checkPwd)){
                System.out.println("user name is invalid.please try again!");
            }else{
                System.out.print("enter your new password:");
                password= input.next();
                System.out.print("password changed successfully!Do you want to go home page(Y/N):");
                String yesNo= input.next();
                if (yesNo.equals("Y")){
                    clearConsole();
                    menu();
                }
            }
        }
    }
}