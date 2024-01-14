package com.pharm.controllers;


import com.pharm.domain.medicines.*;
import com.pharm.services.MedicineService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medicines")
public class MedicinesController {

        private final MedicineService service;

        public MedicinesController(MedicineService service){
            this.service = service;
        }

        @PostMapping
        @Transactional
        public ResponseEntity<Medicine> create(@RequestBody @Valid RequestMedicinesDTO data) {
            return ResponseEntity.ok().body(this.service.create(data));
        }

        @GetMapping
        public ResponseEntity<List<ResponseMedicinesDTO>> index(){
            return ResponseEntity.ok().body(this.service.getAll());
        }

        @PutMapping("/{id}")
        public ResponseEntity<ResponseMedicinesDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateRequestMedicinesDTO data){
            return ResponseEntity.ok().body(this.service.update(id, data));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Medicine> delete(@PathVariable Long id){
            this.service.delete(id);
            return ResponseEntity.noContent().build();
        }


}
