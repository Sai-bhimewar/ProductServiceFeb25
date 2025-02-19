package com.scaler.productservicefeb25;

import com.scaler.productservicefeb25.model.Category;
import com.scaler.productservicefeb25.model.Product;
import com.scaler.productservicefeb25.repository.CategoryRepository;
import com.scaler.productservicefeb25.repository.ProductRepository;
import com.scaler.productservicefeb25.repository.projection.ProductTitleAndDescription;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceFeb25ApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }
//
//    @Test
//    public void Test(){
//        Optional<Product> optionalProduct=productRepository.findByTitleAndCategory_Name("HP","Laptop");
//        System.out.println(optionalProduct.get().getDescription());
//        System.out.println(optionalProduct.get().getCategory());
//    }
//
//    @Test
//    public void Test2(){
//        Product optionalProduct=productRepository.getProductDetails("Laptop");
//        System.out.println(optionalProduct.getDescription());
//    }
//
//    @Test
//    public void Test3(){
//        Product optionalProduct=productRepository.getProductDetaisl2("Oneplus");
//        System.out.println(optionalProduct.getDescription());
//    }
//
//    @Test
//    public void Test4(){
//        ProductTitleAndDescription productTitleAndDescription=productRepository.getProductDetails3(3L);
//        System.out.println(productTitleAndDescription.getTitle());
//        System.out.println(productTitleAndDescription.getDescription());
//    }
//
//    @Test
//    public void Test5(){
//        Optional<Category> category=categoryRepository.findById(1L);
//        System.out.println(category.get().getName());
//    }
//
//    @Test
//    public void Nplus1Problem(){
//        List<Category> categories=categoryRepository.findAll();
//        for(Category c:categories){
//            for(Product p:c.getProducts()){
//                System.out.println(p.getDescription());
//            }
//        }
//    }
//
////    @Test
////    @Transactional
////    public void Test6(){
////        Optional<Category> category=categoryRepository.findById(1L);
////        System.out.println(category.get().getName());
////        System.out.println(category.get().getProducts());
////    }
}
