package com.faforever.api.data.domain;

import com.yahoo.elide.annotation.DeletePermission;
import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.UpdatePermission;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
@Table(name = "name_history")
@Include(rootLevel = true, type = "name")
@DeletePermission(expression = "Prefab.Role.None")
@UpdatePermission(expression = "Prefab.Role.None")
@Setter
public class Name {
  private OffsetDateTime changeTime;
  private Player player;
  private String name;

  @Id
  @Column(name = "change_time")
  public OffsetDateTime getChangeTime() {
    return changeTime;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @NotNull
  public Player getPlayer() {
    return player;
  }

  @Column(name = "previous_name")
  @NotNull
  public String getName() {
    return name;
  }
}
