package org.FeastTogether.service;

import org.FeastTogether.dto.AssignMenuItemDtoToSingleUser;
import org.FeastTogether.dto.NewSingleUserDto;
import org.FeastTogether.dto.SingleUserDto;
import org.FeastTogether.entity.MenuItem;
import org.FeastTogether.entity.SingleUser;
import org.FeastTogether.mapper.SingleUserMapper;
import org.FeastTogether.repository.MenuItemRepository;
import org.FeastTogether.repository.SingleUserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SingleUserService {
    private final SingleUserRepository singleUserRepository;
    private final MenuItemRepository menuItemRepository;
    private final SingleUserMapper singleUserMapper;

    public SingleUserService(SingleUserRepository singleUserRepository,
                             MenuItemRepository menuItemRepository, SingleUserMapper singleUserMapper) {
        this.singleUserRepository = singleUserRepository;
        this.menuItemRepository = menuItemRepository;
        this.singleUserMapper = singleUserMapper;
    }
    public List<SingleUserDto> getAllSingleUsers() {
        return this.singleUserRepository.findAllBy()
                .stream().map(singleUserMapper::mapSingleUserToDto)
                .toList();
    }
    public SingleUserDto addSingleUser(NewSingleUserDto newSingleUserDto) {
        SingleUser singleUser = singleUserMapper.mapDtoToSingleUser(newSingleUserDto);
        SingleUser savedSingleUser = singleUserRepository.save(singleUser);
        return singleUserMapper.mapSingleUserToDto(savedSingleUser);
    }
    public SingleUserDto getSingleUserById(UUID id) {
        return singleUserRepository.findOneById(id)
                .map(singleUserMapper::mapSingleUserToDto)
                .orElseThrow();
    }
    public List<SingleUserDto> getAllSingleUsers(Pageable pageable) {
        return singleUserRepository.findAllBy(pageable).stream()
                .map(singleUserMapper::mapSingleUserToDto).toList();
    }
    public AssignMenuItemDtoToSingleUser assignMenuItem(UUID menuItemId, UUID singleUserId) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow();
        SingleUser singleUser = singleUserRepository.findById(singleUserId)
                .orElseThrow();

        singleUser.addNewMenuItem(menuItem);
        menuItem.addNewSingleUser(singleUser);

        menuItemRepository.save(menuItem);

        return new AssignMenuItemDtoToSingleUser(menuItemId, singleUserId, "Menu Item assigned to User!");
    }
}
