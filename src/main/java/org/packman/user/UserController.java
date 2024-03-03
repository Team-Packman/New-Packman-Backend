package org.packman.user;

import org.packman.packingList.PackingList;
import org.packman.user.dto.response.PackingListGet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {

    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/packingLists")
    public List<PackingListGet> getPackingLists(@PathVariable Long userId) {
        List<PackingList> packingLists = userService.getPackingLists(userId);

        return packingLists.stream()
                .map(PackingListGet::from)
                .toList();
    }

}
