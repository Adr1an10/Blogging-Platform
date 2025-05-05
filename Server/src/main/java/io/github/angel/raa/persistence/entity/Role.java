package io.github.angel.raa.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "roles_table")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roleId;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public enum ERole {
        ROLE_USER,
        ROLE_MODERATOR,
        ROLE_ADMIN
    }

    public Role(UUID roleId, ERole name) {
        this.roleId = roleId;
        this.name = name;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name=" + name +
                '}';
    }
}
