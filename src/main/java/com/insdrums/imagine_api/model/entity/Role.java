package com.insdrums.imagine_api.model.entity;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Role {
    ROLE_SERNAGEOMION(Arrays.asList(
            RolePermission.ACTUALIZAR,
            RolePermission.CREAR,
            RolePermission.LEER,
            RolePermission.ELIMINAR
    )),
    ROLE_SERNAPRED(Arrays.asList(
            RolePermission.ACTUALIZAR,
            RolePermission.CREAR,
            RolePermission.LEER,
            RolePermission.ELIMINAR
            )),
    ROLE_CAMILO(Arrays.asList(
            RolePermission.ACTUALIZAR,
            RolePermission.CREAR,
            RolePermission.LEER,
            RolePermission.ELIMINAR
    ));

    private List<RolePermission> permissions;

    Role(List<RolePermission> permissions) {
        this.permissions = permissions;
    }
}
