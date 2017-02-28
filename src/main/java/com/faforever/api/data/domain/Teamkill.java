package com.faforever.api.data.domain;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.ReadPermission;
import com.yahoo.elide.security.permissions.PermissionExpressionBuilder.Expressions;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Setter
@Table(name = "teamkills")
@Include(rootLevel = true, type = "teamkill")
@Immutable
@ReadPermission(expression = Expressions.)
public class Teamkill {
  private int id;
  private Player teamkiller;
  private Player victim;
  private int gameId;
  private int gameTime;
  private OffsetDateTime reportedAt;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  @ManyToOne
  @JoinColumn(name = "teamkiller")
  public Player getTeamkiller() {
    return teamkiller;
  }

  @ManyToOne
  @JoinColumn(name = "victim")
  public Player getVictim() {
    return victim;
  }

  @Column(name = "game_id")
  public int getGameId() {
    return gameId;
  }

  @Column(name = "gametime")
  public int getGameTime() {
    return gameTime;
  }

  @Column(name = "reported_at")
  public OffsetDateTime getReportedAt() {
    return reportedAt;
  }
}
