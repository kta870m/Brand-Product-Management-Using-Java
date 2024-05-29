package Repository;
import Entity.*;
import java.util.*;

public class BrandProduct {
    public static List<Product> pr;
    public static List<Brand> br;

    public List<Product> findProductByBrandName(String brandName) {
        String[] keyword = brandName.split(" ");
        List<String> brandId = null;
        for(String s : keyword) {
              brandId = br.stream()
                      .filter(b->b.getName().contains(s))
                      .map(Brand::getId)
                      .toList();
        }

        List<String> finalBrandId = brandId;
        return pr.stream()
                .filter(product -> finalBrandId.contains(product.getBrandId()))
                .toList();
    }

    public List<String> getProductQuantityStatistic(){
        return br.stream()
                .map(b->{
                    int totalQuantity = pr.stream()
                            .filter(product -> product.getBrandId().equals(b.getId()))
                            .mapToInt(Product::getQuantity)
                            .sum();
                    return b.getName() + ": " + totalQuantity;
                }).toList();
    }
}
