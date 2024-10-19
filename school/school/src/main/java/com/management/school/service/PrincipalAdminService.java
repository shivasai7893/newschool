package com.management.school.service;

import java.util.List;
import com.management.school.entity.PrincipalAdminBO;

public interface PrincipalAdminService {
    PrincipalAdminBO addPrincipalAdmin(PrincipalAdminBO principalAdmin);
    PrincipalAdminBO updatePrincipalAdmin(PrincipalAdminBO principalAdmin);
    void deletePrincipalAdmin(Integer id);
    PrincipalAdminBO getPrincipalAdminById(Integer id);
    List<PrincipalAdminBO> getAllPrincipalAdmins();
}
