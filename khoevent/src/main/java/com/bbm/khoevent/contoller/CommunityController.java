package com.bbm.khoevent.contoller;

import com.bbm.khoevent.dto.request.CommunityRequest;
import com.bbm.khoevent.dto.response.CommunityResponse;
import com.bbm.khoevent.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/communities")
public class CommunityController {

    private final CommunityService communityService;

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody CommunityRequest request){

        return ResponseEntity.ok(communityService.createCommunity(request));

    }
    @GetMapping
    public ResponseEntity<List<CommunityResponse>> findAllCommunities(){
        return ResponseEntity.ok(communityService.findAllCommunities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunityResponse> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(communityService.findById(id));
    }
}
