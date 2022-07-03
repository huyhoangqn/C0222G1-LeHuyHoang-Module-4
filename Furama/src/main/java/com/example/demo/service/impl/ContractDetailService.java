package com.example.demo.service.impl;

import com.example.demo.bean.Contract;
import com.example.demo.bean.ContractDetail;
import com.example.demo.repository.ContractDetailRepository;
import com.example.demo.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public ContractDetail findByIdContract(Contract contract) {
        return contractDetailRepository.findByContract(contract);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
