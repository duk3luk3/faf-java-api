package com.faforever.api.data.domain;

import com.yahoo.elide.annotation.Include;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "avatars")
@Include(rootLevel = true, type = "avatarAssignment")
@Setter
public class AvatarAssignment {
  private int id;
  private OffsetDateTime createTime;
  private OffsetDateTime updateTime;
  private boolean selected;
  private OffsetDateTime expiresAt;
  private Player player;
  private Avatar avatar;

  @Column(name = "selected")
  public boolean isSelected() {
    return selected;
  }

  @Column(name = "expires_at")
  public OffsetDateTime getExpiresAt() {
    return expiresAt;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idAvatar")
  public Avatar getAvatar() {
    return avatar;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idUser")
  public Player getPlayer() {
    return player;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public int getId() {
    return id;
  }

  @Column(name = "create_time")
  public OffsetDateTime getCreateTime() {
    return createTime;
  }

  @Column(name = "update_time")
  public OffsetDateTime getUpdateTime() {
    return updateTime;
  }
}
