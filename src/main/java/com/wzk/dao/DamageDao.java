package com.wzk.dao;

import com.wzk.entity.Damage;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 15:28
 */
public interface DamageDao {
    int addDamage(Damage damage);

    int updateDamage(Damage damage);

    List<Damage> getDamageList(Damage damage);
}
