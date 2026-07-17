package com.jency.amourboxbackend.service;


import com.jency.amourboxbackend.dto.MemoryResponseDto;
import com.jency.amourboxbackend.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoryService {

    @Autowired
    private MemoryRepository memoryRepository;

    public List<MemoryResponseDto> getAllMemoriesChronologically() {
        return memoryRepository.findAllByOrderByMemoryDateAsc().stream()
                .map(memory -> new MemoryResponseDto(
                        memory.getTitle(),
                        memory.getDescription(),
                        memory.getMemoryDate(),
                        memory.getImageUrl()))
                .collect(Collectors.toList());
    }
}
