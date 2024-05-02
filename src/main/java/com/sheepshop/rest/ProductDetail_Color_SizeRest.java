package com.sheepshop.rest;

import com.sheepshop.model.req.ProductDetail_Size_ColorRequest;
import com.sheepshop.services.ProductDetail_Size_ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productdetail_color_size")
public class ProductDetail_Color_SizeRest {
    @Autowired
    private ProductDetail_Size_ColorService service;
    @GetMapping("/getbycolor")
    public ResponseEntity<?> getByColor(@RequestParam("IdProduct") Integer IdProduct , @RequestParam("IdColor") Integer IdColor){
        return ResponseEntity.ok(service.getByColor(IdProduct,IdColor));
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getbyid(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getByIdd(id));
    }
    @GetMapping("/getbyproduct/{id}")
    public ResponseEntity<?> getbyproduct(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getByProduct(id));
    }
    @GetMapping("/getallbykeyword")
    public ResponseEntity<?> getbyid(@RequestParam(value = "keyword",required = false) String keyword,@RequestParam(value = "idColor",required = false) Integer idCololor,@RequestParam(value = "idSize",required = false) Integer idSize){
        System.out.println(service.getAllByNameAndCodeProduct(keyword,idCololor,idSize).size());
        return ResponseEntity.ok(service.getAllByNameAndCodeProduct(keyword,idCololor,idSize));
    }
    @GetMapping("/getQuantityProduct")
    public ResponseEntity<?> getQuantityProduct(@RequestParam("IdProduct") Integer IdProduct){
        return ResponseEntity.ok(service.getQuantityByProduct(IdProduct));
    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ProductDetail_Size_ColorRequest request){
        return ResponseEntity.ok(service.add(request));
    }

    @PutMapping("/updateQuantity")
    public ResponseEntity<?> updateQuantity (
            @RequestParam("IdProduct") Integer IdProduct,
            @RequestParam("IdColor") Integer IdColor,
            @RequestParam("IdSize") Integer IdSize,
            @RequestParam("Quantity") Integer Quanity
    ){
        return ResponseEntity.ok(service.updateQuantity(IdProduct,IdColor,IdSize,Quanity));
    }


}
