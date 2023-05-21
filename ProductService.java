import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    List<Product> products=new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }
    public List<Product> getAllProducts(){
        return products;
    }
    public Product getProduct(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;

    }
    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
//        List<Product> prods = new ArrayList<>();
//
//        for (Product p : products) {
//            String name = p.getName().toLowerCase();
//            String type = p.getType().toLowerCase();
//            String place = p.getPlace().toLowerCase();
//            if (name.contains(str) || type.contains(str) || place.contains(str))
//                prods.add(p);
//        }
//        return prods;
        return  products.stream().filter(p -> p.getName().toLowerCase().contains(str) || p.getType().toLowerCase().contains(str) ||p.getPlace().toLowerCase().contains(str)).collect(Collectors.toList());
    }
    public List<Product> getProductsWithPlace(String place) {
        String str = place.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for (Product p : products) {
            String productPlace = p.getPlace().toLowerCase();
            if (productPlace.equals(str))
                prods.add(p);
        }
        return prods;
    }
    public List<Product> getOutOfWarrantyProducts() {
        List<Product> outOfWarrantyProds = new ArrayList<>();
        for (Product p : products) {
            if (p.getWarranty() < getCurrentYear()) {
                outOfWarrantyProds.add(p);
            }
        }
        return outOfWarrantyProds;
    }

    private int getCurrentYear() {
        // Add your code here to get the current year
        // You can use the Calendar or LocalDateTime classes or any other preferred method
        // For simplicity, let's assume the current year is 2023
        return 2023;
    }

}
