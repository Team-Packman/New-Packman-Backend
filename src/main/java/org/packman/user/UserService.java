package org.packman.user;

import org.packman.packingList.PackingList;
import org.packman.packingList.PackingListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PackingListService packingListService;

    public UserService(UserRepository userRepository, PackingListService packingListService) {
        this.userRepository = userRepository;
        this.packingListService = packingListService;
    }

    public List<PackingList> getPackingLists(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        return packingListService.getAllByUserId(userId);
    }

}
