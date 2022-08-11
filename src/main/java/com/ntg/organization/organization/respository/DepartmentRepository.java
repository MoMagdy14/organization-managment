package com.ntg.organization.organization.respository;

import com.ntg.organization.organization.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
