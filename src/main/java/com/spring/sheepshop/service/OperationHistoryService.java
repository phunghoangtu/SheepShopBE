package com.spring.sheepshop.service;

import com.spring.sheepshop.entity.OperationHistory;
import com.spring.sheepshop.repository.OperationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OperationHistoryService {
    @Autowired
    OperationHistoryRepository repository;
    public OperationHistory add(OperationHistory operationHistory){
        OperationHistory operationHistory1 = new OperationHistory();
        operationHistory1.setCreateDate(new Date());
        operationHistory1.setStatus(operationHistory.getStatus());
        operationHistory1.setCreateBy(operationHistory.getCreateBy());
        operationHistory1.setIdProductDetail(operationHistory.getIdProductDetail());
        return repository.save(operationHistory1);
    }
    public List<OperationHistory> getAll(){
        return repository.getAll();
    }
}
