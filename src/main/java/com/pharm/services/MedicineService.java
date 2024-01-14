package com.pharm.services;

import com.pharm.domain.medicines.Medicine;
import com.pharm.domain.medicines.RequestMedicinesDTO;
import com.pharm.domain.medicines.ResponseMedicinesDTO;
import com.pharm.domain.medicines.UpdateRequestMedicinesDTO;
import com.pharm.domain.medicines.exception.MedicineNotFoundException;
import com.pharm.repositories.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository repository;

    public MedicineService(MedicineRepository repository){
        this.repository = repository;
    }

    public Medicine create(RequestMedicinesDTO data){
        Medicine medicine = new Medicine(data);
        this.repository.save(medicine);
        return medicine;
    }

    public List<ResponseMedicinesDTO> getAll(){
        return this.repository.findAll().stream().map(ResponseMedicinesDTO::new).toList();
    }

    public ResponseMedicinesDTO update(Long id, UpdateRequestMedicinesDTO data){
        Medicine medicine = this.repository.findById(id).orElseThrow(MedicineNotFoundException::new);

        if(data.nome() != null) medicine.setNome(data.nome());
        if(data.via() != null) medicine.setVia(data.via());
        if(data.lote() != null) medicine.setLote(data.lote());
        if(data.quantidade() != 0) medicine.setQuantidade(data.quantidade());
        if(data.validade() != null) medicine.setValidade(data.validade());
        if(data.laboratorio() != null) medicine.setLaboratorio(data.laboratorio());

        this.repository.save(medicine);

        return new ResponseMedicinesDTO(medicine);
    }

    public void delete(Long id){
        Medicine medicine = this.repository.findById(id).orElseThrow(MedicineNotFoundException::new);

        this.repository.delete(medicine);
    }
}
