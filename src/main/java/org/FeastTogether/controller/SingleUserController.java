package org.FeastTogether.controller;

import org.FeastTogether.dto.AssignMenuItemDto;
import org.FeastTogether.dto.AssignMenuItemDtoToSingleUser;
import org.FeastTogether.dto.NewSingleUserDto;
import org.FeastTogether.dto.SingleUserDto;
import org.FeastTogether.service.SingleUserService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/singleUsers")
public class SingleUserController {
    private final SingleUserService singleUserService;

    public SingleUserController(SingleUserService singleUserService) {
        this.singleUserService = singleUserService;
    }
    @GetMapping
    public List<SingleUserDto> getAllSingleUsers() {
        return singleUserService.getAllSingleUsers();
    }
    @GetMapping("/{id}")
    public SingleUserDto getSingleUserById(@PathVariable UUID id) {
        return singleUserService.getSingleUserById(id);
    }
    @GetMapping(params = {"page", "size", "sort"})
    public List<SingleUserDto> getAllSingleUsers(Pageable pageable){
        return singleUserService.getAllSingleUsers(pageable);
    }
    @PostMapping
    public SingleUserDto createSingleUser(@RequestBody NewSingleUserDto newSingleUserDto) {
        return singleUserService.addSingleUser(newSingleUserDto);
    }

    @PutMapping("/{singleUserId}/menuItems/{menuItemId}")
    public AssignMenuItemDtoToSingleUser assignMenuItemDtoToSingleUser
            (@PathVariable UUID menuItemId, @PathVariable UUID singleUserId) {
        return singleUserService.assignMenuItem(menuItemId, singleUserId);
    }
}
