package Global;

public class Validation {
    public static boolean validateProductId(String productId) {
        String pattern = "^(PR|PS)?[0-9]{2}+$";
        return productId.matches(pattern);
    }

    public static boolean validateBrandId(String brandId) {
        String pattern = "^[A-Z]{2}?[0-9]{2}+$";
        return brandId.matches(pattern);
    }

}
