
import java.util.*;



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
    private static boolean yesNo(String x) {
     L1: while(true) {
          System.out.print(x);
          String yesNo = input.next();
          boolean flag = false;
          yesNo = yesNo.toUpperCase();
          if (yesNo.equals("Y") || yesNo.equals("YES")) {
              flag = true;
          } else if (yesNo.equals("N") || yesNo.equals("NO")) {
              flag = false;
          }else{
            continue L1;
          }
          return flag;
      }
    }
    private static void loginPage() {
        title("LOGIN PAGE");

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
    private static void title(String x) {
        System.out.printf("                   +----------------------------------------------------------------------------------------------------+\n");
        System.out.printf("                   |                  %50s                                |\n",x);
        System.out.printf("                   +----------------------------------------------------------------------------------------------------+\n");
      System.out.println();
    }
    private static void menu() {
        title("WELCOME TO IJSE STOCK MANAGEMENT SYSTEM");
        while (true) {
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
    }
    private static void StockManage() {
        title("STOCK MANAGEMENT");
        while (true) {
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
                case 5:
                    clearConsole();
                    RankItemsPerUnitPrice();
                    break;
                case 6:
                    clearConsole();
                    menu();
                    break;
                default:
                    System.out.println("wrong input!!! please input number belongs to menu....");
            }
        }
    }
    private static void RankItemsPerUnitPrice() {
        title(" RANKED UNIT PRICE");

            String[][]temp = sort(item);

            System.out.printf("+-------------------------------+-------------------------------+-------------------------------+-------------------------------+-------------------------------+-------------------------------+%n");
            System.out.printf("|%15s           |%15s           |%15s           |%15s           |%15s           |%15s           |%n","SID","CODE","DESC","PRICE","QTY","CAT");
            System.out.printf("+-------------------------------+-------------------------------+-------------------------------+-------------------------------+-------------------------------+-------------------------------+%n");

            for (int i = 0; i < item.length; i++){
                System.out.printf("| "+temp[i][1]+" | "+temp[i][0]+" | "+temp[i][3]+" | "+temp[i][4]+" | "+temp[i][5]+" | "+temp[i][2]+" |%n");
            }

            System.out.printf("+-------------------------------+-------------------------------+-------------------------------+-------------------------------+-------------------------------+-------------------------------+%n");

//System.out.println(Arrays.deepToString(temp));
            boolean checked=yesNo("\nDo you want to go stock manage page (Y/N) ");

            if(checked){
                clearConsole();
              StockManage();
            }
            System.exit(0);

    }
    private static String[][] sort(String[][] array){
        String[][] temp1 = array;
        String[] temp2 = new String[6];

        for(int i=0;i<temp1.length-1;i++){
            for(int j=0;j<temp1.length-1;j++){
                if(Integer.parseInt(temp1[j][4])>Integer.parseInt(temp1[j+1][4])){
                    temp2 = temp1[j];
                    temp1[j]=temp1[j+1];
                    temp1[j+1]=temp2;
                }
            }
        }
        return temp1;
    }
    private static void ViewItems() {
        title(" VIEW ITEM");

            for (int i = 0; i < itemCategory.length; i++) {
                System.out.println(itemCategory[i]+":");

                System.out.println();

                System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
                System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", "SID", "CODE", "DESC", "PRICE", "QTY");
                System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

                for (int j = 0; j < item.length; j++) {

                    if (itemCategory[i].equals(item[j][2])){
                        System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", item[j][1], item[j][0], item[j][3], item[j][4], item[j][5]);
                    }
                }
                System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
            }
            boolean checked=yesNo("do you want to go stock management page(Y/N)");

           if (checked){
               StockManage();
           }else if(checked==false) {
               menu();
           }


    }
    private static void GetItemsSupplierWise() {
        title("SEARCH SUPPLIER");

      L1: while (true) {
          System.out.print("Enter Supplier Id : ");
          String sId = input.next();
          int count=0;
          String sName="";

          for (int i = 0; i < supplier.length; i++) {
                if (sId.equals(supplier[i][0])){
                    sName=supplier[i][1];
                    count++;
                }
          }
          if (count==1){
              System.out.println("Supplier Name: "+sName);
          }else{
              System.out.println("can't find supplier!! try again");
              continue L1;
          }

          for (int i = 0; i < item[i].length; i++) {
              if (sId.equals(item[i][1])) {
                  System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
                  System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
                  System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

                  System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", item[i][0], item[i][3], item[i][4], item[i][5], item[i][2]);
                  System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
                  boolean checked = yesNo("search successfully!!Do you want to another search(Y/N):");

                  if (checked) {
                      continue L1;
                  } else if (checked == false) {
                      StockManage();
                  }
              }
          }
        }
    }
    private static void AddItem() {
        title("ADD ITEM");

        int j = 0;
        growItem();
        L4:
        while(true) {
            if (itemCategory.length == 0) {

               L1:
               while (true) {
                    boolean checked=yesNo("oops it seems that you don't have any item categorys in the System.do you want to add a new item category(Y/N)");

                   if (checked) {
                       clearConsole();
                       AddNewItemCategory();
                       break;
                   } else if (checked==false) {
                       StockManage();
                       break;
                   } else {

                   }
               }
           }

           if (supplier.length == 0) {
               L2:
               while (true) {
                    boolean checked=yesNo("oops it seems that you don't have any suppliers in the System.do you want to add a new supplier(Y/N)");

                   if (checked) {
                       clearConsole();
                       AddSupplier();

                   } else if (checked==false) {
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

            boolean checked=yesNo("added successfully!!Do you want to add another item(Y/N):");
           System.out.print("added successfully!!Do you want to add another item(Y/N):");

           if (checked) {
               j++;
               growItem();
               System.out.println(j);
               continue L4;
           } else if (checked==false) {
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
        title("MANAGE ITEM CATEGORY");
        while (true) {
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
    }
    private static void UpdateItemCategory() {
        title("UPDATE ITEM CATEGORY");

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
                    boolean checked=yesNo("Updated successfully!Do you want to update another category?(Y/N):");

                    if(checked){
                        continue L1;
                    } else if (checked==false) {
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
        title("DELETE ITEM CATEGORY");
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
                    boolean checked=yesNo("\ndo you want to delete another category(Y/N):");

                    if (checked) {
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
                    } else if (checked==false) {
                        ManageItemCategories();

                    }else{
                        continue L2;
                    }
                }
            }
        }
    }
    private static void AddNewItemCategory() {
        title("ADD ITEM CATEGORY");
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
                boolean checked=yesNo("added succesfully!Do you want to add another category(Y/N):");

                if (checked) {
                    growItemCategory();
                    continue L1;
                } else if (checked==false) {
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
        title("SUPPLIER MANAGE");
        while (true) {
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
    }
    private static void searchSupplier() {
        title("SEARCH SUPPLIER");
        L1:
        while (true) {
            System.out.print("Supplier ID:");
            String sId = input.next();
            boolean flag = false;

            for (int i = 0; i < supplier.length; i++) {
                if (sId.equals(supplier[i][0])) {
                    System.out.println("Supplier ID:" + supplier[i][0] + "\nSupplier Name:" + supplier[i][1]);
                   boolean checked=yesNo("do you want to find another supplier(Y/N):");
                    if (checked) {
                        continue L1;
                    } else if (checked==false) {
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
        title("VIEW SUPPLIERS");
        System.out.println("+-----------------------+-----------------------+");
        System.out.printf("|%15s        |%15s        |\n", "SUPPLIER NAME", "SUPPLIER ID");
        System.out.println("+-----------------------+-----------------------+");
        for (int i = 0; i < supplier.length; i++) {
            System.out.printf("|%15s        |%15s        |\n", supplier[i][0], supplier[i][1]);
            System.out.println("+-----------------------+-----------------------+");
        }
        boolean checked=yesNo("Do you want to go supplier manage page(Y/N):");
        if (checked) {
            clearConsole();
            SuplierManage();
        } else if (checked==false) {
            clearConsole();
            menu();
        }
    }
    private static void deleteSupplier() {
        title("DELETE SUPPLIER");
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
                    boolean checked=yesNo("\ndo you want to delete another supplier(Y/N):");
                    if (checked) {
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
                    } else if (checked==false) {
                        SuplierManage();

                    }else{
                        continue L2;
                    }
                }
            }
        }
    }
    private static void updateSupplier() {
        title("UPDATE SUPPLIER");
        L1:
        while (true) {
            System.out.print("Supplier ID:");
            String id = input.next();
            boolean flag=false;
            for (int i = 0; i < supplier.length; i++) {
                if (id.equals(supplier[i][0])) {
                    System.out.println("Supplier name:"+supplier[i][1]);
                    System.out.println(Arrays.deepToString(supplier));
                    System.out.print("Enter the new supplier name:");
                    supplier[i][1]= input.next();
                    System.out.println(Arrays.deepToString(supplier));

                    boolean checked=yesNo("Updated successfully!Do you want to update another supplier?(Y/N):");
                    if(checked){
                        continue L1;
                    } else if (checked==false) {
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
        title("ADD SUPPLIER");

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
            boolean checked=yesNo("added succesfully!Do you want to add another suplier(Y/N):");
            if(checked){
                    grow();
                    continue L1;
                }else if(checked==false){
                    clearConsole();
                    SuplierManage();
                    break;
                }else{

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
        title("CREDENTIAL MANAGE");

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
                boolean checked=yesNo("password changed successfully!Do you want to go home page(Y/N):");

                if (checked){
                    clearConsole();
                    menu();
                }
            }
        }
    }
}