package org.springframework.boot.exam.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam.model.Manage;
import org.springframework.boot.exam.repository.ManageRepository;
import org.springframework.boot.exam.service.ManageService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManageServiceImpl implements ManageService {
    private final ManageRepository manageRepository;

    @Override
    public String add(Manage manage) {
        manageRepository.save(manage);
        return "Ok";
    }
}
