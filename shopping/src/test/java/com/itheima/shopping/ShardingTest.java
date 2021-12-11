package com.itheima.shopping;

import com.itheima.shopping.dao.ProductDao;
import com.itheima.shopping.entity.ProductInfo;
import com.itheima.shopping.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingBootstrap.class)
public class ShardingTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductDao productDao;

    //添加商品
    @Test
    public void testCreateProduct(){
        for (int i=1;i<10;i++){
            ProductInfo productInfo = new ProductInfo();
            productInfo.setStoreInfoId(2L);//店铺id
            productInfo.setProductName("Java编程思想"+i);//商品名称
            productInfo.setSpec("大号");
            productInfo.setPrice(new BigDecimal(60));
            productInfo.setRegionCode("110100");
            productInfo.setDescript("Java编程思想不错！！！"+i);//商品描述
            productService.createProduct(productInfo);
        }
        //ProductInfo productInfo = new ProductInfo();
        //productInfo.setStoreInfoId(1L);//店铺id
        //productInfo.setProductName("Java编程思想");//商品名称
        //productInfo.setSpec("大号");
        //productInfo.setPrice(new BigDecimal(60));
        //productInfo.setRegionCode("110100");
        //productInfo.setDescript("Java编程思想不错！！！");//商品描述
        //productService.createProduct(productInfo);

    }

    // 查询商品
    @Test
    public void testQueryProduct(){

        List<ProductInfo> productInfos = productService.queryProduct(2, 2);
        System.out.println(productInfos);
    }

    ////统计商品总数
    //@Test
    //public void testSelectCount(){
    //
    //    int i = productDao.selectCount();
    //
    //    System.out.println(i);
    //}
    //
    ////分组统计商品
    //@Test
    //public void testSelectProductGroupList(){
    //
    //    List<Map> maps = productDao.selectProductGroupList();
    //
    //    System.out.println(maps);
    //}

    @Test
    public void testRemoveFirst() {
        // create a LinkedList
        LinkedList list = new LinkedList();

        // add some elements
        list.add("Hello");
        list.add(2);
        list.add("Chocolate");
        list.add("10");

        // print the list
        System.out.println("LinkedList:" + list);

        // remove the first element
        System.out.println("First element:" + list.removeFirst());

        // print the list
        System.out.println("LinkedList:" + list);
    }

    @Test
    public void MySort () {
        int arr[] = new int[]{5, 2, 3, 1, 4};
//         int temp;
//         for(int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr.length - i - 1; j++) {
//                 if(arr[j] > arr[j + 1]) {
//                     temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                 }
//             }
//         }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }
    @Test
    public void test () {
        int i = 5;
        int j = 10;
        System.out.println(i + ~j);
    }
}
