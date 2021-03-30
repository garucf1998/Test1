package com.example.demo.controller;

import com.example.demo.enity.BenhNhan;
import com.example.demo.repository.BenhNhanRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/benhnhan")
public class BenhNhanController {

    @Autowired
    BenhNhanRepository benhnhanRepository;

    @GetMapping("/getall")
    public List<BenhNhan> getAllBenhNhan() {
        return benhnhanRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<BenhNhan> getBenhNhanById(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        BenhNhan benhNhan = benhnhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(benhNhan);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BenhNhan> updateBenhNhan(@PathVariable(value = "id") int id,
                                                   @RequestBody BenhNhan benhNhanDetais) throws ResourceNotFoundException {
        BenhNhan benhNhan = benhnhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        benhNhan.setTenBenhNhan(benhNhanDetais.getTenBenhNhan());
        benhNhan.setDiaChi(benhNhanDetais.getDiaChi());
        benhNhan.setCmnd(benhNhanDetais.getCmnd());
        benhNhan.setEmail(benhNhanDetais.getEmail());
        benhNhan.setNgaySinh(benhNhanDetais.getNgaySinh());
        benhNhan.setSoDienThoai(benhNhanDetais.getSoDienThoai());
        benhNhan.setGioiTinh(benhNhanDetais.getGioiTinh());
        final BenhNhan updatedBenhNhan = benhnhanRepository.save(benhNhan);
        return ResponseEntity.ok(updatedBenhNhan);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteBenhNhan(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        BenhNhan benhNhan = benhnhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        benhnhanRepository.delete(benhNhan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/insert")
    public BenhNhan createBenhNhan(@RequestBody BenhNhan benhNhan) {
        return benhnhanRepository.save(benhNhan);
    }
    
}
