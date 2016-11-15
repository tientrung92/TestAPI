package com.trungnt.dao;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;

public enum ThemeDAO {
  INSTANCE;

  public boolean deleteThemeById(long themeId) {
    return false;
  }

}
