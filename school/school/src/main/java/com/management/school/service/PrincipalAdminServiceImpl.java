package com.management.school.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.school.dao.PrincipalAdminDao;
import com.management.school.entity.PrincipalAdminBO;

@Service
public class PrincipalAdminServiceImpl implements PrincipalAdminService {

    @Autowired
    private PrincipalAdminDao principalAdminDao;

    @Override
    public PrincipalAdminBO addPrincipalAdmin(PrincipalAdminBO principalAdmin) {
        return principalAdminDao.save(principalAdmin);
    }

    @Override
    public PrincipalAdminBO updatePrincipalAdmin(PrincipalAdminBO principalAdmin) {
        return principalAdminDao.save(principalAdmin);
    }

    @Override
    public void deletePrincipalAdmin(Integer id) {
        principalAdminDao.deleteById(id.longValue());
    }

    @Override
    public PrincipalAdminBO getPrincipalAdminById(Integer id) {
        return principalAdminDao.findById(id.longValue()).orElseThrow();
    }

    @Override
    public List<PrincipalAdminBO> getAllPrincipalAdmins() {
        return principalAdminDao.findAll();
    }
}
