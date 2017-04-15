package com.faforever.api.data.checks;

import com.yahoo.elide.security.User;
import com.yahoo.elide.security.checks.UserCheck;

public class IsLadderManager {

  public static final String EXPRESSION = "is manager for ladder";

  public static class Inline extends UserCheck {
    @Override
    public boolean ok(User user) {
      return false; // TODO: Actual implementation (requires roles in DB)
    }
  }
}
