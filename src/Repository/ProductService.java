package Repository;

import Entity.Product;
import Entity.Status;
import Generic.IGeneric;

import java.util.List;
import java.util.Optional;

public class ProductService implements IGeneric<Product>{

    public static List<Product> pr;

    @Override
    public Product addNew(Product product) {
        if(!notExistProduct(product)){
            pr.add(product);
        }else{
            System.out.println("Product already exists");
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        Product existProduct = findById(product.getId());
        if(!notExistProduct(product)){
            pr.set(pr.indexOf(existProduct), product);
        }else{
            System.out.println("Product already exists");
        }
        return product;
    }


    @Override
    public boolean Delete(String id) {
        Product existProduct = findById(id);
        boolean flag = false;
        if(existProduct != null) {
            pr.remove(existProduct);
            flag = true;
        }
        return flag;
    }

    @Override
    public Product findById(String id) {
        return pr.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Product> findByName(String name) {
        String[] kw = name.split(" ");
        List<Product> prs = null;
        for(String s : kw) {
            prs = pr.stream()
                    .filter(b->b.getName().contains(s))
                    .toList();
        }
        return prs;
    }

    public void updateProductStatus(String id, Status status) {
        Product products = findById(id);
        products.setStatus(status);
    }

    public boolean notExistProduct(Product product) {
        return pr.stream().anyMatch(p->p.equals(product));
    }

    public boolean notExistProductId(String id) {
        return pr.stream().anyMatch(p->p.getId().equals(id));
    }

    public boolean notExistProductName(String name) {
        return pr.stream().anyMatch(p->p.getName().equals(name));
    }

}
