package com.laxmi.inventory.management.inventory.repositories;


import com.laxmi.inventory.management.inventory.Entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StaffRepository {

    @Autowired
    IstaffRepository staffRepository;

    public Staff SaveStaff(Staff staff){

        Staff newStaff = staffRepository.save(Staff.builder().firstName(staff.getFirstName()).
                email(staff.getEmail()).
                address(staff.getAddress()).
                phoneNumber(staff.getPhoneNumber()).
                lastName(staff.getLastName()).build());

        return newStaff;
    }

    public List<Staff> getAllStaff(){

        List<Staff> staffList = staffRepository.findAll();

        return staffList;

    }

    public Staff getStaffById(long id){
        Optional<Staff> staffObj = staffRepository.findById(id);

        if(staffObj.isPresent()){
            return staffObj.get();
        }
        return null;

    }

    public boolean deleteStaffById(long id){
        Staff staff = getStaffById(id);

        if(staff != null){
            staffRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public boolean deleteAllStaffs(){

        try {
            staffRepository.deleteAll();

            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public Staff updateStaff(long id, Staff staff){

        //check if staff exists in database
        Staff staffObj = getStaffById(id);

        if(staffObj != null) {
            staffObj.setAddress(staff.getAddress());
            staffObj.setFirstName(staff.getFirstName());
            staffObj.setLastName(staff.getLastName());
            staffObj.setEmail(staff.getEmail());
            staffObj.setPhoneNumber(staff.getPhoneNumber());
            staffRepository.save(staffObj);

            return staffObj;
        }

        return null;

    }




}
