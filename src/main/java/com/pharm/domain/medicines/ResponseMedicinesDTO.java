package com.pharm.domain.medicines;

import java.time.LocalDate;

public record ResponseMedicinesDTO(Long id, String nome, Via via, int quantidade, LocalDate validade) {
    public ResponseMedicinesDTO(Medicine medicine){
        this(medicine.getId() ,medicine.getNome(), medicine.getVia(), medicine.getQuantidade(), medicine.getValidade());
    }
}
