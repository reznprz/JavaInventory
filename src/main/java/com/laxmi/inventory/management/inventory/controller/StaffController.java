package com.laxmi.inventory.management.inventory.controller;

import com.laxmi.inventory.management.inventory.Entity.Staff;
import com.laxmi.inventory.management.inventory.Model.StaffInfo;
import com.laxmi.inventory.management.inventory.Model.StaffInfoRes;
import com.laxmi.inventory.management.inventory.domain.StaffDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    @Autowired
    StaffDomain staffDomain;


    @PostMapping("/create")
    private ResponseEntity<Staff> saveStaff(@RequestBody Staff staff) {
        System.out.println("Staff : " + staff.toString());
        Staff newStaff = staffDomain.saveStaff(staff);
        return new ResponseEntity<>(newStaff, HttpStatus.OK);
    }

    @GetMapping("/allStaffs")
    private ResponseEntity<List<Staff>> getAllStaffs() {
        try {
            return new ResponseEntity<>(staffDomain.getAllStaffs(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<Staff> getStaffById(@PathVariable("id") long id) {
        try {
            Staff staffObj = staffDomain.getStaffById(id);

            if (staffObj != null) {
                return new ResponseEntity<>(staffObj, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteStaffById(@PathVariable("id") long id) {
        try {
            boolean success = staffDomain.deleteStaffById(id);

            if (success) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }

            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/all")
    private ResponseEntity<Boolean> deleteAllStaffs() {
        try {
            boolean success = staffDomain.deleteAllStaffs();

            if (success) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }

            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<Staff> updateStaff(@PathVariable("id") long id, @RequestBody Staff staff) {
        Staff staffObj = staffDomain.updateStaff(id, staff);

        if (staffObj != null) {
            return new ResponseEntity<>(staffObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/validateStaff")
    private StaffInfoRes validateStaff(@RequestBody StaffInfo staffInfo){
        StaffInfoRes res = staffDomain.validateStaff(staffInfo);

        return res;
//        if (res != null) {
//            return new ResponseEntity<>(res, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
