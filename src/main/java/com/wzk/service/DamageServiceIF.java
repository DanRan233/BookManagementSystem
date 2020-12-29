package com.wzk.service;

import com.wzk.entity.Damage;
import com.wzk.entity.Result;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 21:01
 */
public interface DamageServiceIF {
    Result addDamage(Damage damage);

    Result updateDamage(Damage damage);

    Result getDamageList(Damage damage);
}
