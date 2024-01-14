package com.pharm.domain.medicines;

import java.time.LocalDate;

public record UpdateRequestMedicinesDTO(
        String nome,
        Via via,
        String lote,
        Laboratorio laboratorio,
        int quantidade,
        LocalDate validade) {

}
