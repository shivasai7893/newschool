package com.management.school.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.management.school.entity.PrincipalAdminBO;
import com.management.school.service.PrincipalAdminService;

@RestController
@RequestMapping("/principaladmin")
public class PrincipalAdminController {

    @Autowired
    private PrincipalAdminService principalAdminService;

    @PostMapping
    public ResponseEntity<PrincipalAdminBO> addPrincipalAdmin(@RequestBody PrincipalAdminBO principalAdmin) {
        PrincipalAdminBO newPrincipalAdmin = principalAdminService.addPrincipalAdmin(principalAdmin);
        return ResponseEntity.ok(newPrincipalAdmin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrincipalAdminBO> updatePrincipalAdmin(@PathVariable Integer id, @RequestBody PrincipalAdminBO principalAdmin) {
        principalAdmin.setId(id);
        PrincipalAdminBO updatedPrincipalAdmin = principalAdminService.updatePrincipalAdmin(principalAdmin);
        return ResponseEntity.ok(updatedPrincipalAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrincipalAdmin(@PathVariable Integer id) {
        principalAdminService.deletePrincipalAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrincipalAdminBO> getPrincipalAdminById(@PathVariable Integer id) {
        PrincipalAdminBO principalAdmin = principalAdminService.getPrincipalAdminById(id);
        return ResponseEntity.ok(principalAdmin);
    }

    @GetMapping
    public ResponseEntity<List<PrincipalAdminBO>> getAllPrincipalAdmins() {
        List<PrincipalAdminBO> principalAdmins = principalAdminService.getAllPrincipalAdmins();
        return ResponseEntity.ok(principalAdmins);
    }
}
