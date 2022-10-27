/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deg.clientservice.repository;


import com.deg.clientservice.model.ProductosModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductosRepository extends JpaRepository<ProductosModel,Long> {

   Optional<ProductosModel>findBySku(String Sku);
   List <ProductosModel> findByStockLessThanEqual(int stock);
    
}
