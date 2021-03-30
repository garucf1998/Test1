package com.example.demo.controller;

import com.example.demo.enity.TaiKhoan;
import com.example.demo.repository.TaiKhoantRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class TaiKhoanController {

    @Autowired
    TaiKhoantRepository taiKhoantRepository;

    @GetMapping("/TaiKhoan")
    public List<TaiKhoan> getAllEmployees() {
        return taiKhoantRepository.findAll();
    }

    @GetMapping("/TaiKhoan/{id}")
    public ResponseEntity<TaiKhoan> getTaiKhoanById(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        TaiKhoan taiKhoan = taiKhoantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(taiKhoan);
    }

    @PutMapping("/TaiKhoan/{id}")
    public ResponseEntity<TaiKhoan> updateTaiKhoan(@PathVariable(value = "id") int id,
                                                   @RequestBody TaiKhoan taiKhoanDetais) throws ResourceNotFoundException {
        TaiKhoan taiKhoan = taiKhoantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        taiKhoan.setUserName(taiKhoanDetais.getUserName());
        taiKhoan.setPassword(taiKhoanDetais.getPassword());
        final TaiKhoan updatedTaiKhoan = taiKhoantRepository.save(taiKhoan);
        return ResponseEntity.ok(updatedTaiKhoan);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteTaiKhoan(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        TaiKhoan taiKhoan = taiKhoantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        taiKhoantRepository.delete(taiKhoan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/TaiKhoan")
    public TaiKhoan createTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        return taiKhoantRepository.save(taiKhoan);
    }

}
