package com.forUMC.app.service.mission;

import com.forUMC.app.converter.MissionConverter;
import com.forUMC.app.domain.Member;
import com.forUMC.app.domain.Mission;
import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.repository.MemberRepository;
import com.forUMC.app.repository.MissionRepository;
import com.forUMC.app.repository.RestaurantRepository;
import com.forUMC.app.web.dto.MissionRequest;
import com.forUMC.global.apiPayLoad.code.status.ErrorStatus;
import com.forUMC.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommendService{
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    @Override
    public Mission addMission(Long restaurantId, MissionRequest.addMissionDTO request) {
        Mission newMission = MissionConverter.toMission(request);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        newMission.setRestaurant(restaurant);
        return missionRepository.save(newMission);
    }
}
