package Repository;
import Entity.*;
import Generic.*;

import java.util.List;

public class BrandService implements IGeneric<Brand>{

    public static List<Brand> brands;

    @Override
    public Brand addNew(Brand brand) {
        if(!notExistedBrand(brands, brand)) brands.add(brand);
        return brand;
    }

    @Override
    public Brand update(Brand brand) {
        Brand existingBrand = findById(brand.getId());
        if (!notExistedBrand(brands, brand)) {
            brands.set(brands.indexOf(existingBrand), brand);
        }
        return brand;
    }


    @Override
    public boolean Delete(String id) {
        Brand existingBrand = findById(id);
        boolean flag = false;
        if(existingBrand != null) {
            brands.remove(existingBrand);
            flag = true;
        }
        return flag;
    }



    @Override
    public Brand findById(String id) {
        return brands.stream().filter(brand -> brand.getId()
                        .equals(id))
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Brand> findByName(String keyword) {
        String[] kw = keyword.split(" ");
        List<Brand> brs = null;
        for (String k : kw) {
            brs = brands.stream()
                    .filter(b -> b.getName().contains(k))
                    .toList();
        }
        return brs;
        }

    public boolean notExistedBrand(List<Brand> brands, Brand brand){
        return brands.stream().anyMatch(b->b.equals(brand));
    }

    public boolean isExistBrand(String brandName){
        return brands.stream().anyMatch(b->b.getId().equals(brandName));
    }


}



