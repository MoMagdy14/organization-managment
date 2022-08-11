package com.ntg.organization.organization.service;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List
import org.springframework.beans.BeanUtils;
import com.ntg.organization.organization.entity.Department;
import com.ntg.organization.organization.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ntg.organization.organization.dto.DepartmentDTO;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartment() {
        List<Department> depts = (List<Department>) departmentRepository.findAll();
		List<DepartmentDTO> deptDTOList = null;
		
		if(!depts.isEmpty()) {
			deptDTOList = new ArrayList<>();
			DepartmentDTO deptDto = null;
			for (Department department : depts) {
				deptDto = new DepartmentDTO();
				BeanUtils.copyProperties(department, deptDto);
				deptDTOList.add(deptDto);
			}
		}
		
		return deptDTOList;
    }

    public Department createNewDepartment(Department newDep) {
        if (newDep != null) {
            return departmentRepository.save(newDep);
        }
        return null;
    }

    public boolean deleteDepartmentById(Long id) {
        if (id != null) {
            departmentRepository.deleteById(id);
            return true;
        }

        return false;
    }



}

