package com.taboola.backstage.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum AccountType {
  ADMIN_NETWORK,
  PARTNER,
  NETWORK,
  GROUP,
  @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
