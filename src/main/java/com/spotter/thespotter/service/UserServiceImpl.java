package com.spotter.thespotter.service;

import com.spotter.thespotter.database.entity.User;
import com.spotter.thespotter.database.repository.UserRepository;
import com.spotter.thespotter.exceptions.BusineessException;
import com.spotter.thespotter.model.UserModel;
import com.spotter.thespotter.model.UserRequestModel;
import java.util.Optional;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  private static final String USER_ID = "sub";
  private static final String EMAIL = "email";
  private static final String NAME = "name";
  private static final String GIVEN_NAME = "given_name";
  private static final String PICTURE_URL = "picture";

  @Override
  public String getCurrentUserId() {
    return getClaimByName(USER_ID);
  }

  private String getClaimByName(String claimName) {
    return ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getClaimAsString(claimName);
  }

  @Transactional
  public UserModel getUserModel() {
    UserModel userModel = new UserModel();

    userModel.setMail(getClaimByName(EMAIL));
    userModel.setName(getClaimByName(NAME));
    userModel.setGivenName(getClaimByName(GIVEN_NAME));
    userModel.setPictureUrl(getClaimByName(PICTURE_URL));

    Optional<User> user = userRepository.findByUserIdpId(getCurrentUserId());

    if (user.isPresent()) {
      userModel.setUser(user.get());
    } else {
      User newUser = new User();
      newUser.setIdpUserId(getCurrentUserId());
      newUser.setCarbsGoal(0);
      newUser.setProteinGoal(0);
      newUser.setFatsGoal(0);

      userModel.setUser(userRepository.saveAndFlush(newUser));
    }

    return userModel;
  }

  @Transactional
  public void setOrCreateUserModel(UserRequestModel request) {
    Optional<User> user = userRepository.findByUserIdpId(getCurrentUserId());
    User userEntity;
    if (user.isPresent()) {
      userEntity = user.get();
    } else {
      userEntity = new User();
    }

    if (StringUtils.isEmpty(userEntity.getIdpUserId())) {
      userEntity.setIdpUserId(getCurrentUserId());
    }

    userEntity.setCarbsGoal(request.getCarbsGoal());
    userEntity.setFatsGoal(request.getFatsGoal());
    userEntity.setProteinGoal(request.getProteinsGoal());

    userRepository.saveAndFlush(userEntity);

  }

  @Override
  public User getCurrentUserEntity() {
    return userRepository.findByUserIdpId(getCurrentUserId())
        .orElseThrow(() -> new BusineessException("user not found", HttpStatus.INTERNAL_SERVER_ERROR));
  }

}
