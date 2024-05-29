import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.*;
import Entity.*;
import Global.Validation;
import Repository.BrandProduct;
import Repository.BrandService;
import Repository.ProductService;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        //List Array For Brand
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand("SS01", "Samsung"));
        brands.add(new Brand("SS02", "Apple"));
        brands.add(new Brand("LV01", "Luon Luon Vui Tuoi"));


        //List Array for Product
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("PR01","Samsung Galaxy Note 7","SS01",100,2000,1000,Status.A));
        products.add(new Product("PR02","MacBook Pro 13","SS02",1000,5000,3000,Status.A));
        products.add(new Product("PR03","LV x Supreme Red Hoodie","LV01",1000,5000,3000,Status.I));


        //Repository
        BrandService bs = new BrandService();
        ProductService ps = new ProductService();
        BrandProduct bp = new BrandProduct();

        bs.brands = brands;
        ps.pr = products;

        bp.br = brands;
        bp.pr = products;

        //Brand Management
        String keyword;
        Brand newBrand;
        String brandName;
        Brand updatedBrand;
        String updateName;
        String updateProductName;
        String updateBrandId;

        
        //Product Management
        String brandId;
        Status productStatus = null;
        String updateProductId;
        double baseCost;
        double price;
        int quantity;
        String addId;
        String addName;
        String status;


        try{
            do {


            System.out.println("Brand and Product Service");
            System.out.println("1 - Brand Management");
            System.out.println("2 - Product Service");
            System.out.println("3 - Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    do{
                        System.out.println("====  Brand Management ====");
                        System.out.println("1 - Search Brand");
                        System.out.println("2 - Add Brand");
                        System.out.println("3 - Update Brand");
                        System.out.println("4 - Delete Brand");
                        System.out.println("5 - Show Brand");
                        System.out.println("6 - Exit");
                        System.out.print("Enter your choice: ");
                        int brandChoice = Integer.parseInt(br.readLine());
                        switch (brandChoice){
                            case 1: // Search Brand
                                System.out.println("Enter Keyword: ");
                                keyword = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                bs.findByName(keyword).forEach(System.out::println);
                                break;
                            case 2: //Add Brand
                                do {
                                    System.out.print("Enter your brand id: ");
                                    brandId = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                    if(bs.isExistBrand(brandId)){
                                        System.out.println("Brand exist!");
                                        flag = false;
                                    } else if (!Validation.validateBrandId(brandId)) {
                                        System.out.println("Brand ID wrong format");
                                        flag = false;
                                    } else {
                                        System.out.print("Enter your brand name: ");
                                        brandName = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                        newBrand = new Brand(brandId, brandName);
                                        bs.addNew(newBrand);
                                    }
                                }while (!flag);
                                break;
                            case 3: //Update Brand
                                do{
                                    System.out.print("Enter your brand id: ");
                                    updateBrandId = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                    if(bs.isExistBrand(updateBrandId)){
                                        System.out.println("Brand Exist!");
                                        flag = false;
                                    } else if (Validation.validateBrandId(updateBrandId)) {
                                        System.out.println("Brand ID wrong format");
                                        flag = false;
                                    } else{
                                        System.out.print("Enter your brand name: ");
                                        updateName = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                        updatedBrand = new Brand(updateBrandId, updateName);
                                        bs.update(updatedBrand);
                                    }
                                }while (!flag);
                                break;

                            case 4: //Delete Brand
                                System.out.print("Enter your brand id: ");
                                String deleteId = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                if(bs.isExistBrand(deleteId)){
                                    System.out.println("No such brand!");
                                    flag = false;
                                }else{
                                    bs.Delete(deleteId);
                                }
                                break;

                            case 5:
                                brands.forEach(System.out::println);
                                flag = false;
                                break;

                            case 6:
                                flag = true;
                                break;
                        }
                    }while(!flag);
                    break;
                    case 2:
                        do{
                            System.out.println("====  Product Service ====");
                            System.out.println("1 - Search Product By Brand Name");
                            System.out.println("2 - Add Product");
                            System.out.println("3 - Update Product");
                            System.out.println("4 - Delete Product");
                            System.out.println("5 - Show Product");
                            System.out.println("6 - Show Product Quantity Satistics By Brand");
                            System.out.println("7 - Exit");
                            System.out.print("Enter your choice: ");
                            int productChoice = Integer.parseInt(br.readLine());
                            switch (productChoice) {
                                case 1: //Search Product
                                    System.out.print("Enter Brand Name: ");
                                    String productName = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                    bp.findProductByBrandName(productName).forEach(System.out::println);
                                    flag = false;
                                    break;

                                    case 2: //Add Product
                                    brands.forEach(System.out::println);
                                        do{
                                            System.out.print("Enter Brand ID: ");
                                            brandId = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                            if(bs.isExistBrand(brandId)){
                                                flag = true;
                                            }else{
                                                System.out.println("Brand not found");
                                                flag = false;
                                            }
                                        }while(!flag);
                                    do{
                                        System.out.print("Enter Product ID: ");
                                        addId = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                        if(ps.notExistProductId(addId)){
                                            System.out.println("Product Exist!");
                                            flag = false;
                                        }else if(!Validation.validateProductId(addId)){
                                            System.out.println("Product ID wrong format");
                                            flag = false;
                                        }else{
                                            flag = true;
                                        }
                                    }while(!flag);

                                    do{
                                        System.out.print("Enter Product Name: ");
                                        addName = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                        if(ps.notExistProductName(addName)){
                                            System.out.println("Product Exist!");
                                            flag = false;
                                        }else{
                                            flag = true;
                                        }
                                    }while(!flag);


                                        //Input Base Cost
                                        do{
                                            System.out.print("Enter Base Cost: ");
                                            baseCost = Double.parseDouble((new BufferedReader(new InputStreamReader(System.in))).readLine());
                                            if(baseCost < 0){
                                                System.out.println("Invalid baseCost");
                                                flag = false;
                                            }else{
                                                flag = true;
                                            }
                                        }while(!flag);

                                        //Input Price
                                        do{
                                            System.out.print("Enter Price: ");
                                            price = Double.parseDouble((new BufferedReader(new InputStreamReader(System.in))).readLine());
                                            if(price < 0){
                                                System.out.println("Invalid price");
                                                flag = false;
                                            }else{
                                                flag = true;
                                            }
                                        }while(!flag);

                                        //Input Quantity
                                        do{
                                            System.out.print("Enter Quantity: ");
                                            quantity = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
                                            if(quantity < 0){
                                                System.out.println("Invalid quantity");
                                                flag = false;
                                            }else{
                                                flag = true;
                                            }
                                        }while(!flag);
                                        do {
                                            System.out.print("Enter Status: ");
                                            status = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                            switch(status){
                                                case "A":
                                                case "a":
                                                    productStatus = Status.A;
                                                    flag = true;
                                                    break;
                                                case "I":
                                                case "i":
                                                    productStatus = Status.I;
                                                    flag = true;
                                                    break;
                                                default:
                                                    System.out.println("Invalid status");
                                                    flag = false;
                                                    break;
                                            }
                                        }while(!flag);
                                        Product newProduct = new Product(addId, addName, brandId, baseCost, price, quantity, productStatus);
                                        ps.addNew(newProduct);
                                        flag = false;
                                        break;

                                case 3: //Update Product
                                    brands.forEach(System.out::println);
                                    //Input Brand ID
                                    do{
                                        System.out.print("Enter Brand ID: ");
                                        brandId = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                        if(!bs.isExistBrand(brandId)){
                                            System.out.println("Brand not found");
                                            flag = false;
                                        }else {
                                            flag = true;
                                        }
                                    }while(!flag);
                                    //Input Product ID
                                    do {
                                        System.out.print("Enter Product Id:");
                                        updateProductId = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                        if(!ps.notExistProductId(updateProductId)){
                                            System.out.println("Product not found");
                                            flag = false;
                                        }else{
                                            flag = true;
                                        }
                                    }while(!flag);

                                    //Input Product Name
                                        System.out.print("Enter Product Name:");
                                        updateProductName = (new BufferedReader(new InputStreamReader(System.in))).readLine();


                                    //Input Base Cost
                                    do{
                                        System.out.print("Enter Base Cost: ");
                                        baseCost = Double.parseDouble((new BufferedReader(new InputStreamReader(System.in))).readLine());
                                        if(baseCost < 0){
                                            System.out.println("Invalid baseCost");
                                            flag = false;
                                        }else{
                                            flag = true;
                                        }
                                    }while(!flag);

                                    //Input Price
                                    do{
                                        System.out.print("Enter Price: ");
                                        price = Double.parseDouble((new BufferedReader(new InputStreamReader(System.in))).readLine());
                                        if(price < 0){
                                            System.out.println("Invalid price");
                                            flag = false;
                                        }else{
                                            flag = true;
                                        }
                                    }while(!flag);

                                    //Input Quantity
                                    do{
                                        System.out.print("Enter Quantity: ");
                                        quantity = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
                                        if(quantity < 0){
                                            System.out.println("Invalid quantity");
                                            flag = false;
                                        }else{
                                            flag = true;
                                        }
                                    }while(!flag);

                                    //Input Status
                                    do {
                                        System.out.print("Enter Status: ");
                                        status = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                        switch(status){
                                            case "A":
                                            case "a":
                                                productStatus = Status.A;
                                                flag = true;
                                                break;
                                            case "I":
                                            case "i":
                                                productStatus = Status.I;
                                                flag = true;
                                                break;
                                            default:
                                                System.out.println("Invalid status");
                                                flag = false;
                                                break;
                                        }
                                    }while(!flag);
                                    newProduct = new Product(updateProductId, updateProductName, brandId, baseCost, price, quantity, productStatus);
                                    ps.update(newProduct);
                                    flag = false;
                                    break;
                                case 4:
                                    do{
                                        System.out.print("Enter Product Id: ");
                                        updateProductId = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                                        if(!ps.notExistProductId(updateProductId)){
                                            System.out.println("Product not found");
                                            flag = false;
                                        }else{
                                            ps.Delete(updateProductId);
                                            flag = true;
                                        }
                                    }while(!flag);
                                    break;
                                case 5:
                                    products.forEach(System.out::println);
                                    flag = false;
                                    break;
                                case 6:
                                    bp.getProductQuantityStatistic().forEach(System.out::println);
                                    flag = false;
                                    break;
                                case 7:
                                    flag = true;
                                    break;
                            }
                        }while(!flag);
                        break;
                        case 3:
                            System.out.println("Bye Bye !");
                            flag = false;
                            break;
                 }
            }while (flag);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
