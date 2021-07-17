package com.humanbooster.picom.service.model;

import com.humanbooster.picom.dao.CommercialDAO;
import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.model.Commercial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommercialServiceImpl implements CommercialService {

    CommercialDAO commercialDAO;


    public CommercialServiceImpl(CommercialDAO commercialDAO) {
        this.commercialDAO = commercialDAO;
    }

    @Override
    public Commercial saveCommercial(Commercial commercial) {
        return commercialDAO.save(commercial);
    }

    @Override
    public Commercial getCommercialById(Long id) {
        return commercialDAO.getById(id);
    }

    @Override
    public Page<Commercial> getCommercialsByClient(Client client, Pageable pageable) {
        return commercialDAO.findByClient(pageable, client);
    }

    @Override
    public List<Commercial> getCommercials() {
        return commercialDAO.findAll();
    }

    @Override
    public long countNbCommercials() {
        return commercialDAO.count();
    }
}
