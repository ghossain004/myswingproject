package com.swing.project.common;

import java.util.List;


public interface ICommonDAO<C> {
    public int save(C c);
    public List<C> getAll();
    public int delete(String code);
}
