package com.forUMC.app.service.mission;

import com.forUMC.app.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{
    private final MissionRepository missionRepository;

    @Override
    public boolean existById(Long id) {
        return missionRepository.existsById(id);
    }
}
