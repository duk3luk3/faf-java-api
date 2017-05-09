package com.faforever.integration;

import com.faforever.api.avatar.AvatarAssignmentRepository;
import com.faforever.api.avatar.AvatarRepository;
import com.faforever.api.clan.ClanMembershipRepository;
import com.faforever.api.clan.ClanRepository;
import com.faforever.api.client.OAuthClientRepository;
import com.faforever.api.player.PlayerRepository;
import com.faforever.api.user.UserRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@Component
@Getter
public class TestDatabase {
  private ClanRepository clanRepository;
  private UserRepository userRepository;
  private ClanMembershipRepository clanMembershipRepository;
  private PlayerRepository playerRepository;
  private OAuthClientRepository oAuthClientRepository;
  private AvatarRepository avatarRepository;
  private AvatarAssignmentRepository avatarAssignmentRepository;

  @Inject
  public void init(ClanRepository clanRepository,
                   UserRepository userRepository,
                   PlayerRepository playerRepository,
                   OAuthClientRepository oAuthClientRepository,
                   ClanMembershipRepository clanMembershipRepository,
                   AvatarRepository avatarRepository,
                   AvatarAssignmentRepository avatarAssignmentRepository) {
    this.clanRepository = clanRepository;
    this.userRepository = userRepository;
    this.playerRepository = playerRepository;
    this.oAuthClientRepository = oAuthClientRepository;
    this.clanMembershipRepository = clanMembershipRepository;
    this.avatarRepository = avatarRepository;
    this.avatarAssignmentRepository = avatarAssignmentRepository;
  }

  public void assertEmptyDatabase() {
    assertEquals(0, avatarAssignmentRepository.count());
    assertEquals(0, avatarRepository.count());
    assertEquals(0, clanRepository.count());
    assertEquals(0, userRepository.count());
    assertEquals(0, playerRepository.count());
    assertEquals(0, oAuthClientRepository.count());
    assertEquals(0, clanMembershipRepository.count());
  }

  public void tearDown() {
    avatarAssignmentRepository.deleteAll();
    avatarRepository.deleteAll();
    clanMembershipRepository.deleteAll();
    clanRepository.deleteAll();
    userRepository.deleteAll();
    oAuthClientRepository.deleteAll();
    assertEmptyDatabase();
  }
}
