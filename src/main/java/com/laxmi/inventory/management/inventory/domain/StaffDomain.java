package com.laxmi.inventory.management.inventory.domain;

import com.laxmi.inventory.management.inventory.Entity.Staff;
import com.laxmi.inventory.management.inventory.Model.StaffInfo;
import com.laxmi.inventory.management.inventory.Model.StaffInfoRes;
import com.laxmi.inventory.management.inventory.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StaffDomain {

    @Autowired
    StaffRepository staffRepository;

    public Staff saveStaff(Staff staff){
        return staffRepository.SaveStaff(staff);
    }

    public List<Staff> getAllStaffs(){
        return staffRepository.getAllStaff();
    }

    public Staff getStaffById(long id){
        return staffRepository.getStaffById(id);
    }

    public boolean deleteStaffById(long id){
        return staffRepository.deleteStaffById(id);
    }

    public boolean deleteAllStaffs(){
        return staffRepository.deleteAllStaffs();
    }

    public Staff updateStaff(long id, Staff staff){
        return staffRepository.updateStaff(id,staff);
    }

    public StaffInfoRes validateStaff(StaffInfo staffInfo){
        StaffInfoRes res = new StaffInfoRes();


        if(staffInfo.getSessionId() == null && staffInfo.getSessionId() == ""){
            res.setComment("invalid session ID");
            return res;
        }

        Random rd = new Random();

        if(rd.nextBoolean()){
            res.setStatus("APPROVED");
            res.setComment("");
            res.setSessionId(staffInfo.getSessionId());
        }
        else {
            res.setStatus("REJECTED");
            res.setComment("Under Age");
            res.setSessionId(staffInfo.getSessionId());
        }

        return res;
    }

}
