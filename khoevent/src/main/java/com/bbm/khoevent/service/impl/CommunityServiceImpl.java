package com.bbm.khoevent.service.impl;

import com.bbm.khoevent.dto.request.CommunityRequest;
import com.bbm.khoevent.dto.response.CommunityResponse;
import com.bbm.khoevent.exception.BadRequestException;
import com.bbm.khoevent.mapper.Mapper;
import com.bbm.khoevent.model.Community;
import com.bbm.khoevent.repository.CommunityRepository;
import com.bbm.khoevent.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private final CommunityRepository communityRepository;
    private final Mapper mapper;

    @Override
    public String createCommunity(CommunityRequest request) {

//        Fazendo a verificacao
        if(communityRepository.existsByNameOrEmail(request.getName(), request.getEmail())){
            throw new BadRequestException ("Erro ao criar a Comunidade");
        }

        Community communityToBeSaved = communityRepository.save(Community.builder()
                .name(request.getName())
                .description(request.getDescription())
                .email(request.getEmail())
                .website(request.getWebsite())
                .password(request.getPassword())
                .build());

        return "Comunidade Criada com sucesso!";
    }

    @Override
    public List<CommunityResponse> findAllCommunities() {
        var communities = communityRepository.findAll();
        return mapper.mapToCommunityResponseList(communities);
    }

    @Override
    public CommunityResponse findById(Long id) {
        var community = communityRepository.findById(id).orElseThrow(()-> new BadRequestException("Comunidade nao encontrada"));
        return mapper.mapToCommunityResponse(community);
    }

    @Override
    public Community getCommunityById(Long id) {
        return null;
    }

    @Override
    public String update(CommunityRequest communityRequest, Long id) {
        return null;
    }
}
